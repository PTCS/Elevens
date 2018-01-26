import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
	System.out.println("Directions: Select 2 numbers that add up to 11 on the board! Selecting these numbers will replace them.");
 	System.out.println("If there are jacks, queens, or kings, you can select all three of them to replace all three of them with new cards.");
	System.out.println("In addition, if there are two or more jacks, then you can select the jacks to replace them.");
	System.out.println("If you find yourself with no moves, then you lose. However, there is one chance to redeem yourself...");
	System.out.println();
        Elevens game = new Elevens();
        do {
	    boolean valid=true;
            System.out.println(game.getBoard());

            if (!game.isOver()) {
                String[] moves = in.nextLine().split(" ");
                valid=game.processMoves(moves);
            }
	    else if(!game.isOver()&&!game.didWin()&&game.lose()){
		System.out.println("Sadly, your skill with the numbers is not high enough to get an 11 on the board.");
		System.out.println("However, you have one chance to prove yourself worthy of the cards. If you pass the test,");
		System.out.println("then you can choose any card to be replaced.");
	    }
	    if(!valid)
		System.out.println("Incorrect play, try again.");
        } while(!game.isOver());

        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");


    }
}
