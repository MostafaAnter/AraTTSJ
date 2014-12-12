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
public class TanweenRule extends TextVocalRule {

    public TanweenRule() {
        Priority = 4;
    }

    @Override
    protected String evaluate(String text) {

        text = text.replaceAll("" + ArabicMoves.TANWEEN_FATEH + "|" + ArabicMoves.ALEF + ArabicMoves.TANWEEN_FATEH,
                "" + ArabicMoves.FATHAH + ArabicMoves.NOON);
        text = text.replaceAll("" + ArabicMoves.TANWEEN_DAMM,
                "" + ArabicMoves.DAMMAH + ArabicMoves.NOON);
        return text.replaceAll("" + ArabicMoves.TANWEEN_KASER,
                "" + ArabicMoves.KASRAH + ArabicMoves.NOON);
    }

}
