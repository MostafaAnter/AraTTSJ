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
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * هذا الصف مسؤول عن فتح المقاطع الصوتية
 */
public class AudioPlayer {

	public static final int STATE_UNINITIALIZED = 0;
	public static final int STATE_READY = 1;
	public static final int STATE_PLAYING = 2;
	public static final int STATE_PAUSED = 3;
	private Clip audio;
	private int state = STATE_UNINITIALIZED;
	private boolean pause;
	private AudioInputStream ain;

	/**
	 * فتح المقطع الصوتي و تهيأته للتشغيل
	 *
	 * @param file
	 *            مسار الملف
	 * @throws FileNotFoundException
	 *             في حال كان الملف غير موجوداً
	 * @throws UnsupportedAudioFileException
	 *             في حال كانت صيغة الملف غير مدعومة
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public void open(String file) throws FileNotFoundException,
			UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		open(new FileInputStream(file));
	}

	/**
	 * فتح مسلك بيانات صوتية و تهيأته للتشغيل
	 *
	 * @param afin
	 *            مسلك بيانات يحتوي البيانات الصوتية
	 * @throws UnsupportedAudioFileException
	 *             في حال كانت صيغة البيانات في المسلك غير مدعومة
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	public void open(InputStream afin) throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		state = STATE_UNINITIALIZED;
		ain = createPlayer(afin);
		audio.open(ain);
		/**
		 * تغيير حالة المشغل حسب الحدث
		 */
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
					if (audio.getMicrosecondPosition() == audio
							.getMicrosecondLength() || !pause) {
						System.out.println(audio.isOpen());
						audio.setMicrosecondPosition(0);
						state = STATE_READY;
					} else {
						state = STATE_PAUSED;
					}
				}
			}

		});

		state = STATE_READY;
	}

	private AudioInputStream createPlayer(InputStream afin) throws IOException,
			UnsupportedAudioFileException, LineUnavailableException {
		BufferedInputStream in = new BufferedInputStream(afin);
		AudioInputStream ain = AudioSystem.getAudioInputStream(in);
		audio = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, ain
				.getFormat()));
		return ain;
	}

	/**
	 * إغلاق ملف صوتي
	 */
	public void close() {
		audio.close();
		audio = null;
	}

	/**
	 * تشغيل ملف صوتي
	 */
	public void play() {
		if (state == STATE_PAUSED || state == STATE_READY) {
			pause = false;
			audio.start();
		}
	}

	/**
	 * إيقاف مؤقت
	 */
	public void pause() {
		if (state == STATE_PLAYING) {
			pause = true;
			audio.stop();
		}

	}

	/**
	 * إيقاف
	 */
	public void stop() {
		if (state == STATE_PAUSED || state == STATE_PLAYING) {
			pause = false;
			audio.stop();
			audio.setMicrosecondPosition(0);
		}
	}

	/**
	 * كم ميكروثانية تم قراءتها من الملف الصوتي
	 *
	 * @return كم ميكروثانية تم قراءتها من الملف الصوتي
	 */
	public long getCurrnetTime() {
		return audio.getMicrosecondPosition();
	}

	/**
	 * طول الملف الصوتي الكلي بالميكروثانية
	 *
	 * @return طول الملف الصوتي الكلي بالميكروثانية
	 */
	public long getTotalTime() {
		return audio.getMicrosecondLength();
	}

	public int getState() {
		return state;
	}
}
