package dev.tictactoe.factory;

import dev.tictactoe.model.Bot;
import dev.tictactoe.model.HumanPlayer;

public class PlayerFactory {
	
	
	public static HumanPlayer.Builder createHumanPlayer(){
		return HumanPlayer.getBuilder();
	}
	
	public static Bot.Builder createBotPlayer(){
		return Bot.getBuilder();
	}

}
