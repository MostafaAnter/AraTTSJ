/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.expertsystem;

import java.util.HashMap;
import java.util.Map;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionGaussian;
import net.sourceforge.jFuzzyLogic.membership.Value;
import tts.core.ArabicMoves;
import tts.core.listeners.TrainingEvent;
import tts.core.listeners.TrainingListener;
import tts.core.phonemes.types.EndType;
import tts.core.phonemes.types.Phoneme;
import tts.core.phonemes.types.Word;

/**
 * هذا الصف يمثل النظام الخبير
 */
public class ExpertOptimzer {

    /**
     * مسار ملف القواعد
     */
    private String RulePath;

    /**
     * محتويات ملف القواعد
     */
    private FIS FCLData;

    private TrainingListener listener;
    private double TrainLevel = 0;

    /**
     * بناء النظام الخبير
     *
     * @param RulePath مسار ملف القواعد
     * @throws IllegalArgumentException في حال وجود خطأ في قراءة ملف القواعد
     */
    public ExpertOptimzer(String RulePath) {
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
     * @param train إذا كانت قيمته true يتم تخزين الزمن الناتج ضمن الإحصائيات
     */
    public void optimizeTime(Phoneme p, boolean train) {
        int index = PhonemeInts.get(p.getPhoneme());
        FCLData.setVariable("CHAR_ID", index);
        FCLData.evaluate();
        int time = (int) Math.round(FCLData.getVariable("CHAR_TIME").getValue());
        p.setTime(time);
        //إضافة القيمة الجديدة للإحصائيات
        if (train) {
            Statistic.updateStatistic(time);
        }
    }

    /**
     * استدعاء النظام الخبير لتعديل المدد الزمنية لقائمة من الكلمات
     *
     * @param words الكلمات التي نرغب بتعديل مددها الزمنية
     * @param train إذا كانت قيمته true يتم تخزين الزمن الناتج ضمن الإحصائيات
     * @param TrainingRounds
     * @param RoundNumber
     */
    public void OptimizeList(Word words[], boolean train, int TrainingRounds, int RoundNumber) {
        String stashed = "";
        boolean isHamzah = false;
        //أخذ آخر نسخة من الإحصائيات
        double short_avg = Statistic.getStatistic(Statistic.STAT_SHORT).getAverage();
        double short_std = Statistic.getStatistic(Statistic.STAT_SHORT).getStandardDeviation();
        double med_avg = Statistic.getStatistic(Statistic.STAT_MEDIUM).getAverage();
        double med_std = Statistic.getStatistic(Statistic.STAT_MEDIUM).getStandardDeviation();
        double long_avg = Statistic.getStatistic(Statistic.STAT_LONG).getAverage();
        double long_std = Statistic.getStatistic(Statistic.STAT_LONG).getStandardDeviation();
        //تغييرها ضمن النظام الخبير
        FCLData.getVariable("CHAR_TIME").getLinguisticTerm("SHORT").
                setMembershipFunction(new MembershipFunctionGaussian(new Value(short_avg), new Value(short_std)));
        FCLData.getVariable("CHAR_TIME").getLinguisticTerm("MEDIUM").
                setMembershipFunction(new MembershipFunctionGaussian(new Value(med_avg), new Value(med_std)));
        FCLData.getVariable("CHAR_TIME").getLinguisticTerm("LONG").
                setMembershipFunction(new MembershipFunctionGaussian(new Value(long_avg), new Value(long_std)));
        //معالجة الكلمات
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].getPhonemes().length; j++) {
                Phoneme phoneme = words[i].getPhonemes()[j];
                //هل الفونيم مقطع نظامي و ليس فراغ؟
                //هل الفونيم حرف ؟
                //هل هو حركة تنوب عن همزة ؟
                //هل هو فتحة تنوب عن ألف
                //في حال تححق أحد هذه الشروط مرره للنظام الخبير
                if (validPhoneme(phoneme, i, j, words)) {
                    isHamzah = isHamzah(phoneme, i, j, words);
                    if (isHamzah) {
                        stashed = phoneme.getPhoneme();
                        phoneme.setPhoneme("?");
                    }
                    optimizeTime(phoneme, train);
                    if (isHamzah) {
                        phoneme.setPhoneme(stashed);
                        isHamzah = false;
                    }
                } else if (ArabicMoves.isMove(phoneme.getPhoneme().charAt(0))) {
                    phoneme.setTime(words[i].getPhonemes()[j - 1].getTime() / 2);
                }
            }
            if (train && listener != null) {
                TrainLevel = ((RoundNumber * words.length + 1.0 + i) / (TrainingRounds * words.length)) * 100;
                listener.trainingStatusChanged(new TrainingEvent(TrainLevel));
            }
        }
    }

    private boolean isHamzah(Phoneme phoneme, int i, int j, Word words[]) {
        return (j == 0) && (ArabicMoves.isMove(phoneme.getPhoneme().charAt(0))
                && (i == 0 || (EndType.isEndOfSenctence(words[i - 1].getEnd()))));
    }

    private boolean validPhoneme(Phoneme phoneme, int i, int j, Word words[]) {
        return !phoneme.getPhoneme().equals("_")
                && (!ArabicMoves.isMove(phoneme.getPhoneme().charAt(0))
                || isHamzah(phoneme, i, j, words)
                || (ArabicMoves.isFathah(phoneme.getPhoneme().charAt(0)) && phoneme.getTime() > 50));
    }

    /**
     * مسؤول عن إجراء عملية التدريب للنظام الخبير
     *
     * @param trainRounds عدد دورات التدريب أي كم مرة سيتم معالجة بيانات الدخل
     * @param shortTime مصفوفة من عنصرين الأول المتوسط الحسابي و الثاني الانحراف
     * المعياري للزمن القصير
     * @param medTime مصفوفة من عنصرين الأول المتوسط الحسابي و الثاني الانحراف
     * المعياري للزمن المتوسط
     * @param longTime مصفوفة من عنصرين الأول المتوسط الحسابي و الثاني الانحراف
     * المعياري للزمن الطويل
     * @param trainData قائمة ببيانات التدريب
     * @param listener
     */
    public void train(int trainRounds, double shortTime[], double medTime[], double longTime[], Word trainData[], TrainingListener listener) {
        this.listener = listener;
        TrainLevel = 0;
        Statistic.initializeStatistics(shortTime, medTime, longTime);
        for (int i = 0; i < trainRounds; i++) {
            OptimizeList(trainData, true, trainRounds, i);
        }
    }

    private static final Map<String, Integer> PhonemeInts = new HashMap<>();

    public static Map<String, Integer> getPhonemeInts() {
        return PhonemeInts;
    }

}
