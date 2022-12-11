/**
 * Driver class for Linked
 * List Cipher Program
 * @authors Rowan Richter and Gus Temple
 * @date 11/17/2022
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decryptor {
	
	// class data members
	public static Scanner input;
	public static Llist myList = new Llist();
	
    /*
     * Method that prints out the decrypted message:
     * 
     * 1. Iterate through the linked List
     * 2. And call printNode method to print its elements
	 */
	public static void printMessage(NodePointer temp) {
        while(temp != null) { // keep iterating until you reach the end
        	// print the char letter data of this node using 
        	// the printNode instance method of the NodePointer class
        	temp.printNode();
        	// increment to next node in the list
        	temp = temp.getNext();
        }
	}

	/*
	 * The MAIN METHOD ===> driver method 
	 */
	public static void main(String[] args) {
		
		/*
		 * Read the texts from a test file called texts.txt
		 */
        
        try {
        	// I would use another text file to test if it still worked and it did
	    	File f = new File("texts.txt");
	    	input = new Scanner(f);

        	/*
        	 * Decrypt each text in turn
        	 * 
        	 * Each letter is added to the linked list alternating between:
        	 * 
        	 * 1. adding to the tail of the list
        	 * 2. Followed by adding to the front of the list
        	 */
        
        	// iterate over every line
        	while (input.hasNextLine()) {
        		// go through each line
        		String line = input.nextLine();
        		String[] texts = line.split("[*]");
        	
        		// iterate through each line

        		for (int i = 0; i < texts.length; i++) {	
   
        			for (int j = 0; j < texts[i].length(); j++) {
        				// Alternate between adding to the back
        				// front and the back of the list
        			
        				if( j % 2 == 0) { // on even indexed chars
        					myList.addAtTail(new NodePointer(texts[i].charAt(j)));
        					//System.out.println(texts[i].charAt(j));
        				
        				} else { // (j % 2 != 0) on odd indexed chars
        					myList.addAtStart(new NodePointer(texts[i].charAt(j)));
        					//System.out.println(texts[i].charAt(j));	
        				}
        		
        			}
        			// add space at the end of each word[i] in texts
        			// since split by '*' then replace with a space
        		
        			// will not add a space if you are at the end of the line and there does not exist a star
        			// will only add a space if a star exists once
        			// you have processed all of a string in texts   
        			if (i != (texts.length - 1) || (line.length() >= 1) && line.charAt(line.length() - 1) == '*') {
        			myList.addAtTail(new NodePointer(' '));
        			}
        		}
        		// add newline at the end of each line
        		// wont print the newline if there is not a nextLine to process
        		if (input.hasNext())
        			myList.addAtTail(new NodePointer('\n'));
        	
        	}
        	
        	// Call class method with the list head as a parameter 
        	// to print the whole message
        	printMessage(myList.getHead());
        	

        
        // Catches the file opening errors and displays the issue
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

	}

}
