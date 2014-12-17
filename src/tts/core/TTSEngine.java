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
     * @return قائمة من الكلمات و الفونيمات الموافقة لهاو, null في حال حدوث خطأ
     * و لمعرفة الخطأ راجع {@link TTSEngine#getError() }
     */
    public Word[] convert(String text) {
        error = "";
        try {
            words = pre.preProcess(text);
            words = gen.generatePhoneme(words);
            return words;
        } catch (Exception e) {
            error = e.getMessage();
        }
        return null;
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
