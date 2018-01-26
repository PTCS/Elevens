import java.util.ArrayList;

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
* checks if moves are valid
*@param moves moves from user
*@return if the moves are legal
*/
public boolean validMoves(String[] mvs){

	ArrayList<String> moves= new ArrayList<String>();
	for (String m: mvs){
		moves.add(m);
	}
	
	if(moves.contains("hint")||moves.contains("Hint"))
		return false;
	if(moves.contains("J")||moves.contains("Q")||moves.contains("K")){
		
		return (moves.contains("J")&&moves.contains("Q")&&moves.contains("K"));
	
	}
	if(moves.size()<2)
		return false;
	Card c1 = new Card(mvs[0]);
	Card c2=new Card(mvs[1]);
	return( c1.getMatchingCard().equals(c2));
}

/**
*gives a hint based on current board
*@return a valid move for the current board
*/
public String getHint(){
	ArrayList<Card> cards = board.getAllCards();
      Card jack = new Card(11);
        Card queen = new Card(12);
        Card king = new Card(13);
	if(cards.contains(jack)&&cards.contains(queen)&&cards.contains(king))
		return "J Q K";
	for (Card c: cards){
		if(cards.contains(c.getMatchingCard()))
			return c.toString()+" "+c.getMatchingCard().toString();
}
	return "";
}

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }
}
