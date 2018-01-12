import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> theDeck;

    /**
     * Constructs the deck with 52 cards.
     */
    public Deck() {
        theDeck = new ArrayList<>();
        loadCards();
    }

    /**
     * Loads 52 cards in the deck and shuffles them.
     */
    public void loadCards() {
        for(int i = 1; i <= 13; i++) {
            theDeck.add(new Card(i));
            theDeck.add(new Card(i));
            theDeck.add(new Card(i));
            theDeck.add(new Card(i));
        }
        shuffle();
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffle() {
        Collections.shuffle(theDeck);
    }

    /**
     * Returns and removes the next card
     * in the deck.
     * @return the next card in the deck
     */
    public Card getNextCard() {
       return theDeck.remove(0);
    }

    /**
     * Returns the number of cards left in the deck.
     * @return the number of cards left in the deck.
     */
    public int size() {
        return theDeck.size();
    }
}
