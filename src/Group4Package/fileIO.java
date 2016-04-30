package Group4Package;
/**
 * @author: Aaron Prieger
 */
import java.util.Scanner;
import java.io.*;
/** fileIO: Class that handles the file input and output to text file
 * Also constructs the player array and linked lists
 * @version: 2.3 (created fileOut method)
 * @see fileIn(), LLStart(), fileOut()
 */
public class fileIO
{
	public File playerData;
	public Player newPlayer;
	private int playerCount;
	
	/**fileIO(): constructor for fileIO class
	 * @throws IOException
	 */
	public fileIO()
	{
		playerData = new File("playerdata.txt");
		if (!playerData.exists()){
			try {
				playerData.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**fileIn(): method that sets up the player array by reading from the input
	 * @throws IOException
	 */
	public Player fileIn(String playerName, boolean returning) throws IOException
	{
		FileWriter writeData = new FileWriter("playerdata.txt", true);
	    BufferedWriter writeBuffer = new BufferedWriter(writeData);
		PrintWriter writeFile = new PrintWriter(writeBuffer);

		// Create the array of players based on the input size
		newPlayer = new Player();

		// Loop through amount of players prompting the user for the player names
		// if a name is found in the text file, load that name and wins and losses to a player
		// new file reader object to read from playerdata.txt
		FileReader readData = new FileReader("playerData.txt");
		BufferedReader readBuffer = new BufferedReader(readData);
		String line = null;
		boolean nameFound = false;

		// loop through the length of the text file to search for each players name
		if (returning == true)
		{
	        while((line = readBuffer.readLine()) != null && line.length()!=0){
	        	Scanner delimLine = new Scanner(line).useDelimiter("\\t");
	        	String dataName = delimLine.next();
	
	        	// if the name is found in the text file, copy the name, wins and losses to the player object
	        	if (dataName.equals(playerName)){
	        		newPlayer.setName(playerName);
	        		newPlayer.setWins(delimLine.nextInt());
	        		newPlayer.setLosses(delimLine.nextInt());
	        		newPlayer.setPoints(0); //This is for testing the scoreboard
	        		nameFound = true;
	    	        System.out.println("Added returning player " + newPlayer.getName() + ", with " + newPlayer.getWins() + " wins/" + newPlayer.getLosses() + " losses.");
	        	}
	        	delimLine.close();
	        }
	        // if the name is not found in the text file, create empty entry with typed name
	        if (nameFound == false){
	        	System.out.println("Player Not Found");
	        }
			readBuffer.close();
		}
		else
		{
        	newPlayer.setName(playerName);
        	newPlayer.setWins(0);
        	newPlayer.setLosses(0);
        	newPlayer.setPoints(0);
	        System.out.println("Added new player " + newPlayer.getName() + ", with " + newPlayer.getWins() + " wins/" + newPlayer.getLosses() + " losses.");
	        writeFile.println(newPlayer.getName()+"\t"+newPlayer.getWins()+"\t"+newPlayer.getLosses()+"\n");
		}
		writeFile.close();
		
		return newPlayer;
	}
	/**LLStart(): Method that creates the linked list that will hold the leaderboard
	 * @throws IOException
	 */
	public LinkedList LLStart() throws IOException
	{
		// new reader objects to read from the text file
		//playerData = new File("playerdata.txt");
		FileReader LLRead = new FileReader("playerdata.txt");
		BufferedReader LLReadBuff = new BufferedReader(LLRead);
		String lineLL = null;

		// Create linked list to hold the leader board of all players
		LinkedList playerList = new LinkedList();
		while((lineLL = LLReadBuff.readLine()) != null && lineLL.length()!=0){
			Scanner LLDelim = new Scanner(lineLL).useDelimiter("\\t");
			Player tempInsert = new Player();
    		tempInsert.setName((String)LLDelim.next());
    		tempInsert.setWins(LLDelim.nextInt());
    		tempInsert.setLosses(LLDelim.nextInt());
    		playerList.LLInsert(tempInsert);
        	}
		LLReadBuff.close();
		
		playerList.LLSort();
		return playerList;
	}
	
	public void fileOut() throws IOException
	{
		// new file reader object to read from playerdata.txt
		FileReader readData = new FileReader("playerdata.txt");
		BufferedReader readBuffer = new BufferedReader(readData);
		String saveLine = null;
		String fileContents = "";
		
		if (newPlayer != null)
		{
			// until the end of the file do
			while ((saveLine = readBuffer.readLine()) != null && saveLine.length()!=0){
				// new delimeter and read the next three values into "dataName", "dataWins", and "dataLosses" respectively
				Scanner delimLine = new Scanner(saveLine).useDelimiter("\\t");
	        	String dataName = delimLine.next();
	        	String dataWins = delimLine.next();
	        	String dataLosses = delimLine.next();
	        	boolean found = false;
				// if the name is found in the playerArray, copy the name, wins and losses to the "fileContents"
	        	if (dataName.equals(newPlayer.getName())){
					fileContents = fileContents + (newPlayer.getName()+"\t"+newPlayer.getWins()+"\t"+newPlayer.getLosses());
					found = true;
		        	}
	        	// if the name is not in the array, copy it from the text file and paste into "fileContents"
	        	if (found == false)
	        	{
	        		fileContents = fileContents + (dataName + "\t" + dataWins + "\t" + dataLosses + "\n");
	        	}
	        	delimLine.close();
			}
		}
		readBuffer.close();
		
		// clear all data from the playerData text file
		playerData.delete();
		
		// save text file
		FileWriter saveData = new FileWriter("playerdata.txt", true);
		BufferedWriter saveBuffer = new BufferedWriter(saveData);
		PrintWriter saveFile = new PrintWriter(saveBuffer);
		
		//store the value of fileContents into "playerdata.txt"
		saveFile.println(fileContents);
		saveFile.close();
	}
}
