package com.game.TicTacToe.model;

import com.game.TicTacToe.enums.MarkerValue;
import com.game.TicTacToe.enums.Piece;
import com.game.TicTacToe.exceptions.FirstPlayerException;
import com.game.TicTacToe.exceptions.NextPlayerIsTheSameOneException;
import com.game.TicTacToe.exceptions.PositionAlreadyOccupied;
import com.game.TicTacToe.exceptions.PositionOutsideBoardException;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Game implements Serializable {

    private Board board;
    // list of players ordered
    List<Move> movements = new ArrayList<>();

    public Game() {
        initialize();
    }

    public void initialize() {
        if (board == null) {
            board = new Board();
        }

    }

    public void play(int positionX, int positionY, Player player) {
        checkFirstPlayer(player);
        checkNextPlayer(player);
        checkMarkerBoardPosition(positionX, positionY);
        fillUpBoard(positionX, positionY, player);
    }

    /**
     *   Check if the PlayerX is always the first one
     * @param player
     */
    public void checkFirstPlayer(Player player) {
        if (movements.isEmpty() && !player.getPiece().equals(Piece.PLAYER_X)) {
            throw new FirstPlayerException();
        }
    }


    /**
     * Alternative Players: Compare current player with last player in movement list
     * @param player
     */
    public void checkNextPlayer(Player player) {

        if (!movements.isEmpty()
                && movements.get(movements.size() - 1).getPlayer().getPiece().equals(player.getPiece())) {

            if(player.getPiece().equals(Piece.PLAYER_X)){
                throw new NextPlayerIsTheSameOneException(
                        "Next player should be O");
            }
            else{
                throw new NextPlayerIsTheSameOneException(
                        "Next player should be X");
            }
        }
    }

    /**
     * Check if the markerBoard positions does not exceed 9 squares
     * @param positionX
     * @param positionY
     */
    public void checkMarkerBoardPosition(int positionX, int positionY) {

        if (positionX < 1 || positionX > 3 || positionY < 1 || positionY > 3) {
            throw new PositionOutsideBoardException("Position " + positionX + "-" + positionY + " outside the bound");
        }
    }

    /**
     * Fill up the MarkerBoard and check if the marker position in the board is not occupied
     *
     * @param positionX
     * @param positionY
     */
    private void fillUpBoard(int positionX, int positionY, Player player) {

        MarkerBoard[][] marker = board.getMarkerBoards();

        if (!marker[positionX - 1][positionY - 1].isEmpty()) {

            throw new PositionAlreadyOccupied("Position " + positionX + "-" + positionY + " was occupied");
        }
        board.getMarkerBoards()[positionX - 1][positionY - 1]
                .setValue(MarkerValue.valueOf(player.getPiece().getPieceSymbol()));

        movements.add(new Move(player));

    }
}