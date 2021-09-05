package com.game.TicTacToe.service.serviceImpl;

import com.game.TicTacToe.model.Game;
import com.game.TicTacToe.model.Player;
import com.game.TicTacToe.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private Game game;

    @Override
    public Game play(int positionX, int positionY, Player player) {
        this.game.play(positionX, positionY, player);
        return this.game;
    }
}
