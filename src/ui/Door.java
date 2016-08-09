package ui;

import game.Location;
import game.Player;

/**
 * A square which represents a door, connected to a room, and can contain a player. Has a location corresponding to board
 * 
 * @author Jordan
 * @author Marielle
 *
 */
public class Door extends EmptySquare {
	private Room room;
	private Player playerOnSquare;
	private Location location;
	
	/**
	 * Takes a room enum token and location, and creates a new instance using this information
	 * 
	 * @param room the door leads to
	 * @param location on the board
	 */
	public Door(Room room, Location location){
		this.room = room;
		this.location = location;
	}
	
	/**
	 * @return door's location
	 */
	public Location getLocation(){
		return this.location;
	}
	
	/**
	 * @return room associated with door
	 */
	public Room getRoom(){
		return this.room;
	}

	/* (non-Javadoc)
	 * @see ui.EmptySquare#toString()
	 * Overrides toString method
	 * 
	 */
	@Override
	public String toString(){
		if (this.playerOnSquare == null){
			return "D";	
		}
		else{
		return this.playerOnSquare.toString();
		}
	}
	
}
