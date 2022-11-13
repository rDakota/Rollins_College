/**
 * Delicious Dessert class
 * @author rowanrichter
 * @date 9-15-2022
 */
public class Dessert {

	private String name;
	private double servingTemp; // temp is in fahrenheit
	private int calories;
	
	
	public Dessert(String n, double sTemp, int cal) {
		this.name = n;
		this.servingTemp = sTemp;
		this.calories = cal;
	}
	
	// Getters
	//
	// ---------------------------------

	public String getName() {
		return this.name;
	}
	
	// ---------------------------------
	
	public double getServingTemp() {
		return this.servingTemp;
	}
	
	// ---------------------------------
	
	public int getCalories() {
		return this.calories;
	}
	
	// Setters
	//
	// ---------------------------------

	public void setName(String n) {
		this.name = n;
	}
	
	// ---------------------------------

	public void setServingTemp(double sTemp) {
		this.servingTemp = sTemp;
	}
	
	// ---------------------------------

	public void setCalories(int cal) {
		this.calories = cal;
	}
	
	public String toStringDessert() {
		return this.name + " has a fahrenheit serving temperature of " 
				+ this.servingTemp + " and its calories per serving are "
				+ this.calories;
	}
}
