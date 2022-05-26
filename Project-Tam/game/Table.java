package game;

import java.util.ArrayList;
import java.util.List;

//Table is the space shared by both, the players and the moderator, where game happens. Hence, it is the shared data.
public class Table {
	private int rounds; //total number of rounds
	private int currentround; //current round going on
	private boolean newRound; //has the new round started for players to play (false when moderator is generating number)
	@SuppressWarnings("unused")
	private boolean gameOver;	//is the game over due to (a) someone won, or (b) all rounds end
	List <Integer> numbers = new ArrayList <Integer> (); //list of numbers generated by the moderator
	private List <Boolean> roundPlayed; //whether a player played its current round
	private List <Boolean> winner; //whether a player won
	int playerCount; //total number of players on the table
	public int winThreshold; //number of strikes needed for a player to win
	
	//Creating a table with specified number of rounds, playerCount and winThreshold
	public Table(int rounds, int playerCount,int winThreshold) {
		this.rounds = rounds;
		this.currentround=0;
		this.setNewRound(false);
		this.playerCount=playerCount;
		this.roundPlayed = new ArrayList <Boolean> ();
		this.winner = new ArrayList <Boolean> ();
		this.winThreshold=winThreshold;
		for(int i=0;i<playerCount;i++) {
			this.roundPlayed.add(false);
			this.winner.add(false);
		}		
	}
	
	//if rounds and win threshold are not specified, a default setting is applied with rounds = 10 & winThreshold = 3
	public Table(int playerCount) {
		this.rounds = 10;
		this.currentround=0;
		this.setNewRound(false);
		this.playerCount=playerCount;
		this.roundPlayed = new ArrayList <Boolean> ();
		this.winThreshold=3;
		this.winner = new ArrayList <Boolean> ();
		for(int i=0;i<playerCount;i++) {
			this.roundPlayed.add(false);
			this.winner.add(false);
		}	
	}

	//Getters and Setters
	public int getCurrentround() {
		return currentround;
	}
	public void setCurrentround(int currentround) {
		this.currentround = currentround;
	}
	public int getRounds() {
		return rounds;
	}
	public List<Integer> getNumbers() {
		return numbers;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	public boolean isNewRound() {
		return newRound;
	}
	public void setNewRound(boolean newRound) {
		this.newRound = newRound;
	}
	public void setCheckedFlags(boolean b) {
		for(int i=0;i<this.playerCount;i++)
			this.roundPlayed.set(i,false);
	}
	public boolean getRoundPlayed(int playerId) {
		return this.roundPlayed.get(playerId);
	}
	public void setRoundPlayed(int playerId) {
		this.roundPlayed.set(playerId, true);
	}
	public int getwinThreshold() {
		return this.winThreshold;
	}
	public void setWinner(int index) {
		this.winner.set(index, true);
	}
	public int findWinner() {
		int index = this.winner.indexOf(true);
			return index;
	}
	

	public boolean isGameOver() { //Game ends when either rounds are completed or someone wins
		if(this.currentround==this.rounds || this.winner.contains(true))
			return true;
		else
			return false;
	}
	public boolean playersPlaying() { //checks if all the players have finished playing the ongoing round
		if(this.roundPlayed.contains(false))
			return true;
		else
			return false;
	}
	
	//used by moderator to insert a random value in the list of generated numbers
	public synchronized void insertValue(int num) { 
		this.setCurrentround(this.getCurrentround()+1);
		this.numbers.add(num);
	}
	//used by players to retrieve last inserted value in the list of numbers
	public synchronized int getLastNumber() {
		int val = this.numbers.get(this.numbers.size()-1);
		return val;
	}
	@Override
	public String toString() {
		return "Table [maxRounds=" + rounds + ", currentround=" + currentround + ", numbers=" + numbers + ", playerCount="
				+ playerCount + ", winThreshold=" + winThreshold + "]";
	}
}