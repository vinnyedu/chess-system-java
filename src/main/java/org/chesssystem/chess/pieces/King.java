package org.chesssystem.chess.pieces;

import org.chesssystem.boardgame.Board;
import org.chesssystem.boardgame.Position;
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

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                p.setValues(position.getRow() - i, position.getColumn() - j);
                if (i == 0 && j == 0) {
                    mat[p.getRow()][p.getColumn()] = false;
                } else if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}
