package Group4Package;

/**
 * Title: Game.java
 * @author Armaan Amazan
 * Description: The driver behind the game and the code that interacts with the client interface.
 *
 */
public class Game extends Dice{

	/**
	 * Constructor (set to 2-player games because we didn't implement multiplayer in time)
	 * @param 
	 */
	public Game() {
		super(2);
		// TODO Auto-generated constructor stub
	}
	
	//TODO needs to take player as parameter, update player after game
	/* ok, so the game object needs to work with the GUI to display and manipulate the game's information.
	 * 1. instantiate player object with relevant stats (unless new player)
	 * 2. save player info to linkedlist if new
	 * 3. choose player order (a simple 2-index array will do) a
	 * 4. a do-while loop that just has whichever player acting on their particular turn.
	 * 5. The stopping condition is when either the player's dice or the cpu's dice are 0.
	 * 6. The game then calculates the difference between the player and the cpu's dice to add to points 
	 * 			(tempPoints = player - cpu;, then playerPoints += tempPoints;
	 * 7. close game object, save player information to linked list.
	 * 
	 * note: needs special cases for first bid (no call needed), etc.
	 */

}
