package Group4Package;
import java.util.Arrays;
/**
 * Title: Game.java
 * @author Nathaniel Martin,Armaan Amazan
 * Description: The driver behind the game and the code that interacts with the client interface.
 *
 */
public class Game {

/*Player p = new Player();
Game g = new Game(p);
boolean potato = true;
while(potato) {
	System.out.println("Your dice: "+Arrays.toString(g.getPlayerDice()));
	Scanner inputy = new Scanner(System.in);
	int face = inputy.nextInt();
	int quantity = inputy.nextInt();
	AIDecision decision = new AIDecision();
	if(face == 0 || quantity == 0) {
		decision.call = false;
	}
	else {
		decision.call = true;
		decision.dice_face = face;
		decision.dice_num = quantity;
	}
	g.getPlayerAction(decision);
}*/

	Player player;
	Dice dice;
	AIBrain brain;
	int turn; //Turn number. Allows players to alternate between going first.
	int inner_turn; //The turn number inside of a betting cycle.
	int last_winner;
	boolean done;
	AIDecision current_bet; //The current bet, stored as an AIDecision

	/**
	 * Constructor (set to 2-player games because we didn't implement multiplayer in time)
	 * @param Player object with existing or newly created player profile
	 */
	public Game(Player p) {
		player = p;
		dice = new Dice(2);
		brain = new AIBrain();
		turn = 0;
		inner_turn = 0;
		last_winner = 0;
		done = false;
		current_bet = new AIDecision();
		current_bet.call = true;
		current_bet.dice_face = 1;
		current_bet.dice_num = 1;
	}

	public int[] getPlayerDice() {
		return dice.getPlayerDice();
	}

	public int getOpponentDiceNum() {
		return dice.getOpponentDiceNum();
	}

	/*
	 * Main game method that happens when the player clicks the "Make Your Choice!" button
	 *
	 * @param An AIDecision object that serializes the player's choice.
	 */
	public void getPlayerAction(AIDecision action) {
		if(!done && ((turn+inner_turn)%2==0)) {
			if(inner_turn == 0) { //Is this a starting bet? Do special stuffs:
				if(turn % 2 == 0) { //Player making starting bet
					current_bet = action;
				}
				else {
					//Do nothing, it's the computer's turn!
				}
			}
			if(!action.call) { //The player is calling the opponent's bluff
				System.out.println("You call a bluff!");
				checkCall();
			}
			else {
				current_bet = action;
				System.out.println("You bet there are "+current_bet.dice_num+" rolls of "+current_bet.dice_face);
			}
			inner_turn += 1;
		}

		//Do computer actions
		if(!done && ((turn+inner_turn)%2==1)) {
			AIDecision reaction = new AIDecision();
			reaction.call = true;
			if(inner_turn == 0) { //Is this a starting bet? Do special stuffs:
				if(turn % 2 == 1) { //Computer making starting bet
					reaction = brain.Start(dice.getOpponentDice(),10);
				}
				else {
					//How did we even get here?
				}
			}
			else {
				reaction = brain.React(current_bet.dice_face,current_bet.dice_num,dice.getOpponentDice(),10);
			}
			if(!reaction.call) { //The opponent is calling the player's bluff
				System.out.println("CPU calls a bluff!");
				checkCall();
			}
			else {
				current_bet = reaction;
				System.out.println("CPU bet there are "+current_bet.dice_num+" rolls of "+current_bet.dice_face);
			}
			inner_turn += 1;
		}
	}

	protected void checkCall() {
		int[] all_dice = dice.getAllDice();
		int quantity = 0;
		for(int i = 0; i < 10; i ++) {
			if(all_dice[i] == current_bet.dice_face) {
				quantity++;
			}
		}
		if(quantity >= current_bet.dice_num) {
			//The player was not lying! The caller gets penalized
			if((turn+inner_turn)%2 == 0) {
				//Penalize player
				dice.awardOpponent();
			}
			else {
				//Penalize opponent
				dice.awardPlayer();
			}
		}
		else {
			//The player was lying. The bluffer gets penalized
			if((turn+inner_turn)%2 == 0) {
				//Penalize Opponent
				dice.awardPlayer();
			}
			else {
				//Penalize player
				dice.awardOpponent();
			}
		}
		if(dice.getPlayerDiceNum() == 10 || dice.getOpponentDiceNum() == 10) {
			done = true;
		}
		System.out.println("All dice: "+Arrays.toString(dice.getAllDice())+" "+turn+" "+inner_turn);
		dice.rollDice();
		turn += 1;
		inner_turn = -1;
	}

	/*
	 * Method that gets the possible choices in the player's dropdown menu.
	 *
	 * @return An array of strings for the dropdown menu.
	 */
	public String[] getPossibleActions() {
		String entries = "";
		if(turn % 2 == 1 && inner_turn == 0) {
			return new String[] {"Continue"};
		}
		if(inner_turn == 0) {
			current_bet.dice_face = 1;
			current_bet.dice_num = 1;
		}
		else {
			entries = "Call Opponent's Bluff\n";
		}
		//For dice values lower than the current bet, you need a higher number.
		for(int i = 1; i <= current_bet.dice_face; i++) {
			for(int j = current_bet.dice_num+1; j <= 10; j++) {
				entries += "Bet "+j+" rolls of "+i+"\n";
			}
		}
		//For dice values higher than the current bet, you just need the same number.
		for(int i = current_bet.dice_face+1; i <= 6; i++) {
			for(int j = current_bet.dice_num; j <= 10; j++) {
				entries += "Bet "+j+" rolls of "+i+"\n";
			}
		}
		System.out.println(entries);
		return entries.split("\n");
	}

	//TODO needs to take player as parameter, update player after game
	/* ok, so the game object needs to work with the GUI to display and manipulate the game's information.
	 * 1. instantiate player object with relevant stats (unless new player)
	 * 2. save player info to linkedlist if new
	 * 3. choose player order (a simple 2-index array will do) a
	 * 4. a do-while loop that just has whichever player acting on their particular turn.
	 * 5. The stopping condition is when either the player's dice or the cpu's dice are 0.
	 * 6. The game then calculates the difference between the player and the cpu's dice to add to points
	 * 			(tempPoints = player - cpu;, then playerPoints += tempPoints;
	 * 7. close game object, save player information to linked list.
	 *
	 * note: needs special cases for first bid (no call needed), etc.
	 */

}
