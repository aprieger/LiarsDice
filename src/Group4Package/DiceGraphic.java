package Group4Package;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class DiceGraphic {
	
	private BufferedImage dice = null;
	private ImageFileReader imageFile = new ImageFileReader();
	
	/**
	 * Constructs the DiceGraphic without a picture allocated.
	 */
	public DiceGraphic(){};
	
	//Currently uses relative directory pathing
	
	/**The constructor for the DiceGraphic that takes in a dice number to be concatenated with a filePath
	 * to immediately load a picture, works with  GIF, PNG, JPEG, BMP, WBMP
	 * 
	 * @param diceFace The number to be concatenated with the
	 * path to the image file, relative from the working directory
	 * 
	 * @author Brett Caley
	 */
	public DiceGraphic(int diceFace){
		imageFile.setImage("./src/dice"+diceFace+".jpg");
		dice = imageFile.getImage();
	}
	
	/**Sets the DiceGraphic to be a different picture
	 * 
	 * @param diceFace Integer input that is concatenated into a filepath
	 * to be read from as "./src/dice1.jpg" for instance
	 * 
	 * @author Brett Caley
	 */
	public void setDiceGraphic(int diceFace){
		imageFile.setImage("./src/dice"+diceFace+".jpg");
		dice = imageFile.getImage();
	}
	
	/** Return of the BufferedImage to be used in Graphics and JFrames etc.
	 * 
	 * @return Returns the image held in BufferedImage dice.
	 */
	public Image getDiceGraphic(){
		return dice;
	}
	
	
	
}
