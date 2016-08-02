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
			game.addPlayer(new Player(Player.Token.MissScarlet));
			game.addPlayer(new Player(Player.Token.ColonelMustard));
			System.out.println("Players created");
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
					game.addPlayer(new Player(Player.Token.MissScarlet));
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
	
	
	
	

}
