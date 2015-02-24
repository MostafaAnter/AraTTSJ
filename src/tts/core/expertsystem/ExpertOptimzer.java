/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.expertsystem;

import java.util.HashMap;
import java.util.Map;
import net.sourceforge.jFuzzyLogic.FIS;
import tts.core.phonemes.types.Phoneme;

/**
 * هذا الصف يمثل النظام الخبير
 */
public class ExpertOptimzer {

    /**
     * احصائية الزمن القصير
     */
    public static int STAT_SHORT = 0;

    /**
     * احصائية الزمن المتوسط
     */
    public static int STAT_MEDIUM = 1;

    /**
     * احصائية الزمن الطويل
     */
    public static int STAT_LONG = 2;

    /**
     * مسار ملف القواعد
     */
    private String RulePath;

    /**
     * محتويات ملف القواعد
     */
    private FIS FCLData;

    /**
     * الاحصائيات
     */
    private final Statistic[] stats;

    private static final Map<String, Integer> PhonemeInts = new HashMap<>();

    public static Map<String, Integer> getPhonemeInts() {
        return PhonemeInts;
    }

    /**
     * بناء النظام الخبير
     *
     * @param RulePath مسار ملف القواعد
     * @throws IllegalArgumentException في حال وجود خطأ في قراءة ملف القواعد
     */
    public ExpertOptimzer(String RulePath) {
        stats = new Statistic[3];
        stats[STAT_SHORT] = new Statistic("Short Time");
        stats[STAT_MEDIUM] = new Statistic("Medium Time");
        stats[STAT_LONG] = new Statistic("Long Time");
        setRulePath(RulePath);
    }

    /**
     * تحديد مسار ملف القواعد
     *
     * @param RulePath مسار ملف القواعد
     * @throws IllegalArgumentException في حال وجود خطأ في قراءة ملف القواعد
     */
    public final void setRulePath(String RulePath) {
        this.RulePath = RulePath;
        FCLData = FIS.load(RulePath);
        if (FCLData == null) {
            throw new IllegalArgumentException(RulePath + " Not a valid FCL file");
        }
    }

    /**
     * استدعاء النظام الخبير لتعديل المدد الزمنية
     *
     * @param p الفونيم الذي نريد تعديل مدته الزمنية
     */
    public void optimizeTime(Phoneme p) {
        int index = PhonemeInts.get(p.getPhoneme());
        FCLData.setVariable("CHAR_ID", index);
        FCLData.evaluate();
        int time = (int) Math.round(FCLData.getVariable("CHAR_TIME").getValue());
        p.setTime(time);

    }

}
