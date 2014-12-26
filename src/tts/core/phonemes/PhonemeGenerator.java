/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes;

import tts.core.phonemes.types.Phoneme;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tts.core.ArabicMoves;
import tts.core.phonemes.types.*;

/**
 * هذا الصف مسؤول عن توليد المقاطع الصوتية المستخدمة من قبل نظام MBROLA.
 *
 * عملية التوليد تتم وفقاً للقاعدة ar1-981103 الموجودة ضمن موقع MBROLA
 *
 */
public class PhonemeGenerator {

    /**
     * جدول التحويل
     */
    private final Map<Character, Phoneme> PhonemeDB = new HashMap<>();

    /**
     * يقوم هذا التابع بتهيئة جدول التحويل و يتسعدعى قبل استخدام الصف لأول مرة
     * فقط
     */
    public void initializeGenerator() {
        try {
            //القراءة من ملف قاعدة البيانات
            String DBPath = "PhonemeDB.txt";
            Scanner in = new Scanner(new FileInputStream(DBPath));
            in.nextLine();
            while (in.hasNext()) {
                String tmp = in.nextLine();
                String[] data = tmp.split("\\$");
                //تخزين الرموز في القاعدة
                PhonemeDB.put(data[0].charAt(0), new Phoneme(data[1], Integer.parseInt(data[2])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhonemeGenerator.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    //التحقق من الحروف ذات المقاطع الخاصة (ص،ض،ط،ظ(
    private boolean isSpecialLetter(String Letter) {
        System.out.println(Letter);
        return (Letter.equals(PhonemeDB.get(ArabicMoves.SAAD).getPhoneme()))
                || Letter.equals(PhonemeDB.get(ArabicMoves.DAAD).getPhoneme())
                || Letter.equals(PhonemeDB.get(ArabicMoves.TAH).getPhoneme())
                || Letter.equals(PhonemeDB.get(ArabicMoves.ZHAH).getPhoneme()
                );
    }

    //هل الحركة هي فتحة
    private boolean isFathah(char Letter) {
        return (Letter == ArabicMoves.FATHAH)
                || (Letter == PhonemeDB.get(ArabicMoves.FATHAH).getPhoneme().charAt(0));
    }

    //هل الحركة هي ضمة
    private boolean isDammah(char Letter) {
        return (Letter == ArabicMoves.DAMMAH)
                || (Letter == PhonemeDB.get(ArabicMoves.DAMMAH).getPhoneme().charAt(0));
    }

    //هل الحركة هي كسرة 
    private boolean isKasrah(char Letter) {
        return (Letter == ArabicMoves.KASRAH)
                || (Letter == PhonemeDB.get(ArabicMoves.KASRAH).getPhoneme().charAt(0));
    }

    //هل الحركة هي حركة عادية
    private boolean isMove(char Letter) {
        return isFathah(Letter)
                || isDammah(Letter)
                || isKasrah(Letter);
    }

    private boolean isPunctuationMark(char letter) {
        return (letter == ArabicMoves.QUESTION_MARK)
                || (letter == ArabicMoves.EXLAMATION_MARK)
                || (letter == ArabicMoves.DOT)
                || (letter == ArabicMoves.COMMA)
                || (letter == ArabicMoves.SAY_DOTS)
                || (letter == ArabicMoves.SEMICOLON);

    }

    /**
     * معالجة الأحرف الخاصة.
     *
     * يقوم هذا التابع بإجراء معالجة الأحرف الخاصة و هي ص ض ط ظ باستخدام الحركات
     * الخاصة بها.
     *
     * @param phonemes قائمة المقاطع الصوتية التي ستتم معالجتها
     */
    private void handleSpecialLetters(List<Phoneme> phonemes) {
        for (int i = 0; i < phonemes.size(); i++) {
            //معالجة الحروف الخاصة
            if (i < phonemes.size() - 1 && isSpecialLetter(phonemes.get(i).getPhoneme())) {
                Phoneme p = phonemes.get(i + 1);
                if (isMove(p.getPhoneme().charAt(0))) {
                    p.setPhoneme(p.getPhoneme() + ".");
                }
            }
        }

    }

    /**
     * يقوم بمعالجة الفتحات المتتالية.
     *
     * تعتمد عملية المعالجة على دمج الفتحات كلها بفتحة واحدة بزمن هو مجموع
     * الأزمنة لجميع الفتحات
     *
     * @param FathahIndex موقع الفتحة
     * @param text الكلمة التي سنبحث عن الفتحة فيها
     * @param res قائمة المقاطع الصوتي
     * @return العنصر الذي سنعالجه تالياً
     */
    private int handleFathah(int FathahIndex, String text, List<Phoneme> res) {
        int k = 1;
        //عد الفتحات المتتالية
        while (k + FathahIndex < text.length() && isFathah(text.charAt(k + FathahIndex))) {
            k++;
        }
        Phoneme fatha = (Phoneme) PhonemeDB.get(ArabicMoves.FATHAH).clone();
        fatha.setTime(fatha.getTime() * k);
        res.add(fatha);
        return FathahIndex + k - 1;
    }

    /**
     * يقوم هذا التابع بتوليد المقاطع الصوتية
     *
     * @param words قائمة الكلمات التي نريد توليد المقاطع الصوتية
     * @return قائمة المقاطع الصوتية التي ستمرر للنظام الخبير
     * @throws IllegalArgumentException في حال لم يوجد اللفظ الصوتي ضمن القاعدة
     */
    public Word[] generatePhoneme(Word[] words) {

        for (Word word : words) {
            ArrayList<Phoneme> res = word.getPhonemeList();
            for (int j = 0; j < word.getVocal().length(); j++) {
                if (PhonemeDB.containsKey(word.getVocal().charAt(j))) {
                    //دمج الفتحات المتتالية بفتحة واحدة زمنها هو مجموع أزمنة هذه الفتحات
                    if (isFathah(word.getVocal().charAt(j))) {
                        j = handleFathah(j, word.getVocal(), res);
                    } else {
                        //قراءة الحروف و التحويل لمقاطع صوتية
                        res.add((Phoneme) PhonemeDB.get(word.getVocal().charAt(j)).clone());
                    }
                } else {
                    //الحرف ليس ضمن المقاطع الصوتية
                    throw new IllegalArgumentException("Unkown Phoneme: " + word.getVocal().charAt(j));
                }
            }
            //معالجة الأحرف الخاصة
            handleSpecialLetters(res);
            //معالجة نهاية الكلمة في حال كانت علامة ترقيم
            char end = EndType.EndToChar(word.getEnd());
            if (isPunctuationMark(end)) {
                res.add((Phoneme) PhonemeDB.get(end).clone());
            }
        }

        return words;
    }

}
