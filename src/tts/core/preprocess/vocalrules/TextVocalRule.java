/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import java.util.TreeSet;

/**
 * هذا الصف هو اساس لقواعد التحويل التي ستطبق على النص بأكلمه.
 *
 * يتمتيز هذا الصف بخاصية الأولوية التي تعبر عن ترتيب تطبيق القاعدة فكلما كانت
 * القيمة العددية أقل كلما كانت الألأولوية أعلى و بالتالي تطبق القاعدة ذات
 * الألولية الأعلى قبل القاعدة ذات الأولوية الأدنى
 *
 */
public abstract class TextVocalRule extends VocalRule {

   

    /**
     * تحويل نص من كتابة لغوية لكتابة صوتية
     *
     * @param text النص المراد تحويله
     * @return النص بعد التحويل
     */
    protected abstract String evaluate(String text);

    @Override
    public String evaluate(String... data) {
        return evaluate(data[0]);
    }

    

    /**
     * إنشاء قائمة مرتبة حسب الأولوية من قواعدة تحويل النص
     *
     * @return قائمة مرتبة حسب الأولوية من قواعدة تحويل النص
     */
    public static VocalRule[] getSet() {
        TreeSet<VocalRule> rules = new TreeSet<>();
        rules.add(new AlefMaqsouraRule());
        rules.add(new HamzaRule());
        rules.add(new MaddaRule());
        rules.add(new TanweenRule());
        VocalRule[] x = new VocalRule[rules.size()];
        x = rules.toArray(x);
        return x;
    }
}
