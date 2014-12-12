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
public class TaaMarbotaRule extends VocalRule {

    public TaaMarbotaRule() {
        Priority = 6;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        if (currentWord.endsWith("" + ArabicMoves.TAA_MARBOOTA)) {
            currentWord = currentWord.replaceAll("" + ArabicMoves.TAA_MARBOOTA, "" + ArabicMoves.HAA);
        } else {
            currentWord = currentWord.replaceAll("" + ArabicMoves.TAA_MARBOOTA, "" + ArabicMoves.TAA);
        }
        return currentWord;
    }

}
