import java.util.ArrayList;

public class Board {

    private Card[][] board;
    public static final int SIZE = 3;

    /**
     * Constructs a new board
     */
    public Board() {
        board = new Card[SIZE][SIZE];
    }

    /**
     * Sets a spot on the board with a given value.
     * @param r the row of the spot to set
     * @param c the column of the spot to set
     * @param card the card to set in the spot
     */
    public void set(int r, int c, Card card) {
        board[r][c] = card;
    }

    /**
     * Returns a list of all the cards on the board
     * @return a list of all the cards on the board
     */
    public ArrayList<Card> getAllCards() {
        ArrayList<Card> cards = new ArrayList<>();

        for(int r = 0; r < SIZE; r++) {
            for(int c = 0; c < SIZE; c++) {
                cards.add(board[r][c]);
            }
        }

        return cards;
    }

    /**
     * Returns true if the board contains a given card
     * @param c the card to check
     * @return true if the board contains a given card, false otherwise
     */
    public boolean contains(Card c) {
        return getAllCards().contains(c);
    }

    /**
     * Replaces the first occurrence of oldCard with newCard
     * @param oldCard the card to replace
     * @param newCard the card to replace it with
     */
    public void replace(Card oldCard, Card newCard) {
        for(int r = 0; r < SIZE; r++) {
            for(int c = 0; c < SIZE; c++) {
                if (board[r][c].equals(oldCard)) {
                    board[r][c] = newCard;
                    return;
                }
            }
        }

    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String toString() {

        String s = "";

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                s += board[r][c] + " ";
            }

            if(r != board.length-1)
                s += "\n";
        }

        return s;
    }

}
