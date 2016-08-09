package ui;

import java.util.ArrayList;
import java.util.List;

import game.GameOfCluedo;
import game.Location;
import game.Player;


public class Room extends Square {
	// mucking about with square ideas
	
	private List<Player> playersInside = new ArrayList<Player>();
	private String weapon = null;
	private String roomName;
	public ArrayList<Location> roomSquares = new ArrayList<>();
	private Stairs stairs = null; 
	private ArrayList<Door> doors = new ArrayList<>();
	
	/**
	 * Creates an new instance of a room with the specified name, and list of encompassing locations. 
	 * The room may contain a weapon (null if no weapon is in the room).
	 * 
	 * @param name of the room
	 * @param weapon contained in the room, if any
	 * @param roomSquares list of locations on the board that this room covers
	 */	
	public Room(String name, String weapon){
		roomName = name;
		this.weapon = weapon;
		setSquares();
//		this.roomSquares = roomSquares;
	}
	
	public ArrayList<Location> getRoomSquares(){
		return this.roomSquares;
	}
	
	public List<Player> getPlayers(){
		return this.playersInside;
	}
	
	public void addPlayer(Player player){
		this.playersInside.add(player);

	}
	
	public void removePlayer(Player player){
		this.playersInside.remove(player);
	}
	
	public boolean isInRoom(Location location, Player player){
		return roomSquares.contains(location) || playersInside.contains(player);
	}
	
	public boolean containsWeapon(String string){
		return this.weapon == string;
	}
	
	public void setWeapon(String weapon){
		this.weapon = weapon;
	}
	
	public String getWeapon() {
		return this.weapon;
		
	}
	
	public String getName(){
		return this.roomName;
	}
	
	public Stairs getStairs(){
		return this.stairs;
	}
	
	public void setStairs(Stairs stairs) {
		this.stairs = stairs;
	}
	
	@Override
	public String toString(){
		return "r";
	}
	
	public ArrayList<Door> getDoors(){
		return this.doors;
	}
	
