package Tic_Tac_Toe;

import java.util.Scanner;

public class Game {

	private GameBoard board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	
	
	Game(String p1_name, String p2_name){
		
		this.player1 = new Player(p1_name,'X');
		this.player2 = new Player(p2_name,'O');
		
		currentPlayer = player2;
		
	}
	
	public Player changeCurrentPlayer() {
		if(currentPlayer==player1) {
			
			currentPlayer = player2;
		}
		
		else {
			currentPlayer = player1;
			

		}
		return currentPlayer;
	}
	
	public void startGame() {
		
			try (Scanner scan = new Scanner(System.in)) {
				
				for(int i =1;i<=9;i++) {
					int move;
					
					Player cp = changeCurrentPlayer();
					System.out.println(cp.getName()+"'s turn - Symbol: "+cp.getSymbol());
					GameBoard.printGameBoard();
					
					//ask p1 to make a move((1-9)
					//if already occupied..ask aagain(while loop)...
					
					boolean moveCheck = true;
					
					while (moveCheck) {
						System.out.println(cp.getName() + ", please make your move(1-9)");
						move = scan.nextInt();
						scan.nextLine();
						if(GameBoard.checkMove(move)==true) {
							int[] arr = getCoordinates(move);
							GameBoard.gameboard[arr[0]][arr[1]] = cp.getSymbol();
							GameBoard.printGameBoard();
							moveCheck = false;
						}
						else {
							System.out.println("positon already occupied");
						}
						
					}
					boolean winCheck = GameBoard.checkWinner(GameBoard.gameboard);

					if(winCheck ==true) {
						System.out.println(cp.getName()+" won");
						System.exit(0);
					}

					
					//Gameboard.checkOccupied();
					//after putting...call next fn to check winner(boolean)...(arg is gameboard).
					//if winning..print gameboard and exit..
					
					//GameBoard.printGameBoard();

				}
			}
		
			System.out.println("match drawn, gg");
		}
	

	
	public int[] getCoordinates(int move) {
		
		int [] coord = new int[2];
		
		if(move==1) {
			coord[0] = 0;
			coord[1] = 0;
		}
		if(move==2) {
			coord[0] = 0;
			coord[1] = 1;
		}
		if(move==3) {
			coord[0] = 0;
			coord[1] = 2;
		}
		if(move==4) {
			coord[0] = 1;
			coord[1] = 0;
		}
		if(move==5) {
			coord[0] = 1;
			coord[1] = 1;
		}
		if(move==6) {
			coord[0] = 1;
			coord[1] = 2;
		}
		if(move==7) {
			coord[0] = 2;
			coord[1] = 0;
		}
		if(move==8) {
			coord[0] = 2;
			coord[1] = 1;
		}
		if(move==9) {
			coord[0] = 2;
			coord[1] = 2;
		}
		
		return coord;
		
	}
	

	
	public GameBoard getBoard() {
		return board;
	}
	public void setBoard(GameBoard board) {
		this.board = board;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	
}
