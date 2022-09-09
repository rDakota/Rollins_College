/**
 * Prints Mario-style stairs of arbitrary height
 * based on user given input for height of the staircase
 * 
 * @author rowanrichter
 */

import java.util.Scanner;

public class SuperMario {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the height: ");
		int height = input.nextInt();
		
		
		for (int i = 0; i < height; i++) {
			
			// The first line has (height - 1) spaces
			// The spaces are decremented by 1 each iteration of the main loop
			int numSpaces = (height -1) - i;
			
			// The first line always starts with 2 blocks
			// The stars are incremented by 1 each iteration of the main loop
			int numStars = 2 + i;
			
			// This inner loop prints the number of spaces on each line
			for (int sp = 0; sp < numSpaces; sp++) {
		    	// Prints the designated number of spaces on the same line 
				// based on numSpaces from the outer loop
		        System.out.print(" ");
		    }
		    
		    // This inner loop prints the number of blocks as stars 
		    // on the same line as the corresponding line in the other inner loop
		    for (int st = 0; st < numStars; st++) {
		    	// Prints the designated number of stars on the same line 
		    	// based on numStars from the outer loop
		        System.out.print("*");
		    }
		    
		    System.out.println();
		    // Print statement is used to go to to the next line after each iteration of the outer loop,
		    // meaning both inner loops have completed their iterations of spaces and stars
			
		}
		
		input.close();

	}

}