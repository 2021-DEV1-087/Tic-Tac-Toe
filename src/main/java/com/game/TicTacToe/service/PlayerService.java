package com.game.TicTacToe.service;

import com.game.TicTacToe.model.Player;

public interface PlayerService {
    Player getPlayerByPiece(String piece);
}
