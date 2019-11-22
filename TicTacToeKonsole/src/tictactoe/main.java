package tictactoe;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);  // col, row im Konsole eingeben
		
		TicTacToe game = new TicTacToe();
		game.initializeBoard();
		System.out.println("Spiel Tic-Tac-Toe! \n");

		do {
		game.printBoard();
		int row;
		int col;
				do {
			        System.out.println("\nPlayer " + game.getCurrentPlayerMark() + ", die Wert für ROW eingeben: ");
			         row = scan.nextInt();
			         if (row>2) {
			        	 System.out.println(" Zahl von 0 bis 2 bitte eingeben ");
			        	 row = scan.nextInt();
					}
			        System.out.println("\nPlayer " + game.getCurrentPlayerMark() + ", die Wert für COL eingeben: ");
			         col = scan.nextInt();
			         if (col>2) {
			        	 System.out.println(" Zahl von 0 bis 2 bitte eingeben");
			        	 col = scan.nextInt();
			         }

				} while( !game.placeMark(row, col));
				
				game.changePlayer();
				
				
		}
		while (!game.checkForWin() && !game.isBoardFull() );
		if (game.isBoardFull() && !game.checkForWin() ) {
		
			System.out.println("Kein Gewinner !! ");
//			System.exit(0);
			
		}	else {
//			System.out.println("current: ");
			game.printBoard();
			game.changePlayer();
			System.out.println();
			System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " hat gewonnen ! ");
//			System.exit(0);
		}
		
		
	}  // end of main
	
}
