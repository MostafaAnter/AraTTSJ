/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 *
 * قاعدة معالجة التنوين.
 *
 * يعالح التنوين كما يلي:
 * <ul>
 * <li>تنوين الفتح يستبدل يفتحة و حرف النون</li>
 * <li>تنوين الضم يستبدل بضمة و حرف النون</li>
 * <li>تنوين الكسر يستبدل بكسرة و حرف النون</li>
 * </ul>
 */
public class TanweenRule extends VocalRule {

    public TanweenRule() {
        Priority = 9;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {

        currentWord = currentWord.replaceAll("" + ArabicMoves.TANWEEN_FATEH + "|" + ArabicMoves.ALEF + ArabicMoves.TANWEEN_FATEH,
                "" + ArabicMoves.FATHAH + ArabicMoves.NOON);
        currentWord = currentWord.replaceAll("" + ArabicMoves.TANWEEN_DAMM,
                "" + ArabicMoves.DAMMAH + ArabicMoves.NOON);
        return currentWord.replaceAll("" + ArabicMoves.TANWEEN_KASER,
                "" + ArabicMoves.KASRAH + ArabicMoves.NOON);
    }

}
