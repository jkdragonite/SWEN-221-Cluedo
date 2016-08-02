package ui;

import game.Location;
import game.Player;

public class Board {
	
	private char[][] currentBoardArray;
	private char[][] cleanBoard;
	  
	// using characters just to get started, will change to square instances later
	Board(){
		cleanBoard = new char[][]{
				{'x','x','x','x','x','x','x','x','x','`','x','x','x','x','x','`','x','x','x','x','x','x','x','x','x'},
				{'r','r','r','r','r','s','.','.','.','.','r','r','r','r','r','.','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','d','r','r','r','r','r','r','r','d','.','.','.','r','r','r','s','x'},
				{'x','r','r','r','d','r','.','.','r','r','r','r','r','r','r','r','r','.','.','.','.','.','.','.','`'},
				{'.','.','.','.','.','.','.','.','r','d','r','r','r','r','r','d','r','.','.','.','.','.','.','.','x'},
				{'x','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','.','.','.','.','.','.','.','.','.','.','.','.','.','.','d','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','d','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','d','r'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','.','.','.','.','.','x'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','r','x'},
				{'r','r','r','r','r','r','d','r','.','.','x','x','x','x','x','x','.','.','r','r','r','r','r','r','r'},
				{'x','.','.','.','.','.','.','.','.','.','x','x','x','x','x','x','.','.','r','r','r','r','r','r','r'},
				{'`','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','r','r','r','r','r','r','r'},
				{'x','.','.','.','.','.','.','.','.','r','r','r','r','r','r','r','.','.','.','r','r','r','r','r','x'},
				{'s','r','r','r','r','r','d','.','.','r','r','r','r','r','r','r','.','.','.','.','.','.','.','.','`'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','.','.','.','.','.','.','x'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','s'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','x','`','x','r','r','r','r','r','r','r','x','.','r','r','r','r','r','r','r'},
		};	
		
		currentBoardArray = new char[][]{
				{'x','x','x','x','x','x','x','x','x','`','x','x','x','x','x','`','x','x','x','x','x','x','x','x','x'},
				{'r','r','r','r','r','s','.','.','.','.','r','r','r','r','r','.','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','.','.','d','r','r','r','r','r','r','r','d','.','.','.','r','r','r','s','x'},
				{'x','r','r','r','d','r','.','.','r','r','r','r','r','r','r','r','r','.','.','.','.','.','.','.','`'},
				{'.','.','.','.','.','.','.','.','r','d','r','r','r','r','r','d','r','.','.','.','.','.','.','.','x'},
				{'x','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','.','.','.','.','.','.','.','.','.','.','.','.','.','.','d','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','d','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','d','r'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','.','.','.','.','.','x'},
				{'r','r','r','r','r','r','r','r','.','.','x','x','x','x','x','x','.','.','.','r','r','r','r','r','x'},
				{'r','r','r','r','r','r','d','r','.','.','x','x','x','x','x','x','.','.','r','r','r','r','r','r','r'},
				{'x','.','.','.','.','.','.','.','.','.','x','x','x','x','x','x','.','.','r','r','r','r','r','r','r'},
				{'`','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','r','r','r','r','r','r','r'},
				{'x','.','.','.','.','.','.','.','.','r','r','r','r','r','r','r','.','.','.','r','r','r','r','r','x'},
				{'s','r','r','r','r','r','d','.','.','r','r','r','r','r','r','r','.','.','.','.','.','.','.','.','`'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','.','.','.','.','.','.','x'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','s'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r','.','.','r','r','r','r','r','r','r'},
				{'r','r','r','r','r','r','x','`','x','r','r','r','r','r','r','r','x','.','r','r','r','r','r','r','r'},
		};			
	}
	
	public String toString(){
		String boardState = "";
		for (char[] x : this.currentBoardArray){
			boardState = boardState+"\n";
			boardState = boardState + '|';
			for (char y : x){
				boardState = boardState + y;
				boardState = boardState + '|';
			}
		}
		return boardState;
	}
	
	public void movePlayer(Player player, int x, int y){
		int currentY = player.getLocation().getYLoc();
		int currentX = player.getLocation().getIntXLoc();
		this.currentBoardArray[y][x] = currentBoardArray[currentY][currentX];
		this.currentBoardArray[currentY][currentX] = cleanBoard[currentY][currentX];
		player.setLocation(new Location('a', y, x));
	}
	
	
	
	public static void main(String[] args){
		Board board = new Board();
		System.out.println(board.toString());
	}
	
	
}