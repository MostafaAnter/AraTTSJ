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
public class CharToEnd {

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
            default:
                return EndType.EndOfData;
        }
    }
}
