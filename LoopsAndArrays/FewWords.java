/**
 * Prompts the user to enter a String until
 * the user types "nitwit", "blubber", "oddment", or "tweak"
 * 
 * @author rowanrichter
 */

import java.util.Scanner;

public class FewWords {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Declare boolean variable, notWord, as true
		boolean notWord = true;
	 
		while (notWord) {
			// The user is continually prompted to enter a word 
			// using the .next() method
			// while notWord is still assigned to true 
			System.out.println("Enter your word: ");
			String myWord = input.next();
			
			// The .equals() method is used to compare my word to any of these Dumbledore words
			// if the word input equals any of these words
			// then the variable notWord becomes false and the the while loop is terminated
			if ((myWord.equals("nitwit")) || (myWord.equals("blubber")) || (myWord.equals("oddment")) || (myWord.equals("tweak"))) {
				notWord = false;
				
		// Below was used to see if the the user had exited the while loop 
		// System.out.println("Done.");
				
			}
		}
		
		input.close();
		

		

	}

}
