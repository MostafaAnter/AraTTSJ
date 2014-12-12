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
public class TanweenRule extends VocalRule {

    public TanweenRule() {
        Priority = 9;
    }

    @Override
    public String evaluate(String previousWord,String currentWord) {

        currentWord = currentWord.replaceAll("" + ArabicMoves.TANWEEN_FATEH + "|" + ArabicMoves.ALEF + ArabicMoves.TANWEEN_FATEH,
                "" + ArabicMoves.FATHAH + ArabicMoves.NOON);
        currentWord = currentWord.replaceAll("" + ArabicMoves.TANWEEN_DAMM,
                "" + ArabicMoves.DAMMAH + ArabicMoves.NOON);
        return currentWord.replaceAll("" + ArabicMoves.TANWEEN_KASER,
                "" + ArabicMoves.KASRAH + ArabicMoves.NOON);
    }

}
