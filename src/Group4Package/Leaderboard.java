//Leaderboard Object Source
//Nathaniel Martin
package Group4Package;

import java.util.Arrays;
import java.util.Collections;

public class Leaderboard {
	public Leaderboard() {

	}

	/**
	 * Generates leaderboard data for the game. This takes a standard array of players.
	 * Currently only outputs debug output.
	 *
	 * @param The game's array of players.
	 * @param The game's count of players for the array.
	 */
	public void generate(Player[] playerArray, int playerCount) {
		//Create a copy of the array for sorting.
		//We need to do this so the order of the players isn't disrupted.
		Player[] players = new Player[playerCount];
		for(int i = 0; i < playerCount; i++) {
			players[i] = playerArray[i];
		}
		//Sort the players. This uses the efficient built-in sorting algorithm
		//and makes the code easier to read.
		Arrays.sort(players, Collections.reverseOrder());

		//XXX: Remove this line, it just makes the debug output more readable
		System.out.println("LEADERBOARD\n===========");

		System.out.println("Name\tW/L\tPoints\n");
		for(int i = 0; i < playerCount; i++) {
			Player p = players[i];
			//TODO: Implement GUI functionality instead of console output.
			System.out.println(
				p.getName() + "\t" + p.getWins() + "/" +
				p.getLosses() + "\t" + p.getPoints()
			);
		}
	}

	/**
	 * Generates leaderboard data for the game. This takes in a presorted linked list.
	 * Currently only outputs debug output.
	 *
	 * @param The game's linked list of players
	 * @return String[] version of leaderboard
	 */
	public String[] generate(Player listRoot) {
		Player node = listRoot;
		String[] outarray = new String[50];
		//XXX: Remove this line, it just makes the debug output more readable

		outarray[0] = "LEADERBOARD";
		outarray[1] = "===========";
		outarray[2] ="";
		int index = 3;
		while(node != null) {
			outarray[index] = node.getName() + " has " + node.getWins() + "/" + node.getLosses() + " Wins/Losses and " + node.getPoints() + " Points\n";;
			node = node.next;
			index++;
		}
		return outarray;
	}
}
