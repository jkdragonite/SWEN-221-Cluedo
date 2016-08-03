package ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextClient {
	//wanted to make TextClient a UI of sorts which manages ONLY input and output, 
	//and validation of inputs when requested by the game class.
	Scanner in;
	PrintStream out;
	
	public TextClient(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}
	/**
	 * Prints the specified information to the user
	 * @param toPrint
	 */
	public void println(String toPrint){
		out.println(toPrint);
	}
	
	//patterns for input validation/recognition
	static Pattern  TOKENNAME = Pattern.compile("Miss Scarlett|Colonel Mustard|Mrs. White|Reverend Green|Mrs. Peacock|Professor Plum");
	static Pattern CHARACTERPAT = Pattern.compile("scarlett|mustard|white|green|peacock|plum");
	static Pattern ROOMPAT = Pattern.compile("kitchen|ballroom|conservatory|billiard room|dining room|library|study|hall|lounge");
	static Pattern WEAPONPAT = Pattern.compile("candlestick|dagger|lead pipe|revolver|rope|spanner");
	
	public String getCharacter(){
		if(in.hasNext(CHARACTERPAT)){
			return in.next(CHARACTERPAT);
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
	
	

	/*public static void main(String args[]){
		Board board = new Board();
		boolean start = true;
		boolean gameInProgress = true;
		
		while (gameInProgress == true){

			Scanner in = new Scanner(System.in);			
						
			if (start){
				System.out.println("Welcome to Cluedo");
				System.out.println("Please select and action");
				System.out.println("1) Show Board");
				System.out.println("2) Move Player");
				System.out.println("3) Close Game");
				start = false;
			}
			
			int num = in.nextInt();
			
			if (num == 1){
				System.out.println(board.toString());
			}
			
			if (num == 3){
				gameInProgress = false;
				in.close();
			}
			
		}
	}*/
}
