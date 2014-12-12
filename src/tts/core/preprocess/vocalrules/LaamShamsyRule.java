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
public class LaamShamsyRule extends VocalRule {

    public LaamShamsyRule() {
        Priority = 2;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        final char[] SHAMS_LETTERS = {ArabicMoves.TAA, ArabicMoves.THAA,
            ArabicMoves.DAAL, ArabicMoves.ZHAAL, ArabicMoves.RAA, ArabicMoves.ZAI,
            ArabicMoves.SEEN, ArabicMoves.SHEEN, ArabicMoves.SAAD, ArabicMoves.DAAD,
            ArabicMoves.TAH, ArabicMoves.ZHAH, ArabicMoves.LAM, ArabicMoves.NOON};

        if (currentWord.startsWith(ArabicMoves.AL_TAAREEF)) {
            for (int i = 0; i < SHAMS_LETTERS.length; i++) {

                if (currentWord.charAt(2) == SHAMS_LETTERS[i]) {
                    if (previousWord == null || isEndOfSentence(previousWord)) {
                        currentWord = "" + ArabicMoves.HAMZA + ArabicMoves.FATHAH + currentWord.substring(2);
                    } else {
                        currentWord = currentWord.substring(2);
                    }
                    break;
                }
            }
        }
        return currentWord;
    }

}
