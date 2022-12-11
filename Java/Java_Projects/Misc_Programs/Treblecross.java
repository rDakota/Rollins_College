/**
 * Treblecross game/ 1-D tic-tac-toe
 * 
 * @author rowanrichter
 */

import java.util.Arrays;
import java.util.Scanner;

public class Treblecross {

    public static void main(String[] args) {
    
        // Create a Scanner and get an input value of n
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter a value of n: ");
        int n = input.nextInt();
        
        
        // If n is negative, quit the program immediately
        if (n < 0) {
        	System.out.println("Invalid input: Must be greater than zero");
        	return;
        }
        
        
        // Create a 1-D array of n char
        char[] board = new char[n];
        
        
        // Use a variable to keep track of the current player
        int player = 1;
        
        
        // Main game loop
        boolean playing = true;
        while (playing) {
        
            // Print the current board. Tip: use Arrays.toString()
        	System.out.println(Arrays.toString(board));
            
            
            // Ask the current player to choose an open position
            System.out.println("Player " + player + ": Chose and open position as an index of the board: ");
        
            
            // Read the player's move using the Scanner
            int move = input.nextInt();
            
            
            // If that square is occupied, print an error message then use continue to repeat the loop
            if (board[move] != 0) {
            	System.out.println("That space is already occupied with an 'X'.");
            	continue;
            } else { // Mark the position with an 'X'
            	board[move] = 'X';
            }
            
           
            // Check if there is now a line of three on the board
            //
            // Tip: use a for loop
            //
            // On each iteration, check if positions i, i + 1, and i + 2 are all 'X'.
            
            
            // Minus 2 to account for winning condition checker that checks i, i + 1, and i + 2
            //
            // The loop increments by 1 from i = 0, all the way until i is no longer less than n - 2
            // We only want to loop up until (n - 2) because we are going to index 
            // up to board[i +2] for the checking condition
            //
            // The last i we will loop through is (n - 3), so the last index our board[i + 2] will
            // check is board[n - 1], which is the last index of an array of length n
            for (int i = 0; i < (n - 2); i++) { 
            	// If a group of three exists, declare the current player the winner and set playing = false
            	if ( (board[i] == 'X') && (board[i + 1] == 'X') && (board[i + 2] == 'X')) {
            		System.out.println(Arrays.toString(board));
    				System.out.println("Player " + player + " is the winner!!");
    				playing = false;
    			}
    		}
            
            // In all other cases, switch to the other player
            // Here's a clever way of switching using the mod operator
            // 1 % 2 + 1 ---> 2
            // 2 % 2 + 1 ---> 1
            player = (player % 2) + 1;   
            
        }
        
        input.close();
    
    }

}