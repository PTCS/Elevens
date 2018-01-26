import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
            System.out.println(game.getBoard());

    	    System.out.println();

            if (!game.isOver()) {
		boolean done = false;
		while (!done){
                	String[] moves = in.nextLine().split(" ");
	        	System.out.println();
                	boolean check = game.processMoves(moves);
			done = check;
			if (!done){
				System.out.println("Invalid entry. Try again.");
				System.out.println();
			}
		}
            }
        } while(!game.isOver());

        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");


    }
}
