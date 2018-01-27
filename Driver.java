import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
            System.out.println(game.getBoard());

            if (!game.isOver()) {
                String[] moves = in.nextLine().split(" ");
		boolean gucci = game.isValid(moves);
		if(!gucci){
			System.out.println("Incorrect please try again: ");
			moves = in.nextLine().split(" ");
			gucci = game.isValid(moves);
		}
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
