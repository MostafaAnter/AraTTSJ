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

/**
 * هذا الصف هو الواجهة التي سيتعامل معها المسخدم لإنشاء المقاطع الصوتية من
 * النصوص الممرة له
 */
public class TTSEngine {

    private final PreProcesser pre;
    private final PhonemeGenerator gen;
    private Phoneme[] phonemes;
    private String[] vocals;
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
        error = "";
        try {
            //معرفة مسار الملف الصوتي
            String path = AudioTarget.substring(0, AudioTarget.lastIndexOf(System.getProperty("file.separator")) + 1);
            //بدء عملية التحويل
            //أولاً المعالجة المسبقة
            vocals = pre.preProcess(text);
            //التحويل لمقاطع صوتية
            phonemes = gen.generatePhoneme(vocals);
            //كتابة المقاطع الصوتية إلى ملف .pho

            File opho = new File(path + "out.pho");
            if (opho.exists()) {
                opho.delete();
            }
            //كتابة ملف المقاطع الصوتية
            PrintWriter out = new PrintWriter(opho);
            for (Phoneme phoneme : phonemes) {
                out.println(phoneme);
                out.flush();
            }
            out.close();
            //بدء التحويل إلى صوت
            File owav = new File(AudioTarget);
            if (owav.exists()) {
                owav.delete();
            }
//            تشغيل الـ MBROLA
            Scanner in = new Scanner(Runtime.getRuntime().exec(new String[]{MBROLAPath, DBPath, opho.getAbsolutePath(), owav.getAbsolutePath()}).getErrorStream());
            String result = "";
            while (in.hasNext()) {
                result += in.nextLine();
            }
            //التنفيذ تم بدون مشاكل
            if (!result.equals("")) {
                //من أجل معرفة الخطأ
                error = result;
                return false;
            }
        } catch (Exception e) {
            //من أجل معرفة الخطأ
            error = e.getMessage();
            return false;
        }
        return true;
    }

    /**
     * لمعرفة المقاطع الصوتية المستخدمة في التحويل
     *
     * @return قائمة المقاطع الصوتية المستخدمة في التحويل
     */
    public Phoneme[] getPhonemes() {
        return phonemes;
    }

    /**
     * لمعرفة الكتابة الصوتية الموافقة للنص المكتوب
     *
     * @return الكتابة الصوتية الموافقة للنص المكتوب
     */
    public String[] getVocals() {
        return vocals;
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
