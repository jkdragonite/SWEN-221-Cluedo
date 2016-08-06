package ui;

import game.Player;

public class EmptySquare implements Square{
	// player occupying square, to help check movement legality
	private Player playerOnSquare = null;
	
	public Player getPlayer(){
		return this.playerOnSquare;
	}
	
	public void setPlayer(Player player){
		this.playerOnSquare = player;
	}

	public void removePlayer(){
		this.playerOnSquare = null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ".";
	}
}