	public void addDoor(Door door){
		this.doors.add(door);
	}
	

	
	public void setSquares(){
		if (this.roomName == "Kitchen"){
			for ( int i = 1; i < 6; i++){
				this.roomSquares.add(new Location(0, i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location(1, i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location(2, i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location(3, i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location(4, i));
			}
			for ( int i = 2; i < 7; i++){
				this.roomSquares.add(new Location(5, i));
			}
		}
			
		if (this.roomName == "Dining Room"){
			for ( int i = 9; i < 16; i++){
				this.roomSquares.add(new Location(0, i));
			}
			for ( int i = 9; i < 16; i++){
				this.roomSquares.add(new Location(1, i));
			}
			for ( int i = 9; i < 16; i++){
				this.roomSquares.add(new Location(2, i));
			}
			for ( int i = 9; i < 16; i++){
				this.roomSquares.add(new Location(3, i));
			}
			for ( int i = 9; i < 16; i++){
				this.roomSquares.add(new Location(4, i));
			}
			for ( int i = 10; i < 16; i++){
				this.roomSquares.add(new Location(5, i));
			}
			for ( int i = 10; i < 16; i++){
				this.roomSquares.add(new Location(6, i));
			}
			for ( int i = 10; i < 16; i++){
				this.roomSquares.add(new Location(7, i));
			}
		}
		if (this.roomName == "Lounge"){
			for ( int i = 20; i < 25; i++){
				this.roomSquares.add(new Location(0, i));
			}
			for ( int i = 19; i < 25; i++){
				this.roomSquares.add(new Location(1, i));
			}
			for ( int i = 19; i < 25; i++){
				this.roomSquares.add(new Location(2, i));
			}
			for ( int i = 19; i < 25; i++){
				this.roomSquares.add(new Location(3, i));
			}
			for ( int i = 19; i < 25; i++){
				this.roomSquares.add(new Location(4, i));
			}
			for ( int i = 19; i < 25; i++){
				this.roomSquares.add(new Location(5, i));
			}
			for ( int i = 19; i < 25; i++){
				this.roomSquares.add(new Location(6, i));
			}
		}
		
		if (this.roomName == "Ball Room"){
			for ( int i = 2; i < 8; i++){
				this.roomSquares.add(new Location(8, i));
			}
			for ( int i = 2; i < 8; i++){
				this.roomSquares.add(new Location(9, i));
			}
			for ( int i = 1; i < 8; i++){
				this.roomSquares.add(new Location(10, i));
			}
			for ( int i = 1; i < 8; i++){
				this.roomSquares.add(new Location(11, i));
			}
			for ( int i = 1; i < 8; i++){
				this.roomSquares.add(new Location(12, i));
			}
			for ( int i = 1; i < 8; i++){
				this.roomSquares.add(new Location(13, i));
			}
			for ( int i = 1; i < 8; i++){
				this.roomSquares.add(new Location(14, i));
			}
			for ( int i = 2; i < 8; i++){
				this.roomSquares.add(new Location(15, i));
			}
			for ( int i = 2; i < 8; i++){
				this.roomSquares.add(new Location(16, i));
			}
		}
		
		if (this.roomName == "Hall"){
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(9, i));
			}
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(10, i));
			}
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(11, i));
			}
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(12, i));
			}
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(13, i));
			}
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(14, i));
			}
			for ( int i = 18; i < 25; i++){
				this.roomSquares.add(new Location(15, i));
			}
		}
		
		if (this.roomName == "Conservatory"){
			for ( int i = 1; i < 5; i++){
				this.roomSquares.add(new Location(19, i));
			}
			for ( int i = 1; i < 6; i++){
				this.roomSquares.add(new Location(20, i));
			}
			for ( int i = 1; i < 6; i++){
				this.roomSquares.add(new Location(21, i));
			}
			for ( int i = 1; i < 6; i++){
				this.roomSquares.add(new Location(22, i));
			}
			for ( int i = 1; i < 5; i++){
				this.roomSquares.add(new Location(23, i));
			}
			for ( int i = 1; i < 5; i++){
				this.roomSquares.add(new Location(24, i));
			}
		}
		
		
		if (this.roomName == "Billiard Room"){
			for ( int i = 8; i < 13; i++){
				this.roomSquares.add(new Location(19, i));
			}
			for ( int i = 8; i < 13; i++){
				this.roomSquares.add(new Location(20, i));
			}
			for ( int i = 8; i < 13; i++){
				this.roomSquares.add(new Location(21, i));
			}
			for ( int i = 8; i < 13; i++){
				this.roomSquares.add(new Location(22, i));
			}
			for ( int i = 8; i < 13; i++){
				this.roomSquares.add(new Location(23, i));
			}
			for ( int i = 8; i < 13; i++){
				this.roomSquares.add(new Location(24, i));
			}
		}					
		
		if (this.roomName == "Library"){
			for ( int i = 15; i < 18; i++){
				this.roomSquares.add(new Location(18, i));
			}						
			for ( int i = 14; i < 19; i++){
				this.roomSquares.add(new Location(19, i));
			}
			for ( int i = 14; i < 19; i++){
				this.roomSquares.add(new Location(20, i));
			}
			for ( int i = 14; i < 19; i++){
				this.roomSquares.add(new Location(21, i));
			}
			for ( int i = 14; i < 19; i++){
				this.roomSquares.add(new Location(22, i));
			}
			for ( int i = 14; i < 19; i++){
				this.roomSquares.add(new Location(23, i));
			}
			for ( int i = 15; i < 18; i++){
				this.roomSquares.add(new Location(24, i));
			}
		}						
		if (this.roomName == "Study"){
			for ( int i = 21; i < 25; i++){
				this.roomSquares.add(new Location(18, i));
			}						
			for ( int i = 21; i < 25; i++){
				this.roomSquares.add(new Location(19, i));
			}
			for ( int i = 21; i < 25; i++){
				this.roomSquares.add(new Location(20, i));
			}
			for ( int i = 21; i < 25; i++){
				this.roomSquares.add(new Location(21, i));
			}
			for ( int i = 21; i < 25; i++){
				this.roomSquares.add(new Location(22, i));
			}
			for ( int i = 21; i < 25; i++){
				this.roomSquares.add(new Location(23, i));
			}
			for ( int i = 22; i < 25; i++){
				this.roomSquares.add(new Location(24, i));
			}
		}	
	}

	//stairs
	

}
