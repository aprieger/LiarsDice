package Group4Package;

/**
 * Title: AIDecision
 * Description: Container structure for AIBrain's decision making
 * @author Nathaniel Martin
 *
 */
public class AIDecision {
	public boolean call; //A call of false means they believe the player is lying
						//This variable is ignored when they are starting the turn.

	public int dice_face; //The numbered face they are claiming
	public int dice_num; //The quantity of the face they are claiming
}
