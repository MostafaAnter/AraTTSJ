/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 * قاعدة معالجة حرف الألف.
 * 
 * نستبدل حرف الألف بفتحتين متتالتين
 */
public class AlefRule extends VocalRule {

    public AlefRule() {
        Priority = 10;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        return currentWord.replaceAll("" + ArabicMoves.ALEF + "|"
                + ArabicMoves.ALEF + ArabicMoves.FATHAH + "|"
                + ArabicMoves.ALEF + ArabicMoves.DAMMAH + "|"
                + ArabicMoves.ALEF + ArabicMoves.KASRAH, "" + ArabicMoves.FATHAH + ArabicMoves.FATHAH);
    }

}
