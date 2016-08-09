package ui;

import game.Player;

/**
 * Basis for the squares used for the boards
 * 
 * @author Jordan
 * @author Marielle
 */
public abstract class Square {
	Player playerOnSquare = null;
	public String toString() {
		return null;
	}
	public Player getPlayer(){
		return this.playerOnSquare;
	}
	
	public void setPlayer(Player player){
		this.playerOnSquare = player;
	}

	public void removePlayer(){
		this.playerOnSquare = null;
	}
	
}
