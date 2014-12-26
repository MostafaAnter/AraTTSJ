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
 */
public class HamaztWasilRule extends VocalRule {

    public HamaztWasilRule() {
        Priority = 7;
    }

    @Override
    public String evaluate(String previousWord, String currentWord) {
        if (currentWord.startsWith("" + ArabicMoves.ALEF + ArabicMoves.LAM + ArabicMoves.ALEF)) {
            currentWord = "" + ArabicMoves.LAM + currentWord.substring(3);
        } else if (currentWord.charAt(0) == ArabicMoves.ALEF) {
            currentWord = currentWord.substring(1);
        }
        return currentWord;
    }
}
