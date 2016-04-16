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

	//Not quite sure how to make this one work, perhaps we could use a "toString" into a print function? Might be better.
	@Test
	public void testLLPrint() {
		fail("Not yet implemented");
	}

}
