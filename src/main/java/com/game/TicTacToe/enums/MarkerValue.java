package com.game.TicTacToe.enums;

import lombok.Getter;

@Getter
public enum MarkerValue {
    X("X"),
    O("O"),
    BLANK("");

    private String text;

    private MarkerValue(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}