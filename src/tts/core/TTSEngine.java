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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
    int index = 0;

    /**
     * إنشاء و تهيئة نظام تحويل الكلام
     */
    private TTSEngine() {
        pre = new PreProcesser();
        gen = new PhonemeGenerator();
        gen.initializeGenerator();
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

    /**
     * يقوم هذا التابع بتوليد الملف الصوتي.
     *
     * سيكون ناتج تنفيذ هذا التابع ملفان الأول يحوي المقاع الصوتية و الثانية هو
     * الكلام بعد أن حول لمقطع صوتي
     *
     * @param MBROLA مسار برنامج MBROLA
     * @param PhonemeDB مسار قاعدة بيانات المقاطع الصوتية
     * @param Target مسار حفظ الملف الصوتي
     * @param Transcription إنشاء ملف مقاطع للاستخدام مع أداة MBROLIGN
     * @return true في حال كان التحويل ناجحاً, false إذا لم ينجح و لمعرفة تفاصيل
     * عدم النجاح استدعي التابع {@link TTSEngine#getError()}
     */
    public boolean createAudio(String MBROLA, String PhonemeDB, String Target, boolean Transcription) {
        try {
            //التحقق من وجود الملفات مسبقا و حذفها إذا كانت موجودة
            File wav = new File(Target);
            if (wav.exists()) {
                wav.delete();
            }
            File pho = createPho(Target);
            //إنشاء ملف المقاطع
            if (Transcription) {
                createTranscription(Target);
            }
            //   استدعاء برنامح MBROLA
            //و الانتظار حتى انتهاء التنفيذ
            Runtime rt = Runtime.getRuntime();
            rt.exec(new String[]{
                MBROLA, PhonemeDB, pho.getAbsolutePath(), Target
            }).waitFor();
            return true;
        } catch (IOException | InterruptedException e) {
            error = e.getMessage();
            return false;
        }
    }

    private void createTranscription(String Target) throws FileNotFoundException {
        File trans = new File(Target.replace(".wav", ".txt"));
        if (trans.exists()) {
            trans.delete();
            
        }
        StringBuilder build = new StringBuilder();
        for (Word word : words) {
            for (Phoneme phoneme : word.getPhonemes()) {
                build.append(phoneme.getPhoneme()).append(" ");
            }
        }
        PrintWriter out = new PrintWriter(trans.getAbsolutePath());
        out.print(build.toString());
        out.flush();
        out.close();
    }

    private File createPho(String Target) throws FileNotFoundException {
        File pho = new File(Target.replace(".wav", ".pho"));
        if (pho.exists()) {
            pho.delete();

        }
        //إنشاء ملف
        //pho
        PrintWriter out = new PrintWriter(pho);
        for (Word word : words) {
            for (Phoneme phoneme : word.getPhonemes()) {
                out.println(phoneme.toString());
                out.flush();
            }
        }
        out.close();
        return pho;
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

    /**
     * استخدام نموذج Singleton في إنشاء الصف TTS Engine
     *
     */
    private static TTSEngine tts;

    /**
     * الحصول على TTS Engine.
     *
     * في حال لم يكن موجوداً يتم إنشاؤه و يكون وحيداً
     *
     * @return TTSEngine
     */
    public static TTSEngine getTTSEngine() {
        if (tts == null) {
            tts = new TTSEngine();
        }
        return tts;
    }
}
