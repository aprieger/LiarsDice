package projectPack;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player testPlayer = new Player();
		assertNotNull(testPlayer);
	}

	@Test
	public void testSetNameAndGetName() {
		Player testPlayer = new Player();
		testPlayer.setName("test");
		assertEquals("test", testPlayer.getName());
	}

	@Test
	public void testSetWinsAndGetWins() {
		Player testPlayer = new Player();
		testPlayer.setWins(5);
		assertEquals(5, testPlayer.getWins());
	}

	@Test
	public void testSetLossesAndGetLosses() {
		Player testPlayer = new Player();
		testPlayer.setLosses(3);
		assertEquals(3, testPlayer.getLosses());
	}

	@Test
	public void testSetPointsAndGetPoints() {
		Player testPlayer = new Player();
		testPlayer.setPoints(7);
		assertEquals(7, testPlayer.getPoints());
	}

}
