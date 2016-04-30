package Group4Package;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class fileIOTest {

	@Test
	public void testFileIO() throws IOException {
		fileIO testFile = new fileIO();
		assertNotNull(testFile);
	}

	@Test
	public void testFileIn() throws IOException{
		fileIO testFile = new fileIO();
		testFile.fileIn("Aaron", false);
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
