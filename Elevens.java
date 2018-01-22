import java.util.*;

public class Elevens {

    private Deck deck;
    private Board board;

    /**
     * Constructs a new Elevens object
     */
    public Elevens() {
        deck = new Deck();
        board = new Board();
        initBoard();
    }

    /**
     * Initializes the board with the first 9 cards.
     */
    private void initBoard() {
        for(int r = 0; r < Board.SIZE; r++) {
            for(int c = 0; c < Board.SIZE; c++) {
                board.set(r, c, deck.getNextCard());
            }
        }
    }

    /**
     * Returns true if the game is over, false otherwise
     * @return true if the game is over, false otherwise
     */
    public boolean isOver() {
        if (deck.size() == 0)
            return true;

        ArrayList<Card> values = board.getAllCards();

        Card jack = new Card(11);
        Card queen = new Card(12);
        Card king = new Card(13);

        if(values.contains(jack) && values.contains(queen) && values.contains(king))
            return false;

        for(Card c : values) {
            if(!c.equals(jack) && !c.equals(queen) && !c.equals(king)) {
                Card match = c.getMatchingCard();

                if (values.contains(match))
                    return false;
            }
        }

        return true;
    }

    /**
     * Returns true if the player won, false otherwise
     * @return true if the player won, false otherwise.
     */
    public boolean didWin() {
        return deck.size() == 0;
    }

    /**
     * Checks if valid move from the user.
     * @param moves moves from the user.
     */
    private boolean isValid(String[] moves) {
	if (moves.length == 0 && moves[0].equals("?")) {
	    return true;
	}
	ArrayList<Card> values = board.getAllCards();
        Card jack = new Card(11);
        Card queen = new Card(12);
        Card king = new Card(13);
        if(moves.length == 3 && values.contains(jack) && values.contains(queen) && values.contains(king)) {
	    ArrayList<Card> moveList = new ArrayList<Card>();
	    moveList.add(new Card(moves[0]));
	    moveList.add(new Card(moves[1]));
	    moveList.add(new Card(moves[2]));
	    if (moveList.contains(jack) && moveList.contains(queen) && moveList.contains(king)) {
		return true;
	    }
	}

	if (moves.length == 2) {
	    Card c1 = new Card(moves[0]);
            Card c2 = new Card(moves[1]);
	    if (c1.equals(c2.getMatchingCard()) && values.contains(c1) && values.contains(c2)) {
	    	return true;
	    }
	}

	return false;
    }

    /**
     * Processes moves from the user.
     * @param moves moves from the user.
     */
    public void processMoves(String[] moves) {
	//gives a hint to user: move with first possible card is returned
	if (!isValid(moves)) {
	    System.out.println("Invalid moves.");
	    return;
	}
	if (moves[0].equals("?")) {
	    Card jack = new Card(11);
	    Card queen = new Card(12);
	    Card king = new Card(13);
	    ArrayList<Card> cards = board.getAllCards();
	    for (Card c : cards) {
		Card matching = c.getMatchingCard();
		if (c.equals(jack) || c.equals(queen) || c.equals(king)) {
                    System.out.println("Try: J Q K");
                    return;
                } else if (cards.contains(matching)) {
		    System.out.println("Try: " + c.toString() + " " + matching.toString());
		    return;
		}
	    }
	}
        for(String s : moves) {
            if(deck.size() > 0)
                board.replace(new Card(s), deck.getNextCard());
        }
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }
}
