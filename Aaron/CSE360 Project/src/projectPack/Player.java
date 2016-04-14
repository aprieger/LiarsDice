package projectPack;

public class Player
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
}
