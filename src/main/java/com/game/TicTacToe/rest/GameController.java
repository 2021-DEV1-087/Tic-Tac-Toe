package com.game.TicTacToe.rest;


import com.game.TicTacToe.dto.RequestGamingDto;
import com.game.TicTacToe.model.Game;
import com.game.TicTacToe.model.Player;
import com.game.TicTacToe.service.GameService;
import com.game.TicTacToe.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("tic-tac-toe/api")
public class GameController {

    private GameService gameService;
    private PlayerService playerService;

    public GameController(GameService gameService, PlayerService playerService) {

        this.gameService = gameService;
        this.playerService = playerService;

    }

    /**
     * A player should fill up the RequestGamingDto with his symbol [X/O], marker
     * xPosition [1-3] and marker yPosition  [1-3]
     */
    @PostMapping(value = "/playTheGame")
    public ResponseEntity<Game> updateGameState(@RequestBody RequestGamingDto requestGamingDto) {

        Player player = null;
        Game game = null;

        try {
            player = this.playerService.getPlayerByPiece(requestGamingDto.getPlayerSymbol());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        try {
            game = this.gameService.play(requestGamingDto.getPositionX(), requestGamingDto.getPositionY(), player);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);

        }
        return new ResponseEntity<Game>(game, HttpStatus.OK);

    }


}
