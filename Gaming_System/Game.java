package Gaming_System;

public abstract class Game {
	
	String gameType;
	
	Game( String gameType){
		this.gameType = gameType;
	}
	
	public abstract double getBaseScore();

}
