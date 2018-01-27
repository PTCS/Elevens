import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
            System.out.println(game.getBoard());
            String [] moves;

            if (!game.isOver()) {
                moves = in.nextLine().split(" ");

                if(Integer.parseInt(moves[0]) + Integer.parseInt(moves[1]) == 11)
                    game.processMoves(moves);

                else{
                    System.out.println("Please enter values that add to 11");
                    moves = in.nextLine().split(" ");

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
         
