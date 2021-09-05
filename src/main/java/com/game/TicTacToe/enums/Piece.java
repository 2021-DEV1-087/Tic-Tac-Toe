package com.game.TicTacToe.enums;

import lombok.Getter;

@Getter
public enum Piece {
    PLAYER_X("X"),
    PLAYER_O("O");

    private final String pieceSymbol;

    Piece(String pieceSymbol) {
        this.pieceSymbol = pieceSymbol;
    }
}