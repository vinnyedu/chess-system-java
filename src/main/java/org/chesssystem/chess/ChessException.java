package org.chesssystem.chess;

import java.io.Serial;

public class ChessException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -6196725360940473088L;

    public ChessException(String msg){
        super(msg);
    }
}
