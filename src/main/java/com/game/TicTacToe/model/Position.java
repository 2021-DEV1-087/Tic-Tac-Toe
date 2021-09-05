package com.game.TicTacToe.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class Position implements Serializable {
    private int rowIndex;
    private int columnIndex;

    public Position(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

}