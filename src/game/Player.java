package game;

import java.util.HashSet;

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
		activePlayer = true;
	}
	
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
			return new Location('h',25);
		case ColonelMustard:
			return new Location('a',18);
		case ProfessorPlum:
			return new Location('y',20);
		case MrsWhite:
			return new Location('j',1);
		case ReverendGreen:
			return new Location('p',1);
		case MrsPeacock:
			return new Location('y',7);
		}
		throw new IllegalArgumentException("Token " + token + " has no match");
	}
	
	public void addToHand(Card card){
		hand.addCard(card);
	}
	
}
