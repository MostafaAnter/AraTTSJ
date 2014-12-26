/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core;

/**
 *
 *
 */
public interface ArabicMoves {

    /**
     * الفتحة
     */
    char FATHAH = 'َ';
    /**
     * الضمة
     */
    char DAMMAH = 'ُ';
    /**
     * الكسرة
     */
    char KASRAH = 'ِ';
    /**
     * تنوين الفتح
     */
    char TANWEEN_FATEH = 'ً';
    /**
     * تنوين الكسر
     */
    char TANWEEN_KASER = 'ٍ';
    /**
     * تنوين الضم
     */
    char TANWEEN_DAMM = 'ٌ';
    /**
     * ال التعريف
     */
    String AL_TAAREEF = "ال";
    /**
     * المدّة
     */
    char MADDA = 'آ';
    /**
     * الشدّة
     */
    char SHADDA = 'ّ';

    /**
     * الهمزة بأشكالها مالختلفة
     */
    String HAMZAT = "أ|إ|ؤ|ئ";

    //  الأحرف
    /**
     * ء
     */
    char HAMZA = 'ء';
    /**
     * ا
     */
    char ALEF = 'ا';
    /**
     * ى
     */
    char ALEF_MAQSOORA = 'ى';
    /**
     * ب
     */
    char BAA = 'ب';
    /**
     * ت
     */
    char TAA = 'ت';
    /**
     * ة
     */
    char TAA_MARBOOTA = 'ة';
    /**
     * ث
     */
    char THAA = 'ث';
    /**
     * ج
     */
    char GEEM = 'ج';
    /**
     * ح
     */
    char HAAA = 'ح';
    /**
     * خ
     */
    char KHAA = 'خ';
    /**
     * د
     */
    char DAAL = 'د';
    /**
     * ذ
     */
    char ZHAAL = 'ذ';
    /**
     * ر
     */
    char RAA = 'ر';
    /**
     * ز
     */
    char ZAI = 'ز';
    /**
     * س
     */
    char SEEN = 'س';
    /**
     * ش
     */
    char SHEEN = 'ش';
    /**
     * ص
     */
    char SAAD = 'ص';
    /**
     * ض
     */
    char DAAD = 'ض';
    /**
     * ط
     */

    char TAH = 'ط';
    /**
     * ظ
     */
    char ZHAH = 'ظ';
    /**
     * ع
     */
    char AEEN = 'ع';
    /**
     * غ
     */
    char GAEEN = 'غ';
    /**
     * ف
     */
    char FAA = 'ف';
    /**
     * ق
     */
    char QAF = 'ق';
    /**
     * ك
     */
    char KAF = 'ك';
    /**
     * ل
     */
    char LAM = 'ل';
    /**
     * م
     */
    char MEEM = 'م';
    /**
     * ن
     */
    char NOON = 'ن';
    /**
     * ه
     */
    char HAA = 'ه';
    /**
     * و
     */
    char WOW = 'و';
    /**
     * ي
     */
    char YAA = 'ي';

    //علامات الترقيم
    /**
     * النقطة
     *
     * .
     */
    char DOT = '.';

    /**
     * الفاصلة
     */
    char COMMA = '،';
    /**
     * الفاصلة المنقوطة
     *
     * ؛
     *
     */
    char SEMICOLON
            = '؛';
    /**
     * علامة الاستفهام
     *
     * ؟
     */
    char QUESTION_MARK
            = '؟';
    /**
     * إشارة التعجب
     *
     * !
     */
    char EXLAMATION_MARK
            = '!';
    /**
     * نقتطي القول
     *
     * :
     */
    char SAY_DOTS
            = ':';
}
