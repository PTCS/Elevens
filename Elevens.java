import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
     * Processes moves from the user.
     * @param moves moves from the user.
     */
    public void processMoves(String[] moves) {
        for(String s : moves) {
            if(deck.size() > 0)
                board.replace(new Card(s), deck.getNextCard());
        }
    }

    /**
    * Returns true if the player's moves are valid, false otherwise.
    * @return true if the player's moves are valid, false otherwise.
    */
    public boolean movesValid(String[] moves) {
        List<String> moveList = Arrays.asList(moves);
        boolean isJQK = moves.length == 3 && moveList.contains("J") && moveList.contains("Q") && moveList.contains("K");
        boolean isNum = moves.length == 2 && moves[0].matches("[1-9]|T|A") && moves[1].matches("[1-9]|T|A"); 
	if (!isJQK && !isNum)
	    return false;
	
	ArrayList<Card> values = board.getAllCards();
	if (isJQK)
            return values.contains(new Card(11)) && values.contains(new Card(12)) && values.contains(new Card(13));

	int sum = 0;
	for (String s: moves) {
	   int value;
	   if (s.equals("T"))
		value = 10;
	   else if (s.equals("A"))
		value = 1;
	   else
		value = Integer.parseInt(s);
           
	   Card c = new Card(value);
	   if (!values.contains(c))
		return false;
	   sum += value;
	}

	return sum == 11;
    }
    
    /**
    * Returns size of the deck
    * @return size of the deck
    */
    public int getDeckSize() {
	return deck.size();
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }
}
