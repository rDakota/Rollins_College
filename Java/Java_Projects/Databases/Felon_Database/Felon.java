/**
 * Felon class 
 * 
 * Data members: 
 * Strings name, id, dna 
 * char F or M representing gender
 * an ArrayList of Strings to store the list of crimes that felon has committed 
 * 
 * Constructor method:
 * parameters:
 * String felonName, string felodID
 * 
 * Instance methods:
 * all getters and setters
 * printFelon that prints out the name, ID, gender, and list of crimes of the felon 
 * 
 * @author Rowan Richter and Gus Temple
 * @date 09/30/2022
 */

import java.util.ArrayList;

public class Felon {
	
	//private data members: String name, ID, DNA; Character for gender
	//and ArrayList of Strings to store the list of crimes that felon has committed
	private String name, id, dna; 
	private char gender;         //F or M to represent gender
	private ArrayList<String> crimes = new ArrayList<String>(); 
	
	// Constructor with felonName and felonID parameters
	public Felon(String felonName, String felonID) {
		this.name = felonName;
		this.id = felonID;
	}
	
	// ---------------------------------
	// GETTER METHODS ====> access data members of Felon object
	
	public String getName() {
		return name; 
	}
	
	public String getId() {
		return id; 
	}
	
	public String getDna() {
		return dna; 
	}
	
	public char getGender() {
		return gender; 
	}
	
	public ArrayList<String> getCrimes(){
		return crimes; 
	}
	
	// ---------------------------------
	// SETTER METHODS ====> mutate data members of Felon object
	
	public void setName(String newName) {
		this.name = newName; 
	}
	
	public void setId(String newId) {
		this.id = newId; 
	}
	
	public void setDna(String newDna) {
		this.dna = newDna; 
	}
	
	public void setGender(char newGender) {
		this.gender = newGender; 
	}
	
	public void setCrimes(ArrayList<String> crimes) {
		this.crimes = crimes;
	}
	
	// ---------------------------------
	// PRINT METHOD ====> prints out the name, id, gender and list of crimes of felon

	public void printFelon() {
		System.out.print("Name: " + this.name + " ID: " + this.id +
				" Gender: " + this.gender + " Crimes: ");
		int i = 0;
		while (i < this.crimes.size() - 1) {
			// non last crimes
			System.out.print(this.crimes.get(i) + ", ");
			i++;
		}
		// last crime
		System.out.print(this.crimes.get(i) + "\n");
	}
	
	
	
}