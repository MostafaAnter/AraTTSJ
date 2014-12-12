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
public class AlefMaqsouraRule extends VocalRule {

    public AlefMaqsouraRule() {
        Priority = 1;
    }

    @Override
    public String evaluate(String previousWord,String currentWord) {
        return currentWord.replaceAll(ArabicMoves.ALEF_MAQSOORA + "",
                "" + ArabicMoves.FATHAH + ArabicMoves.FATHAH);
    }

}
