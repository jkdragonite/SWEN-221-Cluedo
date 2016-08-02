package game;

import java.util.HashSet;
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
	
	public void addCard(Card card){
		cards.add(card);
	}

	public Set<Card> findMatches(String character, String weapon, String room) {
		Set<Card> matches = new HashSet<Card>(); 
		for(Card c : cards){
			if(c instanceof CharacterCard){
				if(c.getInfo().equals(character)){
					matches.add(c);
				}
			}
			else if(c instanceof WeaponCard){
				if(c.getInfo().equals(weapon)){
					matches.add(c);
				}
			}
			else if(c instanceof RoomCard){
				if(c.getInfo().equals(room)){
					matches.add(c);
				}
			}
		}
		return matches;
	}
	
	public int handSize(){
		return cards.size();
	}
}
