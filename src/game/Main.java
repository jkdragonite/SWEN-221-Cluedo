package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.BeepAction;

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
		// loop continues if game is in progress, and not won
		// cycles through players and presents each one with game options
		while (gameInProgress && !game.gameWon){
			System.out.println("Game in progress");
			if(game.checkActivePlayers() == 1){
				textClient.println("Game Won!");
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
					// loop continues until current player ends their turn
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
						textClient.println("\n5) Print Legend");
						int userChoice = textClient.getInt();
						if (userChoice == 1){
							if (hasMoved == true){
								throw new GameError("Sorry, you can only roll the dice and move your token once per turn");
							}
							int playerMoves = diceRoll;
							hasMoved = true;
							// if the player chooses to move, this loop will keep prompting them to select a direction to move in
							// until they choose to end their move, or their moves are depleted
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
								textClient.println(playerMovesString);
								int userMoveChoice = textClient.getInt();
								// broken
								if (userMoveChoice == temp.size()){
									playerMoves = 0;
								}
								else {
									String chosenActionString = temp.get(userMoveChoice);
									Location newLocation = moves.get(chosenActionString);
									board.movePlayer(player, newLocation.getXLoc(), newLocation.getYLoc());
									playerMoves = playerMoves -1;
									textClient.println(board.toString(game.getPlayers()));
								}
								
							}
						}
						// allows the player to make an accusation if they thing they can win the game
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
								break;
							}
							else{
								// player is removed from game for incorrect accusation
								player.setInactive();
								playerTurnBoolean = false;
							}
						}
						// allows the player to make a suggestion if they are in the correct room
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
								break;
							}
						}
						// allows the player to end their turn
						else if (textClient.getInt() == 4){
							playerTurnBoolean = false;
							break;	
						}
						// prints key for symbols and room locations
						else if (textClient.getInt() == 5){
							textClient.println("\n"+game.getCharacterString());
							textClient.println("\n"+game.getWeaponString());
							textClient.println("\nd = Door, s = Stairs, r = Room, x = non playable square, . = empty square");
							textClient.println("\nKitchen at D:3, Ball Room at M:3. Conservatory at W:3, Dining Room at D:12, Billiard Room at W:10, Library at W:16, Lounge at D:21, Hall at M:21, Study at W:22");
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
		}
	}
}	
 