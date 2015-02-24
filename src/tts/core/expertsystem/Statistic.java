/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.expertsystem;

import java.util.LinkedList;
import java.util.List;

/**
 * وظيفة هذا الصف تمثيل المعلومات الإحصائية الخاصة بالفئات الزمنية
 */
public class Statistic {

    /**
     * البيانات الإحصائية
     */
    protected List<Integer> stat;
    /**
     * اسم الإحصائية
     */
    protected String name;

    /**
     * إنشاء إحصائية جديدة
     *
     * @param Name اسم الإحصائية
     * @throws IllegalArgumentException في حال كان اسم الإحصائية فارغ
     */
    public Statistic(String Name) {
        if (Name == null || Name.trim().equals("")) {
            throw new IllegalArgumentException("Statistic name cannot be null or empty string");
        }
        name = Name;
        stat = new LinkedList<>();
    }

    /**
     * إضافة قيمة جديدة للإحصائية
     *
     * @param value القيمة الجديدة
     */
    public void update(Integer value) {
        stat.add(value);
    }

    /**
     * معرفة مجموع قيم الإحصائية
     *
     * @return مجموع قيم الإحصائية، 0 في حال لم توجد أي قيمة
     */
    public int getSum() {
        int sum = 0;
        for (Integer i : stat) {
            sum += i;
        }
        return sum;
    }

    /**
     * معرفة المتوسط الحسابي
     *
     * @return المتوسط الحسابي،-1 في حال لم توجد قيمة
     */
    public double getAverage() {
        if (stat.isEmpty()) {
            return -1;
        }
        return getSum() * 1.0 / stat.size();
    }

    /**
     * حساب قيمة الانحراف المعياري
     *
     * @return قيمة الانحراف المعياري،-1 في حال لم توجد إحصائيات
     */
    public double getStandardDeviation() {
        if (stat.isEmpty()) {
            return -1;
        }
        double avg = getAverage();
        double sum = 0;
        for (Integer value : stat) {
            sum += Math.pow(value - avg, 2);
        }
        sum /= stat.size();
        return Math.sqrt(sum);
    }

    /**
     * معرفة عدد العناصر التي تخزنها الإحصائية
     *
     * @return عدد العناصر التي تخزنها الإحصائية
     */
    public int getCount() {
        return stat.size();
    }

    /**
     * حذف كل القيم من الإحصائية
     */
    public void reset() {
        stat.clear();
    }
}
