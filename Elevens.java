import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;

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
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }

    public boolean checkMoves(String[] moves){
	if (moves.length > 3 || moves.length < 2)
	    return false;
	int sum = 0;
	if (moves.length == 3)
	    sum = 100;
	for(String s: moves){
	    try {
		int num = Integer.parseInt(s);
		if (num > 9 || num < 1){
		    return false;
		}
		sum += num;
	    } catch (NumberFormatException e){
		if (s.equals("J")){
		    sum += 15;
		}
		else if (s.equals("K")){
		    sum += 16;
		}
		else if (s.equals("A")){
		    sum+= 1;
		}
		else if (s.equals("Q")){
		    sum += 17;
		}
		else if (s.equals("T")){
		    sum += 10;
		}
		else{
		    return false;
		}
	    }
	}
	for (String s : moves){
	    if (!board.contains(new Card(s)))
		return false;
	    
	}

	if (sum == 11 || sum == 148)
	    return true;
	return false;
    }
    public void explode(){
	Random r = new Random();
	ArrayList<Pair<Integer, Integer>> spots = new ArrayList<>();
	for (int i = 0; i < 5; i++){
	    Pair<Integer, Integer> p = new Pair<>(r.nextInt(3), r.nextInt(3));
	    while(spots.contains(p)){
		p = new Pair<>(r.nextInt(3), r.nextInt(3));
	    }
	    spots.add(p);
	}
	for(Pair<Integer, Integer> p2 : spots){
	    if (deck.size() != 0){
	    board.set(p2.getKey(), p2.getValue(), deck.getNextCard());}
	}
    }
}
