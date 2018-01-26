import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

	System.out.println("Welcome to the Elevens Game");
	System.out.println("New Rules: You have one use of explode, which replaces 5 cards from the feild");

	boolean usedExplode = false;
	boolean stopped = false;
        do {
            System.out.println(game.getBoard());
	    System.out.println();
	    String[] moves;
	    boolean done = true;
	    do {
		if (!done){
		    System.out.println("Please enter again: ");
		}
		else {
		    System.out.println("Please input numbers that add to 11, J K Q, STOP, or EXPLODE");
		}
		done = false;
                moves = in.nextLine().toUpperCase().split(" ");
		if (moves[0].equals("STOP"))
		    stopped = true;
		if (moves[0].equals("EXPLODE") && !usedExplode){
		    game.explode();
		    usedExplode = true;
		    done = true;
		}
		if (game.checkMoves(moves) || stopped){
		    done = true;}
		System.out.println();
	    } while (!done);
	    if (!stopped && !moves[0].equals("EXPLODE")){
	    game.processMoves(moves);}
	    if (game.isOver() && !usedExplode && !game.didWin()){
		System.out.println("You have no more moves except your explode");
		System.out.println("We are going to use it for you, however you may still lose");
		game.explode();
		usedExplode = true;
	    }
        } while(!game.isOver() && !stopped);
	
	if (!stopped){
        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");
	}

    }
}
