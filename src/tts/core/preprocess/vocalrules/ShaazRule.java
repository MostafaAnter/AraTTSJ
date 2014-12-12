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
public class ShaazRule extends VocalRule {

    public ShaazRule() {
        Priority = 11;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        if (currentWord.matches("" + ArabicMoves.AEEN + ArabicMoves.FATHAH + ArabicMoves.MEEM + ArabicMoves.RAA
                + "(" + ArabicMoves.FATHAH + "|" + ArabicMoves.DAMMAH + "|"
                + ArabicMoves.KASRAH + ")?" + ArabicMoves.WOW)) {
            currentWord = currentWord.substring(0, currentWord.length() - 1);
        }
        return currentWord;
    }

}
