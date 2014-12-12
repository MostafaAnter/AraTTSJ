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
public class MaddaRule extends TextVocalRule {

    public MaddaRule() {
        Priority =3;
    }

    @Override
    protected String evaluate(String text) {
        return text.replaceAll(ArabicMoves.MADDA + "", "" + ArabicMoves.HAMZA
                + ArabicMoves.FATHAH + ArabicMoves.FATHAH
                + ArabicMoves.FATHAH);
    }
}
