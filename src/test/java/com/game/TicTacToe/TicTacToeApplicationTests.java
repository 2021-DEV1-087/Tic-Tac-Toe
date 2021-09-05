package com.game.TicTacToe;

import com.game.TicTacToe.enums.GameStatus;
import com.game.TicTacToe.enums.Piece;
import com.game.TicTacToe.exceptions.FirstPlayerException;
import com.game.TicTacToe.exceptions.NextPlayerIsTheSameOneException;
import com.game.TicTacToe.exceptions.PositionAlreadyOccupied;
import com.game.TicTacToe.exceptions.PositionOutsideBoardException;
import com.game.TicTacToe.model.Game;
import com.game.TicTacToe.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		assertThrows(FirstPlayerException.class, () -> game.play(0,2, playerO));
	}

	//test Players alternate placing X’s and O’s on the board
	@Test
	void whenNextPlayerIsTheSamethanThePreviousOneThenThrowsNextPlayerIsTheSameOneException() {
		game.play(1, 1, playerX); // current Player now is playerX
		assertThrows(NextPlayerIsTheSameOneException.class, () -> game.play(2, 2, playerX));
	}

	//Players cannot play on a played position.
	@Test
	void whenMarkerBoundWasOcuppiedThenThrowsPositionAlreadyOccupiedException() {
		game.play(3, 3, playerX);
		assertThrows(PositionAlreadyOccupied.class, () -> game.play(3, 3, playerO));
	}

	/* Players alternate placing X’s and O’s on the board until either:
      One player has three in a row, All nine squares are filled and.
      This test with 5 rows and columns and 25 squares*/
	@Test
	void whenMarkerBoundWasOutsideOfBoundThenThrowsMarkerOutsideBoardException() {
		assertThrows(PositionOutsideBoardException.class, () -> game.play(5, 5, playerX));
	}

	/* scenario :Board is full ,game WIN with Winner, diagonal from right line
       0 O X
	   O X X
	   X O X
    */
	@Test
	void whenBoardIsFullWithWinnerThenGameIsWIN() {
		game.play(1, 3, playerX); // the Player X is always the First
		game.play(1, 1, playerO); // alternative player
		game.play(2, 3, playerX);
		game.play(1, 2, playerO);
		game.play(2, 2, playerX);
		game.play(2, 1, playerO);
		game.play(3, 1, playerX);
		game.play(3, 2, playerO);
		game.play(3, 3, playerX);
		assertEquals(game.getGameStatus(), GameStatus.WIN);

	}
	/* scenario :board not completely full , game WIN with winner, first vertical line
       X O O
       X . .
       X . .
    */
	@Test
	void whenOneOfPlayerFillUpThreeVerticalSuccessiveMarkersThenGameIsWIN() {
		game.play(1, 1, playerX); // the Player X is always the First
		game.play(1, 2, playerO);// alternative player
		game.play(2, 1, playerX);
		game.play(1, 3, playerO);
		game.play(3, 1, playerX);
		assertEquals(game.getGameStatus(), GameStatus.WIN);
	}
	/* scenario: board not completely full , game WIN with winner, first horizontal line
       X X X
	   . O .
	   . O .
    */
	@Test
	void whenOneOfPlayerFillUpThreeHorizontalSuccessiveMarkersThenGameIsWIN() {
		game.play(1, 1, playerX); // the Player X is always the First
		game.play(2, 2, playerO); // alternative player
		game.play(1, 2, playerX);
		game.play(3, 2, playerO);
		game.play(1, 3, playerX);
		assertEquals(game.getGameStatus(), GameStatus.WIN);
	}
	/* scenario :board is full and game WIN without winner => Draw
       O X X
	   X O O
	   X O X
    */
	@Test
	void whenBoardIsFullWithoutWinnerThenGameIsDraw() {
		game.play(1, 2, playerX); // the Player X is always the First
		game.play(1, 1, playerO); // alternative player
		game.play(1, 3, playerX);
		game.play(2, 2, playerO);
		game.play(2, 1, playerX);
		game.play(2, 3, playerO);
		game.play(3, 1, playerX);
		game.play(3, 2, playerO);
		game.play(3, 3, playerX);
		assertEquals(game.getGameStatus(), GameStatus.DRAW);

	}
	/* scenario :board not completely full, game WIN with winner, diagonal from left line
       X . .
	   O X .
	   . O X
    */

	@Test
	void whenOneOfPlayerFillUpThreeDiagonalFromLeftSuccessiveMarkersThenGameIsWIN() {
		game.play(1, 1, playerX); // the Player X is always the First
		game.play(2, 1, playerO);// alternative player
		game.play(2, 2, playerX);
		game.play(3, 2, playerO);
		game.play(3, 3, playerX);
		assertEquals(game.getGameStatus(), GameStatus.WIN);
	}


	/* scenario :board not completely full , game WIN with Winner, diagonal from right line
       . . X
       O X .
       X O .
    */
	@Test
	void whenOneOfPlayerFillUpThreeDiagonalRightSuccessiveMarkersThenGameisWIN() {
		game.play(1, 3, playerX); // the Player X is always the First
		game.play(2, 1, playerO); // alternative player
		game.play(2, 2, playerX);
		game.play(3, 2, playerO);
		game.play(3, 1, playerX);
		assertEquals(game.getGameStatus(), GameStatus.WIN);

	}
}


