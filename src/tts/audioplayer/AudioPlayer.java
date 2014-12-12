/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.audioplayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 */
public class AudioPlayer {

    public static final int STATE_UNINITIALIZED = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PAUSED = 3;
    private Clip audio;
    private int state = STATE_UNINITIALIZED;
    private boolean pause;

    public void open(String file) throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        state = STATE_UNINITIALIZED;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        AudioInputStream ain = AudioSystem.getAudioInputStream(in);
        audio = AudioSystem.getClip();
        audio.addLineListener(new LineListener() {

            @Override
            public void update(LineEvent event) {
                if (event.getType() == LineEvent.Type.CLOSE) {
                    state = STATE_UNINITIALIZED;
                } else if (event.getType() == LineEvent.Type.OPEN) {
                    state = STATE_READY;
                } else if (event.getType() == LineEvent.Type.START) {
                    state = STATE_PLAYING;
                } else if (event.getType() == LineEvent.Type.STOP) {
                    if (audio.getMicrosecondPosition() == audio.getMicrosecondLength() || !pause) {
                        state = STATE_READY;
                    } else {
                        state = STATE_PAUSED;
                    }
                }
            }

        });
        audio.open(ain);
        state = STATE_READY;
    }

    public void close() {
        audio.close();
        audio = null;
    }

    public void play() {
        if (state == STATE_PAUSED || state == STATE_READY) {
            pause = false;
            audio.start();
        }
    }

    public void pause() {
        if (state == STATE_PLAYING) {
            pause = true;
            audio.stop();
        }

    }

    public void stop() {
        if (state == STATE_PAUSED || state == STATE_PLAYING) {
            pause = false;
            audio.stop();
            audio.setMicrosecondPosition(0);
        }
    }
}
