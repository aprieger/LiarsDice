package Group4Package;

import java.util.Random;

/**
 * Title: AIBrain
 * Description: Contains methods for the artificial intelligence part of the game.
 * @author Nathaniel Martin
 *
 */
public class AIBrain {

	/**
	 * Generates a decision reaction based on a player's existing call.
	 *
	 * @param The die face the player is claiming
	 * @param The quantity of dice the player is claiming
	 * @param An array of the AI's dice (ONLY the AI's Dice).
	 * @param The total number of dice in the game
	 */
	public AIDecision React(int face, int quantity, int[] AIDice, int total_dice_count) {
		Random rand = new Random();
		AIDecision decision = new AIDecision();
		int[] owned_quantities = new int[7]; // An array mapped to the number of dice the AI has for each face
		int max_quantity = 0; //The quantity of the AI has of their most abundant face.
		int max_face = 1; //The face the AI has the most of in their hand.

		for(int i = 0; i < owned_quantities.length; i++) {
			owned_quantities[i] = 0;
		}
		for(int i = 0; i < AIDice.length; i++) {
			owned_quantities[AIDice[i]] += 1;
		}

		//This int represents how many calls they're willing to permit before getting suspicious
		int claimTolerance = rand.nextInt(rand.nextInt(total_dice_count/2)+1)+(int)Math.ceil(total_dice_count/6.0);

		if(quantity > total_dice_count || face > 6) {
			//Player makes an impossible call, they be lying.
			decision.call = false;
			return decision;
		}

		if(quantity > claimTolerance) {
			//The quantity is greater than what the AI considers "normal"
			if(quantity-Math.ceil(total_dice_count/6.0) > owned_quantities[face] && rand.nextInt(6) != 4) {
				//The AI does not have the dice in their hand to make that total. Call BS
				decision.call = false;
				return decision;
			}
		}

		for(int i = 0; i < owned_quantities.length; i++) {
			if(owned_quantities[i] >= max_quantity) {
				max_face = i;
				max_quantity = owned_quantities[i];
			}
			if(owned_quantities[i] > quantity || (i == face && owned_quantities[face] > quantity)) {
				//The AI has a larger quantity of dice than (rand.nextInt(2)*2-1) *the claim, raise the bet.
				decision.call = true;
				decision.dice_face = i;
				decision.dice_num = owned_quantities[i] + rand.nextInt((int)Math.ceil(total_dice_count/6.0));
				if(face == i && rand.nextInt(2) == 1) { //50% chance of taking advantage of the player's bet
					decision.dice_num += quantity + rand.nextInt(total_dice_count/6);
					//Add the number of dice the player claimed +/- a random number
				}
				return decision;
			}
		}

		//The AI doesn't have good information on whether the call is true or not. Take a shot in the dark.
		if(rand.nextInt(8) != 0) {
			decision.call = true;
			decision.dice_face = Math.max(max_face,face);
			decision.dice_num = Math.min(Math.max(max_quantity,quantity+1),total_dice_count);
			return decision;
		}
		else {
			decision.call = false;
			return decision;
		}
	}


	/**
	 * Generates a starting move for the AI opponent.
	 *
	 * @param An array of the AI's dice (ONLY the AI's Dice).
	 * @param The total number of dice in the game
	 */
	public AIDecision Start(int[] AIDice, int total_dice_count) {
		Random rand = new Random();
		if(rand.nextInt(9) != 0) {
			//This looks really hacky, but generates good, safe starting moves.
			return React(0,0,AIDice,total_dice_count);
		}
		else {
			//Make a more random guess every once in a while.
			AIDecision decision = new AIDecision();
			int[] owned_quantities = new int[7];
			int max_face = 1;
			int max_quantity = 0;
			for(int i = 0; i < owned_quantities.length; i++) {
				owned_quantities[i] = 0;
			}
			for(int i = 0; i < AIDice.length; i++) {
				owned_quantities[AIDice[i]] += 1;
			}
			for(int i = 0; i < owned_quantities.length; i++) {
				if(owned_quantities[i] >= max_quantity) {
					max_face = i;
					max_quantity = owned_quantities[i];
				}
			}
			decision.call = true;
			decision.dice_face = max_face;
			decision.dice_num = max_quantity+rand.nextInt(max_quantity);
			return decision;
		}
	}
}
