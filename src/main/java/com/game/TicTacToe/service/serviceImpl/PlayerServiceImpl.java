package com.game.TicTacToe.service.serviceImpl;

import com.game.TicTacToe.enums.Piece;
import com.game.TicTacToe.exceptions.PlayerNotFoundException;
import com.game.TicTacToe.model.Player;
import com.game.TicTacToe.service.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {

    private final List<Player> players;
    /**
     * Two player will be initialized from the beginning
     *
     */
    public PlayerServiceImpl() {
        players = new ArrayList<>(2);
        players.add(new Player("FIRST_PLAYER", Piece.PLAYER_X));
        players.add(new Player("SECOND_PLAYER", Piece.PLAYER_O));
    }
    /** Check player with a given piece
     * @param piece
     * @return Player
     */
    @Override
    public Player getPlayerByPiece(String piece) {

        Optional<Player> player = players.stream().filter(e -> e.getPiece().getPieceSymbol().equals(piece))
                .findFirst();

        if (player.isPresent()) {

            return player.get();

        }
        throw new PlayerNotFoundException("Player with Symbol "+piece+" is not found");

    }
}
