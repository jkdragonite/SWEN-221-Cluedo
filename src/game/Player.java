package game;

/**
 * Represents a player in a standard Cluedo game
 * @author Marielle
 *
 */

public class Player {
	// added location
	private Location playerLocation;

	public Location getLocation(){
		return this.playerLocation;
	}
	
	public void setLocation(Location location){
		this.playerLocation = location;
	}
		
	
	
}
