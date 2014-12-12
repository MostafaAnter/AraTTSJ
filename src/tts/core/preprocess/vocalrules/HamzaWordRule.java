/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 *
 * @author ossama
 */
public class HamzaWordRule extends WordVocalRule {

    public HamzaWordRule() {
        Priority = 3;
    }

    @Override
    protected String evaluate(String previousWord, String currentWord) {
        if (currentWord.charAt(0) == ArabicMoves.HAMZA && (previousWord == null || isEndOfSentence(previousWord))) {
            currentWord = currentWord.substring(1);
        }
        return currentWord;
    }

}
