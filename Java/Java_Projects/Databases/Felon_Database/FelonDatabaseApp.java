/**
 * Felon Driver class
 * 
 * @author Rowan Richter , Gus Temple
 * @date 09/30/2022
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FelonDatabaseApp {
	
	// class data members
	public static String line;
	public static Scanner input;
	private static ArrayList<Felon> felons = new ArrayList<Felon>();
	
	
	/*
	 * Implements linear search to find Felon object
	 * provided a given dna string
	 */
	public static Felon findByDNA(String dna) {
		int index = 0;
		while (index < felons.size()) {
			if(felons.get(index).getDna().equals(dna)) {
				return felons.get(index);
			}
			else {
				index++;
			}
		}
		// return null if no match is found
		return null;
		
	}
	/*
	 * Prints out the name, id, gender and list of crimes for each felon in the database.
	 * utilizes Felon instance method printFelon 
	 */
	public static void printDatabase() {
		for (int i = 0; i < felons.size(); i++) {
			// print Felon object info 
			felons.get(i).printFelon();
		}
	}
	
	/*
	 * Print out the Felons of the required gender  
     * who have also committed that type of crime.
	 */
	public static void generateLineup(String crime, char gender) {
		int felIndex = 0;
		// while not at the end of the ArrayList
		while (felIndex < felons.size()) {
			// compares gender of Felon object to gender in the argument
			if (felons.get(felIndex).getGender() == gender) {
				// if correct gender then while go through second loop
				// which checks if specific crime in crimes ArrayList matches
				for (int i = 0; i < felons.get(felIndex).getCrimes().size(); i++) {
					// if Felon has the specified crime in their list of crimes 
					if (felons.get(felIndex).getCrimes().get(i).equals(crime)) {
						// print out this Felon
						felons.get(felIndex).printFelon();
					}
				}
			}
			// increment index
			felIndex++;
		}
		
	}
	
	/*
	 * Populate the database with the felons
	 * Store the felon data in the database 
	 * by creating new Felon objects and putting them into
	 * the class variable -> felons arraylist
	 */
	public static void populateDatabase(int numEntries) {
		for(int i = 0; i < numEntries; i++) {
			line = input.nextLine();
			String[] data = line.split(" "); //splits on the blank space

			String name = data[0];
			String id = data[1];
			char gender = data[2].charAt(0);
            String DNA = data[3]; 
            felons.add(i, new Felon(name, id));
            felons.get(i).setDna(DNA); 
            felons.get(i).setGender(gender);
            
            felons.get(i).setCrimes(new ArrayList<String>());
            
            //add to the arraylist of crimes 
    		for (int j = 4; j < data.length; j++) {
    			felons.get(i).getCrimes().add(data[j]);
    		}
    		
		}
	}
	
	/*
	 * The MAIN METHOD ===> driver method 
	 */
	public static void main(String[] args) {
		
        
	    try {
	    	File f = new File("felons.txt");
	    	input = new Scanner(f); 

	    	line = input.nextLine();
			int numFelons = Integer.parseInt(line);
	    	populateDatabase(numFelons);
        
	    	System.out.println("The Winter Park Felons Database"); 
	    	System.out.println("-------------------------------------------\n");
	        //processes list of database requests
	    	int r = Integer.parseInt(input.nextLine());   //numbers of database requests to follow
	        
	        for(int i = 0; i < r; i++) {
	        	
	        	String request = input.next();
    	
    		
	        	// P request
	        	if (request.equals("P")) {
	        		System.out.println("Felons in the Database");
	        		System.out.println("-------------------------------------------");
	        		printDatabase();
	        		System.out.println("-------------------------------------------\n");
	        	}
    		
	        	// F request
	        	if (request.equals("F")) {
	        		String dna = input.next(); // get dna
	        		Felon culprit = findByDNA(dna);
	        		if (culprit != null) {
	        			System.out.println("A match has been found for DNA: \'" + dna + "\'");
	        			culprit.printFelon();
	        		} else {
	        			System.out.println("No matches were found for DNA: \'" + dna + "\'");

	        		}
	        		System.out.println();
	        	}
    		
	        	// L request
	        	if (request.equals("L")) {
	        		String crime = input.next();
	        		char gender = input.next().charAt(0);
	        		// ternary operator used because in the system
	        		// there is only male and female genders
	        		String sex = (gender == 'M') ? "male" : "female";
	        		System.out.println("\nLineup of " + sex + " "  + crime + " suspects");
	        		System.out.println("-------------------------------------------");
	        		generateLineup(crime, gender);
	        		System.out.println("-------------------------------------------\n\n");
	        	}
    	
	        }
	        input.close(); //close the Scanner
	    }
    	
	    // Catches the file opening errors and displays the issue
	    catch (FileNotFoundException e) {
	        System.out.println("Error");
	        e.printStackTrace();  
	    }
    	

    }
	

}