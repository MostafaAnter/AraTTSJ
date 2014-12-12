/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core;

import tts.core.phonemes.types.Phoneme;
import tts.core.phonemes.PhonemeGenerator;
import tts.core.preprocess.PreProcesser;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import tts.core.phonemes.types.Word;

/**
 * هذا الصف هو الواجهة التي سيتعامل معها المسخدم لإنشاء المقاطع الصوتية من
 * النصوص الممرة له
 */
public class TTSEngine {

    private final PreProcesser pre;
    private final PhonemeGenerator gen;
    private Word[] words;
    private String error;

    /**
     * إنشاء و تهيئة نظام تحويل الكلام
     */
    public TTSEngine() {
        pre = new PreProcesser();
        gen = new PhonemeGenerator();
        gen.intializePhonemeDB();
    }

    /**
     * يقوم بتحويل النص لكلام
     *
     * @param text النص المراد تحويله لكلام
     * @param MBROLAPath مسار برنامج MBROLA
     * @param DBPath مسار قاعدة المقاطع الصوتية
     * @param AudioTarget مكان حفظ المقطع الصوتي
     * @return trueفي حال كان التحويل ناجحا و falseفي حال حدوث خطأ . في حال حدوث
     * خطأ استخدم التابع {@link TTSEngine#getError() }
     */
    public boolean convert(String text, String MBROLAPath, String DBPath, String AudioTarget) {
        words = pre.preProcess(text);
        words = gen.generatePhoneme(words);
        return true;
    }

    public Word[] getWords() {
        return words;
    }

    /**
     * لمعرفة الخطا في حال أعاد تابع التحويل قيمة false
     *
     * @return نص الخطأ في حال أعاد تابع التحويل قيمة false، نص فارغ خلاف ذلك
     */
    public String getError() {
        return error;
    }

}
