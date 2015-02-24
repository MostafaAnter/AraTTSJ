/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core;

import tts.core.phonemes.PhonemeGenerator;

/**
 *
 *
 */
public abstract class ArabicMoves {

    /**
     * الفتحة
     */
    public static final char FATHAH = 'َ';
    /**
     * الضمة
     */
    public static final char DAMMAH = 'ُ';
    /**
     * الكسرة
     */
    public static final char KASRAH = 'ِ';
    /**
     * تنوين الفتح
     */
    public static final char TANWEEN_FATEH = 'ً';
    /**
     * تنوين الكسر
     */
    public static final char TANWEEN_KASER = 'ٍ';
    /**
     * تنوين الضم
     */
    public static final char TANWEEN_DAMM = 'ٌ';
    /**
     * ال التعريف
     */
    public static final String AL_TAAREEF = "ال";
    /**
     * المدّة
     */
    public static final char MADDA = 'آ';
    /**
     * الشدّة
     */
    public static final char SHADDA = 'ّ';

    /**
     * الهمزة بأشكالها مالختلفة
     */
    public static final String HAMZAT = "أ|إ|ؤ|ئ";

    //  الأحرف
    /**
     * ء
     */
    public static final char HAMZA = 'ء';
    /**
     * ا
     */
    public static final char ALEF = 'ا';
    /**
     * ى
     */
    public static final char ALEF_MAQSOORA = 'ى';
    /**
     * ب
     */
    public static final char BAA = 'ب';
    /**
     * ت
     */
    public static final char TAA = 'ت';
    /**
     * ة
     */
    public static final char TAA_MARBOOTA = 'ة';
    /**
     * ث
     */
    public static final char THAA = 'ث';
    /**
     * ج
     */
    public static final char GEEM = 'ج';
    /**
     * ح
     */
    public static final char HAAA = 'ح';
    /**
     * خ
     */
    public static final char KHAA = 'خ';
    /**
     * د
     */
    public static final char DAAL = 'د';
    /**
     * ذ
     */
    public static final char ZHAAL = 'ذ';
    /**
     * ر
     */
    public static final char RAA = 'ر';
    /**
     * ز
     */
    public static final char ZAI = 'ز';
    /**
     * س
     */
    public static final char SEEN = 'س';
    /**
     * ش
     */
    public static final char SHEEN = 'ش';
    /**
     * ص
     */
    public static final char SAAD = 'ص';
    /**
     * ض
     */
    public static final char DAAD = 'ض';
    /**
     * ط
     */

    public static final char TAH = 'ط';
    /**
     * ظ
     */
    public static final char ZHAH = 'ظ';
    /**
     * ع
     */
    public static final char AEEN = 'ع';
    /**
     * غ
     */
    public static final char GAEEN = 'غ';
    /**
     * ف
     */
    public static final char FAA = 'ف';
    /**
     * ق
     */
    public static final char QAF = 'ق';
    /**
     * ك
     */
    public static final char KAF = 'ك';
    /**
     * ل
     */
    public static final char LAM = 'ل';
    /**
     * م
     */
    public static final char MEEM = 'م';
    /**
     * ن
     */
    public static final char NOON = 'ن';
    /**
     * ه
     */
    public static final char HAA = 'ه';
    /**
     * و
     */
    public static final char WOW = 'و';
    /**
     * ي
     */
    public static final char YAA = 'ي';

    //علامات الترقيم
    /**
     * النقطة
     *
     * .
     */
    public static final char DOT = '.';

    /**
     * الفاصلة
     */
    public static final char COMMA = '،';
    /**
     * الفاصلة المنقوطة
     *
     * ؛
     *
     */
    public static final char SEMICOLON
            = '؛';
    /**
     * علامة الاستفهام
     *
     * ؟
     */
    public static final char QUESTION_MARK
            = '؟';
    /**
     * إشارة التعجب
     *
     * !
     */
    public static final char EXLAMATION_MARK
            = '!';
    /**
     * نقتطي القول
     *
     * :
     */
    public static final char SAY_DOTS
            = ':';

    /**
     * هل الحركة ضمة
     *
     * @param Letter الحرف الذي نريد مقانته
     * @return true في حال كان ضمة , false خلاف ذلك
     */
    public static boolean isDammah(char Letter) {
        return (Letter == ArabicMoves.DAMMAH) || (Letter == PhonemeGenerator.getPhonemeDB().get(ArabicMoves.DAMMAH).getPhoneme().charAt(0));
    }

    /**
     * هل الحركة فتحة
     *
     * @param Letter الحرف الذي نريد مقانته
     * @return true في حال كان فتحة , false خلاف ذلك
     */
    public static boolean isFathah(char Letter) {
        return (Letter == ArabicMoves.FATHAH) || (Letter == PhonemeGenerator.getPhonemeDB().get(ArabicMoves.FATHAH).getPhoneme().charAt(0));
    }

    /**
     * هل الحركة كسرة
     *
     * @param Letter الحرف الذي نريد مقانته
     * @return true في حال كان كسرة , false خلاف ذلك
     */
    public static boolean isKasrah(char Letter) {
        return (Letter == ArabicMoves.KASRAH) || (Letter == PhonemeGenerator.getPhonemeDB().get(ArabicMoves.KASRAH).getPhoneme().charAt(0));
    }

    public static boolean isPunctuationMark(char letter) {
        return (letter == ArabicMoves.QUESTION_MARK) || (letter == ArabicMoves.EXLAMATION_MARK) || (letter == ArabicMoves.DOT) || (letter == ArabicMoves.COMMA) || (letter == ArabicMoves.SAY_DOTS) || (letter == ArabicMoves.SEMICOLON);
    }

    /**
     * هل الحرف حركة
     *
     * @param Letter الحرف الذي نريد مقانته
     * @return true في حال كان حركة , false خلاف ذلك
     */
    public static boolean isMove(char Letter) {
        return isFathah(Letter) || isDammah(Letter) || isKasrah(Letter);
    }
}
