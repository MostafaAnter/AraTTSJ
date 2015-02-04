/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 *
 * قاعدة معالجة اللام الشمسية.
 *
 * تعالج اللام الشمسية بأن تستبدل بهمزة في حال كانت في بداية الجملة و تحذف
 * خلافاً لذلك
 */
public class LaamShamsyRule extends VocalRule {

    /**
     * الكلمة ابتدأت بأل تعريف عادية
     */
    public static int AL_TAREEF_NORMAL = 1;
    /**
     * الكلمة ابتدأت بأل تعريف مسبوقة بحرف الجر الباء
     */
    public static int AL_TAREEF_BAA = 2;
    /**
     * الكلمة ابتدأت بأل تعريف مسبوقة بحرف الجر اللام
     */
    public static int AL_TAREEF_LAAM = 3;
    /**
     * الكلمة لم تبدأ بأل تعريف
     */
    public static int AL_TAREEF_NONE = 4;
    /**
     * قائمة بالأحرف الشمسية
     */
    static final char[] SHAMS_LETTERS = {ArabicMoves.TAA, ArabicMoves.THAA,
        ArabicMoves.DAAL, ArabicMoves.ZHAAL, ArabicMoves.RAA, ArabicMoves.ZAI,
        ArabicMoves.SEEN, ArabicMoves.SHEEN, ArabicMoves.SAAD, ArabicMoves.DAAD,
        ArabicMoves.TAH, ArabicMoves.ZHAH, ArabicMoves.LAM, ArabicMoves.NOON};

    public LaamShamsyRule() {
        Priority = 2;
    }

    /**
     * تفحص أل التعريف الموجودة في بداية الكلمة
     *
     * @param word الكلمة المراد فحصها
     * @return إما {@link LaamShamsyRule#AL_TAREEF_NONE} أو
     * {@link LaamShamsyRule#AL_TAREEF_NORMAL} أو
     * {@link LaamShamsyRule#AL_TAREEF_BAA} أو
     * {@link LaamShamsyRule#AL_TAREEF_LAAM}
     */
    protected int isStartAlTareef(String word) {

        if (word.startsWith(ArabicMoves.AL_TAAREEF)) {
            return AL_TAREEF_NORMAL;
        }
        if (word.startsWith("" + ArabicMoves.LAM + ArabicMoves.KASRAH + ArabicMoves.LAM)) {
            return AL_TAREEF_LAAM;
        }
        if (word.startsWith("" + ArabicMoves.BAA + ArabicMoves.KASRAH + ArabicMoves.AL_TAAREEF)) {
            return AL_TAREEF_BAA;
        }
        return AL_TAREEF_NONE;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {

        if (isStartAlTareef(currentWord) == AL_TAREEF_NORMAL) {
            currentWord = handleNormal(currentWord, previousWord);
        } else if (isStartAlTareef(currentWord) == AL_TAREEF_BAA || isStartAlTareef(currentWord) == AL_TAREEF_LAAM) {
            currentWord = handleLamBaa(currentWord);
        }
        return currentWord;
    }

    /**
     * معالجة اللام الشمسية في الحالة العادية
     *
     * @param currentWord الكلمة التي تتم معالجتها
     * @param previousWord الكلمة السابقة للكلمة الحالية
     * @return الكلمة بعد معالجتها
     */
    private String handleNormal(String currentWord, String previousWord) {
        for (int i = 0; i < SHAMS_LETTERS.length; i++) {

            if (currentWord.charAt(2) == SHAMS_LETTERS[i]) {
                if (previousWord == null || isEndOfSentence(previousWord)) {
                    currentWord = "" + ArabicMoves.HAMZA + ArabicMoves.FATHAH + currentWord.substring(2);
                } else {
                    currentWord = currentWord.substring(2);
                }
                break;
            }
        }
        return currentWord;
    }

    /**
     * معالجة اللام الشمسية في حال سبقت بالباء أو اللام كأحرف جر
     *
     * @param currentWord الكلمة المراد معالجتها
     * @return الكلمة بعد المعالجة
     */
    private String handleLamBaa(String currentWord) {
        /*
         *هنا سنبحث عن لام ألف التعريف فإذا كانت في المحرف الثاني فهي مسبوقة بحرف الجر اللام
         أما إذا كانت في المحرف الثالث فهي مسبوقة بحرف الجر الباء
         */
        //في حال كانت مسبوقة بلام فإن الحرف الأول سيكون لام أيضا
        //و عليه يجب أن نتجه للحرف الثالث
        int index = 2;
        //عدد الحروف التي يجب أن نحذفها في حال سبقة أل التعريف بلام فهو حرف واحد
        int len = 0;
        //في حال لم يكن هذا الحرف لام فإننا في حال سبق أل التعريف بالباء  بالتالي هي المحرف الرابع
        if (currentWord.charAt(index) != ArabicMoves.LAM) {
            index = 3;
            //في حال سبقة بباء فهما حرفان
            len = 1;
        }
        for (int i = 0; i < SHAMS_LETTERS.length; i++) {
            //هل اللام التي نعالجها شمسية ؟
            if (currentWord.charAt(index + 1) == SHAMS_LETTERS[i]) {
                currentWord = currentWord.substring(0, index - len) + currentWord.substring(index + 1);
                break;
            }
        }
        return currentWord;
    }

}
