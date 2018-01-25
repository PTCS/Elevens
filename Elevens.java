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
    public boolean  processMoves(String[] moves) {
     if(isValidMove(moves)) {
        for(String s : moves) {
            if(deck.size() > 0)
                board.replace(new Card(s), deck.getNextCard());
        }
	return true;
    }
    else
	return false;
    }

   public boolean isValidMove(String[] moves) {
    ArrayList<String> firstCheck = new ArrayList<>();
        for(String s : moves) {
            firstCheck.add(s);
        }
        for(String s1 : firstCheck) {
            Card c = new Card(s1);
            if(!board.contains(c))
                return false;
        }


        if(moves.length < 2 || moves.length > 3)
            return false;
        else {

            ArrayList<String> temp = new ArrayList<>();
            for(String s : moves) {
                temp.add(s);
            }

            if(temp.size() == 2) {
                if(temp.contains("J") || temp.contains("K") || temp.contains("Q"))
                    return false;
                else {
                    Card c1 = new Card(temp.get(0));
                    Card c2 = new Card(temp.get(1));
                    if(c1.equals(c2.getMatchingCard()))
                        return true;
                    else
                        return false;
                }
            }

            if(temp.size() == 3) {
                if(temp.contains("J") && temp.contains("K") && temp.contains("Q"))
                    return true;
                else {
                    ArrayList<Integer> a1 = new ArrayList<>();
                    for(String s : temp) {
                        if(s.equals("A"))
                            a1.add(1);
                        else if(s.equals("T"))
                            a1.add(10);
                        else if(s.equals("J"))
                            a1.add(12);
                        else if(s.equals("Q"))
                            a1.add(13);
                        else if(s.equals("K"))
                            a1.add(14);
                        else
                            a1.add(Integer.parseInt(s));
                    }
                    int sum = 0;
                    for(int n : a1)
                        sum+=n;
                    if(sum!=11)
                        return false;
                    else
                        return true;
                }
            }

        }
        return false;
   }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    public String getBoard() {
        return board.toString();
    }
}
