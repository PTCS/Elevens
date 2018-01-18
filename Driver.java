import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
            System.out.println(game.getBoard());
            System.out.println();

            if (!game.isOver()) {
                String[] moves;

                do
                {
                    moves = in.nextLine().split(" ");
                } while (! game.isValid(moves));
                game.processMoves(moves);
                System.out.println();
            }
        } while(!game.isOver());

        System.out.println(game.getBoard());
        System.out.println();

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");


    }
}
