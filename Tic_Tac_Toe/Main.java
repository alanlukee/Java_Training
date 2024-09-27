package Tic_Tac_Toe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("  ");
		String player_1;
		String player_2;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter player-1 name: ");
		player_1 = scan.nextLine();
		System.out.println("Enter player-2 name: ");
		player_2 = scan.nextLine();

	
		Game tictactoe = new Game(player_1,player_2);
		
		GameBoard board = new GameBoard();

		tictactoe.startGame();
		


	}

}
