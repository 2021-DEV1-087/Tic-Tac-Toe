package com.game.TicTacToe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NextPlayerIsTheSameOneException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public NextPlayerIsTheSameOneException() {
        super("Next player should be different");
    }

    public NextPlayerIsTheSameOneException(String message) {
        super(message);
    }
}