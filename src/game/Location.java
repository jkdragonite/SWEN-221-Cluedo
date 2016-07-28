package game;

import java.awt.Point;

/**
 * This class represents the alphanumerical location on a 
 * Cluedo Board, which is used primarily for finding and 
 * moving players and weapons around the board.
 * 
 * @author Marielle Cheyne
 * @author Jordan Ching
 *
 */

public class Location {
	private char xLoc;
	private int yLoc;
	
	public Location(char x, int y){
		xLoc = x;
		yLoc = y;
	}
	
	/**
	 * This translates the alphanumerical location to a point usable by
	 * the Board, using char to int ASCII conversion for the x co-ordinate
	 * Calculates the appropriate x,y values for use with an array directly
	 * (i.e. 1 becomes 0 so the correct array reference is found)
	 * 
	 * @return a Point usable directly with a 2D array
	 */
	public Point getBoardCoOrd(){
		//ASCII values 97(a)-122(z)
		//convert x to ASCII value
		int x = ((int) xLoc) - 97;
		return new Point(x, yLoc-1);
	}
}
