package ui;

import game.Player;

public class EmptySquare extends Square{
	// player occupying square, to help check movement legality
	private Player playerOnSquare = null;
	
	public Player getPlayer(){
		return this.playerOnSquare;
	}
	

}
