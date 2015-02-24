/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

import tts.core.ArabicMoves;

/**
 * يتضمن هذا الصف أنواع النهايات الممكنة للكلمة
 */
public enum EndType {

    /**
     * الفراغ
     */
    Space("فراغ"),
    /**
     * الفاصلة
     */
    Comma("فاصلة"),
    /**
     * النقطة
     */
    Dot("نقطة"),
    /**
     * نقطا القول (:)
     */
    SayDots("نقطتا القول"),
    /**
     * الفاصلة المنقوطة
     */
    SemiColon("فاصلة منقوطة"),
    /**
     * علامة الاستفهام
     */
    QuestionMark("إشارة استفهام"),
    /**
     * علامة التعجب
     */
    ExeclamationMark("إشارة تعجب"),
    /**
     * نهاية البيانات
     */
    EndOfData("نهاية البيانات");

    private String name;

    private EndType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * يقوم بقراءة المحرف و توليد النهاية المناسبة
     *
     * @param c محرف نهاية الكلمة
     * @return النهاية الموافقة
     */
    public static EndType charToEnd(char c) {
        switch (c) {
            case ArabicMoves.DOT:
                return EndType.Dot;
            case ArabicMoves.COMMA:
                return EndType.Comma;
            case ArabicMoves.SEMICOLON:
                return EndType.SemiColon;
            case ArabicMoves.QUESTION_MARK:
                return EndType.QuestionMark;
            case ArabicMoves.EXLAMATION_MARK:
                return EndType.ExeclamationMark;
            case ArabicMoves.SAY_DOTS:
                return EndType.SayDots;
            case ' ':
                return EndType.Space;
            default:
                return EndType.EndOfData;
        }
    }

    /**
     * يقوم بتحويل النهاية للمحرف الموافق
     *
     * @param end نهاية الكلمة
     * @return المحرف الموافق و يعيد القيمة "\0" في حال كانت النهاية هي نهاية
     * البيانات
     */
    public static char EndToChar(EndType end) {
        switch (end) {
            case Dot:
                return ArabicMoves.DOT;
            case Comma:
                return ArabicMoves.COMMA;
            case SemiColon:
                return ArabicMoves.SEMICOLON;
            case QuestionMark:
                return ArabicMoves.QUESTION_MARK;
            case ExeclamationMark:
                return ArabicMoves.EXLAMATION_MARK;
            case SayDots:
                return ArabicMoves.SAY_DOTS;
            case Space:
                return ' ';
            default:
                return '\0';
        }
    }

    /**
     * معرفة إذا كانت النهاية المحددة هي نهاية جملة
     * @param e النهاية
     * @return true في حال كانت نهاية جملة , false خلاف ذلك
     */
    public static boolean isEndOfSenctence(EndType e) {
        return e != Space;
    }
}
