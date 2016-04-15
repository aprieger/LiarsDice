package projectPack;

public class Player implements Comparable<Player>
{
	private String name;
	private int wins;
	private int losses;
	private int points;
	Player next;

	public Player(){
	}

	public void setName(String nameSet){
		name = nameSet;
	}

	public String getName(){
		return name;
	}

	public void setWins(int winsSet){
		wins = winsSet;
	}

	public int getWins(){
		return wins;
	}

	public void setLosses(int lossesSet){
		losses = lossesSet;
	}

	public int getLosses(){
		return losses;
	}

	public void setPoints(int pointsSet){
		points = pointsSet;
	}

	public int getPoints(){
		return points;
	}

	/**
	 * Standard compareTo function.
	 * Allows builtin sorting algorithms to sort an array of players.
	 * Also allows us to easily check if players are equal.
	 *
	 * @param The other player object this object is being compared to.
	 * @return A standard compareTo value based on a player's total points.
	 */
	public int compareTo(Player other) {
		int compare;
		if(getPoints() > other.getPoints()) {
			compare = 1;
		}
		else if (getPoints() < other.getPoints()) {
			compare = -1;
		}
		else {
			compare = 0;
		}
		return compare;
	}
}
