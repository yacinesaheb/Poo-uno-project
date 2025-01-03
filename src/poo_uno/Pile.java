package poo_uno;

import java.util.Random;

public class Pile {

	
	// Attributes of the Deck class
	
    private Card[] cards;      // ArrayList of Card
    private int numberOfCards;  // Actual number of cards in the deck
    
    
    public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
    public int getNumberOfCards() {
    	return this.numberOfCards;
    }
	
	
	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

    // Constructor of Pile; 
	//When argument Deck is passed, initialize a whole deck with 108 cards . 
	//When argument Discard Pile is passed , initializes a regular empty discard pile.
    
    public Pile (String DeckorDp) { 
    	
        if (DeckorDp.equals("Deck")) {
            numberOfCards = 108;
            cards = new Card[numberOfCards];

            // ALL COLORS AND NUMBERS AVAILABLE
            final String[] colors = {"R", "B", "G", "Y"}; // We took only the initials to make the display better.
            final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            int index = 0; // Tracks the current position in the cards array

            // Iterate through all the colors
            for (int i = 0; i < 4; i++) {

                // Adding zero cards
                cards[index++] = new RegularCard(colors[i], 0);

                // Adding numbered cards
                for (int j = 1; j < 10; j++) {
                    cards[index++] = new RegularCard(colors[i], numbers[j]);
                    cards[index++] = new RegularCard(colors[i], numbers[j]);
                }

                // Adding action cards
                cards[index++] = new DrawTwoCard(colors[i]);
                cards[index++] = new DrawTwoCard(colors[i]);
                cards[index++] = new ReverseCard(colors[i]);
                cards[index++] = new ReverseCard(colors[i]);
                cards[index++] = new SkipCard(colors[i]);
                cards[index++] = new SkipCard(colors[i]);
            }

            // Adding special cards
            for (int i = 0; i < 4; i++) {
                cards[index++] = new WildCard();
            }
            for (int i = 0; i < 4; i++) {
                cards[index++] = new WildDrawFour();
            }

        } else if (DeckorDp.equals("Discard Pile")) {
        	
            cards = new Card[108];
            this.numberOfCards = 0;
            
        } /*else if (DeckorDp.equals("Deck20")) { // Deck of 20 same cards to test the refill mechanic from draw card. PLEASE DO NOT REMOVE THIS.
        	 numberOfCards = 20;
             cards = new Card[numberOfCards];
             
          // ALL COLORS AND NUMBERS AVAILABLE
             final String[] colors = {"R", "B", "G", "Y"}; // We took only the initials to make the display better.
             final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
             
             Random randomIndex = new Random(); // Creating the randomizer.
             
             for (int i = 0;i < numberOfCards;i++) {
            	 int randomNumberIndex = randomIndex.nextInt(numbers.length);
            	 int randomColorIndex = randomIndex.nextInt(colors.length);
            	 cards[i] = new RegularCard(colors[randomColorIndex],numbers[randomNumberIndex]);
             }
        }*/
    }
    
    // Returns the top card of the deck and removing it.
    public Card drawPileCard() {
            return cards[--numberOfCards];
    }
    
    // Shuffle randomly the cards of the pile.
    public void shuffle() {
        for (int i = numberOfCards - 1; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    // Returns the top card of the pile (without removing it)
    public Card getTopCard() {
        return cards[numberOfCards - 1];
    }

    // Adding a card to the pile.
    public void addCard(Card card) {
        if (numberOfCards < cards.length) {
            cards[numberOfCards++] = card;
        }
    }

    // Empties the cards array and sets numberOfCards to 0.
    public Pile resetPile() {
        for (int i = 0; i < numberOfCards; i++) {
            cards[i] = null;
        }
        numberOfCards = 0;
        return this;
    }

    // Displays the deck
    public void displayDeck() {
        System.out.println("Deck contains " + numberOfCards + " cards:");
        for (int i = 0; i < numberOfCards; i++) {
            System.out.println((i + 1) + ": " + cards[i].displayCard()); // Assumes Card class has a meaningful `toString` method
        }
    }
}
