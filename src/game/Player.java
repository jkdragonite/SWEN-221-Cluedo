package game;

import java.util.HashSet;

import ui.Room;
import game.Player.Token;

/**
 * Represents a player in a standard Cluedo game
 * 
 * @author Marielle Cheyne
 * @author Jordan Ching
 *
 */

public class Player {
	public enum Token{
		MissScarlett,
		ColonelMustard,
		ProfessorPlum,
		MrsWhite,
		ReverendGreen,
		MrsPeacock
	}
	
	private Token token;
	private Location location;
	private Hand hand;
	private boolean activePlayer;
	private Room room;
	private String boardString;
	
	
	/**
	 * 
	 * @param token
	 * @param location
	 * @param hand
	 */
	public Player(Token token){
		this.token = token;
		this.hand = new Hand(new HashSet<Card>());
		this.location = getStartLocation(token);
		this.room = null;
		activePlayer = true;
		setString();
	}
	
	// get moves
	// get movement choices
	
	public Token getToken(){
		return token;
	}
	
	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	
	public Hand getHand(){
		return hand;
	}
	
	public void setInactive(){
		activePlayer = false;
	}
	
	public boolean isActive(){
		return activePlayer;
	}
	
	public String toString(){
		return this.boardString;
	}
	
	/**
	 * Basic method used in construction of a character returning their 
	 * set start location.
	 * This allows the constructor to be a little less cluttered.
	 * 
	 * @param token
	 * @return
	 */
	public Location getStartLocation(Token token){
		switch(token){
		case MissScarlett:
			return new Location(7,24);
		case ColonelMustard:
			return new Location(0,17);
		case ProfessorPlum:
			return new Location(24,19);
		case MrsWhite:
			return new Location(9,0);
		case ReverendGreen:
			return new Location(15,0);
		case MrsPeacock:
			return new Location(24,6);
		}
		throw new IllegalArgumentException("Token " + token + " has no match");
	}
	
	public void setRoom(Room room){
		this.room = room;
	}
	
	public void resetRoom(){
		this.room = null;
	}
	
	public Room getRoom(){
		return this.room;
	}
	
	public void addToHand(Card card){
		hand.addCard(card);
	}
	
	public void setString(){
		if (this.token == Token.MissScarlett){
			this.boardString = "S";
		}
		if (this.token == Token.ColonelMustard){
			this.boardString = "C";
		}
		if (this.token == Token.ProfessorPlum){
			this.boardString = "P";
		}
		if (this.token == Token.MrsWhite){
			this.boardString = "W";
		}
		if (this.token == Token.ReverendGreen){
			this.boardString = "G";
		}
		if (this.token == Token.MrsPeacock){
			this.boardString = "M";
		}	
	}
	
}
