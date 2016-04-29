package Group4Package;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	//Checks to see if the root node is not null, indicative of success of insertion
	@Test
	public void testLLInsert() {
		Player testSubj1 = new Player();
		testSubj1.setName("Brett");
		LinkedList testList = new LinkedList();
		testList.LLInsert(testSubj1);
		assertNotNull(testList.root);
	}
	
	//Checks the order to make sure it is from highest to lowest. Inserts Low points first.
	@Test
	public void testLLInsertOrderLowFirst(){
		Player testSubj1 = new Player();
		testSubj1.setName("Bob");
		testSubj1.setWins(10);
		Player testSubj2 = new Player();
		testSubj2.setName("Brett");
		testSubj2.setWins(5);
		LinkedList testList = new LinkedList();
		testList.LLInsert(testSubj2);
		testList.LLInsert(testSubj1);
		assertEquals("Bob",testList.root.getName());
	}
	
	//Checks the order to make sure it is from highest to lowest. Inserts High points first.
	@Test
	public void testLLInsertOrderHighFirst(){
		Player testSubj1 = new Player();
		testSubj1.setName("Bob");
		testSubj1.setWins(10);
		Player testSubj2 = new Player();
		testSubj2.setName("Brett");
		testSubj2.setWins(5);
		LinkedList testList = new LinkedList();
		testList.LLInsert(testSubj1);
		testList.LLInsert(testSubj2);
		assertEquals("Bob",testList.root.getName());
	}
	
	// inserts 3 players into linked list and sets values to them, then attempts to print them out
	@Test
	public void testLLInsertAndPrint() {
		LinkedList playerList = new LinkedList();
		Player tempInsert1 = new Player();
		tempInsert1.setName("test1");
		tempInsert1.setWins(5);
		tempInsert1.setLosses(4);
		playerList.LLInsert(tempInsert1);
		
		Player tempInsert2 = new Player();
		tempInsert2.setName("test2");
		tempInsert2.setWins(3);
		tempInsert2.setLosses(2);
		playerList.LLInsert(tempInsert2);
		
		Player tempInsert3 = new Player();
		tempInsert3.setName("test3");
		tempInsert3.setWins(1);
		tempInsert3.setLosses(0);
		playerList.LLInsert(tempInsert3);
		playerList.LLPrint();
		
		assertEquals(playerList.LLPrint(), 
				"test1: Points: 0, Wins/Losses: 5/4\n"
				+ "test2: Points: 0, Wins/Losses: 3/2\n"
				+ "test3: Points: 0, Wins/Losses: 1/0\n");
	}
	
	// test the LLSort() method by inserting in random order and sorting based on points
	@Test
	public void testLLSort() {
		LinkedList playerList = new LinkedList();
		Player tempInsert5 = new Player();
		tempInsert5.setName("test5");
		tempInsert5.setPoints(5);
		tempInsert5.setWins(4);
		tempInsert5.setLosses(3);
		playerList.LLInsert(tempInsert5);
		playerList.LLPrint();
		
		Player tempInsert2 = new Player();
		tempInsert2.setName("test2");
		tempInsert2.setPoints(2);
		tempInsert2.setWins(1);
		tempInsert2.setLosses(0);
		playerList.LLInsert(tempInsert2);
		
		Player tempInsert3 = new Player();
		tempInsert3.setName("test3");
		tempInsert3.setPoints(3);
		tempInsert3.setWins(2);
		tempInsert3.setLosses(1);
		playerList.LLInsert(tempInsert3);
		
		Player tempInsert1 = new Player();
		tempInsert1.setName("test1");
		tempInsert1.setPoints(1);
		tempInsert1.setWins(0);
		tempInsert1.setLosses(0);
		playerList.LLInsert(tempInsert1);
		playerList.LLPrint();
		
		Player tempInsert4 = new Player();
		tempInsert4.setName("test4");
		tempInsert4.setPoints(4);
		tempInsert4.setWins(3);
		tempInsert4.setLosses(2);
		playerList.LLInsert(tempInsert4);
		playerList.LLPrint();
		
		playerList.LLSort();
		assertEquals(playerList.LLPrint(), 
				"test5: Points: 5, Wins/Losses: 4/3\n"
						+ "test4: Points: 4, Wins/Losses: 3/2\n"
						+ "test3: Points: 3, Wins/Losses: 2/1\n"
						+ "test2: Points: 2, Wins/Losses: 1/0\n"
						+ "test1: Points: 1, Wins/Losses: 0/0\n");
	}
}
