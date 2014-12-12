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
public class ShaddaRule extends WordVocalRule {

    public ShaddaRule() {
        Priority = 2;
    }

    @Override
    protected String evaluate(String previousWord, String currentWord) {
        for (int j = 0; j < currentWord.length(); j++) {
            if (currentWord.charAt(j) == ArabicMoves.SHADDA) {
                currentWord = currentWord.substring(0, j) + currentWord.charAt(j - 1) + currentWord.substring(j + 1);
            }
        }
        return currentWord;
    }
}
