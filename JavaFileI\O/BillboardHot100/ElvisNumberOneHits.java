/**
 * Open and process the Billboard Hot 100 chart data file
 * Question 2: Find and print all of the number one hits by Elvis Presley.
 * 
 * @author rowanrichter
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ElvisNumberOneHits {

	public static void main(String[] args) {
		
		// Declare before the try block so that it is not only scoped in the try block
		// Deliberately uninitialized
		Scanner fileInput = null;
		
		// QUESTION 2 ->
		// initialize Elvis Presley count
		int epCount = 0;
		
		// Standard setup for opening a file
		try {
			fileInput = new Scanner(new File("billboard_chart_data.txt"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (fileInput.hasNext()) {
			String line = fileInput.nextLine();
			
			// Make a second Scanner to process the line
			Scanner s = new Scanner(line);
			
			// Tell Scanner s to use ; as its delimiter
			s.useDelimiter(";");
			
			// Read through the five entries on each line
			String artist = s.next();
			String title = s.next();
			int year = s.nextInt();
			int maxChartPos = s.nextInt();
			int weeks = s.nextInt();
			
			if (artist.equals("Elvis Presley") && maxChartPos == 1) {
				System.out.println(title + ", " + maxChartPos);
				epCount ++;
			}
		}
		
		System.out.println();
		// Print the Elvis number on hit count
		System.out.println("Question 2: Find and print all of the number one hits by Elvis Presley?\n");
		System.out.println("\tElvis Presley had a total of " + epCount + " number one hits based on this data set.");
 
	}

}