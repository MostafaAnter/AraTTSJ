/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

import java.util.ArrayList;

/**
 * هذا الصف يمثل الكلمة ضمن العبارة بكل تفاصيلها.
 *
 * تشمل التفاصيل :
 * <ol>
 * <li>الكتابة الأصلية للكلمة</li>
 * <li>الكتابة اللفظية</li>
 * <li>قائمة بالمقاع الصوتية المكونة للكلمة</li>
 * <li>نوع نهاية الكلمة ( للتفاصيل راجع {@link EndType})</li>
 * </ol>
 */
public class Word {

    private String Normal, Vocal;
    ArrayList<Phoneme> phonemes;
    private EndType end;

    /**
     * إنشاء كلمة جديدة
     *
     * @param Normal الكتابة الأصلية
     * @param Vocal الكتابة الصوتية
     * @param end نوع النهاية
     */
    public Word(String Normal, String Vocal, EndType end) {
        this.Normal = Normal;
        this.Vocal = Vocal;
        this.phonemes = new ArrayList<>();
        this.end = end;
    }

    /**
     * تغيير نوع المهاية
     *
     * @param end النهاية الجديدة
     */
    public void setEnd(EndType end) {
        this.end = end;
    }

    /**
     * قراءة الكتابة الأصلية للكلمة
     *
     * @return الكتابة الأصلية للكلمة
     */
    public String getNormal() {
        return Normal;
    }

    /**
     * تغيير الكتابة الأصلية للكملة
     *
     * @param Normal الكتابة الأصلية الجديدة
     */
    public void setNormal(String Normal) {
        this.Normal = Normal;
    }

    /**
     * قراءة الكتابة الصوتية للكلمة
     *
     * @return الكتابة الصوية للكلمة
     */
    public String getVocal() {
        return Vocal;
    }

    /**
     * تغيير الكتابة الصوتية للكلمة
     *
     * @param Vocal الكتابة الصوتية الجديدة
     */
    public void setVocal(String Vocal) {
        this.Vocal = Vocal;
    }

    /**
     * قراءة قائمة المقاطع الصوتية بصيغ قابلة للتعديل
     *
     * @return قائمة المقاطع الصوتية بصيغ قابلة للتعديل
     */
    public ArrayList<Phoneme> getPhonemeList() {
        return phonemes;
    }

    /**
     * قراءة المقاطع الصوتية بصيغة غير قابلة للتعديل
     *
     * @return المقاطع الصوتية بصيغة غير قابلة للتعديل
     */
    public Phoneme[] getPhonemes() {
        Phoneme[] result = new Phoneme[phonemes.size()];
        result = phonemes.toArray(result);
        return result;

    }

    /**
     * قراءة نهاية الكلمة
     *
     * @return نهاية الكلمة
     */
    public EndType getEnd() {
        return end;
    }

}
