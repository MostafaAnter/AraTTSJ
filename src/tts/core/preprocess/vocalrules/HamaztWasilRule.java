package tts.core.preprocess.vocalrules;

import tts.core.ArabicMoves;

/**
 * قاعدة معالجة همزة الوصل.
 *
 * تعالج همزة الوصل بأن تحذف من بداية الكلمة.
 *
 * في حالة خاصة ندخل ال التعريف القمرية على كلمة تبدأ بهمزة وصل، و بالتالي يوجد
 * لدينا همزتي وصل للحذف
 *
 * مثال : اسم و الاسم
 *
 * و في حالات خاصة أخرى يدخل حرف الجر الباء أو اللام كما في : باسم ، بالاسم لاسم
 * ، للاسم
 */
public class HamaztWasilRule extends VocalRule {

    public HamaztWasilRule() {
        Priority = 7;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {

        if (currentWord.startsWith("" + ArabicMoves.BAA + ArabicMoves.KASRAH + ArabicMoves.ALEF
                + ArabicMoves.LAM + ArabicMoves.ALEF)) {
            //نعالج أولا حرف الجر الباء مع ال التعريف  مع همزة الوصل     
            currentWord = "" + ArabicMoves.BAA + ArabicMoves.KASRAH + ArabicMoves.LAM 
                    + currentWord.substring(5);
        } else if (currentWord.startsWith("" + ArabicMoves.LAM + ArabicMoves.KASRAH + ArabicMoves.LAM 
                + ArabicMoves.ALEF)) {
            // المعالجة في حال دخل حرف الجر اللام على لام قمرية متبوعة بهمزة وصل كما في للاسم
            currentWord = "" + ArabicMoves.LAM + ArabicMoves.KASRAH + ArabicMoves.LAM + currentWord.substring(4);
        } else if (currentWord.startsWith("" + ArabicMoves.LAM + ArabicMoves.KASRAH + ArabicMoves.ALEF)
                || currentWord.startsWith("" + ArabicMoves.BAA + ArabicMoves.KASRAH + ArabicMoves.ALEF)) {
            //في حال دخل حرف الجر اللام على كلمة تبدأ بهمزة وصل كما في لاسم
            //نعالج حالة حرف الجر الباء مع الف تليه كما في باسم أو بالقمر لتصبحان بسم و بلقمر
            currentWord = currentWord.substring(0,2) + currentWord.substring(3);
        } else if (currentWord.startsWith("" + ArabicMoves.ALEF + ArabicMoves.LAM + ArabicMoves.ALEF)) {
            currentWord = "" + ArabicMoves.LAM + currentWord.substring(3);
        } else if (currentWord.charAt(0) == ArabicMoves.ALEF) {
            currentWord = currentWord.substring(1);
        }
        return currentWord;
    }
}
