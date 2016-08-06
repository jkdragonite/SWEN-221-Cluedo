package ui;

import java.util.ArrayList;
import java.util.List;

import game.GameOfCluedo;
import game.Location;
import game.Player;


public class Room implements Square {
	// mucking about with square ideas
	
	private List<Player> playersInside = new ArrayList<Player>();
	private GameOfCluedo.Weapon weapon = null;
	private String roomName;
	private ArrayList<Location> roomSquares;
	
	/**
	 * Creates an new instance of a room with the specified name, and list of encompassing locations. 
	 * The room may contain a weapon (null if no weapon is in the room).
	 * 
	 * @param name of the room
	 * @param weapon contained in the room, if any
	 * @param roomSquares list of locations on the board that this room covers
	 */	
	public Room(String name, GameOfCluedo.Weapon weapon){
		roomName = name;
		this.weapon = weapon;
		setSquares();
//		this.roomSquares = roomSquares;
	}
	
	public ArrayList<Location> getRoomSquares(){
		return this.roomSquares;
	}
	
	public List<Player> getPlayers(){
		return this.playersInside;
	}
	
	public void addPlayer(Player player){
		this.playersInside.add(player);

	}
	
	public void removePlayer(Player player){
		this.playersInside.remove(player);
	}
	
	public boolean isInRoom(Location location){
		return roomSquares.contains(location);
	}
	
	public GameOfCluedo.Weapon containsWeapon(){
		return weapon;
	}
	
	public void setWeapon(GameOfCluedo.Weapon weapon){
		this.weapon = weapon;
	}
	
	public String getName(){
		return this.roomName;
	}
	
	public void setSquares(){
		if (this.roomName == "Kitchen"){
			for ( int i = 1; i < 6; i++){
				this.roomSquares.add(new Location('A', i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location('B', i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location('C', i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location('D', i));
			}
			for ( int i = 1; i < 7; i++){
				this.roomSquares.add(new Location('E', i));
			}
			for ( int i = 2; i < 7; i++){
				this.roomSquares.add(new Location('F', i));
			}
			
			if (this.roomName == "Dining Room"){
				for ( int i = 9; i < 16; i++){
					this.roomSquares.add(new Location('A', i));
				}
				for ( int i = 9; i < 16; i++){
					this.roomSquares.add(new Location('B', i));
				}
				for ( int i = 9; i < 16; i++){
					this.roomSquares.add(new Location('C', i));
				}
				for ( int i = 9; i < 16; i++){
					this.roomSquares.add(new Location('D', i));
				}
				for ( int i = 9; i < 16; i++){
					this.roomSquares.add(new Location('E', i));
				}
				for ( int i = 10; i < 16; i++){
					this.roomSquares.add(new Location('F', i));
				}
				for ( int i = 10; i < 16; i++){
					this.roomSquares.add(new Location('G', i));
				}
				for ( int i = 10; i < 16; i++){
					this.roomSquares.add(new Location('H', i));
				}
				if (this.roomName == "Lounge"){
					for ( int i = 21; i < 25; i++){
						this.roomSquares.add(new Location('A', i));
					}
					for ( int i = 20; i < 25; i++){
						this.roomSquares.add(new Location('B', i));
					}
					for ( int i = 20; i < 25; i++){
						this.roomSquares.add(new Location('C', i));
					}
					for ( int i = 20; i < 25; i++){
						this.roomSquares.add(new Location('D', i));
					}
					for ( int i = 20; i < 25; i++){
						this.roomSquares.add(new Location('E', i));
					}
					for ( int i = 20; i < 25; i++){
						this.roomSquares.add(new Location('F', i));
					}
					for ( int i = 20; i < 25; i++){
						this.roomSquares.add(new Location('G', i));
					}
					
					if (this.roomName == "Ball Room"){
						for ( int i = 2; i < 8; i++){
							this.roomSquares.add(new Location('I', i));
						}
						for ( int i = 2; i < 8; i++){
							this.roomSquares.add(new Location('J', i));
						}
						for ( int i = 1; i < 8; i++){
							this.roomSquares.add(new Location('K', i));
						}
						for ( int i = 1; i < 8; i++){
							this.roomSquares.add(new Location('L', i));
						}
						for ( int i = 1; i < 8; i++){
							this.roomSquares.add(new Location('M', i));
						}
						for ( int i = 1; i < 8; i++){
							this.roomSquares.add(new Location('N', i));
						}
						for ( int i = 1; i < 8; i++){
							this.roomSquares.add(new Location('O', i));
						}
						for ( int i = 2; i < 8; i++){
							this.roomSquares.add(new Location('P', i));
						}
						for ( int i = 2; i < 8; i++){
							this.roomSquares.add(new Location('Q', i));
						}
					}
					
					if (this.roomName == "Hall"){
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('J', i));
						}
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('K', i));
						}
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('L', i));
						}
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('M', i));
						}
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('N', i));
						}
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('O', i));
						}
						for ( int i = 18; i < 25; i++){
							this.roomSquares.add(new Location('P', i));
						}
					}
					
					if (this.roomName == "Conservatory"){
						for ( int i = 1; i < 5; i++){
							this.roomSquares.add(new Location('T', i));
						}
						for ( int i = 1; i < 6; i++){
							this.roomSquares.add(new Location('U', i));
						}
						for ( int i = 1; i < 6; i++){
							this.roomSquares.add(new Location('V', i));
						}
						for ( int i = 1; i < 6; i++){
							this.roomSquares.add(new Location('W', i));
						}
						for ( int i = 1; i < 6; i++){
							this.roomSquares.add(new Location('X', i));
						}
						for ( int i = 1; i < 6; i++){
							this.roomSquares.add(new Location('Y', i));
						}
					}
					if (this.roomName == "Billiard Room"){
						for ( int i = 8; i < 13; i++){
							this.roomSquares.add(new Location('T', i));
						}
						for ( int i = 8; i < 13; i++){
							this.roomSquares.add(new Location('U', i));
						}
						for ( int i = 8; i < 13; i++){
							this.roomSquares.add(new Location('V', i));
						}
						for ( int i = 8; i < 13; i++){
							this.roomSquares.add(new Location('W', i));
						}
						for ( int i = 8; i < 13; i++){
							this.roomSquares.add(new Location('X', i));
						}
						for ( int i = 8; i < 13; i++){
							this.roomSquares.add(new Location('Y', i));
						}
					}					
					if (this.roomName == "Library"){
						for ( int i = 16; i < 19; i++){
							this.roomSquares.add(new Location('S', i));
						}						
						for ( int i = 15; i < 20; i++){
							this.roomSquares.add(new Location('T', i));
						}
						for ( int i = 15; i < 20; i++){
							this.roomSquares.add(new Location('U', i));
						}
						for ( int i = 15; i < 20; i++){
							this.roomSquares.add(new Location('V', i));
						}
						for ( int i = 15; i < 20; i++){
							this.roomSquares.add(new Location('W', i));
						}
						for ( int i = 15; i < 20; i++){
							this.roomSquares.add(new Location('X', i));
						}
						for ( int i = 16; i < 19; i++){
							this.roomSquares.add(new Location('Y', i));
						}
					}						
					if (this.roomName == "Study"){
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('S', i));
						}						
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('T', i));
						}
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('U', i));
						}
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('V', i));
						}
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('W', i));
						}
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('X', i));
						}
						for ( int i = 21; i < 25; i++){
							this.roomSquares.add(new Location('Y', i));
						}
					}	
				
		}
	}
		}
	}
	//stairs
	
}
