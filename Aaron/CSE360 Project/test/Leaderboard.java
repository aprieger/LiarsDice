package projectPack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeaderboardTests {

	@Test
	public void testSort() {
		Player testPlayer = new Player();
		Player[] playerArray = new Player[2];
		playerArray[0].setName("Hillary");
		playerArray[0].setWins(1);
		playerArray[0].setLosses(2);
		playerArray[0].setPoints(3);
		testPlayer.setName("Bernie");
		testPlayer.setWins(2);
		testPlayer.setLosses(1);
		testPlayer.setPoints(4); //Feel the bern or something
		playerArray[1] = testPlayer;

		Leaderboard tester = new Leaderboard();
		tester.generate(playerArray,playerArray.length);
		assertEquals("The array must not have been modified.",playerArray[1],testPlayer);
	}
}
