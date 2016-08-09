package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import game.GameOfCluedo.GameError;
import game.Player.Token;
import ui.Board;
import ui.TextClient;

public class Main {
	/**
	 * 
	 * The main loop for the game.
	 * Initializes all game classes, maintains an outer loop driven by a win condition in GameOfCluedo, with
	 * an inner loop for each player's turn.
	 * Iterates through a list of players, rolls the dice for them, and allows them to move until the dice roll is
	 * depleted.
	 * 
	 * @param args
	 * @throws GameError
	 */
	public static void main(String args[]) throws GameError{
		GameOfCluedo game = new GameOfCluedo();
		Board board = new Board();
		System.out.println(board.toString(game.getPlayers()));
		TextClient textClient = new TextClient();
		Boolean setup = true;
		Boolean gameInProgress = false;
		while (setup){
			textClient.println(""
					+ "\n Welcome to Cluedo"
					+ "\n Game setup in progress; please select an action"
					+ "\n 1) Add Player" 
					+ "\n 2) Start Game");
			int setupChoice = textClient.getInt();
			if (setupChoice == 1){
				// player select string

//				if (game.getPlayers().isEmpty()){
//					textClient.println("There are currently no players in the game");
//				}
//				else{
					String players = "";
					for (Player player : game.getPlayers()){
						players = players + player.getToken() + " ";
					}
					textClient.println("Current players:" + players);
					
					List<Token> usedTokens = new ArrayList<Token>();
					List<Token> availableTokens = new ArrayList<Token>();
					for (Player player : game.getPlayers()){
						usedTokens.add(player.getToken());
					}	
					for (Token token : Player.Token.values()){
//						System.out.println(token);
						if (usedTokens.contains(token) == false){
//							System.out.println(token);
							availableTokens.add(token);
//							System.out.println(availableTokens);
						}
					}
					// loop through tokens taken vs tokens available, present these at options to user
					textClient.println("Please choose a player to add:");
					String playerString = "";
					for (int i = 0; i < availableTokens.size(); i++){
						playerString = playerString + "\n"+ i + ")" + availableTokens.get(i);
					}
					System.out.println(playerString);
					int userChoice = textClient.getInt();
					Player newPlayer = new Player(availableTokens.get(userChoice));
					// add user's choice
					game.addPlayer(newPlayer);					
					board.setPlayer(newPlayer, newPlayer.getLocation().getXLoc(), newPlayer.getLocation().getYLoc());
//				}				
			}
			else if (setupChoice == 2){
//				System.out.println("deal");
				game.dealCards();
				game.generateCharacterKey();
				setup = false;
				gameInProgress = true;
			}
		}
		while (gameInProgress && !game.gameWon){
			System.out.println("Game in progress");
			if(game.checkActivePlayers() == 1){
				game.gameWon = true;
				gameInProgress = false;
			}
			for (Player player : game.getPlayers()){
				if (game.gameWon == true){
					gameInProgress = false;
					break;
				}
				textClient.println(board.toString(game.getPlayers()));
				if (player.isActive() == true){
					Boolean playerTurnBoolean = true;
					textClient.println("\nIt is now " + player.getToken() + "'s turn");
					while (playerTurnBoolean){
						Boolean hasMoved = false;
						if (game.gameWon == true){
							playerTurnBoolean = false;
							gameInProgress = false;
							break;
						}
						textClient.println("\nRolling the dice...");
						int diceRoll = (int)(Math.random()*6) + 1; // this is wrong
						textClient.println("\nYou have rolled: " + diceRoll);
						textClient.println("\nPlease select an action to take: ");
						textClient.println("\n1) Move Player"); 
						textClient.println("\n2) Make Accusation");
						textClient.println("\n3) Make Suggestion");
						textClient.println("\n4) End Turn");
						int userChoice = textClient.getInt();
						if (userChoice == 1){
							if (hasMoved == true){
								throw new GameError("Sorry, you can only roll the dice and move your token once per turn");
							}
							int playerMoves = diceRoll;
							hasMoved = true;
							while (playerMoves > 0){
								textClient.println("\nYou have " + playerMoves +" moves left");
								Map<String, Location> moves = board.getMoves(player);
								
								String playerMovesString = "";
								ArrayList<String> temp = new ArrayList<>();
								for (String string : moves.keySet()){
									temp.add(string);
								}
								
								
								
								for (int i = 0; i < temp.size(); i++){
									playerMovesString = playerMovesString + "\n"+ i + ")" + temp.get(i);
								}
								playerMovesString = playerMovesString + "\n"+ temp.size() + ")" + "End Movement";
								System.out.println(playerMovesString);
								int userMoveChoice = textClient.getInt();
								// broken
								if (userMoveChoice == temp.size()){
									playerMoves = 0;
								}
								else {
									String chosenActionString = temp.get(userMoveChoice);
									Location newLocation = moves.get(chosenActionString);
									// will be wrong because of loc retrieval
									board.movePlayer(player, newLocation.getXLoc(), newLocation.getYLoc());
									playerMoves = playerMoves -1;
									textClient.println(board.toString(game.getPlayers()));
	//								textClient.println(board.cleanString());
								}
								// check rooms to see if player location new is in rroom, if so, add to room
								// pair each move with a location, build player moves as an hashmap, string equivalent then location or room
								// print movement options
								// move player based on iput
								// subtract from player moves
								
							}
						}
						else if (userChoice == 2){
							textClient.println("\nYou have chosen to make an accusation");
							textClient.println("\nPlease type a character");
							String character = textClient.getCharacter();
							textClient.println("\nPlease type a room");
							String room = textClient.getRoom();
							textClient.println("\nPlease type a weapon");
							String weapon = textClient.getWeapon();
							Boolean result = game.makeAccusation(player, character, room, weapon);
							if (result == true){
								// player has won game if accusation true
								game.gameWon = true;
								playerTurnBoolean = false;
							}
							else{
								// player is removed from game for incorrect accusation
								player.setInactive();
								playerTurnBoolean = false;
							}
						}
						
						else if (userChoice == 3){
							textClient.println("\nYou have chosen to make a suggestion");
							textClient.println("\nPlease type a character");
							String character = textClient.getCharacter();
							textClient.println("\nPlease type a room");
							String room = textClient.getRoom();
							textClient.println("\nPlease type a weapon");
							String weapon = textClient.getWeapon();
							try{
								game.makeSuggestion(player, character, room, weapon);
							}
							catch(GameError ge){
								textClient.println("Player turn over");
								playerTurnBoolean = false;
							}
						}
						else if (textClient.getInt() == 4){
							playerTurnBoolean = false;
							break;
						
						}
						else{
							throw new GameError("Invalid selection, please a number corresponding to a game move");
						}
				}
					if (textClient.getInt() == 4){
						playerTurnBoolean = false;
						break;
					}
				}
			}
			
			
			// loop through players in order, get first player
			
			// logic to decide each player's available moves, start with dice roll
			
			// track number, loop for movement, present move in four cardinal directions if possible so long as player has moves left
			
			// test for special squares, present these options too			
			
			// player stuff
		}
	}
}	
 