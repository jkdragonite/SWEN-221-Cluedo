package game;

/**
 * A subclass of Card which is used to represent cards with character information
 * in a standard game of Cluedo. Most functionality is implemented in the Card 
 * superclass.
 * 
 * @author Marielle Cheyne
 * @author Jordan Ching
 *
 */

public class CharacterCard extends Card{

	/**
	 * Creates a new instance of a CharacterCard with the given information
	 * @param info
	 */
	public CharacterCard(String info) {
		super(info);
	}

	/**
	 * Determines whether the given Card is a CharacterCard, and if the 
	 * information stored in the card is identical
	 * @return true if above conditions met, false otherwise
	 */
	@Override
	public boolean equals(Card card) {
		if(card instanceof CharacterCard){
			if(this.getInfo().equals(card.getInfo())){
				return true;
			}
		}
		return false;
	}
}
