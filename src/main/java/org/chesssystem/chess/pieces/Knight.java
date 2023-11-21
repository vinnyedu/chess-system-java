package org.chesssystem.chess.pieces;

import org.chesssystem.boardgame.Board;
import org.chesssystem.boardgame.Position;
import org.chesssystem.chess.ChessPiece;
import org.chesssystem.chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        if (super.getColor() == Color.WHITE) {
            return String.valueOf('♞');
        } else {
            return String.valueOf('♘');
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

        for (int i = -1; i <= 1; i+= 2) {
            for (int j = -2; j <= 2; j+=4) {
                p.setValues(position.getRow() - i, position.getColumn() - j);
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }
        for (int i = -2; i <= 2; i+= 4) {
            for (int j = -1; j <= 1; j+=2) {
                p.setValues(position.getRow() - i, position.getColumn() - j);
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }
        return mat;
    }
}
