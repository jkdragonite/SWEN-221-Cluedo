package game;

/**
 * This abstract class represents a card object in the Cluedo game. 
 * It contains most of the methods need by all instances of its subclasses
 * (WeaponCard, CharacterCard & RoomCard), and only one method to be 
 * implemented in subclasses (which allows for easy identification of subclass
 * Card types when required). 
 * 
 * @author Marielle Cheyne
 * @author Jordan Ching
 *
 */

public abstract class Card {
	private String info;
	
	/**
	 * A basic constructor which stores the card's information in the relevant field
	 * @param (String) info
	 */
	public Card(String info){
		this.info = info;
	}
	/**
	 * Returns the information stored in the card object's only field, which 
	 * helps identify card instances 
	 * @return 
	 */
	public String getInfo(){
		return info;
	}
	
	/**
	 * Standard equals method used to determine firstly if the object given is
	 * a Card before a second equals(Card) method is called to determine
	 * if the Card subtypes match
	 * 
	 * @return true or false 
	 */
	public boolean equals(Object o){
		if(o instanceof Card){
			Card c = (Card) o;
			return this.equals(c);
		}
		return false;
	}
	/**
	 * Used to differentiate between class subtypes given another card. 
	 * @param c
	 * @return true or false
	 */
	public abstract boolean equals(Card c);
}
