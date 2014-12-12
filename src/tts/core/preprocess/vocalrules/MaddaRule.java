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
public class MaddaRule extends VocalRule {

    public MaddaRule() {
        Priority =5;
    }

    @Override
    public String evaluate(String previousWord,String currentWord) {
        return currentWord.replaceAll(ArabicMoves.MADDA + "", "" + ArabicMoves.HAMZA
                + ArabicMoves.FATHAH + ArabicMoves.FATHAH
                + ArabicMoves.FATHAH);
    }
}
