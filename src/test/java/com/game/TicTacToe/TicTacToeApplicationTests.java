package com.game.TicTacToe;

import com.game.TicTacToe.enums.Piece;
import com.game.TicTacToe.exceptions.FirstPlayerException;
import com.game.TicTacToe.model.Game;
import com.game.TicTacToe.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TicTacToeApplicationTests {

	@Test
	void contextLoads() {
	}

	private Game game;
	private Player playerX = new Player("Sophie", Piece.PLAYER_X);
	private Player playerO = new Player("Anna", Piece.PLAYER_O);

	@BeforeEach
	void init() {
		game = new Game();
	}

	//Rule: X always goes first
	@Test
	void whenStartGameThePlayerXShouldStartFirstTest() {
		// game is empty
		assertThrows(FirstPlayerException.class, () -> game.play(playerO));
	}
}


