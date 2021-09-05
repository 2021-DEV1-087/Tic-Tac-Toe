package com.game.TicTacToe.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Move implements Serializable {
    Player player;

    public Move(Player player) {
        this.player = player;
    }
}