import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();
	
	System.out.println("Welcome to Elevens!");
	System.out.println("Here is an explanation of the rules:");
	System.out.println("Look at the nine cards on the board and find two that add up to Eleven.");
	System.out.println("If no two cards exist, you can also choose a Jack, Queen, and King.");
	System.out.println("if neither of these conditions exist, you lose!");
	System.out.println("But if you burn through the entire deck, you win!");

        do {
            System.out.println(game.getBoard());

            if (!game.isOver()) {
                String[] moves = in.nextLine().split(" ");
                game.processMoves(moves);
            }
        } while(!game.isOver());

        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner! Congratulations, you are truly a skilled player.");
        else
            System.out.println("Loser! Sorry, but you are a weak and unskilled player.");


    }
}
