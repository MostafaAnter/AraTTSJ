/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

import java.util.ArrayList;

/**
 * المقطع الصوتي بكل بياناته
 */
public class Phoneme implements Cloneable {

    private String Phoneme;
    private int Time;
    private ArrayList<Pitch> Pitch;

    /**
     * إنشاء مقطع صوتي
     *
     * @param Phoneme رمز المقطع الصوتي كما في قاعدة المقاطع الصوتية
     * @param Time زمن المقطع الصوتي مقدراً بالميلي ثانية
     */
    public Phoneme(String Phoneme, int Time) {
        this.Phoneme = Phoneme;
        this.Time = Time;
        Pitch = new ArrayList<>();
    }

    /**
     * تحويل قائمة الطبقات لسلسة نصية
     *
     * @return قائمة الطبقات كلسلسة نصية
     */
    public String pitchString() {
        String res = "";
        for (Pitch Pitch1 : Pitch) {
            res += Pitch1.toString();
        }
        return res;
    }

    @Override
    public String toString() {
        return Phoneme + " " + Time + " " + pitchString();
    }

    /**
     * قائمة الطبقات كمصوفة
     *
     * @return قائمة الطبقات كمصوفة
     */
    public ArrayList<Pitch> getPitch() {
        return Pitch;
    }

    /**
     * تغيير قائمة الطبقات
     *
     * @param Pitch قائمة الطبقات الجديدة
     * @throws IllegalArgumentException في حال كانت القيمة المررة هي null
     */
    public void setPitch(ArrayList<Pitch> Pitch) {
        if (Pitch == null) {
            throw new IllegalArgumentException("Pitch array list cannot be null");
        }
        this.Pitch = Pitch;
    }

    @Override
    public Object clone() {
        Phoneme val = new Phoneme(Phoneme, Time);
        val.setPitch((ArrayList<Pitch>) Pitch.clone());
        return val;
    }

    /**
     * المقطع الصوتي
     *
     * @return المقطع الصوتي
     */
    public String getPhoneme() {
        return Phoneme;
    }

    /**
     * تعديل المقطع الصوتي
     *
     * @param Phoneme المقطع الصوتي الجديد
     */
    public void setPhoneme(String Phoneme) {
        this.Phoneme = Phoneme;
    }

    /**
     * المدة الزمنية للمقطع
     *
     * @return المدة الزمنية للمقطع مقدرةً بالميلي ثانية
     */
    public int getTime() {
        return Time;
    }

    /**
     * تغيير المدة الزمنية للمقطع
     *
     * @param Time المدة الزمنية الجديدة مقدرةً بالميلي ثانية
     */
    public void setTime(int Time) {
        this.Time = Time;
    }

}
