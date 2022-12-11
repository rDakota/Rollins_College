/**
 * Open and process the Billboard Hot 100 chart data file
 * Question 3: Which song spent the greatest total number of weeks on the charts?
 * 
 * @author rowanrichter
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MostWeeksOnCharts {

	public static void main(String[] args) {
		
		// Declare before the try block so that it is not only scoped in the try block
		// Deliberately uninitialized
		Scanner fileInput = null;
		
		// initialize weekMax + corresponding artist and song title
		int weeksMax = 0;
		String newMaxArtist = null;
		String newMaxTitle = null;
		
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
			
			// if the weeks associated with the current artist is greater than weeksMax,
			// then save the current artist and song title under newMaxArtist and 
			// newMaxTitle respectively. Also assign weeksMax to weeks to be used for next iteration
			if (weeks > weeksMax) {
				newMaxArtist = artist;
				newMaxTitle = title;
				weeksMax = weeks;
				// System.out.println(artist + ", " + title + ", " + weeks);
			}

		}
		
		// Printing of the song with the max weeks on the charts as well as
		// the corresponding artist and title
		System.out.println("Question 3: Which song spent the greatest total number of weeks on the charts?\n");
		System.out.println("\t" + newMaxArtist + "'s song '" + newMaxTitle + "' spent the most total weeks on the charts at " + weeksMax + " weeks.\n");
				
	}

}