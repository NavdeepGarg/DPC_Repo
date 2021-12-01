package dev.tictactoe.strategy;

import dev.tictactoe.model.Board;
import dev.tictactoe.model.Move;

public interface IAutomaticMoveStrategy {
	
	Move playMove(Board board);

}
