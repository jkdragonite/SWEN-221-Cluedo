package ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 
 * Helper class to handle input and output
 * 
 * @author Jordan
 * @author Marielle
 */
public class TextClient {

	public Scanner in;
	public PrintStream out;
	
	public TextClient(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}
	/**
	 * Prints the specified information to the user
	 * @param toPrint
	 */
	public void println(String toPrint){
		// add \n to print statement?  
		
		out.println(toPrint);
	}
	
	//patterns for input validation/recognition
	static Pattern TOKENNAME = Pattern.compile("Miss Scarlett|Colonel Mustard|Mrs. White|Reverend Green|Mrs. Peacock|Professor Plum");
	static Pattern CHARACTERPAT = Pattern.compile("scarlett|mustard|white|green|peacock|plum");
	static Pattern ROOMPAT = Pattern.compile("kitchen|ballroom|conservatory|billiard room|dining room|library|study|hall|lounge");
	static Pattern WEAPONPAT = Pattern.compile("candlestick|dagger|lead pipe|revolver|rope|spanner");
	static Pattern ROOMCARDPAT = Pattern.compile("Kitchen|Ballroom|Conservatory|Billiard Room|Dining Room|Library|Study|Hall|Lounge");
	static Pattern WEAPONCARDPAT = Pattern.compile("Candlestick|Dagger|Lead Pipe|Revolver|Rope|Spanner");
	static Pattern CONFIRMPAT = Pattern.compile("yes");
	static Pattern REFUSEPAT = Pattern.compile("no");
	
	public String getCharacter(){
		if(in.hasNext(CHARACTERPAT)){
			switch(in.next(CHARACTERPAT)){
			case("scarlett"):
				return "Miss Scarlett";
			case("mustard"):
				return "Colonel Mustard";
			case("white"):
				return "Mrs. White";
			case("green"):
				return "Reverend Green";
			case("peacock"):
				return "Mrs. Peacock";
			case("plum"):
				return "Professor Plum";
			default: 
				return new String();
			}
		}
		else{
			out.println("The string you entered for the character was invalid: please enter the character's last name below (in lowercase letters).");
			return getCharacter();
		}
	}
	
	public String getRoom(){
		if(in.hasNext(ROOMPAT)){
			return in.next(ROOMPAT);
		}
		else{
			out.println("The string you entered for the room was invalid: please enter the room's name below (in lowercase letters).");
			return getRoom();
		}
	}
	
	public String getWeapon(){
		if(in.hasNext(WEAPONPAT)){
			return in.next(WEAPONPAT);
		}
		else{
			out.println("The string you entered for the weapon was invalid: please enter the weapon's name below (in lowercase letters).");
			return getWeapon();
		}
	}
	
	public int getInt(){
		if(in.hasNextInt()){
			return in.nextInt();
		}
		else{
			out.println("The input entered was invalid: please enter an integer below.");
			return getInt();
		}
	}
	//confirmation from player method
	public String getYNResponse(){
		if(in.hasNext(CONFIRMPAT) || in.hasNext(REFUSEPAT)){
			return in.next();
		}
		else{
			out.println("You are required to type 'yes' or 'no'. Please do so.");
			return getYNResponse();
		}
	}
	
	public boolean getConfirm(){
		if(in.hasNext(CONFIRMPAT)){
			return true;
		}
		else{
			out.println("You are required to type 'yes' to confirm. Please do so.");
			return getConfirm();
		}
	}
	
	public String getCard(){
		if(in.hasNext(TOKENNAME) || in.hasNext(ROOMCARDPAT) || in.hasNext(WEAPONCARDPAT)){
			return in.next();
		}
		else{
			out.println("The input entered was invalid: please enter the card name you wish to refute with EXACTLY as printed above. EXACTLY.");
			return getCard();
		}
	}
	
	public void clearWindow(){
		for(int i = 0; i < 10; i++){
			out.println();
		}
	}
}
