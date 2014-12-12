/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

/**
 *
 * @author ossama
 */
public interface Phonemeable {

    Phoneme[] getPhonemes();

    EndType getEnd();
}
