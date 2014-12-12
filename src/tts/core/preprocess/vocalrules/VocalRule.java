/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

/**
 *
 * @author ossama
 */
public abstract class VocalRule implements Comparable<VocalRule> {

    protected int Priority;

    public int getPriority() {
        return Priority;
    }

    @Override
    public int compareTo(VocalRule o) {
        Integer n = Priority;
        return n.compareTo(o.Priority);
    }

    public abstract String evaluate(String... data);
}
