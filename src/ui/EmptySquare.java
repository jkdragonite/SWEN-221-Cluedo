package ui;

import game.Player;

/**
 * A class representing an empty square
 * 
 * @author Jordan
 * @author Marielle
 *
 */
public class EmptySquare extends Square{
	
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
		if (this.playerOnSquare == null){
			return ".";	
		}
		else{
			return this.playerOnSquare.toString();
		}
		
	}
}
