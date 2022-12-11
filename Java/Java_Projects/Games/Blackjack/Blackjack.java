/**
 * BLACKJACK
 * 
 * @author rowanrichter
 */
 
import java.util.Scanner; 
 
public class Blackjack {

	public static void main(String[] args) {
    
        System.out.println("WELCOME TO BLACKJACK.\n");
    
        // Initialize a Scanner for input
        Scanner input = new Scanner(System.in);
    
        // Create a Deck and two empty Hands
        System.out.println("Shuffling the deck...\n");
        Deck deck = new Deck();
        
        // Shuffle the deck
        deck.shuffle();
        
        // create two different hands for the player and the dealer
        Hand player = new Hand();
        Hand dealer = new Hand();
        
        // Deal two cards to the player
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        
        // Deal two cards to the dealer
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());
        
        // Print the player's two cards
        // Tip: think about adding a method to the Hand class to make this easier
        System.out.println("You're two cards are");
        // using firstCard method to get the first card added to the player's hand
        System.out.println("\t" + player.getFirstCard());
        // using lastCard method to get the last card added to the player's hand aka the second card
        System.out.println("\t" + player.getLastCard());
        
        // Print the dealer's first card
        // Again, think about adding a method to Hand to print only the first card
        System.out.println("\nThe dealer's face-up card is");
        // using firstCard method to get the first card added to the dealer's hand
        System.out.println("\t" + dealer.getFirstCard());
        
        // below was used to end the program and test if 
        // I was correctly printing the dealer and player cards
        //System.exit(0);
        
        // Calculate the score of the player's current hand of two cards
        // If score == 21, it's a Blackjack and the player wins immediately
        if (player.score() == 21) {
            // Print Blackjack message and return to end the program
        	System.out.println("\nYour current score is 21.");
        	System.out.println("\nYou Win!");
        	return;
        }
        
        
        // Use a loop to prompt the player to hit or stand
        boolean looping = true;
        
        while (looping) {
            // Calculate and print the player's score
            // You'll need to complete the score method in the Hand class
            System.out.println("\nYour current score is " + player.score() + ".");
            
            // Print choices
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("Hit or Stand?");
            
            // Read the player's move
            int choice = input.nextInt();
            
            // If the player chooses to hit,
            //     Deal a new card
            //     Add it to the player's hand
            //     Calculate the score of the hand using the Hand class's score method
            //     Check if the score is greater than 21. If so, the player loses immediately
            if (choice == 1) {
            	System.out.println("Your next card is");
            	
            	// player has hit and a card is added to their hand
            	player.addCard(deck.deal());
            	
            	// the last card that was added to the player's hand is displayed
                System.out.println("\t" + player.getLastCard());
                
                // If score == 21, it's a Blackjack and the player wins immediately
                if (player.score() == 21) {
                    // Print Blackjack message and return to end the program
                    System.out.println("\nYour current score is " + player.score() + ".");
                	System.out.println("\nYou Win!");
                	return;
                }
                if (player.score() > 21) {
                    System.out.println("\nYour current score is " + player.score() + ".");
                    System.out.println("\nYou have busted.");
                    System.out.println("\nYou Lost!");
                	return;
                }
            }
            // Else if the player chooses stand,
            // 		Set looping = false to end the loop
            else if (choice == 2) {
            	System.out.println("You stand with " + player.score() + ".\n");
            	looping = false;
            }
            // Else, the player has chosen an option that isn't 1 or 2,
            //     Print an error message and allow the loop to repeat
            else {
            	System.out.println("Uh Oh! Your option must be either 1 or 2.");
            	continue;
            }
        }
        
        // using lastCard method to get the dealer's second card 
        // as it was the last card added to their hand
        System.out.println("The dealer's second card is");
        System.out.println("\t" + dealer.getLastCard() + "\n");
        
        // Use a second loop to make the dealer hit as long as his score is < 17
        //     If the dealer's score goes over 21, he busts and the player wins immediately
        while (dealer.score() < 17) {
        	
        	// printing the dealer score
            System.out.println("The dealer's score is " + dealer.score() + ".\n");
            
            // dealer hits and a card is added to their hand
        	System.out.println("Dealer Hits.");
        	dealer.addCard(deck.deal());
        	
        	// the last card that was added to the dealer's hand is displayed
        	System.out.println("\t" + dealer.getLastCard() + "\n");
        	
        	// dealer score will only be above 21 if the dealer's first two cards 
        	// were already below 17 and the dealer subsequently hit to get a score above 21
        	if (dealer.score() > 21) {
        		System.out.println("The dealer's score is " + dealer.score() + ".");
        		System.out.println("\nThe dealer has busted.");
        		System.out.println("\nYou Win!");
        		return;
        	}
        }
        
        // see if the dealers score is equal to 21 and if so then print dealing winning message
        // this message will be reached if the dealer's first two cards were already equal to 21 and 
        // if after the dealer hits, their score is equal to 21 
        if (dealer.score() == 21) {
            // Print Blackjack message and return to end the program
    		System.out.println("The dealer's score is " + dealer.score() + ".\n");
        	System.out.println("The dealer Wins!\n");
    		System.out.println("You Lose!"); 
        	return;
        }
        
        
    	// printing the dealer score
        System.out.println("The dealer's score is " + dealer.score() + ".\n");
        // printing the dealer standing message
        System.out.println("Dealer stands with " + dealer.score() + ".\n");
        
        // If neither player nor dealer has busted, compare the scores of their two hands
        // The hand with the higher score is the winner
    	if (player.score() > dealer.score()) { 
    		System.out.println("Your " + player.score() + " beats the dealer's " + dealer.score() + ".\n");
    		System.out.println("You Win!");
    		return;
    	} else if (player.score() == dealer.score()){
    		System.out.println("Your " + dealer.score() + " equals their " + player.score() + ".\n");
    		System.out.println("Draw!");
    	} else {
    		System.out.println("Their " + dealer.score() + " beats your " + player.score() + ".\n");
    		System.out.println("You Lose!"); 
    		return;
    	}
    }

}