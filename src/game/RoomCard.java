package game;

/**
 * A subclass of Card which is used to represent cards with room information
 * in a standard game of Cluedo. Most functionality is implemented in the Card 
 * superclass.
 * 
 * @author Marielle Cheyne
 * @author Jordan Ching
 *
 */

public class RoomCard extends Card{

	/**
	 * Creates a new instance of a RoomCard with the given information
	 * @param info
	 */
	public RoomCard(String info) {
		super(info);
	}

	/**
	 * Determines whether the given Card is a RoomCard, and if the information
	 * stored in the card is identical
	 * @return true if above conditions met, false otherwise
	 */
	@Override
	public boolean equals(Card card) {
		if(card instanceof RoomCard){
			if(this.getInfo().equals(card.getInfo())){
				return true;
			}
		}
		return false;
	}
}
