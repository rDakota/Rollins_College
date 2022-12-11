/**
 * A blackjack hand
 * 
 * @author rowanrichter
 */
 
import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    
    
    /**
     * Constructor
     */
    public Hand() {
        this.cards = new ArrayList<Card>();
    }
    
    
    /**
     * Add a new card to the hand
     * 
     * @param newCard    the new Card object to append to this Hand
     * @return           nothing, the card is added to the Hand
     */
    public void addCard(Card newCard) {
        this.cards.add(newCard);    
    }
    
    
    /**
     * Obtain the last card added to the player's hand
     * 
     * @return         the card at the last index in the hand
     */
    public Card getLastCard() {
    		return this.cards.get(this.cards.size() - 1);
    }
    
    
    /**
     * Obtain the first card added to the player's hand
     *
     * @return         the card at the first index in the hand
     */
    public Card getFirstCard() {
    	return this.cards.get(0);
    }
    
    
    /**
     * Calculate the value of the cards
     *
     * @return        The value of this Hand, scored according to the rules of Blackjack
     */
    public int score() {

        // Declare an int to hold the final score calculated for the hand
        int score = 0;
        
        // Count the number of Aces and determine their values at the end
        int numAces = 0;
        
        // Loop through all of the cards in the Hand and add up their
        // individual values
        
        // enhanced for loop iterating through all cards in the hand
        for (Card c : this.cards) {
            Rank r = c.getRank();
            
            if (r == Rank.TWO) {
                score += 2;
            }
            
            // Similar for other card Ranks
            // All face cards count for 10
            
            if (r == Rank.THREE) {
            	score += 3;
            }
            
            if (r == Rank.FOUR) {
            	score += 4;
            }
            
            if (r == Rank.FIVE) {
            	score += 5;
            }
            
            if (r == Rank.SIX) {
            	score += 6;
            }
            
            if (r == Rank.SEVEN) {
            	score += 7;
            }
            
            if (r == Rank.EIGHT) {
            	score += 8;
            }
            
            if (r == Rank.NINE) {
            	score += 9;
            }
            
            if (r == Rank.TEN || r == Rank.JACK || r == Rank.QUEEN || r == Rank.KING) {
            	score += 10;
            }
            
            if (r == Rank.ACE) {
                numAces++;
            }
        }
        
        // Each Ace counts for 11, unless counting for 11 would make the score > 21, then the Ace
        // counts for only 1
        while (numAces > 0) {
            // Add 11 to the score unless that would make score > 21, in which case
            // this Ace only counts for 1
        	if (score + 11 <= 21) {
        		score += 11;
        	} else {
        		score += 1;
        	}
            numAces--;
        }
        
        return score;
    }

}