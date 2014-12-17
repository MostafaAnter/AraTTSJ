/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 * قاعدة معالجة ألف التفريق.
 *
 * ألف التفريق تأتي بعد واو الجماعة في الماضي و بالتالي عندما تنتهي الكلمة بواو
 * و ألف نحذف هذه الألف
 *
 */
public class AlefTafreeqRule extends VocalRule {

    public AlefTafreeqRule() {
        Priority = 8;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        if (currentWord.endsWith("" + ArabicMoves.WOW + ArabicMoves.ALEF)) {
            currentWord = currentWord.substring(0, currentWord.length() - 1);
        }
        return currentWord;
    }

}
