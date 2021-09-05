package com.game.TicTacToe.model;

import com.game.TicTacToe.enums.MarkerValue;
import lombok.Data;

@Data
public class MarkerBoard {
    private MarkerValue value;
    private Position position;

    public MarkerBoard(Position position) {

        this.value = MarkerValue.BLANK;
        this.position = position;
    }

    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return this.value == MarkerValue.BLANK;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "BoardMarker [columnIndex=" + position.getColumnIndex() + ", rowIndex=" + position.getRowIndex() + ", value=" + value + "]";
    }
}