import java.util.ArrayList;
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

    /**
     * Returns whether the choosing of cards is valid
     * @return a boolean output of whether the cards chosen is valid
     */
     public boolean isValid(String[] args)
     {
         boolean status = true;
         if (args.length == 3)
         {
             String[] valid = {"J", "Q", "K"};

             ArrayList<String> key = new ArrayList<String>();
             for (String str : valid)
             {
                 key.add(str);
             }
             Collections.sort(key);

             ArrayList<String> comp = new ArrayList<String>();
             for (String str : args)
             {
                 comp.add(str);
             }

             Collections.sort(comp);

             status = comp.equals(key);
         }
         else if (args.length == 2)
         {
             boolean integers = true;
             int sum = 0;
             for (String str : args)
             {
                 Card c = new Card(str);
                 try
                 {
                     sum += c.getValue(); 
                 }
                 catch (Exception e)
                 {
                     integers = false;
                     break;
                 }
             }
             status =  integers && sum == 11; 
         }
         else
         {
             status = false;
         }

         if (status)
         {
             boolean finalStatus = true;
             for (String str : args)
             {
                 Card c = new Card(str);
                 if (! board.contains(c))
                 {
                     finalStatus = false;
                     break;
                 }
             }
             return finalStatus;
         }
         else
         {
             return false;
         }
    }
}
