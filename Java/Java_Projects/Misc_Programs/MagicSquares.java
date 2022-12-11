/**
 * Magic Squares Siamese method demonstration
 * 
 * @author rowanrichter
 */

import java.util.Scanner;
 
public class MagicSquares {

    public static void main(String[] args) {

        // Create a Scanner and read n from the terminal
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a value of n: ");
        int n = input.nextInt();
        
        
        // n must be odd and positive; if it isn't, quit immediately
        // Use return to end program immediately
        if ((n % 2 == 0) || n < 0) {
        	System.out.println("Invalid Input: Must be odd and greater than zero");
        	return;
        }
        
        // Initialize an n x n array of int
        int[][] square = new int[n][n];
           
        // Start in the top row, center column
        int row = 0;
        int col = n / 2;  // Integer division yields the correct column
        
        
        // Place the values from 1 to n ^ 2
        for (int i = 1; i <= n * n; i++) {
        	        
            // Place value i at square[row][col]
        	square[row][col] = i;
        	//System.out.println(i);
           
        	// Save the initial row and col before the shift for later use 
        	int oldRow = row; 
            int oldCol = col; 
            
            // Move up and to the right in the matrix
            // Try to move up and right, wrapping around if you need to
        	row -= 1;
        	if (row < 0) {
        		row = n - 1;
        	}
            
        	col += 1;
        	if (col > n - 1) {
        		col = 0;
        	}
            
            // If that position is occupied, go back to the old location and move down instead
            if (square[row][col] != 0) { 
            	// Reset to the old original values of row and col
        		row = oldRow;
        		col = oldCol;
        		
        		// Move down one square, wrapping around the bottom if I need to
        		row = row + 1;
            	if (row > n - 1) {
            		row = 0;
            	}
            }
     
        }
        
        // Print the final magic square
        // Strategy: outer loop to iterate over the rows, inner loop for the columns
        // 
     	// square[r].length is the length of the inner array for row r, thus the columns
     	// square.length is always the number of rows
        for (int r = 0; r < square.length; r++) {
            for (int c = 0; c < square.length; c++) {
                System.out.print(square[r][c] + "\t");
            }
            System.out.println();
        }
       
        input.close();
        
    }
}