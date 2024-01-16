package pmaiamod4;

public class Player {
	private String name;
	private int points;
	
	public Player() {
		super();
	}

	public Player(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}

	public String toString() {
		return name + ":" + points +" point(s) ";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
	

}
