package org.chesssystem.chess;

import org.chesssystem.boardgame.BoardException;

import java.io.Serial;

public class ChessException extends BoardException {
    @Serial
    private static final long serialVersionUID = -6196725360940473088L;

    public ChessException(String msg) {
        super(msg);
    }
}
