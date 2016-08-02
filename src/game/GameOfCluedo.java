package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ui.Board;

public class GameOfCluedo {
	//private Board board;
	private List<Player> players;
	private ArrayList<Card> solution;
	
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
		solution = new ArrayList<Card>();
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
	
	public List<Player> getPlayers(){
		return this.players;
	}
	
	public ArrayList<Card> getSolution(){
		return solution;
	}
	
	public void dealCards(){
		List<Card> deck = createDeck();
		Collections.shuffle(deck);
		
		while(!deck.isEmpty()){
			System.out.println("deck size:" + deck.size());
			System.out.println("players:" + players.size());
			if(deck.size() < players.size()){
				System.out.println("less cards than players reached");
				for(int i = deck.size()-1; i >= 0; i--){
					players.get(i).addToHand(deck.remove(i));
					System.out.println("added card to player" + i);
				}					
			}
			else{
				for(int i = players.size()-1; i >= 0; i--){
					players.get(i).addToHand(deck.remove(i));
					System.out.println("added card to player" + i);
				}	
			}
		}
	}
	
	public ArrayList<Card> createDeck(){
		ArrayList<Card> characters = new ArrayList<Card>();
		ArrayList<Card> rooms = new ArrayList<Card>();
		ArrayList<Card> weapons = new ArrayList<Card>();
		
		characters.add(new CharacterCard("Miss Scarlet"));
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
