package testing;

import org.junit.*;

import game.*;
import game.GameOfCluedo.GameError;

import static org.junit.Assert.*;
import java.util.*;

public class CluedoGameTests {
	
	@Test
	public void testSolutionDeal_1(){
	//tests that a solution is created when asked, and that it contains the correct cards
	//1 WeaponCard, 1 Character Card, 1 RoomCard
		GameOfCluedo game = new GameOfCluedo();
		game.createDeck();
		ArrayList<Card> solution = game.getSolution();
		
		assertEquals(solution.size(), 3);
		assertTrue(solution.get(0) instanceof CharacterCard);
		assertTrue(solution.get(1) instanceof RoomCard);
		assertTrue(solution.get(2) instanceof WeaponCard);
	}
	
	@Test
	public void testSolutionShuffle_1(){
		//ensure that the cards are actually being shuffled when the solution is being created
		//i.e. that the same cards aren't getting picked every time, as the index of the card chosen 
		//doesn't change. If the decks are not shuffled we will get Reverend Green as the villain,
		//Hall as the room and Spanner as the weapon 10 times out of 10. 
		ArrayList<Card> characters = new ArrayList<Card>();
		ArrayList<Card> rooms = new ArrayList<Card>();
		ArrayList<Card> weapons = new ArrayList<Card>();
		
		for(int i = 0; i < 10; i++){
			GameOfCluedo game = new GameOfCluedo();
			game.createDeck();
			ArrayList<Card> solution = game.getSolution();
			characters.add(solution.get(0));
			rooms.add(solution.get(1));
			weapons.add(solution.get(2));
		}
		int greenCount = 0;		//is incremented each time we have Reverend Green as the villain
		for(Card c : characters){
			assertTrue(c instanceof CharacterCard);		//just to ensure the card types haven't been mixed up
			if(c.getInfo().equals("Reverend Green")){greenCount++;}
		}
		int hallCount = 0;		//is incremented each time we have Hall as the room
		for(Card c : rooms){
			assertTrue(c instanceof RoomCard);		//just to ensure the card types haven't been mixed up
			if(c.getInfo().equals("Hall")){hallCount++;}
		}
		int spannerCount = 0;		//is incremented each time we have spanner as the weapon
		for(Card c : weapons){
			assertTrue(c instanceof WeaponCard);		//just to ensure the card types haven't been mixed up
			if(c.getInfo().equals("Spanner")){spannerCount++;}
		}
		
		assertTrue(greenCount != 10);
		assertTrue(hallCount != 10);
		assertTrue(spannerCount != 10);
	}
	
	@Test
	public void testDeckDeal_1(){
		//tests that the cards are actually shuffled and dealt properly in a game where the number of players 
		//goes into 18 with no remainders
		GameOfCluedo game = new GameOfCluedo();
		try{
			game.addPlayer(new Player(Player.Token.MissScarlett));
			game.addPlayer(new Player(Player.Token.ColonelMustard));
		}
		catch(GameError ge){
			fail("Should not throw error as there are only two players");
		}
		
		game.dealCards();
		try{
			Player one = game.getPlayer(1);
			Player two = game.getPlayer(2);
			
			assertEquals(one.getHand().handSize(), 9);
			assertEquals(two.getHand().handSize(), 9);
		}
		catch(GameError ge){
			fail("getPlayer method may be at fault");
		}
	}
	
