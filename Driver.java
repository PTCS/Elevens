import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Elevens game = new Elevens();

        do {
            System.out.println(game.getBoard());

            if (!game.isOver()) {
                String[] moves = in.nextLine().split(" ");
		if (game.movesValid(moves))
                    game.processMoves(moves);
            	else
		    System.out.println("Invalid move.");
	    }
	    System.out.println();
        } while(!game.isOver());

        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");


    }
}
