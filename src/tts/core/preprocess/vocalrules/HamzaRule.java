/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 *
 *
 *
 */
public class HamzaRule extends TextVocalRule {

    public HamzaRule() {
        Priority = 2;
    }

    

    @Override
    protected String evaluate(String text) {
        return text.replaceAll(ArabicMoves.HAMZAT, "" + ArabicMoves.HAMZA);
//        if (previousWord == null || isEndOfSentence(previousWord)) {
//            currentWord=currentWord.substring(1);
//        }
//        return currentWord;
    }

}
