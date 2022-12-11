/**
 * Open and process the Billboard Hot 100 chart data file
 * Question 1: Which artist has more all-time chart appearances: Prince or Madonna?
 * 
 * @author rowanrichter
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PrinceOrMadonna {

	public static void main(String[] args) {
		
		// Declare before the try block so that it is not only scoped in the try block
		// Deliberately uninitialized
		Scanner fileInput = null;
		
		// initialize Madonna and Prince chart appearance counters
		int pCount = 0;
		int mCount = 0;

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
			
			if ((artist.equals("Prince"))) {
				//System.out.println(title + ", " + year); 
				pCount ++; 
			}
			if (artist.equals("Madonna")) {
				//System.out.println(artist + ", " + title + ", " + year + ", " + maxChartPos);
				mCount ++;
			}
		}
		
		// if Prince has more chart appearances then provide the Prince print statement 
		// otherwise (Madonna has more chart appearances) provide the Madonna print statement
		System.out.println("Question 1: Which artist has more all-time chart appearances as a solo artist, Prince or Madonna?\n");
		//System.out.println(Math.max(pCount, mCount));
		if (pCount > mCount) { 
			System.out.println("\tPrince has more all time chart appearances as a solo artist.\n"); 
		} else {
			System.out.println("\tMadonna has more all time chart appearances as a solo artist.\n"); 
		}
 
	}

}