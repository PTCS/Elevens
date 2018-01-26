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
	if(values.contains(jack)) {
	    values.remove(values.indexOf(jack));
	    if(values.contains(jack))
		return false;
	}
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
    public boolean processMoves(String[] moves) {
	boolean valid=false;
	ArrayList<Card> play = new ArrayList<Card>();
	for(String s : moves) {
	    for(Card c : board.getAllCards())
		if(c.toString().equals(s.toUpperCase()))
		    valid=true;
	    if(valid)
		play.add(new Card(s));
	    else
		return false;
	}
	valid=true;
	while(play.contains(new Card(11))&&play.contains(new Card(12))&& play.contains(new Card(13))) {
	    play.remove(play.indexOf(new Card(11)));
	    play.remove(play.indexOf(new Card(12)));
	    play.remove(play.indexOf(new Card(13)));
	}
	if(play.contains(new Card(11))) {
	    play.remove(play.indexOf(new Card(11)));
	    if(play.contains(new Card(11))) {
		play.remove(play.indexOf(new Card(11)));
		if(play.contains(new Card(11))){
		    play.remove(play.indexOf(new Card(11)));
		    if(play.contains(new Card(11)))
			play.remove(play.indexOf(new Card(11)));
		}
	    }
	    else
		return false;
	}
	for(int i = 0; i<play.size();i++) {
	    Card c = play.get(i).getMatchingCard();
	    if(play.contains(c)) {
		play.remove(play.indexOf(c));
		play.remove(i);
		i=i-1;
	    }
	    else
		return false;
	}
	for(String s: moves) {
            if(deck.size() > 0) {
                board.replace(new Card(s), deck.getNextCard());
	    }
        }
	return true;
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }
}
