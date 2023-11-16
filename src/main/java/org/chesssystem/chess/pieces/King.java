package org.chesssystem.chess.pieces;

import org.chesssystem.boardgame.Board;
import org.chesssystem.chess.ChessPiece;
import org.chesssystem.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        if (super.getColor() == Color.WHITE) {
            return String.valueOf('♔');
        } else {
            return String.valueOf('♚');
        }
    }
}
