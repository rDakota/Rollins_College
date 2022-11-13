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
	
	// class data member
	private static ArrayList<Felon> felons = new ArrayList<Felon>();
	
	/*
	 * Implements linear search to find Felon object
	 * provided a given dna string
	 */
	public static Felon findByDNA(String dna) {
		int index = 0;
		while (index < felons.size()) {
			if(felons.get(index).getDna().equals(dna)) {
				System.out.println("A match has been found");
				return felons.get(index);
			}
			else {
				index++;
			}
		}
		System.out.println("\nNo match was found");
		// return null if no match is found
		return null;
		
	}
	/*
	 * Prints out the name, id, gender and list of crimes for each felon in the database.
	 * utilizes Felon instance method printFelon 
	 */
	public static void printDatabase() {
		System.out.println("\nFelons in the Database");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < felons.size(); i++) {
			// print Felon object info 
			felons.get(i).printFelon();
		}
		System.out.println("-------------------------------------------\n");
	}
	
	/*
	 * Print out the Felons of the required gender  
     * who have also committed that type of crime.
	 */
	public static void generateLineup(String crime, char gender) {
		int felIndex = 0;
		System.out.println("\nLineup of " + crime + " suspects");
		System.out.println("-------------------------------------------");
		// while not at the end of the ArrayList
		while (felIndex < felons.size()) {
			// compares gender of Felon object to gender in the argument
			if (felons.get(felIndex).getGender().equals(gender)) {
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
		System.out.println("-------------------------------------------\n");
		
	}

	public static void main(String[] args) {
		
		
		Scanner input = null;
        
        try {
          input = new Scanner(new File("felons.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // loop to initialize the arrayList
    	// first value read is an integer that contains number of felons
    	int n = Integer.parseInt(input.nextLine());
        //need to move to next line
    	//input.next();
        
        	
    	//loop n times
    	//read each line as a string, then use a method to turn it into an array
    	for (int i = 0; i < n; i++) {
    		
    		//read a line
    		String line = input.nextLine();
    		
    		//split the line into an array
    		String[] data = line.split(" ");

    		/* for sanity sake
    		 * 
    		 * data[0] = felon name (string)
    		 * data[1] = felon id (string)
    		 * data[2] = felon gender (character)
    		 * data[3] = felon dna (string)
    		 * data[4] = crime (string)
    		 * data[4+] = more crimes
    		 */
    		
    		//make a new felon object and store it in the arrayList
    		felons.add(new Felon(data[0], data[1]));
    		
    		// update their gender
    		String g = data[2];
    		Character gender = g.charAt(0);
    		felons.get(i).setGender(gender);
    		
    		//update their dna
    		felons.get(i).setDna(data[3]);
    		
    		//need to initialize the arraylist
    		
    		felons.get(i).setCrimes(new ArrayList<String>());
    		
    		//need sub for loop to iterate over any extra crimes, since some ppl have more than 1
    		// loop needs to start at 4 cause the 4th index of data is the first crime to add to the list
    		
    		for (int j = 4; j < data.length; j++) {
    			felons.get(i).getCrimes().add(data[j]);
    		}
    		
    	}
    		
    	// at this point, all the data about felons should be added to the list
    	
    	//need the number of database requests
    	int r = Integer.parseInt(input.nextLine());
    	
    	for (int k = 0; k < r; k++) {
    		
    		String request = input.nextLine();
    		String[] requests = request.split(" ");
    		
    		// P request
    		if (requests[0].equals("P")) {
    			printDatabase();
    		}
    		
    		// F request
    		if (requests[0].equals("F")) {
    			Felon culprit = findByDNA(requests[1]);
    			if (culprit != null) {
        			culprit.printFelon();
    			}
    		}
    		
    		// L request
    		if (requests[0].equals("L")) {
    			generateLineup(requests[1], requests[2].charAt(0));
    		}
    	
    	}
    	

    }
	

}