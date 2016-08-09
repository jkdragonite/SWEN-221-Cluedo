package ui;

import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import game.Location;
import game.Player;

/**
 * 
 * The board comprising of instances of the square class. Hard coded emptysquare instances because we had issues with eclipse.
 * This is a 25 by 25 grid made up of a mix of empty squares, roomsquares, stair squares, door squares, and non-playable squares, which each have differnt
 * attributes used to dictate player interaction and movement.
 * 
 * @author Jordan
 * @author Marielle
 *
 */
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
	
	

	
	  
	public Board(){
		
		cleanBoard = new char[][]{
				// a character representation of the array, used to reset board positions
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
		

		// a character representation of the current board state, to make printing easier
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
	
	
	/**
	 * 
	 * Creates room instances and uses a set of loops to fill out the board 
	 * 
	 * 
	 */
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
		
		
		Stairs kitchenStairs = new Stairs(new Location(5, 1), kitchen, study); 
		boardSquares[1][5] = kitchenStairs;
		kitchen.setStairs(kitchenStairs);
		
		Stairs loungeStairs = new Stairs(new Location(0, 19), lounge, conservatory);
		boardSquares[19][0] = loungeStairs;
		lounge.setStairs(loungeStairs);
		
		Stairs conservatoryStairs = new Stairs(new Location(23, 5), conservatory, lounge);
		boardSquares[5][23] = conservatoryStairs;
		conservatory.setStairs(conservatoryStairs);
		
		Stairs studyStairs = new Stairs(new Location(24, 5), study, kitchen);
		boardSquares[21][24] = studyStairs;
		study.setStairs(studyStairs);
		
		
		Room[] roomArray = {kitchen, ballRoom, conservatory, diningRoom, billiardRoom,
				library, lounge, hall, study};
		this.rooms = roomArray;
		
		for (Room room : roomArray){
			for (Location location : room.getRoomSquares()){
				Point point = new Point(location.getXLoc(), location.getYLoc());
				boardSquares[point.y][point.x] = room;
			}
			
		}
		
		
		boardSquares[6][4] = new Door(kitchen, new Location(4, 6));
		kitchen.addDoor((Door) boardSquares[6][4]);
		
		boardSquares[12][7] = new Door(diningRoom, new Location(7,12));
		diningRoom.addDoor((Door) boardSquares[12][7]);
		boardSquares[15][6] = new Door(diningRoom, new Location(6,15));
		diningRoom.addDoor((Door) boardSquares[15][6]);
		
		
		boardSquares[19][6] = new Door(lounge, new Location(6,19));
		lounge.addDoor((Door) boardSquares[19][6]);

		boardSquares[5][8] = new Door(ballRoom, new Location(8,5));
		ballRoom.addDoor((Door) boardSquares[5][8]);
		boardSquares[7][9] = new Door(ballRoom, new Location(9,7));
		ballRoom.addDoor((Door) boardSquares[7][9]);
		boardSquares[5][16] = new Door(ballRoom, new Location(16,5));
		ballRoom.addDoor((Door) boardSquares[5][16]);
		boardSquares[7][15] = new Door(ballRoom, new Location(15,7));
		ballRoom.addDoor((Door) boardSquares[7][15]);
		
		boardSquares[4][19] = new Door(conservatory, new Location(19,4));
		conservatory.addDoor((Door) boardSquares[4][19]);
		
		boardSquares[18][11] = new Door(hall, new Location(11,18));
		hall.addDoor((Door) boardSquares[18][11]);
		boardSquares[18][12] = new Door(hall, new Location(12,18));
		hall.addDoor((Door) boardSquares[18][12]);
		boardSquares[18][13] = new Door(hall, new Location(13,18));
		hall.addDoor((Door) boardSquares[18][13]);
		boardSquares[20][15] = new Door(hall, new Location(15,20));
		hall.addDoor((Door) boardSquares[20][15]);
		
		boardSquares[21][18] = new Door(study, new Location(18,21));
		study.addDoor((Door) boardSquares[21][18]);
		
		boardSquares[16][18] = new Door(library, new Location(18,16));
		library.addDoor((Door) boardSquares[16][18]);
		boardSquares[14][22] = new Door(library, new Location(22,14));
		library.addDoor((Door) boardSquares[14][22]);

		
		boardSquares[9][19] = new Door(billiardRoom, new Location(19,9));
		billiardRoom.addDoor((Door) boardSquares[9][19]);
		boardSquares[12][23] = new Door(billiardRoom, new Location(23,12));
		billiardRoom.addDoor((Door) boardSquares[12][23]);
			

	}
	
	/**
	 * Takes a location and a player, and checks if the given location is within a room
	 * 
	 * @param location on board
	 * @param player
	 * @return boolean
	 */
	public boolean isInRoom(Location location, Player player){
		for (Room r : rooms){
			if (r.isInRoom(location, player)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * takes a list of players, and uses the information contained in the board arrays to construct a string representing the current
	 * board state
	 * 
	 * @param list of players 
	 * 
	 * @return a string representing the board 
	 */
	public String toString(java.util.List<Player> list){
		for (int i = 0; i < currentBoardArray.length; i++){
			for (int j = 0; j < currentBoardArray[i].length; j++){
				currentBoardArray[i][j] = cleanBoard[i][j];
			}
		}
		String boardState = "";
		
		for (Room room : this.rooms){
			// checks rooms for players, and adds the right character representation
			if (room.getPlayers().isEmpty() == false){
				for (int i = 0; i < room.getPlayers().size(); i++){
					int x = room.roomSquares.get(i).getXLoc(); 
					int y = room.roomSquares.get(i).getYLoc();
					currentBoardArray[y][x] = room.getPlayers().get(i).toString().charAt(0);
				}
			}
		}
		
		for (Player player : list){
			// sets player location on board
			int x = player.getLocation().getXLoc();
			int y = player.getLocation().getYLoc();
			currentBoardArray[y][x] = player.toString().charAt(0);
		}
		
		for (Room room : this.rooms){
			// finds weapons in each room and set the right character on the board
			if (room.getWeapon() != null){
				for (int i = 0; i < room.getPlayers().size(); i++){
					int x = room.roomSquares.get(room.roomSquares.size()).getXLoc(); 
					int y = room.roomSquares.get(room.roomSquares.size()).getYLoc();
					if(room.getWeapon() == "spanner"){
						currentBoardArray[y][x] = 'Y';	
					}
					if(room.getWeapon() == "rope"){
						currentBoardArray[y][x] = '8';	
					}
					if(room.getWeapon() == "revolver"){
						currentBoardArray[y][x] = 'F';	
					}
					if(room.getWeapon() == "lead pipe"){
						currentBoardArray[y][x] = '/';	
					}
					if(room.getWeapon() == "dagger"){
						currentBoardArray[y][x] = '!';	
					}
					if(room.getWeapon() == "candlestick"){
						currentBoardArray[y][x] = 'I';	
					}
					
				}
			}
		}
		boardState = boardState +"    A B C D E F G H I J K L M N O P Q R S T U V W X Y ";
		int i = 0;
		for (char[] x : this.currentBoardArray){
			// finally, builds the string for the board
			String spaceString = "";
			if (i < 10){
				spaceString = "  ";
			}
			else {
				spaceString = " ";
			}
			boardState = boardState+"\n"+ i + spaceString;
			i = i + 1;
			boardState = boardState + '|';
			for (char y : x){

					boardState = boardState + y;
					boardState = boardState + '|';					
				}
			}
		
		return boardState;
	}
	
	
// old unneeded code
//	public String toString(){
//		String boardState = "";
//		for (Square[] x : this.boardSquares){             
//			String lastCharacterAdded = "";
//			boardState = boardState+"\n";
//			boardState = boardState + '|';
//			for (Square y : x){
//				if ( y instanceof Room){
//					// check for weapons / players
//					// check against last character
//					// or make an array of room characters?
//					// construct the array
//					if (((Room) y).getPlayers().isEmpty() == false){
//						boardState = boardState + ((Room) y).getPlayers().get(0).toString();
//						boardState = boardState + '|';		
//					}
//					else{
//						boardState = boardState + y.toString();
//						boardState = boardState + '|';					
//					}
//				}
//				else{
//					boardState = boardState + y.toString();
//					boardState = boardState + '|';					
//				}
//			}
//		}
//		return boardState;
//	}
	
	
	/**
	 * Sets a player's location on the board
	 * 
	 * @param player
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void setPlayer(Player player, int x, int y){
		this.boardSquares[y][x].setPlayer(player);
	}
	
	/**
	 * Moves a player to the new x/y coordinate on the board
	 * Adds/removes player to/from room if necessary 
	 * 
	 * @param player
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void movePlayer(Player player, int x, int y){
		for (Room room : rooms){
			if (room.isInRoom(player.getLocation(), player)){
				room.removePlayer(player);
				player.resetRoom();
			}
		}				
		Point point = new Point(player.getLocation().getXLoc(), player.getLocation().getYLoc());
		int currentY = point.y;
		int currentX = point.x;
		// add player to empty square / room
		this.boardSquares[currentY][currentX].removePlayer();
		this.boardSquares[y][x].setPlayer(player);
		///////
		player.setLocation(new Location(x, y));
		for (Room room : rooms){
			if (room.isInRoom(player.getLocation(), player)){
				room.addPlayer(player);
				player.setRoom(room);
			}
		}
		if (this.boardSquares[y][x] instanceof Door){
			Door door = (Door) boardSquares[y][x];
			player.setRoom(door.getRoom());
			door.getRoom().addPlayer(player);
		}
	}
	
	/**
	 * takes a player and checks the four movable directions for legal moves
	 * adds a special move for leaving a room, if applicable
	 * 
	 * @param player
	 * @return map of moves with their corresponding locations
	 */
	public Map<String, Location> getMoves(Player player){
		

		Map<String, Location> possibleMoves = new HashMap<String, Location>();
		Point upPoint = new Point(player.getLocation().getXLoc(), player.getLocation().getYLoc()-1);
//		System.out.println("up"+upPoint);
		if (upPoint.x > -1 && upPoint.x < 25 && upPoint.y > -1 && upPoint.y < 25){
			if (boardSquares[upPoint.y][upPoint.x] instanceof EmptySquare && boardSquares[upPoint.y][upPoint.x].getPlayer() == null || 
					boardSquares[upPoint.y][upPoint.x] instanceof Door){
				possibleMoves.put("Move Up", new Location(upPoint.x, upPoint.y));
			}			
		}
		Point downPoint = new Point(player.getLocation().getXLoc(), player.getLocation().getYLoc()+1);
//		System.out.println("down"+downPoint);
		if (downPoint.x > -1 && downPoint.x < 25 && downPoint.y > -1 && downPoint.y < 25){
			if (boardSquares[downPoint.y][downPoint.x] instanceof EmptySquare && boardSquares[downPoint.y][downPoint.x].getPlayer() == null || 
					boardSquares[downPoint.y][downPoint.x] instanceof Door){
				possibleMoves.put("Move Down", new Location(player.getLocation().getXLoc(), player.getLocation().getYLoc()+1));
			}	
		}
		Point leftPoint = new Point(player.getLocation().getXLoc()-1, player.getLocation().getYLoc());
//		System.out.println("left"+leftPoint);
		if (leftPoint.x > -1 && leftPoint.x < 25 && leftPoint.y > -1 && leftPoint.y < 25){
			if (boardSquares[leftPoint.y][leftPoint.x] instanceof EmptySquare && boardSquares[leftPoint.y][leftPoint.x].getPlayer() == null || 
				boardSquares[leftPoint.y][leftPoint.x] instanceof Door){
				possibleMoves.put("Move Left", new Location(player.getLocation().getXLoc()-1, player.getLocation().getYLoc()));
			}
		}
		Point rightPoint = new Point(player.getLocation().getXLoc()+1, player.getLocation().getYLoc());
//		System.out.println(rightPoint);
		if (rightPoint.x > -1 && rightPoint.x < 25 && rightPoint.y > -1 && rightPoint.y < 25){
			if (boardSquares[rightPoint.y][rightPoint.x] instanceof EmptySquare && boardSquares[rightPoint.y][rightPoint.x].getPlayer() == null || 
					boardSquares[rightPoint.y][rightPoint.x] instanceof Door){
				possibleMoves.put("Move Right", new Location(player.getLocation().getXLoc()+1, player.getLocation().getYLoc()));
			}
		}
		
		if (player.getRoom() != null){
			Point doorLocUp = new Point(player.getRoom().getDoors().get(0).getLocation().getXLoc(), player.getRoom().getDoors().get(0).getLocation().getYLoc()-1);
//			System.out.println("up"+upPoint);
			if (doorLocUp.x > -1 && doorLocUp.x < 25 && doorLocUp.y > -1 && doorLocUp.y < 25){
				if (boardSquares[doorLocUp.y][doorLocUp.x] instanceof EmptySquare){
					possibleMoves.put("Exit Room", new Location(doorLocUp.x, doorLocUp.y));
				}			
			}
			Point doorLocDown = new Point(player.getRoom().getDoors().get(0).getLocation().getXLoc(), player.getRoom().getDoors().get(0).getLocation().getYLoc()+1);
//			System.out.println("down"+downPoint);
			if (doorLocDown.x > -1 && doorLocDown.x < 25 && doorLocDown.y > -1 && doorLocDown.y < 25){
				if (boardSquares[doorLocDown.y][doorLocDown.x] instanceof EmptySquare){
					possibleMoves.put("Exit Room", new Location(doorLocDown.x, doorLocDown.y+1));
				}	
			}
			Point doorLocLeft = new Point(player.getRoom().getDoors().get(0).getLocation().getXLoc()-1, player.getRoom().getDoors().get(0).getLocation().getYLoc());
//			System.out.println("left"+leftPoint);
			if (doorLocLeft.x > -1 && doorLocLeft.x < 25 && doorLocLeft.y > -1 && doorLocLeft.y < 25){
				if (boardSquares[doorLocLeft.y][doorLocLeft.x] instanceof EmptySquare){
					possibleMoves.put("Exit Room", new Location(doorLocLeft.x-1, doorLocLeft.y));
				}
			}
			Point doorLocRight = new Point(player.getRoom().getDoors().get(0).getLocation().getXLoc()+1, player.getRoom().getDoors().get(0).getLocation().getYLoc());
//			System.out.println(rightPoint);
			if (doorLocRight.x > -1 && doorLocRight.x < 25 && doorLocRight.y > -1 && doorLocRight.y < 25){
				if (boardSquares[doorLocRight.y][doorLocRight.x] instanceof EmptySquare){
					possibleMoves.put("Exit Room", new Location(doorLocRight.x+1, doorLocRight.y));
				}
			}
		}
		if (player.getRoom() != null && player.getRoom().getStairs() != null){
			// method to add stairs to player move options
			int x = player.getRoom().getDoors().get(0).getLocation().getXLoc();
			int y = player.getRoom().getDoors().get(0).getLocation().getYLoc();
			possibleMoves.put("Take Stairs to " + player.getRoom().getStairs().getDestination().getName(), new Location(x, y));
		}
		return possibleMoves;
	}
	
	/**
	 * @return list of rooms on the board
	 */
	public Room[] getRooms(){
		return rooms;
	}
	
}