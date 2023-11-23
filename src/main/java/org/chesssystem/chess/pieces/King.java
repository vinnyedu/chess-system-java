package org.chesssystem.chess.pieces;

import org.chesssystem.boardgame.Board;
import org.chesssystem.boardgame.Position;
import org.chesssystem.chess.ChessMatch;
import org.chesssystem.chess.ChessPiece;
import org.chesssystem.chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        if (super.getColor() == Color.WHITE) {
            return String.valueOf('♚');
        } else {
            return String.valueOf('♔');
        }
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        // Special move castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {

            // King side rook
            Position posR1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posR1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // Queen side rook
            Position posR2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posR2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
