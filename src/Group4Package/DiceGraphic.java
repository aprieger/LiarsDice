package Group4Package;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class DiceGraphic {
	
	private BufferedImage img = null;
	
	/**
	 * Constructs the DiceGraphic without a picture allocated.
	 */
	public DiceGraphic(){};
	
	//Currently uses relative directory pathing
	
	/**The constructor for the DiceGraphic that takes in a filePath to immediately load a 
	 * picture, works with  GIF, PNG, JPEG, BMP, WBMP
	 * 
	 * @param filePath The path to the image file, relative from the working directory
	 * 
	 * @author Brett Caley
	 */
	public DiceGraphic(String filePath){
		try{
			img = ImageIO.read(new File(filePath));
		} catch (IOException e){
			System.out.println("File not found.");
		}
	}
	
	/**Sets the DiceGraphic to be a different picture
	 * 
	 * @param filePath File path of the picture to be used,
	 * 		  relative from the working directory.
	 * 
	 * @author Brett Caley
	 */
	public void setDiceGraphic(String filePath){
		try{
			img = ImageIO.read(new File(filePath));
		} catch (IOException e){
			System.out.println("File not found.");
		}
	}
	
	/** Return of the BufferedImage to be used in Graphics and JFrames etc.
	 * 
	 * @return Returns the image held in BufferedImage.
	 */
	public Image getDiceGraphic(){
		return img;
	}
	
	
	
}
