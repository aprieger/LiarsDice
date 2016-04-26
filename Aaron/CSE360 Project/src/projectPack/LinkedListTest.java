package projectPack;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

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
		
		assertEquals(playerList.LLPrint(), "test1: 5 wins/4 losses.\ntest2: 3 wins/2 losses.\ntest3: 1 wins/0 losses.\n");
	}
	
	@Test
	public void testLLSort() {
		LinkedList playerList = new LinkedList();
		Player tempInsert5 = new Player();
		tempInsert5.setName("test5");
		tempInsert5.setWins(5);
		tempInsert5.setLosses(0);
		playerList.LLInsert(tempInsert5);
		playerList.LLPrint();
		
		Player tempInsert1 = new Player();
		tempInsert1.setName("test2");
		tempInsert1.setWins(2);
		tempInsert1.setLosses(0);
		playerList.LLInsert(tempInsert1);
		
		Player tempInsert2 = new Player();
		tempInsert2.setName("test3");
		tempInsert2.setWins(3);
		tempInsert2.setLosses(0);
		playerList.LLInsert(tempInsert2);
		
		Player tempInsert3 = new Player();
		tempInsert3.setName("test1");
		tempInsert3.setWins(1);
		tempInsert3.setLosses(0);
		playerList.LLInsert(tempInsert3);
		playerList.LLPrint();
		
		Player tempInsert4 = new Player();
		tempInsert4.setName("test4");
		tempInsert4.setWins(4);
		tempInsert4.setLosses(0);
		playerList.LLInsert(tempInsert4);
		playerList.LLPrint();
		
		playerList.LLSort();
		assertEquals(playerList.LLPrint(), "test5: 5 wins/0 losses.\ntest4: 4 wins/0 losses.\ntest3: 3 wins/0 losses.\ntest2: 2 wins/0 losses.\ntest1: 1 wins/0 losses.\n");
	}
	
}
