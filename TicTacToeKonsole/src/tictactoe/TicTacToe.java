package tictactoe;

public class TicTacToe {

	private char[][] board;
	private char currentPlayerMark;
	
	public TicTacToe() {
		board = new char [3][3];
		currentPlayerMark = 'x';
		
	}

    public char getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }

    public void initializeBoard() {

        // Loop  rows
        for (int i = 0; i < 3; i++) {

        // Loop  columns
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

	
    public void printBoard() {
//        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            if ( i < 2) {
                System.out.println();
            }
        }
    }

    
    
	// is the board full or not
    public boolean isBoardFull() {
    	
    	boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    isFull = false;
                } 
             
            }
        }

        return isFull;

    }
	
    
	
    public  boolean checkRowsWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }
    
    
    private boolean checkColWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }
    
    
    private boolean checkDiagonalsWin() {
        return ( (checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
    
    
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ( (c1 != ' ') && (c1 == c2) && (c2 == c3) );
    }

    public boolean checkForWin() {
        return (checkRowsWin() || checkColWin() || checkDiagonalsWin());
    }

    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }

    public boolean placeMark(int row, int col) {

        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayerMark;
                    return true;
                } else {
                	System.out.println("fehler! versuch es nochmal ");
                }
            } else { System.out.println("fehler!, bitte zwischen 0 und 2 eingeben:"); }

        }  else { System.out.println("fehler!, bitte zwischen 0 und 2 eingeben:"); }
        
        return false  ;

    }


    
}
