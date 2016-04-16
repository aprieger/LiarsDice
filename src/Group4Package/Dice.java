package Group4Package;

import java.util.Random;

/**
 * Title: Dice
 * Description: Encapsulates certain functions and behaviors related to the dice.
 * @author Nathaniel Martin
 *
 */
public class Dice {
	private int[] dice;
	private int turn;
	private int player;
	private int opponent;

	public static final int MAX_DICE = 5;

	/**
	 * Creates a new Dice object.
	 *
	 * @param Maximum number of players for the game.
	 */
	public Dice(int playerCount) {
		dice = new int[playerCount*MAX_DICE];
		rollDice();
	}

	/**
	 * Gets a specified player's set of dice.
	 *
	 * @param The index of the player (Player 0, Player 1, Player 2, etc.)
	 * @return An array of their roll results. (Includes missing dice)
	 */
	public int[] getPlayerDice(int playerIndex) {
		int[] playerDice = new int[MAX_DICE];
		for(int i = 0; i < MAX_DICE; i++) {
			playerDice[i] = dice[playerIndex*MAX_DICE+i];
		}
		return playerDice;
	}

	/**
	 * Randomizes all player dice.
	 */
	public void rollDice() {
		Random rand = new Random();
		for(int i = 0; i < dice.length; i++) {
			int roll = rand.nextInt(6) + 1;
			dice[i] = roll;
		}
	}
}
