/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess.vocalrules;

import java.util.TreeSet;
import tts.core.ArabicMoves;

/**
 * هذا الصف هو اساس لقواعد التحويل التي ستطبق على كلمة لوحدها.
 *
 * يتمتيز هذا الصف بخاصية الأولوية التي تعبر عن ترتيب تطبيق القاعدة فكلما كانت
 * القيمة العددية أقل كلما كانت الألأولوية أعلى و بالتالي تطبق القاعدة ذات
 * الألولية الأعلى قبل القاعدة ذات الأولوية الأدنى
 *
 */
public abstract class WordVocalRule extends VocalRule {

    /**
     * تحويل اللغة من الكتابة اللغوية للكتابة الصوتية
     *
     * @param previousWord الكلمة السابقة للكلمة الحالية
     * @param currentWord الكلمة الحالية التي سيجري عليها التحويل
     * @return الكليمة بعد تطبيق التحويل
     */
    protected abstract String evaluate(String previousWord, String currentWord);

    @Override
    public String evaluate(String... data) {
        return evaluate(data[0], data[1]);
    }

    protected boolean isEndOfSentence(String word) {
        return word.equals("\n") || word.equals(ArabicMoves.DOT + "")
                || word.equals(ArabicMoves.COMMA + "")
                || word.equals(ArabicMoves.EXLAMATION_MARK + "") || word.equals(ArabicMoves.QUESTION_MARK + "")
                || word.equals(ArabicMoves.SEMICOLON + "") || word.equals(ArabicMoves.SAY_DOTS + "");
    }

    /**
     * إنشاء قائمة مرتبة حسب الأولوية من قواعدة تحويل الكلمات
     *
     * @return قائمة مرتبة حسب الأولوية من قواعدة تحويل الكلمات
     */
    public static VocalRule[] getSet() {
        TreeSet<VocalRule> rules = new TreeSet<>();

        rules.add(new ShaazRule());
        rules.add(new ShaddaRule());
        rules.add(new AlefRule());
        rules.add(new AlefTafreeqRule());
        rules.add(new TaaMarbotaRule());
        rules.add(new HamaztWasilRule());
        rules.add(new LaamShamsyRule());
        rules.add(new HamzaWordRule());
        VocalRule[] x = new VocalRule[rules.size()];
        x = rules.toArray(x);
        return x;
    }
}
