import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String replay = "Y";

	while (replay.equals("Y")) {
	    Elevens game = new Elevens();

            do {
	        System.out.println(game.getDeckSize() + " cards remaining.");
                System.out.println(game.getBoard());

                if (!game.isOver()) {
	  	    System.out.println("Please enter your move: ");
		
  		    String[] moves = in.nextLine().toUpperCase().split(" ");
	
	            while (!game.movesValid(moves)) {
		        System.out.println("Invalid move. Please enter your move: ");
		        moves = in.nextLine().toUpperCase().split(" ");
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
        
	    System.out.println("Replay? (Y/N)");
	    replay = in.nextLine().toUpperCase();
	}
    }
}
