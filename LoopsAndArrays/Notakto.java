/**
 * NOTAKTO
 *
 * Notakto is like tic-tac-toe but uses only X's. The first player who completes a line of X's is the LOSER.
 *
 * @author CMS 121
 *
 */

import java.util.Scanner;

public class Notakto {

	/**
	 * Print the board
	 * 
	 * @param  board  the 3x3 Notakto board
	 */
	public static void print(boolean[][] board) {
		for (int r = 0; r < board.length; r++) {
	        for (int c = 0; c < board[r].length; c++) {
	        	
	        	// Initialize the space before the number or 
	        	// the "X" in each block 
		    	System.out.print(" ");
		    	
		    	// if the value at this position is true, then print an "X"
	            if (board[r][c]) {
	                System.out.print("X");
	                
	            // otherwise print the correct number
	            } else {
	                System.out.print((r * 3 + c + 1));
	            } 
	            
	            // Only print the line on the inside of the numbers
	            if (c < 2) { 
	            	System.out.print(" |");
	            } 
	            
	        }
	        // Move to new line and add the proper format
	        System.out.println();
	        if (r < 2) {
	        	System.out.println("---|---|---");
	        }
	    }

	}


	/**
	* Convert a position 1-9 into the corresponding row number
	*
	* @param  position   the user's choice, which must be 1-9
	* @return            the row associated with that position
	*/
	public static int convertToRow(int position) {
		// Directly calculating the row using integer division
		int row = (position - 1) / 3;
		return row;
	}
	
	/**
	 * Convert a position 1-9 into the corresponding column number
	 *
	 * @param  position   the user's choice, which must be 1-9
	 * @return            the column associated with that position
	 */
	public static int convertToCol(int position) {
		// The column can be calculated using a similar method 
		// The position can be taken using modulo.
		// (1 - 1) % 3 == 0
		// (2 - 1) % 3 == 1
		// (3 - 1) % 3 == 2
		int col = (position - 1) % 3;
		return col;
	     
	}
	
	/**
	 * Check for three X's in any row
	 * 
	 * @param  board  the 3x3 boolean game board
	 * 
	 * @return true if the board contains three X's in any row, false otherwise
	 */
	public static boolean checkRows(boolean[][] board) {
		// Loop over all of the rows
		for (int r = 0; r < board.length; r++) {
			
		    // return true if row r contains three true values
		    if (board[r][0] && board[r][1] && board[r][2]) {
			    return true;
		    }
		}
		
		// If we check all three rows but never return true, then return false
		//
		// This is the case where no row meets the winning condition
		return false;
	}
	
	/**
	 * Check for three X's in any column
	 * 
	 * @param board	  the 3x3 boolean game board
	 * @return	true if the board contains three X's in any column, false otherwise
	 */
	public static boolean checkCols(boolean[][] board) {
		for (int c = 0; c < board.length; c++) {
			
		    // return true if column c contains three true values
		    if (board[0][c] && board[1][c] && board[2][c]) {
			    return true;
		    }
		}
		
		// If we check all three rows but never return true, then return false
		//
		// This is the case where no row meets the winning condition
		return false;
	}
	
	/**
	 * Check for three X's in any diagonal
	 * 
	 * @param board 	the 3x3 boolean game board
	 * 
	 * @return	true if the board contains three X's in any diagonal, false otherwise
	 */
	public static boolean checkDiags(boolean[][] board) {
		// return true if diagonal from top left to bottom right
		// or
		// diagonal from top right to bottom left
		if ((board[0][0] && board[1][1] && board[2][2]) || (board[0][2] && board[1][1] && board[2][0])) {
			return true;
		}
		
		
		// If we check all three rows but never return true, then return false
		//
		// This is the case where no row meets the winning condition
		return false;
	}

	
	/**
	 * Main -- run the main game loop
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 3x3 grid of booleans
		boolean[][] board = new boolean[3][3];
		
		// Create one Scanner to use for all input
		Scanner input = new Scanner(System.in);

		// Use a variable to keep track of the current player
		int player = 1;
		
		// Main game loop
		boolean playing = true;
		
		while (playing) {
			
			// Print the game board
			print(board);
			
			// Read the player's move -- use a loop to force valid input
			//
			// The variable position will store a number 1-9 corresponding 
			// to the place the user picks
		    boolean readingInput = true;
		    int position;
		    
		    while (readingInput) {
		    	// print the prompt message for the correct player 
		    	System.out.println("Player " + player + ": Chose an open position: ");
				position = input.nextInt();
				
				// if invalid position then print error message 
				// and return to the top of the loop
				if (position < 1 || position > 9) {	
					System.out.println("That is not a valid position choice.");
					continue;
		        }
				
				// Update the board
				int row = convertToRow(position);
			    int col = convertToCol(position);
			    
			    // if this position on the board is false
			    // then that means we have not touched it yet 
			    // and it is safe to put an "X" on.
			    //
			    // We thus end the readingInput loop and
			    // assign this position as true so an X can 
			    // be placed on it from the print(board) method
			    if (board[row][col] == false) {
			    	readingInput = false;
			    	board[row][col] = true;
			    	
			    // if this position on the board is already true 
			    // it means that it already has an X on it and any 
			    // position input that goes on this already occupied 
			    // spot should cause this error message to print and
			    // for us the return to the top of the reading input loop
			    } else {
			        System.out.println("This spot is already taken.");
			        continue;
			    }

		    }

			// Check for three X's in any row, column, or diagonal
            if (checkRows(board) || checkCols(board) || checkDiags(board)) {
            	// print board again to show the final result
            	print(board);
            	// print losing message and winning message for the other player
            	System.out.println("Player " + player + " has LOST the game.\nPlayer " + ((player % 2) + 1) + " has WON." );
            	// terminate the main game loop
            	playing = false;
            
          
            } else {
            // Switch to the other player
            	player = (player % 2) + 1;
            }
		        
		    
		}	
		
		// Close the input Scanner at the end of the program
		input.close();
	}
	
}