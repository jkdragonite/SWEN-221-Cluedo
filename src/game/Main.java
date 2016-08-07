package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import game.GameOfCluedo.GameError;
import game.Player.Token;

import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;

import ui.Board;
import ui.TextClient;

public class Main {
	public static void main(String args[]) throws GameError{
		GameOfCluedo game = new GameOfCluedo();
		Board board = new Board();
		TextClient textClient = new TextClient();
		Boolean setup = true;
		Boolean gameInProgress = false;
		while (setup){
//			Boolean addingPlayer = false;
			textClient.println(""
					+ "\n Welcome to Cluedo"
					+ "\n Game setup in progress; please select an action"
					+ "\n 1) Add Player" 
					+ "\n 2) Start Game");
			if (textClient.getInt() == 1){
				// player select string

//				if (game.getPlayers().isEmpty()){
//					textClient.println("There are currently no players in the game");
//				}
//				else{
					String players = game.getPlayers().toString();
					textClient.println("Current players:" + players);
					
					List<Token> usedTokens = new ArrayList<Token>();
					List<Token> availableTokens = new ArrayList<Token>();
					for (Player player : game.getPlayers()){
						usedTokens.add(player.getToken());
					}	
					for (Token token : Player.Token.values()){
						if (usedTokens.contains(token) == false){
							availableTokens.add(token);
						}
					}
					
					textClient.println("Please choose a player to add:");
					String playerString = "";
					for (int i = 0; i < availableTokens.size(); i++){
						playerString = playerString + "\n"+ i + ")" + availableTokens.get(i);
					}
					int userChoice = textClient.getInt();
					Player newPlayer = new Player(availableTokens.get(userChoice));
					game.addPlayer(newPlayer);					
//				}				
			}
			else if (textClient.getInt() == 2){
				game.dealCards();
				setup = false;
				gameInProgress = true;
			}
		}
		while (gameInProgress){
			
			for (Player player : game.getPlayers()){
				Boolean playerTurnBoolean = true;
				while (playerTurnBoolean){
					textClient.println("\nRolling the dice...");
					int diceRoll = (int)(Math.random()*6) + 1;
					textClient.println("\nYou have rolled: " + diceRoll);
					textClient.println("\nPlease select an action to take: ");
					textClient.println("\n1) Move Player"); 
					textClient.println("\n2) Make Accusation");
					textClient.println("\n3) Make Suggestion");
					if (textClient.getInt() == 1){
						int playerMoves = diceRoll;
						while (playerMoves > 0){
							textClient.println("\nYou have" + playerMoves +" left");
							Map<String, Location> moves = board.getMoves(player);
							
							String playerMovesString = "";
							ArrayList<String> temp = new ArrayList<>();
							for (String string : moves.keySet()){
								temp.add(string);
							}
							
							
							
							for (int i = 0; i < temp.size(); i++){
								playerMovesString = playerMovesString + "\n"+ i + ")" + temp.get(i);
							}
							int userChoice = textClient.getInt();
							
							String chosenActionString = temp.get(userChoice);
							Location newLocation = moves.get(chosenActionString);
							// will be wrong because of loc retrieval
							board.movePlayer(player, newLocation.getXLoc(), newLocation.getYLoc());
							playerMoves = playerMoves -1;
							// check rooms to see if player location new is in rroom, if so, add to room
							// pair each move with a location, build player moves as an hashmap, string equivalent then location or room
							// print movement options
							// move player based on iput
							// subtract from player moves
							
						}
					}
					if (textClient.getInt() == 2){
						textClient.println("\nYou have chosen to make an accusation");
						textClient.println("\nPlease type a character");
						String character = textClient.getCharacter();
						textClient.println("\nPlease type a room");
						String room = textClient.getRoom();
						textClient.println("\nPlease type a weapon");
						String weapon = textClient.getWeapon();
						game.makeAccusation(player, character, room, weapon);
					}
					
					if (textClient.getInt() == 3){
						textClient.println("\nYou have chosen to make an accusation");
						textClient.println("\nPlease type a character");
						String character = textClient.getCharacter();
						textClient.println("\nPlease type a room");
						String room = textClient.getRoom();
						textClient.println("\nPlease type a weapon");
						String weapon = textClient.getWeapon();
						game.makeSuggestion(player, character, room, weapon);
					}
				}
			}
			
			
			// loop through players in order, get first player
			
			// logic to decide each player's available moves, start with dice roll
			
			// track number, loop for movement, present move in four cardinal directions if possible so long as player has moves left
			
			// test for special squares, present these options too			
			
			// player stuff
		}
		// add check for terminating condition
	}
}	
 