package Tic_Tac_Toe;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
	
	public static char[][]gameboard = new char [3][3];
	public static List<Integer> moves = new ArrayList<>();
	
	GameBoard(){
		
		for(int i =0;i<3;i++) {
			for (int j = 0;j<3;j++) {
				gameboard[i][j] = ' ';
			}
		}
	}
	
	public static void printGameBoard() {
		
		System.out.println("             ");
		System.out.println("  " +gameboard[0][0] + " | " + gameboard[0][1] + " | " + gameboard[0][2] + " ");
		System.out.println(" ---+---+---");
		System.out.println("  " + gameboard[1][0] + " | " + gameboard[1][1] + " | " + gameboard[1][2] + " ");
		System.out.println(" ---+---+---");
		System.out.println("  " + gameboard[2][0] + " | " + gameboard[2][1] + " | " + gameboard[2][2] + " ");
		System.out.println("             ");

	}
	
	public boolean isFull() {

		boolean checkFull = false;
		
		for(int i =0;i<3;i++) {
			for (int j = 0;j<3;j++) {
				if(gameboard[i][j]==' ') {
					checkFull = false;
					return checkFull;
				}
			}
		}
		return checkFull;
	}
	
	public static boolean checkMove(int move) {
		
		if(moves.contains(move)) {
			return false;
		}
		else {
			moves.add(move);
			return true;
		}

	}

	public static boolean checkWinner(char[][]board) {
		
		boolean winner = false;
		
		if(board[0][0]==board[0][1] && board[0][1] ==board[0][2] &&board[0][0]!=' ') {
			winner = true;
		}
		else if(board[1][0]==board[1][1] && board[1][1] ==board[1][2] && board[1][0]!=' ') {
			winner = true;
		}
		else if(board[2][0]==board[2][1] && board[2][1] ==board[2][2] && board[2][0]!=' ') {
			winner = true;
		}
		
		
		else if(board[0][0]==board[1][0] && board[1][0] ==board[2][0] && board[0][0]!=' ') {
			winner = true;
		}
		else if(board[0][1]==board[1][1] && board[1][1] ==board[2][1] && board[0][1]!=' ') {
			winner = true;
		}
		else if(board[0][2]==board[1][2] && board[1][2] ==board[2][2] && board[0][2]!=' ') {
			winner = true;
		}
		
		else if(board[0][0]==board[1][1] && board[1][1] ==board[2][2] && board[0][0]!=' ') {
			winner = true;
		}
		else if(board[0][2]==board[1][1] && board[1][1] ==board[2][0] && board[0][2]!=' ') {
			winner = true;
		}

		return winner;
		
	}
	



}
