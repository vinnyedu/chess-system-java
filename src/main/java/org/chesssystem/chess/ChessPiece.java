package org.chesssystem.chess;

import org.chesssystem.boardgame.Board;
import org.chesssystem.boardgame.Piece;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
