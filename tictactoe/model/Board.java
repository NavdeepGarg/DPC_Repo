package dev.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	
	List<List<Cell>> board= new ArrayList<>();
	
	Board (int row, int col){
		
		for(int i =0 ; i < row; i++) {
			board.set(i, new ArrayList<>());
			for(int j =0 ; j < col; j++) {
				
				board.get(i).set(j, new Cell());
			}
			
		}
		
	}
}
