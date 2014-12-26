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
    Space,
    /**
     * الفاصلة
     */
    Comma,
    /**
     *النقطة
     */
    Dot,
    /**
     *نقطا القول  (:)
     */
    SayDots,
    /**
     *الفاصلة المنقوطة
     */
    SemiColon,
    /**
     *علامة الاستفهام
     */
    QuestionMark,
    /**
     * علامة التعجب
     */
    ExeclamationMark,
    /**
     * نهاية البيانات
     */
    EndOfData;

    @Override
    public String toString() {
        switch (ordinal()) {
            case 0:
                return "فراغ";
            case 1:
                return "فاصلة";
            case 2:
                return "نقطة";
            case 3:
                return "نقط القول (:)";
            case 4:
                return "فاصلة منقوطة";
            case 5:
                return "إشارة استفهام";
            case 6:
                return "إشارة تعجب";
            case 7:
                return "نهاية البيانات";
            default:
                return "";
        }
    }

    /**
     * يقوم بقراءة المحرف و توليد النهاية المناسبة
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
     * @param end نهاية الكلمة
     * @return المحرف الموافق و يعيد القيمة "\0" في حال كانت النهاية هي نهاية البيانات
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
}
