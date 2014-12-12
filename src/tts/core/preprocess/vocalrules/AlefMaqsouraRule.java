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
public class AlefMaqsouraRule extends TextVocalRule {

    public AlefMaqsouraRule() {
        Priority = 1;
    }

    @Override
    protected String evaluate(String text) {
        return text.replaceAll(ArabicMoves.ALEF_MAQSOORA + "",
                "" + ArabicMoves.FATHAH + ArabicMoves.FATHAH);
    }

}
