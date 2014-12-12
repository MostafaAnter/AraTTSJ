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
 */
public class AlefTafreeqRule extends WordVocalRule {

    public AlefTafreeqRule() {
        Priority = 6;
    }

    @Override
    protected String evaluate(String previousWord, String currentWord) {
        if (currentWord.endsWith("" + ArabicMoves.WOW + ArabicMoves.ALEF)) {
            currentWord = currentWord.substring(0, currentWord.length() - 1);
        }
        return currentWord;
    }

}
