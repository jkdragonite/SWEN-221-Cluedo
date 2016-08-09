package ui;


import game.Location;

/**
 * Represents stairs, hold it's room as well as the room is leads to
 * @author Jordan
 * @author Marielle
 */
public class Stairs extends Square {
	
	private Location location;
	private Room room;
	private Room destinationRoom;
	
	
	public Stairs(Location location, Room room, Room destination) {
		this.room = room;
		this.location = location;
		this.destinationRoom = destination;
		// TODO Auto-generated constructor stub
	}
	
	public Room getDestination(){
		return this.destinationRoom;
	}
	
	public Room getRoom(){
		return this.room;
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	@Override
	public String toString() {
		return "s";
	}
}
