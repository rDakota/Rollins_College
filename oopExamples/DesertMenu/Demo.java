/**
 * Driver class for Dessert
 * @author rowanrichter
 * @date 9-15-2022
 */

import java.util.ArrayList;

public class Demo {
	
	private static ArrayList<Dessert> dessertMenu = new ArrayList<Dessert>();

	public static void main(String[] args) {
		
		
		// Create ArrayList items
		Dessert chocoCake = new Dessert("Chocolate Cake", 70.0, 450);
		Dessert brown = new Dessert("Brownie", 100.5, 325);
		Dessert sund = new Dessert("Icecream Sundae", 0.0, 670);
		Dessert pop = new Dessert("Popsicle", -10.5, 215);
		Dessert Jelo = new Dessert("Jell-O", 40.3, 150);
		
		// add items to ArrayList
		dessertMenu.add(Jelo);
		dessertMenu.add(pop);
		dessertMenu.add(sund);
		dessertMenu.add(brown);
		dessertMenu.add(chocoCake);
		
		// Desired method call 1
		System.out.println("Desserts served cold:\n");
		printColdDesserts();
		
		System.out.println();
		
		// Desired method call 2
		System.out.println("There are " + countCal() + " desserts over 250 calories per serving");
		
		System.out.println();
		
		// Desired method call 3
		// print out the contents of the ArrayList
		printDesserts();
		
	}
	
	public static void printColdDesserts() {
		for (int i = 0; i < dessertMenu.size(); i++) {
			if (dessertMenu.get(i).getServingTemp() < 60.0) {
				System.out.println((i + 1) + ". " + dessertMenu.get(i).getName());
			}
		}
	}
	
	public static Dessert getDessert(Dessert c) {
		if (dessertMenu.get(0).equals(c)) {
			return dessertMenu.get(0);
		}
		return null;

	}
	
	public static int countCal() {
		int total = 0;
		for (int i = 0; i < dessertMenu.size(); i++) {
			if (dessertMenu.get(i).getCalories() > 250) {
				total++;
			}
		}
		return total;
	}
	
	public static void printDesserts() {
        System.out.println("The elements of the Dessert Menu are:\n");
        for (int i = 0; i < dessertMenu.size(); i++) {
            System.out.println( (i + 1) + ". " + dessertMenu.get(i).toStringDessert() + "\n");
        }
	}
	
}
