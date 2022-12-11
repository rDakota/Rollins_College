/**
 * Create a class that represents a single playing card
 * Combine with a Deck class to represent a full deck of 52 cards
 * 
 * @author rowanrichter
 *
 */

// Question: How to represent the Suit and Rank?

// Suit could be "S" "C" "D" or "H"
// Use a number to encode the suit: Clubs = 0, Diamonds = 1, Hearts = 2, Spades = 3

// java supports a special feature called enumerated types or enum
// An enum is a user-defined type that can take only elements of a finite-sized set of values

// Behind the scenes, Java automatically maps each element of an enum to an underlying int value
// Constants so in all caps

// Enumerated suit and rank types

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
}


public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * Constructor -- create a new card with a specified Suit and Rank
     */
    public Card(Suit newSuit, Rank newRank) {
        this.suit = newSuit;
        this.rank = newRank;
    }

    /**
     * Get methods -- return the value of suit and rank
     */
    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    /**
     * toString -- return a String representation of the object
     */
    public String toString() {
        return this.rank + " of " + this.suit;
    }
	
}