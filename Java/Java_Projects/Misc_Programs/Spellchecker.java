/**
 * Spellchecker
 *
 * CMS 121
 * 
 * @author rowanrichter
 */
 
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Spellchecker {

    // Instance variable: HashSet that holds the set of all words
    private HashSet<String> words;
    
    
    /**
     * Constructor -- initialize the HashSet and read in the words from the given file
     *
     * @param    wordFile    File containing the reference words for the Spellchecker
     */
    public Spellchecker(String wordFile) {
    	
    	this.words = new HashSet<String>();
    
        Scanner input = null;
        
       
        try {
            input = new Scanner(new File(wordFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        while (input.hasNext()) {
            // Read the nextLine from the Scanner
        	String line = input.nextLine();
            
            // Add that word to the HashSet (using this.words.add)
        	this.words.add(line);
        }
        
        input.close();
    
    }  
    
    /**
     * search -- return true if the set contains the given word, false otherwise
     * 
     * @param    searchWord
     */
    public boolean search(String searchWord) {
        
        // Convert to lowercase
        String lower = searchWord.toLowerCase();
    
        // Use the contains method of HashSet to check if this.words contains lower
        if (this.words.contains(lower)) {
        	return true;
        }
        // else return false
        return false;
        
    }

    /**
     * suggestions -- given a word, look for alternate spellings that could be valid words
     */
    public ArrayList<String> suggestions(String word) {
        
        // Empty ArrayList<String> to hold the possible replacement words
        ArrayList<String> alternates = new ArrayList<String>();
        
        // Find all valid words that can be created by substituting a letter
        String letters = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < letters.length(); j++) {
            
                // Construct a candidate word
                //
                // The first substring gets the letters from index 0 to i - 1
                // The letter at position i is replaced by a different letter
                // The second substring gets the remaining letters from i + 1 to word.length() - 1
                
                String candidate = word.substring(0, i)
                                   + letters.charAt(j) + word.substring(i+1, word.length());
                
                // Check if the canddiate word is valid by searching the word set
                if (this.search(candidate)) {
                    alternates.add(candidate.toLowerCase());
                }
            }
        }
        
        // Find all valid words that can be created by deleting a letter
        for (int i = 0; i < word.length(); i++) {
            String candidate = word.substring(0, i)
            		+ word.substring(i + 1, word.length());
            	        	
            // Check if the canddiate word is valid by searching the word set
            if (this.search(candidate)) {
            	// checking for valid words by deleting a character is the only spellchecker rule
            	// that would would allow multiple of the same word to be added to the list because
            	// if the word has one too many of the same letter, then any of those letters could be delete
            	// to result in a correct word suggestion
            	//
            	// if the word is not already in the arraylist then add the word to the list
            	if (!alternates.contains(candidate.toLowerCase())) {
            		alternates.add(candidate.toLowerCase()); 
            	} 
            }
        }
        
        // Find all valid words that can be created by inserting a letter
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < letters.length(); j++) {
                
            	// similar to substitution rule but instead of concatenating
            	// the substring from i + 1 to word.length(),
            	// we will add a letter by concatenating the substring 
            	// from i to word.length()
                String candidate = word.substring(0, i)
                        + letters.charAt(j) + word.substring(i, word.length());

                // Check if the candidate word is valid by searching the word set
                if (this.search(candidate)) {
                    alternates.add(candidate.toLowerCase());
                }
            }
        }
        
        // Return the final list of possible alternate words
        return alternates;
        
    }
    
    /**
     * spellcheck -- takes a string as input and spellchecks each word
     *
     * @param    line    a line of text to spellcheck
     */
    public void spellcheck(String line) {
        
        // Create a Scanner to break the line into individual words
        Scanner s = new Scanner(line);
        
        while (s.hasNext()) {
            String w = s.next();
            
            // Use the search method to check if w is in this.words
            if (!search(w)) {
                // If not, it might be misspelled
                //
                // Call the suggestions method to generate an ArrayList<Strring> representing
                // possible correct spellings
                //
                // Print the misspelled word and all of the possible correct spellings
                // returned by suggestions
            	System.out.println("\"" + w + "\"");
            	System.out.println("Suggestions: " + suggestions(w) + "\n");
            }
        }
        s.close();
    }

    /**
     * main -- testing
     * 
     * DO NOT EDIT MAIN
     */
    public static void main(String[] args) {

        // Create a new Spellchecker using the words.txt list
        Spellchecker checker = new Spellchecker("words.txt");
        
        // Check some lines of text
        checker.spellcheck("Tere once wass a grrl named Lenore");
        checker.spellcheck("Annd a brd and a bhst and a dooor");
        checker.spellcheck("And a gux with deprssion");
        checker.spellcheck("And a whole lot of uestions");
        checker.spellcheck("And the bir allways says Nevermore");
    
    }
    
}