package ui;

import game.Player;

public class Door extends EmptySquare {
	private Room room;
	private Player playerOnSquare;
	
	public Door(Room room){
		this.room = room;
	}
	
	public Room getRoom(){
		return this.room;
	}

	@Override
	public String toString(){
		if (this.playerOnSquare == null){
			return ".";	
		}
		else{
		return "D";
		}
	}
	
}
