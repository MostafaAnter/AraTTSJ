/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

/**
 * الطبقة الصوتية للمقطع الصوتي
 */
public class Pitch implements Cloneable {

    private double N1;
    private double N2;

    public Pitch(double N1, double N2) {
        this.N1 = N1;
        this.N2 = N2;
    }

    public Object clone() {
        return new Pitch(N1, N2);
    }

    public double getN1() {
        return N1;
    }

    public void setN1(double N1) {
        this.N1 = N1;
    }

    public double getN2() {
        return N2;
    }

    public void setN2(double N2) {
        this.N2 = N2;
    }

    public String toString() {
        return N1 + " " + N2;
    }
}
