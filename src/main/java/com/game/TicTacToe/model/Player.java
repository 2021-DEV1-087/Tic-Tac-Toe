package com.game.TicTacToe.model;

import com.game.TicTacToe.enums.Piece;
import lombok.Data;

import java.io.Serializable;

@Data
public class Player  implements Comparable<Player>, Serializable {
    private final String name;
    private final Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    @Override
    public int compareTo(Player player) {
        return name.compareTo(player.getName());
    }
}