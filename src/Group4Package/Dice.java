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
	//need turn counter to make it so that winner doesn't go first
	private int player;
	private int opponent; //output this to cpu's number of dice on GUI

	public static final int MAX_DICE = 5;

	/**
	 * Creates a new Dice object.
	 *
	 * @param Maximum number of players for the game.
	 */
	public Dice(int playerCount) {
		dice = new int[playerCount*MAX_DICE];
		player = 5;
		opponent = 5;
		rollDice();
	}

	/**
	 * Gets a specified player's set of dice.
	 *
	 * @param The index of the player (Player 0, Player 1, Player 2, etc.)
	 * @return An array of their roll results.
	 */
	public int[] getPlayerDice(int playerIndex) {
		int[] playerDice = new int[MAX_DICE];
		for(int i = 0; i < MAX_DICE; i++) {
			playerDice[i] = dice[playerIndex*MAX_DICE+i];
		}
		return playerDice;
	}

	/**
	 * Gets the human player's set of dice.
	 *
	 * @return An array of their roll results.
	 */
	public int[] getPlayerDice() {
		int[] playerDice = new int[player];
		for(int i = 0; i < player; i++) {
			playerDice[i] = dice[i];
		}
		return playerDice;
	}

	/**
	 * Gets the computer opponent's set of dice.
	 *
	 * @return An array of their roll results.
	 */
	public int[] getOpponentDice() {
		int[] playerDice = new int[opponent];
		for(int i = 0; i < opponent; i++) {
			playerDice[i] = dice[player+i];
		}
		return playerDice;
	}

	/**
	 * Gets the player's dice score.
	 *
	 * @return An int representing their dice score.
	 */
	public int getPlayerDiceNum() {
		return player;
	}

	/**
	 * Gets the opponents's dice score.
	 *
	 * @return An int representing their dice score.
	 */
	public int getOpponentDiceNum() {
		return opponent;
	}

	/*
	 * Gives the player 1 die from the opponent.
	 */
	public void awardPlayer() {
		player++;
		opponent--;
	}

	/*
	 * Gives the opponent 1 die from the opponent.
	 */
	public void awardOpponent() {
		player--;
		opponent++;
	}


	/*
	 * Gets all dice for the game to validate bets/calls
	 *
	 * @return An array of all dice results.
	 */
	public int[] getAllDice() {
		return dice;
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
