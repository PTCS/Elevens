import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
            System.out.println();
            System.out.println("Deck Size: " + game.deckSize());
            System.out.println(game.getBoard());

            if (!game.isOver()) {
                System.out.print("Enter your move: ");
                String[] moves = in.nextLine().split(" ");
                game.processMoves(moves);
            }
        } while(!game.isOver());

        System.out.println(game.getBoard());
        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");
    }
}
