package org.chesssystem.application;

import org.chesssystem.boardgame.Board;
import org.chesssystem.chess.ChessMatch;

public class Program {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

    }
}
