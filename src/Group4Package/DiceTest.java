package Group4Package;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	private Dice twoPlayerDice;
	
	
	//Sets up the test cases to have a dice game of two players for each test run 
	@Before
	public void setUp(){
		twoPlayerDice = new Dice(2);
	}
	
	//Makes sure the dice is created
	@Test
	public void testDice() {
		assertNotNull(twoPlayerDice);		
	}

	
	//Tests the GetPlayerDice and makes sure that they are within bounds of 1 to 6
	@Test
	public void testGetPlayerDice() {
		boolean outOfBounds = false;
		int [] returnDice = twoPlayerDice.getPlayerDice(1);
		if(returnDice[0] < 1 || returnDice[0] > 6){
			outOfBounds = true;
		}
		if(returnDice[1] < 1 || returnDice[1] > 6){
			outOfBounds = true;
		}
		if(returnDice[2] < 1 || returnDice[2] > 6){
			outOfBounds = true;
		}
		if(returnDice[3] < 1 || returnDice[3] > 6){
			outOfBounds = true;
		}
		if(returnDice[4] < 1 || returnDice[4] > 6){
			outOfBounds = true;
		}
		assertFalse("out of bounds", outOfBounds);
	}
	
/*	@Test
	public void testGetPlayerDiceIndex(){
		
	}*/

	//Tests dice roll by checking if after rollDice the two arrays are equal, ensuring new numbers.
	@Test
	public void testRollDice() {
		int [] returnDicePrimary = twoPlayerDice.getPlayerDice(1);
		twoPlayerDice.rollDice();
		int [] returnDiceSecondary = twoPlayerDice.getPlayerDice(1);
		
		assertFalse("arrays are equal", Arrays.equals(returnDicePrimary, returnDiceSecondary));
		
	}

}
