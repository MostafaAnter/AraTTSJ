package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 */
public class HamaztWasilRule extends VocalRule {

    public HamaztWasilRule() {
        Priority = 7;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        if (currentWord.startsWith("" + ArabicMoves.ALEF + ArabicMoves.LAM + ArabicMoves.ALEF)) {
            currentWord = "" + ArabicMoves.LAM + currentWord.substring(3);
        } else if (currentWord.charAt(0) == ArabicMoves.ALEF) {
            currentWord = currentWord.substring(1);
        }
        return currentWord;
    }
}
