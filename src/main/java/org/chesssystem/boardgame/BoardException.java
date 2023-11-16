package org.chesssystem.boardgame;

import java.io.Serial;

public class BoardException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1515751900771205040L;
    public BoardException(String msg){
        super(msg);
    }
}
