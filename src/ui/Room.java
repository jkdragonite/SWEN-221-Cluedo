package ui;

import java.util.ArrayList;

import game.GameOfCluedo;
import game.Location;
import game.Player;

public class Room extends Square {
	// mucking about with square ideas
	
	private Player[] playersInside;
	private GameOfCluedo.Weapon weapon = null;
	private String roomName;
	private ArrayList<Location> roomSquares;
	
	/**
	 * Creates an new instance of a room with the specified name, and list of encompassing locations. 
	 * The room may contain a weapon (null if no weapon is in the room).
	 * 
	 * @param name of the room
	 * @param weapon contained in the room, if any
	 * @param roomSquares list of locations on the board that this room covers
	 */
	public Room(String name, GameOfCluedo.Weapon weapon, ArrayList<Location> roomSquares){
		roomName = name;
		this.weapon = weapon;
		this.roomSquares = roomSquares;
	}
	
	public Player[] getPlayers(){
		return this.playersInside;
	}
	
	public void addPlayer(Player player){

	}
	
	public void removePlayer(Player player){

	}
	
	public boolean isInRoom(Location location){
		return roomSquares.contains(location);
	}
	
	public GameOfCluedo.Weapon containsWeapon(){
		return weapon;
	}
	
	public void setWeapon(GameOfCluedo.Weapon weapon){
		this.weapon = weapon;
	}
	
	public String getName(){
		return this.roomName;
	}
}
