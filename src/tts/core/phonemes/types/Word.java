/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

import java.util.ArrayList;

/**
 *
 * @author ossama
 */
public class Word {

    private String Normal, Vocal;
    ArrayList<Phoneme> phonemes;
    private EndType end;

    public Word(String Normal, String Vocal, EndType end) {
        this.Normal = Normal;
        this.Vocal = Vocal;
        this.phonemes = new ArrayList<>();
        this.end = end;
    }

    public void setEnd(EndType end) {
        this.end = end;
    }

    public String getNormal() {
        return Normal;
    }

    public void setNormal(String Normal) {
        this.Normal = Normal;
    }

    public String getVocal() {
        return Vocal;
    }

    public void setVocal(String Vocal) {
        this.Vocal = Vocal;
    }

    public ArrayList<Phoneme> getPhonemeList() {
        return phonemes;
    }

    public Phoneme[] getPhonemes() {
        Phoneme[] result = new Phoneme[phonemes.size()];
        result = phonemes.toArray(result);
        return result;

    }

    public EndType getEnd() {
        return end;
    }

}
