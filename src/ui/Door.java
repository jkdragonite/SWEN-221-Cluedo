package ui;

public class Door implements Square {
	private Room room;
	
	public Door(Room room){
		this.room = room;
	}
	
	public Room getRoom(){
		return this.room;
	}

}