	@Test
	public void testDeckDeal_2(){
		//tests that the cards are actually shuffled and dealt properly in a game where the number of players 
		//goes into 18 with no remainders
				GameOfCluedo game = new GameOfCluedo();
				try{
					game.addPlayer(new Player(Player.Token.MissScarlett));
					game.addPlayer(new Player(Player.Token.ColonelMustard));
					game.addPlayer(new Player(Player.Token.MrsPeacock));
					game.addPlayer(new Player(Player.Token.MrsWhite));
					game.addPlayer(new Player(Player.Token.ReverendGreen));
				}
				catch(GameError ge){
					fail("Should not throw error as there are only five players");
				}
				
				game.dealCards();
				try{
					Player one = game.getPlayer(1);
					Player two = game.getPlayer(2);
					Player three = game.getPlayer(3);
					Player four = game.getPlayer(4);
					Player five = game.getPlayer(5);
					
					assertEquals(one.getHand().handSize(), 4);
					assertEquals(two.getHand().handSize(), 4);
					assertEquals(three.getHand().handSize(), 4);
					assertEquals(four.getHand().handSize(), 3);
					assertEquals(five.getHand().handSize(), 3);
				}
				catch(GameError ge){
					fail("getPlayer method may be at fault");
				}
	}
	
	@Test
	public void makeValidSuggestion_1(){
		//tests that the correct protocols are observed when the player makes a refutable suggestion,
		//i.e. player is in room, suggestion is refuted by correct player, turn ends as it should
		GameOfCluedo game = initRiggedGame();
		
		//find out which player has 
	}
	
	@Test
	public void makeValidSuggestion_2(){
		//tests that the correct protocols are observed when the player makes an irrefutable suggestion,
		//i.e. player is in room, all players checked that it's non-refutable, player does not have any
		//of the suggestion cards, win condition observed
	}
	
	@Test
	public void makeInvalidSuggestion_1(){
		//tests that errors are picked up when the player attempts to make a suggestion outside a room
		GameOfCluedo game = initBasicGame();
		List<Player> players = game.getPlayers();
		
		try{
			game.makeSuggestion(players.get(0), "plum", "hall", "dagger");
			fail("Should have thrown a game error as character is not in the room");
		}
		catch(GameError ge){
			Location playerLoc = players.get(0).getLocation();
			assertEquals(playerLoc.getXLoc(), 7);
			assertEquals(playerLoc.getYLoc(), 25);
		}
	}
	
	@Test
	public void makeInvalidSuggestion_2(){
		//tests that errors are picked up when the player attempts to make a suggestion with a room that
		//is not the one they are currently in
		GameOfCluedo game = initBasicGame();
		List<Player> players = game.getPlayers();
		
		//move player 1 into the lounge
		players.get(0).setLocation(new Location('a', 25));
		
		try{
			game.makeSuggestion(players.get(0), "plum", "hall", "dagger");
			fail("Should have thrown a game error as character is not in that particular room");
		}
		catch(GameError ge){
			Location playerLoc = players.get(0).getLocation();
			assertEquals(playerLoc.getXLoc(), 0);
			assertEquals(playerLoc.getYLoc(), 25);
		}
	}
	
	@Test
	public void makeInvalidSuggestion_3(){
		//tests that errors are picked up when the player attempts to make a suggestion when they have cards
		//in their hand which can refute it
	}
	
	@Test
	public void makeValidAccusation_1(){
		//tests that the win condition is set when the player makes the correct Accusation while IN a room
		GameOfCluedo game = initBasicGame();
		List<Player> players = game.getPlayers();
		
		//move player 1 into the lounge
		players.get(0).setLocation(new Location('a', 25));
		
		//get solution to test with
		List<Card> solution = game.getSolution();
		String murderer = solution.get(0).getInfo();
		String solRoom = solution.get(1).getInfo();
		String solWeapon = solution.get(2).getInfo();
		
		boolean success = game.makeAccusation(players.get(0), murderer, solRoom, solWeapon);
		if(!success){
			fail("Should have returned true because that's the solution dammit, location shouldn't matter");
		}
	}
	
