package ui;

import javax.print.attribute.standard.Destination;

import game.Location;

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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "s";
	}
	// location in constructor?
	// travel method?

}
