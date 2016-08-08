package ui;

import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import game.Location;
import game.Player;

public class Board {
	
	public Map<Integer, Character> charMap = new HashMap<Integer, Character>();
	private char[][] currentBoardArray;
	private char[][] cleanBoard;
	private Square[][] boardSquares = {{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
	},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
		
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			},{new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare(),new EmptySquare()
				
			}};
	private Room[] rooms;
	
	

	
	  
	// using characters just to get started, will change to square instances later
	public Board(){
		makeMap();
		
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
		
		createBoard();
	}
	
	
	void makeMap(){
		this.charMap.put(0, 'a');
		this.charMap.put(1, 'b');
		this.charMap.put(2, 'c');
		this.charMap.put(3, 'd');
		this.charMap.put(4, 'e');
		this.charMap.put(5, 'f');
		this.charMap.put(6, 'g');
		this.charMap.put(7, 'h');
		this.charMap.put(8, 'i');
		this.charMap.put(9, 'j');
		this.charMap.put(10, 'k');
		this.charMap.put(11, 'l');
		this.charMap.put(12, 'm');
		this.charMap.put(13, 'n');
		this.charMap.put(14, 'o');
		this.charMap.put(15, 'p');
		this.charMap.put(16, 'q');
		this.charMap.put(17, 'r');
		this.charMap.put(18, 's');
		this.charMap.put(19, 't');
		this.charMap.put(20, 'u');
		this.charMap.put(21, 'v');
		this.charMap.put(22, 'w');
		this.charMap.put(23, 'x');
		this.charMap.put(24, 'y');		
	}
	public void createBoard(){
		for ( int i = 0; i < boardSquares.length; i ++){
			for ( int j = 0; j < 25; j ++){
				if (cleanBoard[i][j] == 'x'){
					boardSquares[i][j] = new NonPlayableSquare();
				}
				else {
					boardSquares[i][j] = new EmptySquare();
				}				
			}
		}
		
			
		
		Room kitchen = new Room("Kitchen", null);
		Room ballRoom = new Room("Ball Room", null);
		Room conservatory = new Room("Conservatory", null);
		Room diningRoom = new Room("Dining Room", null);
		Room billiardRoom = new Room("Billiard Room", null);
		Room library = new Room("Library", null);
		Room lounge = new Room("Lounge", null);
		Room hall = new Room("Hall", null);
		Room study = new Room("Study", null);
		
		
		Stairs kitchenStairs = new Stairs(new Location('f', 1), kitchen, study); 
		boardSquares[1][5] = kitchenStairs;
		kitchen.setStairs(kitchenStairs);
		
		Stairs loungeStairs = new Stairs(new Location('A', 19), lounge, conservatory);
		boardSquares[19][0] = loungeStairs;
		lounge.setStairs(loungeStairs);
		
		Stairs conservatoryStairs = new Stairs(new Location('X', 5), conservatory, lounge);
		boardSquares[5][23] = conservatoryStairs;
		conservatory.setStairs(conservatoryStairs);
		
		Stairs studyStairs = new Stairs(new Location('Y', 5), study, kitchen);
		boardSquares[21][24] = studyStairs;
		study.setStairs(studyStairs);
		
		
		boardSquares[7][4] = new Door(kitchen);
		
		boardSquares[12][8] = new Door(diningRoom);
		boardSquares[16][6] = new Door(diningRoom);
		
		boardSquares[18][6] = new Door(lounge);

		boardSquares[5][7] = new Door(ballRoom);
		boardSquares[8][9] = new Door(ballRoom);
		boardSquares[5][17] = new Door(ballRoom);
		boardSquares[8][15] = new Door(ballRoom);
		
		boardSquares[5][19] = new Door(conservatory);
		
		boardSquares[17][11] = new Door(hall);
		boardSquares[17][12] = new Door(hall);
		boardSquares[17][13] = new Door(hall);
		boardSquares[20][16] = new Door(hall);
		
		boardSquares[20][18] = new Door(study);
		
		boardSquares[16][17] = new Door(library);
		boardSquares[13][21] = new Door(library);

		
		boardSquares[9][18] = new Door(billiardRoom);
		boardSquares[13][23] = new Door(billiardRoom);
		
		
		
		
		
		
		
		Room[] roomArray = {kitchen, ballRoom, conservatory, diningRoom, billiardRoom,
				library, lounge, hall, study};
		this.rooms = roomArray;
		
		for (Room room : roomArray){
			for (Location location : room.getRoomSquares()){
				Point point = location.getBoardCoOrd();
				boardSquares[point.y][point.x] = room;
			}
			
		}
	}
	
	public boolean isInRoom(Location location, Player player){
		for (Room r : rooms){
			if (r.isInRoom(location, player)){
				return true;
			}
		}
		return false;
	}
	
	
	public String otherString(){
		String boardState = "";
		for (Square[] x : this.boardSquares){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
			boardState = boardState+"\n";
			boardState = boardState + '|';
			for (Square y : x){
				boardState = boardState + y.toString();
				boardState = boardState + '|';
			}
		}
		return boardState;
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
		for (Room room : rooms){
			if (room.isInRoom(player.getLocation(), player)){
				room.removePlayer(player);
				player.resetRoom();
			}
		}				
		Point point =  player.getLocation().getBoardCoOrd();
		int currentY = point.y;
		int currentX = point.x;
		// add player to empty square / room
		this.boardSquares[currentY][currentX].removePlayer();
		this.boardSquares[y][x].setPlayer(player);
		player.setLocation(new Location(charMap.get(x), y));
		for (Room room : rooms){
			if (room.isInRoom(player.getLocation(), player)){
				room.addPlayer(player);
				player.setRoom(room);
			}
		}
	}
	
	public Map<String, Location> getMoves(Player player){
		// this is gonna be wrong because of the getlocaiton stuff
//		ArrayList<Location> playerMoves = new ArrayList<Location>();
//		ArrayList<String> moves = new ArrayList<String>(); 
		Map<String, Location> possibleMoves = new HashMap<String, Location>();
		// if instance of room add move for room

		if (boardSquares[player.getLocation().getBoardCoOrd().y-1][player.getLocation().getBoardCoOrd().x] instanceof EmptySquare || 
				boardSquares[player.getLocation().getBoardCoOrd().y-1][player.getLocation().getBoardCoOrd().x] instanceof Door ||
				boardSquares[player.getLocation().getBoardCoOrd().y-1][player.getLocation().getBoardCoOrd().x] instanceof Room){
			possibleMoves.put("Move Up", new Location(charMap.get(player.getLocation().getBoardCoOrd().x), player.getLocation().getBoardCoOrd().y-1));
		}
		if (boardSquares[player.getLocation().getBoardCoOrd().y+1][player.getLocation().getBoardCoOrd().x] instanceof EmptySquare || 
				boardSquares[player.getLocation().getBoardCoOrd().y+1][player.getLocation().getBoardCoOrd().x] instanceof Door ||
				boardSquares[player.getLocation().getBoardCoOrd().y+1][player.getLocation().getBoardCoOrd().x] instanceof Room){
			possibleMoves.put("Move Down", new Location(charMap.get(player.getLocation().getBoardCoOrd().x), player.getLocation().getBoardCoOrd().y+1));
		}		
		if (boardSquares[player.getLocation().getBoardCoOrd().y][player.getLocation().getBoardCoOrd().x-1] instanceof EmptySquare || 
				boardSquares[player.getLocation().getBoardCoOrd().y][player.getLocation().getBoardCoOrd().x-1] instanceof Door ||
				boardSquares[player.getLocation().getBoardCoOrd().y][player.getLocation().getBoardCoOrd().x-1] instanceof Room){
			possibleMoves.put("Move Left", new Location(charMap.get(player.getLocation().getBoardCoOrd().x-1), player.getLocation().getBoardCoOrd().y));
		}
		if (boardSquares[player.getLocation().getBoardCoOrd().y][player.getLocation().getBoardCoOrd().x+1] instanceof EmptySquare || 
				boardSquares[player.getLocation().getBoardCoOrd().y][player.getLocation().getBoardCoOrd().x+1] instanceof Door ||
				boardSquares[player.getLocation().getBoardCoOrd().y][player.getLocation().getBoardCoOrd().x+1] instanceof Room){
			possibleMoves.put("Move Right", new Location(charMap.get(player.getLocation().getBoardCoOrd().x+1), player.getLocation().getBoardCoOrd().y));
		}

		return possibleMoves;
	}
	
	public Room[] getRooms(){
		return rooms;
	}
	
	
	
//	public static void main(String[] args){
//		Board board = new Board();
//		System.out.println(board.otherString());
//	}
	
	
}