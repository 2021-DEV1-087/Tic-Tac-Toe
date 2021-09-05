package com.game.TicTacToe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FirstPlayerException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FirstPlayerException() {
        super(" The player X should start First");
    }
}