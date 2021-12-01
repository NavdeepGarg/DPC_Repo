package dev.tictactoe.model;

public abstract class Player {
	
	Symbol symbol;
	
	public static class Builder{

		private Player player;
		
		Builder(Player player){
			this.player= player;
			
		}
		
		 public Builder setSymbol(char symbol) {
			 this.player.symbol= new Symbol(symbol);
			 return this;
		 }
		 
		 
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	
	
}
