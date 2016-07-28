package game;

import java.util.Set;

/**
 * Represents a given Cluedo Player's hand of cards in a standard Cluedo game
 * Implements methods for efficient search/return of specified cards
 * 
 * @author Marielle Cheyne
 * @author Jordan Ching
 *
 */

public class Hand {
	private Set<Card> cards; 
	
	/**
	 * Creates a new Hand from a given set of cards
	 * @param cards
	 */
	public Hand(Set<Card> cards){
		this.cards = cards;
	}
}