	@Test
	public void makeInvalidAccusation_1(){
		//tests that the correct procedures are in place when the player makes an incorrect accusation
		//i.e they are removed from the game 
		GameOfCluedo game = initBasicGame();
		List<Player> players = game.getPlayers();
		
		//get solution to test with
		List<Card> solution = game.getSolution();
		String murderer = solution.get(0).getInfo();
		String solRoom = solution.get(1).getInfo();
		String solWeapon = solution.get(2).getInfo();
		
		boolean success = game.makeAccusation(players.get(0), murderer, solRoom, "dagger");
		assertTrue(!solWeapon.equals("dagger"));
		
		if(success){
			fail("Should not have okayed the accusation: incorrect weapon");
		}
		assertFalse(players.get(0).isActive());
	}
	
	@Test
	public void checkRefutationOrder_1(){
		//tests players are checked for refutations in the correct order
	}
	
	@Test
	public void checkWinCondition_1(){
		//check that the win condition is set when there is only one player left
		GameOfCluedo game = initBasicGame();
		List<Player> players = game.getPlayers();
		players.get(0).setInactive();
		players.get(1).setInactive();
		game.checkActivePlayers();
		assertTrue(game.gameWon);
	}
	
	@Test
	public void testKeyGeneration(){
		GameOfCluedo game = initBasicGame();
		String expected = "Miss Scarlett: 1 | Colonel Mustard: 2 | Mrs. White: W | Reverend Green: G | Mrs. Peacock: 3 | Professor Plum: P";
		assertEquals(expected, game.generateCharacterKey());
	}
	
	//test valid player move
		//test moving into/through/out of rooms
	//test invalid player move
	
	private GameOfCluedo initBasicGame(){
		GameOfCluedo game= new GameOfCluedo();
		
		//add three players to the game-it's a nice number to test with
		try{
			game.addPlayer(new Player(Player.Token.MissScarlett));
			game.addPlayer(new Player(Player.Token.ColonelMustard));
			game.addPlayer(new Player(Player.Token.MrsPeacock));
		}
		catch(GameError ge){}
		
		//initialise the deck/deal cards/create solution
		game.dealCards();

		return game;
	}

	private GameOfCluedo initRiggedGame(){
		GameOfCluedo game= new GameOfCluedo();
		//get all players 
				Player one = new Player(Player.Token.MissScarlett);
				Player two = new Player(Player.Token.ColonelMustard);
				Player three = new Player(Player.Token.MrsPeacock);
				
		//add three players to the game-it's a nice number to test with
		try{
			game.addPlayer(one);
			game.addPlayer(two);
			game.addPlayer(three);
		}
		catch(GameError ge){}
		
		//initialize the deck/deal cards/create solution
		ArrayList<Card> deck = new ArrayList<Card>();
		ArrayList<Card> solution = new ArrayList<Card>();
		
		solution.add(new CharacterCard("Reverend Green"));
		solution.add(new RoomCard("Conservatory"));
		solution.add(new WeaponCard("Rope"));
		
		one.getHand().addCard(new CharacterCard("Miss Scarlett"));
		two.getHand().addCard(new CharacterCard("Colonel Mustard"));
		three.getHand().addCard(new CharacterCard("Mrs. White"));
		one.getHand().addCard(new CharacterCard("Mrs. Peacock"));
		two.getHand().addCard(new CharacterCard("Professor Plum"));
		
		three.getHand().addCard(new RoomCard("Kitchen"));
		one.getHand().addCard(new RoomCard("Ballroom"));
		two.getHand().addCard(new RoomCard("Dining Room"));
		three.getHand().addCard(new RoomCard("Billiard Room"));
		one.getHand().addCard(new RoomCard("Library"));
		two.getHand().addCard(new RoomCard("Study"));
		three.getHand().addCard(new RoomCard("Hall"));
		one.getHand().addCard(new RoomCard("Lounge"));
		
		two.getHand().addCard(new WeaponCard("Candlestick"));
		three.getHand().addCard(new WeaponCard("Dagger"));
		one.getHand().addCard(new WeaponCard("Lead Pipe"));
		two.getHand().addCard(new WeaponCard("Revolver"));
		three.getHand().addCard(new WeaponCard("Spanner"));

		return game;
	}
}
