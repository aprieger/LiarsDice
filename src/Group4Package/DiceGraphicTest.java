package Group4Package;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Before;
import org.junit.Test;

public class DiceGraphicTest {

	private DiceGraphic diceImageTest1;
	
	@Before
	public void setUp() throws Exception {
		 diceImageTest1 = null;
	}

	//Object creation
	@Test
	public void testDiceGraphic() {
		diceImageTest1 = new DiceGraphic();
		assertNotNull(diceImageTest1);
	}

	//Tests to make sure the correct kind of image is loaded by checking the width of it versus expected width
	//in this case, the dice1 icon should have a width of 50.
	@Test
	public void testDiceGraphicInt() {
		diceImageTest1 = new DiceGraphic(1);
		Image dice1 = null;
		dice1 = diceImageTest1.getDiceGraphic();
		assertEquals(dice1.getWidth(null),50);
		
	}
	
	@Test
	public void testSetDiceGraphic(){
		diceImageTest1 = new DiceGraphic(1);
		DiceGraphic diceImageTest2 = new DiceGraphic(1);
		diceImageTest1.setDiceGraphic(2);
		
		assertNotSame(diceImageTest1.getDiceGraphic(),diceImageTest2.getDiceGraphic());
		
	}

}
