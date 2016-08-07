package ui;

import game.Player;

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
