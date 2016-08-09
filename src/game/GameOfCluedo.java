package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;

import ui.Board;
import ui.Room;
import ui.TextClient;

public class GameOfCluedo {
	private Board board;
	private List<Player> players;
	private int currentPlayer;
	private ArrayList<Card> solution;
	private TextClient ui;
	public boolean gameWon;
	
	private String characterKey = "Miss Scarlett: S | Colonel Mustard: C | Mrs. White: W | Reverend Green: G | Mrs. Peacock: M | Professor Plum: P";
	private final String weaponKey = "Weapon Symbols: 'Y' : spanner | '8' : rope | 'F' : revolver | '/' : lead pipe | '!' : dagger | 'I' : candlestick";
	
	public enum Weapon{
		Candlestick,
		Dagger,
		LeadPipe,
		Revolver,
		Rope,
		Spanner
	}
	/**
	 * Creates a new GameOfCluedo instance with a board, empty player array, and a ui
	 */
	public GameOfCluedo(){
		board = new Board();
		players = new ArrayList<Player>();
		currentPlayer = 1;
		solution = new ArrayList<Card>();
		ui = new TextClient();
		gameWon = false;
	}
	/**
	 * Adds a given player to the game. Should be called after the GameOfCluedo instance is created and
	 * before any other method calls are made.
	 * Must be called for each player wishing to join the game.
	 * @param player
	 * @throws GameError
	 */
	public void addPlayer(Player player) throws GameError{
		if(players.size() > 6){
			throw new GameError("Cannot have more than 6 players");
		}
		players.add(player);
	}
	
	/**
	 * Returns the player associated with the number, e.g Player 1 returns players index 0.
	 * @param playerNum
	 * @return
	 * @throws GameError
	 */
	public Player getPlayer(int playerNum) throws GameError{
		if(playerNum > players.size()){
			throw new GameError("Game only has " + players.size() + ". Invalid player number entered");
		}
		return players.get(playerNum -1);
	}
	
	/**
	 * Returns the complete list of all players in the current game instance
	 * @return
	 */
	public List<Player> getPlayers(){
		return this.players;
	}
	/**
	 * Shuffles and deals a deck of cards after they are created and the solution has been initialised.
	 * When the amount of cards left is less than the amount of players the method deals to the 
	 * final player first, and works its way backwards until it runs out of cards.
	 */
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
	/**
	 * Instantiates the complete deck of cards and creates the solution from them.
	 * 
	 * @returns the remaining cards after the solution has taken on of each type.
	 */
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
	
	/**
	 * Creates the solution for the game 
	 * i.e selects the character, room and weapon which represent the murderer, murder weapon and location from
	 * the complete deck of cards.
	 * 
	 * @param characters: a list of CharacterCards
	 * @param rooms: a list of RoomCards
	 * @param weapons: a list of WeaponCards
	 * @returns the remaining cards to be dealt to players
	 */
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
	
