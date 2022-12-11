/** 
* Rock, paper, scissors
* Plays a single round of human vs. computer
*
* @author rowanrichter
* CMS 121
*/

import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
    	
        // 1. Declare final variables representing the three moves
    	final int ROCK = 1;
    	final int PAPER = 2;
    	final int SCISSORS = 3;
    
        // 2. Create a new Scanner
    	Scanner scan = new Scanner(System.in);
    
        // 3. Print the welcome message and list the three moves
    	System.out.println("Welcome to Rock, Paper, Scissors.");
    	System.out.println("1. Rock");
    	System.out.println("2. Paper");
    	System.out.println("3. Scissors");
    	
    	// 4. Read the user's move as an int
    	System.out.println("Select your move: ");
    	int playerMove = scan.nextInt();
    	
        // 5. If the move is not 1, 2, or 3, exit the program with return
    	if (playerMove < 1 || playerMove > 3) {
    	    System.out.println("That's not a valid move, meatbag.");
    	    return;
    	    
    	}
    	
        // 6. Randomly generate the CPU's move...there are three possible
    	// if - else if - else block for the three choices of 
    	// Rock, Paper, or Scissors
    	int cpuMove;
    	double r = Math.random();
    	
    	if (r < .3333) {
            cpuMove = ROCK;
        } else if (r < .6666) {
            cpuMove = PAPER;
        } else { // Block for SCISSORS
            cpuMove = SCISSORS;
        }
    
        // 7. Print the CPU's move
    	if (cpuMove == ROCK) {
    	    System.out.println("I choose Rock.");
    	} else if (cpuMove == PAPER) {
    		System.out.println("I choose Paper.");
    	} else { // Block for SCISSORS
    		System.out.println("I choose Scissors.");
    	}
    	
        // 8. Determine the outcome and print an appropriate message
    	if (playerMove == cpuMove) {
    	    System.out.println("Draw! I'll get you next time, human.");
    	    
    	// Situations that are not a draw
    	// playMove != cpuMove
    	} else {
    		
    		// Player Loses 
            if (playerMove == ROCK && cpuMove == PAPER) {
            	System.out.println("Paper covers Rock!");
            	System.out.println("You lose!...Humans...so soft...so weak.");
            } else if (playerMove == PAPER && cpuMove == SCISSORS) {
            	System.out.println("Scissors cuts Paper!");
            	System.out.println("You lose!...Humans...so soft...so weak.");
            } else if (playerMove == SCISSORS && cpuMove == ROCK) {
            	System.out.println("Rock crushes Scissors!");
            	System.out.println("You lose!...Humans...so soft...so weak.");
            		
            // Player Wins
            } else if (playerMove == ROCK && cpuMove == SCISSORS) {
            	System.out.println("Rock crushes Scissors!");
            	System.out.println("You won!...my failure...does not compute...");
            } else if (playerMove == SCISSORS && cpuMove == PAPER) {
            	System.out.println("Scissors cuts Paper!");
            	System.out.println("You won!...my failure...does not compute...");
            } else { // playerMove is PAPER and cpuMove is ROCK)
            	System.out.println("Paper covers Rock!");
            	System.out.println("You won!...my failure...does not compute...");
    		   
        	}
    	}
 
    	scan.close();

    }
  
}