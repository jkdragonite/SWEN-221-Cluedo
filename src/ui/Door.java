package ui;

public class Door extends EmptySquare implements Square {
	private Room room;
	
	public Door(Room room){
		this.room = room;
	}
	
	public Room getRoom(){
		return this.room;
	}

}
