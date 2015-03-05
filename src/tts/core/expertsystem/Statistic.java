/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.expertsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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
     * المتوسط الابتدائي
     */
    private double init_avg;
    /**
     * الانحراف المعياري الابتدائي
     */
    private double init_std;

    /**
     * إنشاء إحصائية جديدة
     *
     * @param Name اسم الإحصائية
     * @param init_avg المتوسط الابتدائي
     * @param init_std الانحراف المعياري الابتدائي
     * @throws IllegalArgumentException في حال كان اسم الإحصائية فارغ
     */
    Statistic(String Name, double init_avg, double init_std) {
        if (Name == null || Name.trim().equals("")) {
            throw new IllegalArgumentException("Statistic name cannot be null or empty string");
        }
        name = Name;
        stat = new LinkedList<>();
        this.init_std = init_std;
        this.init_avg = init_avg;
    }

    /**
     * إضافة قيمة جديدة للإحصائية
     *
     * @param value القيمة الجديدة
     */
    void update(Integer value) {
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
     * @return المتوسط الحسابي، و في حال عدم وجود قيم فإنه يعيد القيمة init_avg
     * الممررة في الباني
     */
    public double getAverage() {
        if (stat.isEmpty()) {
            return init_avg;
        }
        return getSum() * 1.0 / stat.size();
    }

    /**
     * حساب قيمة الانحراف المعياري
     *
     * @return الانحراف المعياري، و في حال عدم وجود قيم فإنه يعيد القيمة
     * init_std الممررة في الباني
     */
    public double getStandardDeviation() {
        if (stat.isEmpty()) {
            return init_std;
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
     * الاحصائيات
     */
    private static Statistic[] stats;

    /**
     * تهئية الإحصائيات
     *
     * @param shortTime مصفوفة من عنصرين الأول المتوسط الحسابي و الثاني الانحراف
     * المعياري للزمن القصير
     * @param medTime مصفوفة من عنصرين الأول المتوسط الحسابي و الثاني الانحراف
     * المعياري للزمن المتوسط
     * @param longTime مصفوفة من عنصرين الأول المتوسط الحسابي و الثاني الانحراف
     * المعياري للزمن الطويل
     */
    public static void initializeStatistics(double shortTime[], double medTime[], double longTime[]) {

        stats = new Statistic[3];
        stats[STAT_LONG] = new Statistic("long", longTime[0], longTime[1]);
        stats[STAT_SHORT] = new Statistic("short", shortTime[0], shortTime[1]);
        stats[STAT_MEDIUM] = new Statistic("medium", medTime[0], medTime[1]);

    }

    /**
     * تقوم بإضافة الوقت الجديد للفئة المناسبة و تقوم بتحديث الإحصائيات.
     *
     * اختيار الفئة يعتمد على مفهوم أقرب جار إذ يتم حساب الفروقات بين الوقت
     * الممرر و متوسطات كل فئة و الفرق الأقل يمقل الفئة التي ينتمي لها الوقت. في
     * حال تساوي الفرق بين الوقت الممرر و فئتين يتم إضفة الوقت لكلا هاتين
     * الفئتين
     *
     * @param time الوقت الجديد
     */
    public static void updateStatistic(int time) {
        //حساب الفروقات
        double short_diff = Math.abs(stats[STAT_SHORT].getAverage() - time);
        double med_diff = Math.abs(stats[STAT_MEDIUM].getAverage() - time);
        double long_diff = Math.abs(stats[STAT_LONG].getAverage() - time);
        //هل يوجد فرقين متساويين أي هل الفرق بين الوقت و فئة الزمن القصير
        //مساو للفرق بين الوقت و فئة الزمن المتوسط ؟
        //و الفرق بين الوقت و الزمن المتوسط و الوقت و الزمن الطويل
        if (short_diff == med_diff && short_diff < long_diff) {
            stats[STAT_SHORT].update(time);
            stats[STAT_MEDIUM].update(time);
        } else if (long_diff == med_diff && long_diff < short_diff) {
            stats[STAT_LONG].update(time);
            stats[STAT_MEDIUM].update(time);
        } else {
            //علينا تحديد الفئة الصحيحة بالمقارنة بين القيم الثلاثة
            if (short_diff < med_diff && short_diff < long_diff) {
                stats[STAT_SHORT].update(time);
            } else if (med_diff < short_diff && med_diff < long_diff) {
                stats[STAT_MEDIUM].update(time);
            } else {
                stats[STAT_LONG].update(time);
            }
        }
    }

    /**
     * للإطلاع على قيم إحصائية
     *
     * @param StatisticID رقم الإحصائية : إما {@link Statistic#STAT_SHORT} أو
     * {@link Statistic#STAT_MEDIUM} أو {@link Statistic#STAT_LONG}
     * @return الإحصائية
     */
    public static Statistic getStatistic(int StatisticID) {
        return stats[StatisticID];
    }

    public static void loadFromFile(String filename) throws FileNotFoundException, IOException {
        double zero[] = new double[]{0, 0};
        initializeStatistics(zero, zero, zero);
        BufferedReader in = new BufferedReader(new FileReader(filename));
        for (int i = 0; i < 3; i++) {
            String[] values = in.readLine().split("\\$");
            stats[i].init_avg=Double.parseDouble(values[0]);
            stats[i].init_std=Double.parseDouble(values[1]);
        }
        in.close();
    }

   
    public static void saveToFile(String Filename) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(Filename);
        for (int i = 0; i < 3; i++) {
            out.println(stats[i].getAverage()+"$"+stats[i].getStandardDeviation());
            out.flush();
        }
        out.close();
    }

}
