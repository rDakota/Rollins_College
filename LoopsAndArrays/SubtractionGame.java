/**
 * Simulation of the subtraction game
 * 
 * Also called Thai 21
 * @author rowanrichter
 */

import java.util.Scanner;

public class SubtractionGame {
	
	/**
     * Main
     */
	public static void main(String[] args) {
		
		boolean playing = true;  // Guard variable
        int stones = 21;
        int player = 1;
        

        // Initializes Scanner to read from the terminal
        Scanner input = new Scanner(System.in);
        
        // Main game loop
        while (playing) {
        
            System.out.println();
            System.out.println("Stones: " + stones);
            System.out.println("It's your turn, Player " + player + ".");
            System.out.println("Take 1, 2, or 3 stones from the pile.");
            
            
            // Uses nextInt() to get the player's move
            int playerMove = input.nextInt();
            // Below if block is true when EITHER:
            // playerMove is less than 1 or greater than 3
            // OR
            // playerMove is greater than the amount of remaining stones
            if ((playerMove < 1 || playerMove > 3) || (playerMove > stones)) {
            	System.out.println("Invalid stone pickup.");
            	continue;
            }
            	
            // Reduces the number of stones
            stones = stones - playerMove;
            
            // Checks for winning condition
            if (stones == 0) {
            	// If stones == 0, print a winning message and set playing = false;
            	System.out.println("Player " + player + " has won the subtraction game!");
            	playing = false;
            	
            // else, switch to the other player
            // When player one => switch to player two
            // and when player two => switch to player one
            } else { 
            	if (player == 1) {
            		player = 2;
            	} else { // player == 2
            		player = 1;
            	}
            	
            }
            
           
        }

	}

}
