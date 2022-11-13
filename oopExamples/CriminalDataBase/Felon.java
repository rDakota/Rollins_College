/**
 * Felon object class
 *  
 * @author Rowan Richter , Gus Temple
 * @date 09/30/2022
 */

import java.util.ArrayList;

public class Felon {
	private String name, id, dna;
	private char gender;
	private ArrayList<String> crimes;
	
	/*
	 * Felon Constructor with name and id parameters
	 */
	public Felon(String felonName, String felonID) {
		this.name = felonName;
		this.id = felonID;
	}
	
	// ---------------------------------
	// Getters ====>

	public String getName() {
		return this.name;
	}
	
	// ---------------------------------
	
	public String getId() {
		return this.id;
	}
	
	// ---------------------------------
	
	public String getDna() {
		return this.dna;
	}
	
	// ---------------------------------

	public Character getGender() {
		return this.gender;
	}
	
	// ---------------------------------
	
	public ArrayList<String> getCrimes() {
		return this.crimes;
	}
	
	// ---------------------------------
	// Setters ====>

	public void setName(String felonName) {
		this.name = felonName;
	}
	
	// ---------------------------------

	public void setId(String felonID) {
		this.id = felonID;
	}
	
	// ---------------------------------

	public void setDna(String dna) {
		this.dna = dna;
	}
	
	// ---------------------------------

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	// ---------------------------------

	public void setCrimes(ArrayList<String> crimes) {
		this.crimes = crimes;
	}
	
	// ---------------------------------
	// Print Felon ====>
	
	/*
	 * printFelon that prints out the name, id, gender
	 * and list of crimes of the felon
	 */
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
		
		// Original Version
//		System.out.println("Name: " + this.name + " ID: " + this.id +
//				" Gender: " + this.gender + " Crimes: " + 
//				this.crimes.toString().replace("[","").replace("]",""));
				// above returns crimes to String and removes "[" and "]"
	}
	
	
}
