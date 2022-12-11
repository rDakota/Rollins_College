/**
 * Open and process the Billboard Hot 100 chart data file
 * Question 5:  It’s been said that the switch to SoundScan led to popular songs remaining 
 * 			 	on the charts longer than the old survey system. Determine if this is 
 * 				empirically true by calculating the average time spent on the charts 
 * 				for songs released in 1991 or earlier and songs released in 1992 or later.
 * 
 * @author rowanrichter
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SoundScan {

	public static void main(String[] args) {
		
		// Declare before the try block so that it is not only scoped in the try block
		// Deliberately uninitialized
		Scanner fileInput = null;
		
		// initialize survey system counters
		double surveySysCount = 0;
		double surveySysTotal = 0;
		
		// initialize during Nielsen SoundScan era counters
		double nielsenCount = 0;
		double nielsenTotal = 0;
		
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
			
			// use surveySysTotal to count up the total weeks songs during the survey system
			// remained on the charts and count the number of songs released using surveySysCount 
			// in order to calculate the average later on
			//
			// use nielsenTotal to count up the total weeks songs released DURING the Nielsen Soundscan
			// era remained on the charts and count the number of songs during this era 
			// using nielsenCount in order to calculate the average later on
			if (year < 1992){
				surveySysTotal += weeks;
				surveySysCount += 1;
			} else {
				nielsenTotal += weeks;
				nielsenCount += 1;
			}
		}
		
		// Formatted printing of the general question and the answer through empirical evidence
		System.out.println("Question 5: What is SoundScan's influence on the average time songs spent on the charts?\n");
		System.out.printf("\tThe original pressumption is true as the avg weeks apent on the charts before 1992 was roughly %.2f weeks", surveySysTotal/surveySysCount);
		System.out.printf("\n\tand the avg weeks spent on the charts in 1992 or later was roughly %.2f weeks.", nielsenTotal/nielsenCount);
		System.out.println(" Therefore, SoundScan did \n\tlead to popular songs remaining on the charts longer than the old survey system.");
		
		
		
	}

}