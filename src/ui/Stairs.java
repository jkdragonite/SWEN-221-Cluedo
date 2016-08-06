package ui;

import javax.print.attribute.standard.Destination;

import game.Location;

public class Stairs implements Square {
	
	private Location location;
	private Room room;
	private Room destinationRoom;
	
	
	public Stairs(Location location, Room room, Room destination) {
		this.room = room;
		this.location = location;
		this.destinationRoom = destination;
		// TODO Auto-generated constructor stub
	}
	// location in constructor?
	// travel method?

}
