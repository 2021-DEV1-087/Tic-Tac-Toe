package com.game.TicTacToe.enums;

public enum GameStatus {
    IN_PROGRESS("IN POGRESS"),
    WIN("WIN"),
    DRAW("DRAW"); // game over without winner

    private String value;

    private GameStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
