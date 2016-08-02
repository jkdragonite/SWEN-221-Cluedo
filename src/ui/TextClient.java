package ui;

import game.GameOfCluedo;
import game.GameOfCluedo.GameError;
import game.Player;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.type.NullType;

public class TextClient {

	public static void main(String args[]) throws GameError{
		GameOfCluedo game = new GameOfCluedo();
//		Board board = new Board();
		boolean start = true;
		boolean gameInProgress = true;
		boolean showMenu = false;
		while (gameInProgress == true){

			Scanner in = new Scanner(System.in);			
						
			if (start){
				System.out.println("Welcome to Cluedo");
				System.out.println("1) Add Player");
//				System.out.println("Please select and= action");
				System.out.println("2) Show Board");
//				System.out.println("2) Move Player");
				System.out.println("3) Close Game");
				start = false;
			}
			
			if (showMenu){
				System.out.println("Please select an action:");
				System.out.println("1) Add Player");
				System.out.println("2) Begin Game");
				System.out.println("3) Show Board");
				System.out.println("4) Close Game");
			}
			
			int num = in.nextInt();
			
			if (num == 1){
//				in.close();
				// check for token already present
				System.out.println("Please select a Token:");
				System.out.println("1) MissScarlet");
				System.out.println("2) ColonelMustard");
				System.out.println("3) ProfessorPlum");
				System.out.println("4) MrsWhite");
				System.out.println("5) ReverendGreen");
				System.out.println("6) MrsPeacock");
				Scanner selectScanner = new Scanner(System.in);
				int charNum = selectScanner.nextInt();
				Player.Token token = null;
				if (charNum == 1){
					token = Player.Token.MissScarlet;
					System.out.println("Miss Scarlet added to the game");
				}
				else if (charNum == 2){
					token = Player.Token.ColonelMustard;
					System.out.println("ColonelMustard added to the game");
				}
				else if (charNum == 3){
					token = Player.Token.ProfessorPlum;
					System.out.println("ProfessorPlum added to the game");
				}
				else if (charNum == 4){
					token = Player.Token.MrsWhite;
					System.out.println("MrsWhite added to the game");
				}
				else if (charNum == 5){
					token = Player.Token.ReverendGreen;
					System.out.println("ReverendGreen added to the game");
				}
				else if (charNum == 6){
					token = Player.Token.MrsPeacock;
					System.out.println("MrsPeacock added to the game");
				}
				
				if (token != null){
					Player player = new Player(token);
					game.addPlayer(player);
				}

				System.out.println("Current number of players: " + game.getPlayers().size());
				
				showMenu = true;
				
			}
			
			
			if (num == 2){
//				System.out.println(board.toString());
			}
			
			if (num == 3){
				gameInProgress = false;
			}
			
		}
	}
	
	
	
	

}
