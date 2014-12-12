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
public class Paragraph implements Phonemeable {

    private ArrayList<Sentence> sentences = new ArrayList<>();

    public ArrayList<Sentence> getWords() {
        return sentences;
    }

    public void setWords(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public Phoneme[] getPhonemes() {
        ArrayList<Phoneme> result1 = new ArrayList<>();
        for (Sentence sentence : sentences) {
            result1.addAll(Arrays.asList(sentence.getPhonemes()));
        }
        Phoneme[] result = new Phoneme[result1.size()];
        return result;
    }

    @Override
    public EndType getEnd() {
        if (sentences.isEmpty()) {
            return EndType.EndOfData;
        } else {
            return sentences.get(sentences.size() - 1).getEnd();
        }
    }

    
}
