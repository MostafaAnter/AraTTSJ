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
public class HamzaWordRule extends VocalRule {

    public HamzaWordRule() {
        Priority = 4;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        currentWord = currentWord.replaceAll(ArabicMoves.HAMZAT, "" + ArabicMoves.HAMZA);
        if (currentWord.charAt(0) == ArabicMoves.HAMZA && (previousWord == null || isEndOfSentence(previousWord))) {
            currentWord = currentWord.substring(1);
        }
        return currentWord;
    }

}
