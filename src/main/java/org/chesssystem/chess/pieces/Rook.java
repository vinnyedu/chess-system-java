package org.chesssystem.chess.pieces;

import org.chesssystem.boardgame.Board;
import org.chesssystem.chess.ChessPiece;
import org.chesssystem.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        if (super.getColor() == Color.WHITE) {
            return String.valueOf('♖');
        } else {
            return String.valueOf('♜');
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[getBoard().getRows()][getBoard().getColumns()];
    }
}