	/**
	 * Contains the execution pattern and logic required to allow a player to make a suggestion.
	 * Ensures that the player is in the room they want to use in the suggestion, throws an error if not.
	 * Iterates through the rest of the players to refute the suggestion, and if this fails it calls 
	 * makeAccusation, which may end the game if the player is correct.
	 * 
	 * @param player: current player making the suggestion
	 * @param character name
	 * @param room name
	 * @param weapon type
	 * @throws GameError
	 */
	public void makeSuggestion(Player player, String character, String room, String weapon) throws GameError{
		if(!board.isInRoom(player.getLocation(), player)){
			throw new GameError("Player is not in the correct location (by location): please move to the " + room + " to make this suggestion");
		}
		if(!player.getRoom().getName().equalsIgnoreCase(room)){
		throw new GameError("Player is not in the correct location (by room name): please move to the " + room + " to make this suggestion");
	}
		player.getRoom().setWeapon(weapon);
		//move relevant objects to the room
		//board.move(String weapon, String room)
		//board move searches the room 
		
		//check if players can refute the suggestion one at a time
		int nextPlayerNum = getNextPlayer(currentPlayer-1);
		Player nextPlayer = players.get(nextPlayerNum);
		
		boolean refuted = false;
		Set<Card> refuteCards;
		for(Player p = nextPlayer; !refuted || !p.equals(players.get(currentPlayer-1)); p = players.get(getNextPlayer(nextPlayerNum-1))){
			System.out.println("Player: " + p.getToken() + "'s turn");
			nextPlayerNum = getNextPlayer(nextPlayerNum);
			System.out.println(nextPlayerNum);
			refuteCards = p.getHand().findMatches(character, weapon, room);
			
			if(!refuteCards.isEmpty()){
				refuted = true;
				ui.println("Player " + nextPlayerNum + " can refute Player " + currentPlayer + "'s suggestion.");
				ui.println("Give the screen/keyboard to Player " + nextPlayerNum + "please. When Player" + nextPlayerNum + " is ready, type yes");
				if(ui.getConfirm()){
					String refuteCard = getRefutation(refuteCards, true);
					ui.println("Thank you for choosing your card to refute with.");
					ui.println("Please give the screen/keyboard back to Player " + currentPlayer + ". When Player" + currentPlayer + " is ready, type yes");
					if(ui.getConfirm()){
						repaintUI(false);
						ui.println("Player " + nextPlayerNum + " has chosen to refute your suggestion and shows you this card:  " + refuteCard);
					}
					else{throw new GameError("Getting to this error should be technically impossible. Congratulations! Everything is terrible now.");}
				}
				else{throw new GameError("Getting to this error should be technically impossible. Congratulations! Everything is terrible now.");}
			}
		}
		//if the loop exits and no-one has refuted, we call makeAccusation, as it follows the same steps we need to take now. 
		if(!refuted){
			gameWon = makeAccusation(players.get(currentPlayer), character, room, weapon);
		}
	}
	/**
	 * Contains all the game logic for allowing a different player to refute the current player's suggestion.
	 * It ensures that the refuting player cannot see the current player's hand, and that the card chosen is
	 * actually contained in their hand. 
	 * 
	 * @param refuteCards
	 * @param firstRun
	 * @returns the name of the card chosen
	 */
	public String getRefutation(Set<Card> refuteCards, boolean firstRun){
		repaintUI(true);
		if(!firstRun){
			ui.println("You entered a card that wasn't in your hand. Please note cheaters never prosper.");
			ui.println("Now, please follow the instructions properly this time.");
		}
		ui.println("Enter the name of the card from the following list you wish to refute with exactly as printed below:");
		for(Card c : refuteCards){
			ui.println(c.getInfo());
		}
		String refuteChoice = ui.getCard();
		//ensure that the response is actually one from the player's hand, else run the method again
		for(Card c : refuteCards){
			if(c.getInfo().equals(refuteChoice)){
				return refuteChoice;
			}
		}
		return getRefutation(refuteCards, false);
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
		if(prevPlayer >= players.size()){
			return 1;
		}
		else{
			return prevPlayer+1;
		}
	}
	
	/**
	 * Clears and then prints all base information to the output. 
	 * Takes a boolean which is true when this method is called from the makeSuggestion
	 * method which allows it to not print the current player's hand when another player is 
	 * choosing a card from their hand 
	 * @param isSuggestion
	 */
	public void repaintUI(boolean isSuggestion){
		ui.clearWindow();
		ui.println("CLUEDO GAME");
		ui.println(characterKey);
		ui.println(weaponKey);
		ui.println(board.toString());
	}
	
	/**
	 * Generates the key which is printed with the board to the user, to make it easier for the player 
	 * to visually identify where their and others' tokens are. 
	 * Should only be called after all players have been added.
	 * @returns the modified key string
	 */
	public String generateCharacterKey(){
		char[] currentKey = characterKey.toCharArray();
		
		for(int i = 0; i < players.size(); i++){
			switch(players.get(i).getToken()){
			case MissScarlett:
				currentKey[15] = (char) (i+49);
				break;
			case ColonelMustard:
				currentKey[36] = (char) (i+49);
				break;
			case ProfessorPlum:
				currentKey[109] = (char) (i+49);
				break;
			case MrsWhite:
				currentKey[51] = (char) (i+49);
				break;
			case ReverendGreen:
				currentKey[71] = (char) (i+49);
				break;
			case MrsPeacock:
				currentKey[90] = (char) (i+49);
				break;
			}
		}
		return String.valueOf(currentKey);
	}
	
	/**
	 * Returns the set of cards that make up the solution. Used mainly in test cases
	 * @return
	 */
	public ArrayList<Card> getSolution(){
		return solution;
	}
	
	/**
	 * Checks for the number of players who are still flagged as active and returns it.
	 * If there is only one player the gameWon boolean is set to true and the game should end.
	 * 
	 * @return num of active players remaining
	 */
	public int checkActivePlayers(){
		int count = 0; 
		for(Player p : players){
			if(p.isActive()){
				count++;
			}
		}
		
		if(count < 2){
			gameWon = true;
		}
		return count;
	}
	
	/**
	 * Adds a given solution to the game. Used only for testing purposes
	 * @param solution
	 */
	public void addSolution(ArrayList<Card> solution){
		this.solution = solution;
	}

	/**
	 * Returns the set of Room instances used in the game, for testing purposes only.
	 * @return
	 */
	public Room[] getRooms(){
		return board.getRooms();
	}
	
	public String getCharacterString(){
		return this.characterKey;
	}
	
	public String getWeaponString(){
		return this.weaponKey;
	}
	
	/**
	 * Indicates an attempted action is in error of game logic.
	 */
	public static class GameError extends Exception {
		public GameError(String msg) {
			super(msg);
		}
	}
}
