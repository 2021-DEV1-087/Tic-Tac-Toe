package com.game.TicTacToe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PositionAlreadyOccupied extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PositionAlreadyOccupied() {
        super("Position already occupied");
    }

    public PositionAlreadyOccupied(String message) {
        super(message);
    }
}
