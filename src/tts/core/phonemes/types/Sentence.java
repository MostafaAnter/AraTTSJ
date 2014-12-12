/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ossama
 */
public class Sentence implements Phonemeable {

    private ArrayList<Word> words = new ArrayList<>();

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    @Override
    public Phoneme[] getPhonemes() {
        ArrayList<Phoneme> result1 = new ArrayList<>();
        for (Word word : words) {
            result1.addAll(Arrays.asList(word.getPhonemes()));
        }
        Phoneme[] result = new Phoneme[result1.size()];
        return result;
    }

    @Override
    public EndType getEnd() {
        if (words.isEmpty()) {
            return EndType.EndOfData;
        } else {
            return words.get(words.size() - 1).getEnd();
        }
    }

    
}
