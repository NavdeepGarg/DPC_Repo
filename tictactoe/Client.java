package dev.tictactoe;

import dev.tictactoe.controller.GameController;
import dev.tictactoe.factory.PlayerFactory;
import dev.tictactoe.model.Bot;
import dev.tictactoe.model.Game;
import dev.tictactoe.model.HumanPlayer;
import dev.tictactoe.model.User;
import dev.tictactoe.strategy.DefaultWinnigStrategy;

public class Client {
	
	
	public static void main(String[] args) {
		Game game=Game.getBuilder()
				.addPlayer(
					PlayerFactory.createHumanPlayer()
						.setUser(new User())
						.setSymbol('0')
						.build()
						)
				.addPlayer(new Bot())
				.addWinningStrategies(new DefaultWinnigStrategy())
				.setRows(3)
				.setColumns(3)
				.build();
		
		
		GameController controller = new GameController();
		controller.runGame(game);
				
	}

}


