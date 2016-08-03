package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ui.Board;
import ui.TextClient;

public class GameOfCluedo {
	//private Board board;
	private List<Player> players;
	private int currentPlayer;
	private ArrayList<Card> solution;
	private TextClient ui;
	
	public enum Weapon{
		Candlestick,
		Dagger,
		LeadPipe,
		Revolver,
		Rope,
		Spanner
	}
	
	public GameOfCluedo(){
		//board = new Board();
		players = new ArrayList<Player>();
		currentPlayer = 1;
		solution = new ArrayList<Card>();
		ui = new TextClient();
	}
	
	public void addPlayer(Player player) throws GameError{
		if(players.size() > 6){
			throw new GameError("Cannot have more than 6 players");
		}
		players.add(player);
	}
	
	public Player getPlayer(int playerNum) throws GameError{
		if(playerNum > players.size()){
			throw new GameError("Game only has " + players.size() + ". Invalid player number entered");
		}
		return players.get(playerNum -1);
	}
	
	
	public ArrayList<Card> getSolution(){
		return solution;
	}
	
	public void dealCards(){
		List<Card> deck = createDeck();
		Collections.shuffle(deck);
		
		while(!deck.isEmpty()){
			if(deck.size() < players.size()){
				for(int i = deck.size()-1; i >= 0; i--){
					players.get(i).addToHand(deck.remove(i));
				}					
			}
			else{
				for(int i = players.size()-1; i >= 0; i--){
					players.get(i).addToHand(deck.remove(i));
				}	
			}
		}
	}
	
	public ArrayList<Card> createDeck(){
		ArrayList<Card> characters = new ArrayList<Card>();
		ArrayList<Card> rooms = new ArrayList<Card>();
		ArrayList<Card> weapons = new ArrayList<Card>();
		
		characters.add(new CharacterCard("Miss Scarlett"));
		characters.add(new CharacterCard("Colonel Mustard"));
		characters.add(new CharacterCard("Mrs. White"));
		characters.add(new CharacterCard("Reverend Green"));
		characters.add(new CharacterCard("Mrs. Peacock"));
		characters.add(new CharacterCard("Professor Plum"));
		
		rooms.add(new RoomCard("Kitchen"));
		rooms.add(new RoomCard("Ballroom"));
		rooms.add(new RoomCard("Conservatory"));
		rooms.add(new RoomCard("Dining Room"));
		rooms.add(new RoomCard("Billiard Room"));
		rooms.add(new RoomCard("Library"));
		rooms.add(new RoomCard("Study"));
		rooms.add(new RoomCard("Hall"));
		rooms.add(new RoomCard("Lounge"));
		
		weapons.add(new WeaponCard("Candlestick"));
		weapons.add(new WeaponCard("Dagger"));
		weapons.add(new WeaponCard("Lead Pipe"));
		weapons.add(new WeaponCard("Revolver"));
		weapons.add(new WeaponCard("Rope"));
		weapons.add(new WeaponCard("Spanner"));
		
		return createSolution(characters, rooms, weapons);
	}
	
	private ArrayList<Card> createSolution(List<Card> characters, List<Card> rooms, List<Card> weapons){
		Collections.shuffle(characters);
		solution.add(characters.remove(3));

		Collections.shuffle(rooms);
		solution.add(rooms.remove(7));
		
		Collections.shuffle(weapons);
		solution.add(weapons.remove(5));	
		
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.addAll(characters);
		deck.addAll(rooms);
		deck.addAll(weapons);
		
		return deck;
	}
	
	public void makeSuggestion(Player player, String character, String room, String weapon) throws GameError{
		//if(!board.isInRoom(room, player.getLocation())){
		//	throw new GameError("Player is not in the correct location: please move to the " + room + "to make this suggestion");
		//}
		
		//move relevant objects to the room
		//weapon symbols as follows: Y(spanner) 8(rope) F(revolver) /(lead pipe) !(dagger) I(candlestick)
		
		//check if players can refute the suggestion one at a time
		int nextPlayerNum = getNextPlayer(currentPlayer);
		Player nextPlayer = players.get(nextPlayerNum);
		Set<Card> refuteCards = nextPlayer.getHand().findMatches(character, weapon, room);
		
		if(!refuteCards.isEmpty()){
			ui.println("Player " + nextPlayerNum + " can refute Player " + currentPlayer + "'s suggestion.");
			ui.println("Give the screen/keyboard to Player " + nextPlayerNum + "please. When Player" + nextPlayerNum + " is ready, type yes");
			
		}
		
	}
	
	
	/**
	 * Used by the give player when they believe they have determined the correct solution. There are no refutations 
	 * from other players, and the solution is then compared with the accusation: if they correspond, the given player
	 * is the winner. If not, the player is removed from the game.
	 *  
	 * @param player making the accusation
	 * @param character accused of the murder
	 * @param room the murder is said to have been committed in
	 * @param weapon used in the murder
	 * 
	 * @return true if the solution matches
	 */
	public boolean makeAccusation(Player player, String character, String room, String weapon){
		String murderer = solution.get(0).getInfo();
		String solRoom = solution.get(1).getInfo();
		String solWeapon = solution.get(2).getInfo();
		
		if(character.equalsIgnoreCase(murderer) && room.equalsIgnoreCase(solRoom) 
				&& weapon.equalsIgnoreCase(solWeapon)){
			return true;
		}
		else{
			player.setInactive();
			return false;
		}
	}
	
	private int getNextPlayer(int prevPlayer){
		if(prevPlayer == players.size()){
			return 1;
		}
		else{
			return prevPlayer+1;
		}
	}
	
	/**
	 * Indicates an attempted action is in error of game logic.
	 *
	 */
	public static class GameError extends Exception {
		public GameError(String msg) {
			super(msg);
		}
	}
}
