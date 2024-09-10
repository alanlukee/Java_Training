package Gaming_System;

public class ScoreCalculator {
	
	double arcadeMult = 1.2;
	double strategyMult= 1.5;
	double puzzleMult = 1.3;
	double lowMult = 1.0;
	double medMult = 1.5;
	double hardMult = 2.0;
	//static final int baseValue = 100;
	static final double powerUpBonus = 0.05;

	
	public double calculateScore(String gameType ,String gameDifficulty) {
		double gamebaseScore = 0;
		
		if(gameType.equalsIgnoreCase("arcadegame")) {
			Game arcade = new ArcadeGame(gameType);
			gamebaseScore = arcade.getBaseScore();
		}
		else if(gameType.equalsIgnoreCase("puzzlegame")) {
			Game puzzle = new PuzzleGame(gameType);
			gamebaseScore = puzzle.getBaseScore();

		}
		else if(gameType.equalsIgnoreCase("strategygame")) {
			Game strategy = new StrategyGame(gameType);
			gamebaseScore = strategy.getBaseScore();

		}
		
		double baseScore = 0;
		if(gameType.equalsIgnoreCase("arcadegame")) {
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = arcadeMult * lowMult* gamebaseScore;
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = arcadeMult * medMult* gamebaseScore;
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = arcadeMult * hardMult*gamebaseScore;
			}
			else {
				System.out.println("invalid");
			}

		}
		else if(gameType.equalsIgnoreCase("puzzlegame")) {
			
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = puzzleMult * lowMult* gamebaseScore;
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = puzzleMult * medMult* gamebaseScore;
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = puzzleMult * hardMult* gamebaseScore;
			}
			else {
				System.out.println("invalid");
			}
			
		}
		else if (gameType.equalsIgnoreCase("strategygame")) {
			
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = strategyMult * lowMult* gamebaseScore;
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = strategyMult * medMult* gamebaseScore;
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = strategyMult * hardMult* gamebaseScore;
			}
			else {
				System.out.println("invalid");
			}
		}
		else {
			System.out.println("invalid");
		}
		
		return baseScore;
		
	}
	//
	public double calculateScore(String gameType ,String gameDifficulty,double playerPerformance ) {
		
		double gamebaseScore = 0;
		
		if(gameType.equalsIgnoreCase("arcadegame")) {
			Game arcade = new ArcadeGame(gameType);
			gamebaseScore = arcade.getBaseScore();
		}
		else if(gameType.equalsIgnoreCase("puzzlegame")) {
			Game puzzle = new PuzzleGame(gameType);
			gamebaseScore = puzzle.getBaseScore();

		}
		else if(gameType.equalsIgnoreCase("strategygame")) {
			Game strategy = new StrategyGame(gameType);
			gamebaseScore = strategy.getBaseScore();

		}
		
		double baseScore = 0;
		if(gameType.equalsIgnoreCase("arcadegame")) {
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = arcadeMult * lowMult* gamebaseScore *(playerPerformance/10);
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = arcadeMult * medMult* gamebaseScore*(playerPerformance/10);
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = arcadeMult * hardMult* gamebaseScore*(playerPerformance/10);
			}
			else {
				System.out.println("invalid");
			}

		}
		else if(gameType.equalsIgnoreCase("puzzlegame")) {
			
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = puzzleMult * lowMult* gamebaseScore*(playerPerformance/10);
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = puzzleMult * medMult* gamebaseScore*(playerPerformance/10);
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = puzzleMult * hardMult* gamebaseScore*(playerPerformance/10);
			}
			else {
				System.out.println("invalid");
			}
			
		}
		else if (gameType.equalsIgnoreCase("strategygame")) {
			
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = strategyMult * lowMult* gamebaseScore*(playerPerformance/10);
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = strategyMult * medMult* gamebaseScore*(playerPerformance/10);
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = strategyMult * hardMult* gamebaseScore*(playerPerformance/10);
			}
			else {
				System.out.println("invalid");
			}
		}
		else {
			System.out.println("invalid");
		}
		
		return baseScore;
		
	}
	public double calculateScore(String gameType ,String gameDifficulty,double playerPerformance ,int powerUpsUsed) {
		
		
		
		double baseScore = 0;
		if(gameType.equalsIgnoreCase("arcadegame")) {
			if(gameDifficulty.equalsIgnoreCase("low")) {
				
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else {
				System.out.println("invalid");
			}

		}
		else if(gameType.equalsIgnoreCase("puzzlegame")) {
			
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else {
				System.out.println("invalid");
			}
			
		}
		else if (gameType.equalsIgnoreCase("strategygame")) {
			
			if(gameDifficulty.equalsIgnoreCase("low")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else if(gameDifficulty.equalsIgnoreCase("medium")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else if(gameDifficulty.equalsIgnoreCase("hard")) {
				baseScore = calculateScore(gameType, gameDifficulty, playerPerformance)*(1+(powerUpsUsed*powerUpBonus));
			}
			else {
				System.out.println("invalid");
			}
		}
		else {
			System.out.println("invalid");
		}
		
		return baseScore;
		
	}

}
