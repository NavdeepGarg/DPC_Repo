package dev.tictactoe.model;

import dev.tictactoe.model.HumanPlayer.Builder;
import dev.tictactoe.strategy.IAutomaticMoveStrategy;

public class Bot extends Player{
	
	IAutomaticMoveStrategy automaticMoveStrategy;
	
	
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	
	public static class Builder{

		private Bot bot;
		
		Builder(){
			this.bot=new Bot();
			
		}
		
		
		public Bot build() {
			return bot;
		}

		  
		public Builder setMoveStrategy(IAutomaticMoveStrategy strategy) {
			this.bot.automaticMoveStrategy=strategy;
			return this;
			
			
		}
		public Builder setSymbol(char symbol) {
			this.bot.symbol=new Symbol(symbol);
			return this;
		}
		
		
	}
 
}
