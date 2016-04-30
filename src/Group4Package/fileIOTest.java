package Group4Package;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class fileIOTest {

	// tests that the new fileIO object is not null when initilized
	@Test
	public void testFileIO() throws IOException {
		fileIO testFile = new fileIO();
		assertNotNull(testFile);
	}

	// tests the fileIn() method where it opens a file, and if one doesn't exist it creates one
	// and inserts the object into the text file
	@Test
	public void testFileIn() throws IOException{
		fileIO testFile = new fileIO();
		Player tempPlayer = testFile.fileIn("Aaron", false);
		assertEquals(tempPlayer.getName(), "Aaron");
		assertEquals(tempPlayer.getWins(), 0);
		assertEquals(tempPlayer.getLosses(), 0);
	}

	// tests the LLStart method by creating a file and LinkedList objects, inserting a new 
	// player into then attempting to set the new Linked list from LLStart to newList
	@Test
	public void testLLStart() throws IOException {
		fileIO testFile = new fileIO();
		LinkedList newList = new LinkedList();
		testFile.fileIn("Joe", false);
		newList = testFile.LLStart();
	}

	// tests the LLStart method by creating a file and LinkedList objects, inserting a new 
	// player into then attempting to set the new Linked list from LLStart to newList
	@Test
	public void testFileOut() throws IOException {
		fileIO testFile = new fileIO();
		testFile.fileIn("Phil", false);
		testFile.fileOut();
	}

}
