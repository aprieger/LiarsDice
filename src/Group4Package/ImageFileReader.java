package Group4Package;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageFileReader {
	
	private BufferedImage img = null;
	
	/**
	 * Constructs the DiceGraphic without a picture allocated.
	 */
	public ImageFileReader(){};
	
	//Currently uses relative directory pathing
	
	/**The constructor for the DiceGraphic that takes in a filePath to immediately load a 
	 * picture, works with  GIF, PNG, JPEG, BMP, WBMP
	 * 
	 * @param filePath The path to the image file, relative from the working directory
	 * 
	 * @author Brett Caley
	 */
	public ImageFileReader(String filePath){
		try{
			img = ImageIO.read(new File(filePath));
		} catch (IOException e){
			System.out.println(e);
		}
	}
	
	/**Sets the DiceGraphic to be a different picture
	 * 
	 * @param filePath File path of the picture to be used,
	 * 		  relative from the working directory.
	 * 
	 * @author Brett Caley
	 */
	public void setImage(String filePath){
		try{
			img = ImageIO.read(new File(filePath));
		} catch (IOException e){
			System.out.println(e);
		}
	}
	
	/** Return of the BufferedImage to be used in Graphics and JFrames etc.
	 * 
	 * @return Returns the image held in BufferedImage.
	 */
	public BufferedImage getImage(){
		return img;
	}
	
	
	
}
