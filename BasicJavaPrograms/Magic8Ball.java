/**
 * The Magic Eight Ball knows your future
 * 
 * Illustrate making multi-part choices and random choices
 * 
 * Prompts the user for a question and 
 * 
 * returns one of 10 random fortunes each time it's run
 * 
 * @author rowanrichter
 * CMS 121
 */

import java.util.Scanner;

public class Magic8Ball {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Profess your Question!");
		
		// Allow for question input 
		// Produces warning bc the String myQuestion is not used later on
		String myQuestion = input.next();
		
		// Generates random value that is uniformly distributed in [0, 1)
		double r = Math.random();
		
		// Use the value r to select from among three choices
		// Divide the interval 0-1 into three equal pieces
		// Can create as many else if blocks as desired and end with single else case
		// Always use the braces!!!
		// r is separated into 10 intervals for the 10 different cases
		
		if (r < .1) {
			System.out.println("It is certain.");
			
		} else if (r >= .1 && r < .2) {
			System.out.println("It is decidedly so.");
			
		} else if (r >= .2 && r < .3) {
			System.out.println("Signs point to yes.");
			
		} else if (r >= .3 && r < .4) {
			System.out.println("Reply hazy, try again.");
		
		} else if (r >= .4 && r < .5) {
			System.out.println("Ask again later.");
			
		} else if (r >= .5 && r < .6) {
			System.out.println("Better not tell you now.");
			
		} else if (r >= .6 && r < .7) {
			System.out.println("Concentrate and ask again.");
			
		} else if (r >= .7 && r < .8) {
			System.out.println("Don't count on it.");
			
		} else if (r >= .8 && r < .9) {
			System.out.println("My reply is no.");
		
		} else {
			System.out.println("My sources say no.");
		}
		
		input.close();
		
	}

}
