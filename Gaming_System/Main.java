package Gaming_System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Hey Gamer!");
		System.out.println("Enter game type(ArcadeGame/PuzzleGame/StrategyGame):");
		String gameType = scan.nextLine();
		System.out.println("Enter game difficulty(low/medium/hard):");
		String gameDiff = scan.nextLine();
		System.out.println("Enter player performance(out of 10):");
		double playerPerf = scan.nextDouble();
		System.out.println("Enter number of power-ups used");
		int powerUps = scan.nextInt();
		
		ScoreCalculator calc = new ScoreCalculator();
		
		System.out.println("Gaming System");
		System.out.println("  ");
		System.out.println("Game type choosen: "+gameType);
		System.out.println("Game difficulty: "+gameDiff);
		System.out.println("Player perfomance: "+playerPerf+"/10");
		System.out.println("Powerups used: "+powerUps);
		
		if(playerPerf==0 && powerUps==0) {
			System.out.println("Final player score: "+calc.calculateScore(gameType, gameDiff));
		}
		else if(powerUps ==0) {
			System.out.println("Calculating score with perfomance bonus...");
			System.out.println("Final player score: "+calc.calculateScore(gameType, gameDiff,playerPerf));
			
		}
		else {
			System.out.println("Calculating score with perfomance bonus and power up bonus...");

			System.out.println("Final player score: "+calc.calculateScore(gameType, gameDiff,playerPerf,powerUps));

		}
	
		scan.close();
		

	}

}
