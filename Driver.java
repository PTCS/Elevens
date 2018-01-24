import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Elevens game = new Elevens();

        do {
	    System.out.println(game.getDeckSize() + " cards remaining.");
            System.out.println(game.getBoard());

            if (!game.isOver()) {
		System.out.println("Please enter your move: ");
		
		String[] moves = uppercase(in.nextLine().split(" "));
	
		while (!game.movesValid(moves)) {
		    System.out.println("Invalid move. Please enter your move: ");
		    moves = uppercase(in.nextLine().split(" "));
		}
		
                game.processMoves(moves);
	    }
	    System.out.println();
        } while(!game.isOver());

        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");
    }

    public static String[] uppercase(String[] moves) {
	String[] converted = new String[moves.length];
	for (int i = 0; i < moves.length; i++)
	    converted[i] = moves[i].toUpperCase();

	return converted;
    }
}
