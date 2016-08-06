package ui;

import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;

import game.Location;
import game.Player;

public class Board {
	
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
	
	public void createBoard(){
		for ( int i = 0; i < boardSquares.length; i ++){
			for ( int j = 0; j < 25; j ++){
				if (cleanBoard[i][j] == 'x'){
					System.out.println(i);
					System.out.println(j);
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
		
		
		boardSquares[1][5] = new Stairs(new Location('f', 1), kitchen, study);
		boardSquares[19][0] = new Stairs(new Location('A', 19), lounge, conservatory);
		boardSquares[5][23] = new Stairs(new Location('X', 5), conservatory, lounge);
		boardSquares[21][24] = new Stairs(new Location('Y', 5), study, kitchen);
		
		
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
			System.out.println(room.getName());
			for (Location location : room.getRoomSquares()){
				Point point = location.getBoardCoOrd();
				System.out.println(":OIAHKHKH" + point);
				boardSquares[point.y][point.x] = room;
			}
			
		}
	}
	
	public boolean isInRoom(Location location){
		for (Room r : rooms){
			if (r.isInRoom(location)){
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
		Point point =  player.getLocation().getBoardCoOrd();
		int currentY = point.y;
		int currentX = point.x;
		this.currentBoardArray[y][x] = currentBoardArray[currentY][currentX];
		this.currentBoardArray[currentY][currentX] = cleanBoard[currentY][currentX];
		player.setLocation(new Location('a', y));
	}
	
	
	
	
	
	public static void main(String[] args){
		Board board = new Board();
		System.out.println(board.otherString());
	}
	
	
}