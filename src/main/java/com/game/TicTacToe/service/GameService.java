package com.game.TicTacToe.service;

import com.game.TicTacToe.model.Game;
import com.game.TicTacToe.model.Player;

public interface GameService {
    Game play(int positionX, int positionY, Player player);
}
