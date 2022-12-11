/**
 * Open and process the Billboard Hot 100 chart data file
 * Question 4: How many unique artists are in the entire data set?
 * 
 * @author rowanrichter
 */
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UniqueArtists {

	public static void main(String[] args) {
		
		// Declare before the try block so that it is not only scoped in the try block
		// Deliberately uninitialized
		Scanner fileInput = null;
		
		// Create an empty HashSet that can only hold String values
		// A HashSet maintains a set of values with no duplicates.
		HashSet<String> artists = new HashSet<String>();
		
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
			
			// add() method adds the specified element to this set if it is not already present. 
			// essentially this method adds the specified element e to this set if this set 
			// does not already contain e
			artists.add(artist);

		}
		
		// Printing of the general question and implementation of artists.size()
		// to show the length of this unique set of values
		System.out.println("Question 4: How many unique artists are in the entire data set?\n");
		System.out.println("\tThere are " + artists.size() + " unique artists in the entire data set.\n");

	}

}