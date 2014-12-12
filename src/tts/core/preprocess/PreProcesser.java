/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import tts.core.ArabicMoves;
import tts.core.phonemes.types.CharToEnd;
import tts.core.phonemes.types.EndType;
import tts.core.phonemes.types.Word;

import tts.core.preprocess.vocalrules.VocalRule;

/**
 * هذا الصف يعالح النص لغوياً قبل تحويله لمقاطع صوتية.
 *
 *
 * وذلك بهدف تحويله إلى كتابة لفظية عوضاً عن الكتابة التقليدية المعتادة (النحوية
 * الإملائية).
 *
 *
 * المعالجة تقوم على ما يلي:
 * <table border="1">
 * <tr>
 * <td>الحرف</td>
 * <td>التغيير</td>
 * </tr>
 * <tr>
 * <td>آ</td>
 * <td>ََ في أول الكلام و ءََ في وسط الكلام</td>
 * </tr>
 * <tr>
 * <td>ًـ</td>
 * <td>ـَن</td>
 * </tr>
 * <tr>
 * <td>ـٌ</td>
 * <td>ـُن</td>
 * </tr>
 * <tr>
 * <td>ـٍ</td>
 * <td>ـِن</td>
 * </tr>
 * <tr>
 * <td>الحرف المشدد</td>
 * <td>تكرار نفس الحرف مرتين ، الأول ساكن و الثاني متحرك بالحركة الأصلية</td>
 * </tr>
 * <tr>
 * <td>ال التعريف الشمسية</td>
 * <td>َ</td>
 * </tr>
 * <tr>
 * <td>أ إ ؤ ئ ء</td>
 * <td>تحذف الهمزة في أول الكلمة و نبقي على حركتها, أما في وسط الكلام فتحول كل
 * الهمزات لهمزة على السطر</td>
 * </tr>
 * </table>
 *
 *
 */
public class PreProcesser {

    private static final VocalRule[] wordRules = VocalRule.getSet();

    /**
     * الأسطر الفارغة
     */
    private static final String EMPTY_LINES = "\n\n+";
    /**
     * بديل الأسطر الفارغة
     */
    private static final String EMPTY_LINES_REPLACER = "\n";

    /**
     * الحرف الذي يدل على وجود سطر
     */
    private static final String LINE_MARKER = EMPTY_LINES_REPLACER;
    /**
     * بديل الحرف الذي يدل على وجود سطر
     */
    private static final String LINE_MARKER_REPLACER = ".";
    /**
     * الفراغات المتكررة
     */
    private static final String REPEATED_SPACES = "\\s\\s+";
    /**
     * الفاصلة
     */
    private static final String COMMA = "\\s?،\\s?";
    /**
     * تعديل الفاصلة
     */
    private static final String COMMA_REPLACER = " ، ";
    /**
     * النقطة
     */
    private static final String DOT = "\\s?\\.\\s?";
    /**
     * تعديل النقطة
     */
    private static final String DOT_REPLACER = " \\. ";
    /**
     * الفاصلة المنقوطة
     */
    private static final String SEMICOLON = "\\s?؛\\s?";
    /**
     * تعديل الفاصلة المنقوطة
     */
    private static final String SEMICOLON_REPLACER = " ؛ ";
    /**
     * إشارة الاستفهام
     */
    private static final String QUENSTION_MARK = "\\s?؟\\s?";
    /**
     * تعديل إشارة الاستفهام
     */
    private static final String QUENSTION_MARK_REPLACER = " ؟ ";
    /**
     * إشارة التعجب
     */
    private static final String EXCLAMTION_MARK = "\\s?!\\s?";
    /**
     * تعديل إشارة التعجب
     */
    private static final String EXCLAMTION_MARK_REPLACER = " ! ";

    /**
     * نقطتين فوق بعض
     */
    private static final String SAY_DOTS = "\\s?:\\s?";
    /**
     * تعديل نقطتين فوق بعض
     */
    private static final String SAY_DOTS_REPLACER = " : ";

    /**
     * يقوم هذا التابع بجراء عملية تصويب للنص. تقوم العملية على حذف السطور و
     * الفراغات الزائدة و جعل النص سطراً واحداً بتحويل محرف السطر الجديد لمحرف
     * النقطة. و أخيراً معالجة علامات الترقيم بحيث يصبح قبل و بعد كل علامة فراغ
     *
     * @param text النص قبل المعالجة
     * @return النص بعد المعالجة
     */
    private String repaireText(String text) {
        //إلغاء الأسطر الفارغة من النص
        text = text.replaceAll(EMPTY_LINES, EMPTY_LINES_REPLACER);
        //إلغاء السطور من النص
        text = text.replaceAll("\n", ".");
        //ضبط الفراغات بحيث يصبح لدينا فراغ واحد فقط بين الكلمات
        text = text.replaceAll(REPEATED_SPACES, " ");
        //معالجة علامات الترقيم لتسهيل عمل المصحح اللغوي
        text = text.replaceAll(COMMA, COMMA_REPLACER);
        text = text.replaceAll(DOT, DOT_REPLACER);
        text = text.replaceAll(SEMICOLON, SEMICOLON_REPLACER);
        text = text.replaceAll(SAY_DOTS, SAY_DOTS_REPLACER);
        text = text.replaceAll(QUENSTION_MARK, QUENSTION_MARK_REPLACER);
        text = text.replaceAll(EXCLAMTION_MARK, EXCLAMTION_MARK_REPLACER);
        return text;
    }

    //معالجة حرف الألف باستباداله بفتحتين متتاليتين
    /**
     * يقوم هذا التابع بإجراء عملية التحويل اللغوي
     *
     * @param text النص المراد تحويله
     * @return النص محولاً و مقطعاً لكلامات ، كل كلمة هي عنصر من المصفوفة
     * @throws IllegalArgumentException إذا كان النص المرر غير موجوداًًً او
     * فارغاً
     */
    public Word[] preProcess(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        if (text.trim().equals("")) {
            throw new IllegalArgumentException("Text cannot be empty");
        }
        //معالجة النص
        text = repaireText(text);

        //التقسيم
        StringTokenizer tokens = new StringTokenizer(text, " ");
        ArrayList<Word> words = new ArrayList<>();
        String previous = null;
        while (tokens.hasMoreTokens()) {
            String current = tokens.nextToken();
            if (previous != null) {
                if (isNotAWord(current)) {
                    words.get(words.size() - 1).setEnd(CharToEnd.charToEnd(current.charAt(0)));
                    continue;
                }
            }
            String copy = current;
            for (VocalRule wordRule : wordRules) {
                current = wordRule.evaluate(previous, current);
                words.add(new Word(copy, current, EndType.Space));
            }
        }
        words.get(words.size() - 1).setEnd(EndType.EndOfData);
        Word[] result = new Word[words.size()];
        result = words.toArray(result);
        return result;
    }

    private boolean isNotAWord(String word) {
        return word.equals(ArabicMoves.DOT + "")
                || word.equals(ArabicMoves.COMMA + "")
                || word.equals(ArabicMoves.EXLAMATION_MARK + "") || word.equals(ArabicMoves.QUESTION_MARK + "")
                || word.equals(ArabicMoves.SEMICOLON + "") || word.equals(ArabicMoves.SAY_DOTS + "");
    }
}
