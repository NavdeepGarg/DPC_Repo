package dev.tictactoe.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.tictactoe.exception.DuplicateSymbolException;
import dev.tictactoe.exception.InvalidPlayerQuantityException;
import dev.tictactoe.strategy.IWinningStrategies;

public class Game {

	



	List<Player> playerList = new ArrayList<>();
	Board board;
	List<IWinningStrategies> winningStrategies; //why list

	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public List<IWinningStrategies> getWinningStrategies() {
		return winningStrategies;
	}
	public void setWinningStrategies(List<IWinningStrategies> winningStrategies) {
		this.winningStrategies = winningStrategies;
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public  static class Builder{
		
		
		Game game ;
		int rows;
		int columns;
		
		public Builder(){
			this.game = new Game();
		}
		
		
		public Builder(Game game){
			this.game = new Game();
		}
		
		public Builder addPlayer(Player player) {
			
			this.game.getPlayerList().add(player);
			return this;
		}
		
		public 	Builder addWinningStrategies(IWinningStrategies ws) {
			game.getWinningStrategies().add(ws);
			return this;
		}
		
		public Game build() throws DuplicateSymbolException {
			
			if(game.getPlayerList().size()<2) {
				throw new InvalidPlayerQuantityException();
			}
			Set<Character> symbols = new HashSet<>(); 
			
			for(Player player : game.getPlayerList()) {
				if(symbols.contains(player.getSymbol())) {
					throw new DuplicateSymbolException();
				}
			}
			
			Board board = new Board(rows, columns);
			this.game.setBoard(board);
			return this.game;
		}


		public Game getGame() {
			return game;
		}


		public void setGame(Game game) {
			this.game = game;
		}


		public int getRows() {
			return rows;
		}


		public void setRows(int rows) {
			this.rows = rows;
		}


		public int getColumns() {
			return columns;
		}


		public void setColumns(int columns) {
			this.columns = columns;
		}
		
		
	}
	
	
}

