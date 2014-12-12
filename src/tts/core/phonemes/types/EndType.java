/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.core.phonemes.types;

import tts.core.ArabicMoves;

/**
 *
 * @author ossama
 */
public enum EndType {

    Space, Comma, Dot, SayDots, SemiColon, QuestionMark, ExeclamationMark, EndOfData;

    public String toString() {
        switch (ordinal())
        {
            case 0:
                return "فراغ"  ;
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
            default :
                return "";
        }
    }
    
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
