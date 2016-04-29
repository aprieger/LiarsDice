package Group4Package;
//Aaron Prieger
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class fileIO{
	public static void main(String []args) throws IOException{
		//This is AIBrain testing code, uncomment to test it out.
		/*
		boolean potato = true;
		while(potato) {
			AIBrain n = new AIBrain();
			AIDecision d;
			Scanner inputy = new Scanner(System.in);
			int face = inputy.nextInt();
			int quantity = inputy.nextInt();
			Random rand = new Random();
			int[] inventory = new int[]{rand.nextInt(6)+1,rand.nextInt(6)+1,rand.nextInt(6)+1,rand.nextInt(6)+1,rand.nextInt(6)+1};
			d = n.React(face,quantity,inventory,10);
			if(d.call == false) {
				System.out.println("Liar!");
			}
			else {
				System.out.println("Challenge accepted... I'm betting on "+d.dice_num+" "+d.dice_face+"'s!");
			}
			System.out.println("\nMy turn...\n");
			d = n.Start(inventory,10);
			System.out.println("Alright, I'm betting on "+d.dice_num+" "+d.dice_face+"'s!");
		}
		*/

		// Open the file playerdata.txt, if the file doesn't exist, create a new one
		File playerData = new File("playerdata.txt");
		if (!playerData.exists()){
			playerData.createNewFile();
		}

		FileWriter writeData = new FileWriter("playerdata.txt", true);
	    	BufferedWriter writeBuffer = new BufferedWriter(writeData);
		PrintWriter writeFile = new PrintWriter(writeBuffer);

		// Create a Scanner object and prompt user for the amount of players
		Scanner input = new Scanner(System.in);
		System.out.println("How many players will play?");
		int playerNum = input.nextInt();

		// Create the array of players based on the input size
		Player[] playerArray = new Player[playerNum];

		// Loop through amount of players prompting the user for the player names
		// if a name is found in the text file, load that name and wins and losses to a player
		String playerName;
		for (int i = 0; i < playerNum; i++){
			// Prompt for a name
			System.out.println("Player " + (i+1) + ": Enter Name");
			playerName = input.next();

			// new file reader object to read from playerdata.txt
			FileReader readData = new FileReader(playerData);
			BufferedReader readBuffer = new BufferedReader(readData);
			String line = null;
			boolean nameFound = false;

			// loop through the length of the text file to search for each players name
	        while((line = readBuffer.readLine()) != null){
	        	Scanner delimLine = new Scanner(line).useDelimiter("\\t");
	        	String dataName = delimLine.next();

	        	// if the name is found in the text file, copy the name, wins and losses to the player object
	        	if (dataName.equals(playerName)){
	        		playerArray[i] = new Player();
	        		playerArray[i].setName(playerName);
	        		playerArray[i].setWins(delimLine.nextInt());
	        		playerArray[i].setLosses(delimLine.nextInt());
	        		playerArray[i].setPoints(0); //This is for testing the scoreboard
	        		nameFound = true;
	    	        	System.out.println("Added returning player " + playerArray[i].getName() + ", with " + playerArray[i].getWins() + " wins/" + playerArray[i].getLosses() + " losses.");
	        	}
	        	delimLine.close();
	        }
	        // if the name is not found in the text file, create empty entry with typed name
	        if (nameFound == false){
	        	playerArray[i] = new Player();
	        	playerArray[i].setName(playerName);
	        	playerArray[i].setWins(0);
        		playerArray[i].setLosses(0);
        		playerArray[i].setPoints(0);
    	        	System.out.println("Added new player " + playerArray[i].getName() + ", with " + playerArray[i].getWins() + " wins/" + playerArray[i].getLosses() + " losses.");
    	        	writeFile.println(playerArray[i].getName()+"\t"+playerArray[i].getWins()+"\t"+playerArray[i].getLosses());
	        }
			readBuffer.close();
		}
		input.close();
		writeFile.close();

		FileReader LLRead = new FileReader(playerData);
		BufferedReader LLReadBuff = new BufferedReader(LLRead);
		String lineLL = new String();

		// Create linked list to hold the leader board of all players
		LinkedList playerList = new LinkedList();
		while((lineLL = LLReadBuff.readLine()) != null){
			Scanner LLDelim = new Scanner(lineLL).useDelimiter("\\t");
			Player tempInsert = new Player();
        		tempInsert.setName((String)LLDelim.next());
        		tempInsert.setWins(LLDelim.nextInt());
        		tempInsert.setLosses(LLDelim.nextInt());
        		playerList.LLInsert(tempInsert);
        	}
		LLReadBuff.close();
		
		//Test leaderboard
		Leaderboard board = new Leaderboard();
		board.generate(playerList.root);

		//Test dice
		Dice dice = new Dice(2);
		System.out.println(dice.getPlayerDice(1)[0]);
		dice.rollDice();
		System.out.println(dice.getPlayerDice(1)[0]);
		
		
		// This next part needs to come after the game is done to save the data to file
		// new file reader object to read from playerdata.txt
		FileReader readData = new FileReader(playerData);
		BufferedReader readBuffer = new BufferedReader(readData);
		String saveLine = null;
		String fileContents = "";
		
		while ((saveLine = readBuffer.readLine()) != null){
        	Scanner delimLine = new Scanner(saveLine).useDelimiter("\\t");
        	String dataName = delimLine.next();
        	String dataWins = delimLine.next();
        	String dataLosses = delimLine.next();
        	boolean found = false;
        	for (int index = 0; index < playerNum; index++)
        	{
			// if the name is found in the text file, copy the name, wins and losses to the player object
			if (dataName.equals(playerArray[index].getName())){
				fileContents = fileContents + (playerArray[index].getName()+"\t"+playerArray[index].getWins()+"\t"+playerArray[index].getLosses());
				found = true;
	        	}
        	}
        	if (found == false)
        	{
        		fileContents = fileContents + (dataName + "\t" + dataWins + "\t" + dataLosses + "\n");
        	}
        	delimLine.close();
		}
		readBuffer.close();
		playerData.delete();
		
		// save text file
		FileWriter saveData = new FileWriter("playerdata.txt", true);
		BufferedWriter saveBuffer = new BufferedWriter(saveData);
		PrintWriter saveFile = new PrintWriter(saveBuffer);
		saveFile.println(fileContents);
		saveFile.close();
	}
}
