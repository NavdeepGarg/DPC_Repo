package dev.tictactoe.strategy;

import java.util.List;

import dev.tictactoe.model.Board;
import dev.tictactoe.model.Player;

public interface IWinningStrategies {
	
	Player checkWinner(Board board, List<Player> player);

}
