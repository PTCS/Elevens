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
        if (moves.length == 2) {
            Card c1 = new Card(moves[0]);
            Card c2 = new Card(moves[1]);
            if (board.contains(c1) && board.contains(c2) && c1.getValue() + c2.getValue() == 11) {
                for(String s : moves) {
                    if(deck.size() > 0)
                        board.replace(new Card(s), deck.getNextCard());
                }
            }
            else {
                System.out.println("You played an invalid move!");
                return;
            }
        }
        else if (moves.length == 3) {
            Card c1 = new Card(moves[0]);
            Card c2 = new Card(moves[1]);
            Card c3 = new Card(moves[2]);
            Arrays.sort(moves);
            if (moves[0].equals("J") && moves[1].equals("K") && moves[2].equals("Q") && board.contains(c1) && board.contains(c2) && board.contains(c3)) { 
                for(String s : moves) {
                    if(deck.size() > 0)
                        board.replace(new Card(s), deck.getNextCard());
                }
            }
            else {
                System.out.println("You played an invalid move!");
                return;
            }
        }

        else {
            System.out.println("You played an invalid move!");
        }
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }

    /**
     * Returns the size of the deck
     * @return the size of the deck
     */

    public int deckSize() {
        return deck.size();
    }
}
