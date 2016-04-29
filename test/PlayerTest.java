package Group4Package;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	//Tests for a non null object on creation
	@Test
	public void testPlayer() {
		Player testSubj1 = new Player();
		assertNotNull(testSubj1);
	}

	//tests the value of TestSubj1 to see if it has the correct name.
	@Test
	public void testSetName() {
		Player testSubj1 = new Player();
		testSubj1.setName("Brett");
		assertEquals(testSubj1.getName(),"Brett");
	}

	//Test the return of testSubj1 
	@Test
	public void testGetName() {
		Player testSubj1 = new Player();
		testSubj1.setName("Brett");
		assertEquals(testSubj1.getName(),"Brett");
	}

	//Tests the value of testSubj1 to ensure it sets the win data correctly
	@Test
	public void testSetWins() {
		Player testSubj1 = new Player();
		testSubj1.setWins(15);
		assertEquals(testSubj1.getWins(),15);
	}

	//Tests the value of testSubj1 to ensure it has the correct win data.
	@Test
	public void testGetWins() {
		Player testSubj1 = new Player();
		testSubj1.setWins(15);
		assertEquals(testSubj1.getWins(),15);
	}

	//Test Losses setter
	@Test
	public void testSetLosses() {
		Player testSubj1 = new Player();
		testSubj1.setLosses(15);
		assertEquals(testSubj1.getLosses(),15);
	}

	//Test Losses getter
	@Test
	public void testGetLosses() {
		Player testSubj1 = new Player();
		testSubj1.setLosses(15);
		assertEquals(testSubj1.getLosses(),15);
	}

	//Test Points setter
	@Test
	public void testSetPoints() {
		Player testSubj1 = new Player();
		testSubj1.setPoints(15);
		assertEquals(testSubj1.getPoints(),15);
	}

	//Test Points getter
	@Test
	public void testGetPoints() {
		Player testSubj1 = new Player();
		testSubj1.setPoints(15);
		assertEquals(testSubj1.getPoints(),15);
		
	}

	//Tests CompareTo function, with testSubj2 points > testSubj1 points
	@Test
	public void testCompareToGreaterThan() {
		Player testSubj1 = new Player();
		testSubj1.setPoints(15);
		Player testSubj2 = new Player();
		testSubj2.setPoints(10);
		assertEquals(testSubj2.compareTo(testSubj1),-1);
	}
	
	//Tests CompareTo function, with testSubj2 points < testSubj1 points
	@Test
	public void testCompareToLessThan(){
		Player testSubj1 = new Player();
		testSubj1.setPoints(10);
		Player testSubj2 = new Player();
		testSubj2.setPoints(15);
		assertEquals(testSubj2.compareTo(testSubj1),1);
	}
	
	//Tests CompareTo function, with testSubj2 points == testSubj1 points
	public void testCompareToEqual(){
		Player testSubj1 = new Player();
		testSubj1.setPoints(15);
		Player testSubj2 = new Player();
		testSubj2.setPoints(15);
		assertEquals(testSubj2.compareTo(testSubj1),0);
	}

}
