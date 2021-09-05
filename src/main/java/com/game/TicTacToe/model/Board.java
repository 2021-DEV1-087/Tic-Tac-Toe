package com.game.TicTacToe.model;

import com.game.TicTacToe.utils.Utilities;
import lombok.Data;

import java.io.Serializable;


@Data
public class Board implements Serializable {

    private MarkerBoard[][] markerBoards;

    public Board() {

        markerBoards = new MarkerBoard[Utilities.INDEX_COLUMNS][Utilities.INDEX_ROWS];

        for (int rowIndex = 0; rowIndex < Utilities.INDEX_ROWS; rowIndex++) {
            for (int columnIndex = 0; columnIndex < Utilities.INDEX_COLUMNS; columnIndex++) {
                markerBoards[rowIndex][columnIndex] = new MarkerBoard(new Position(rowIndex, columnIndex));
            }
        }
    }

}