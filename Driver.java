import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        String lastMove = "";	
        do {
            System.out.println(game.getBoard());
	    if (!lastMove.equals("KKK") && !lastMove.equals("QQQ") && !lastMove.equals("JJJ"))
		lastMove = "";

            if (!game.isOver()) {
                String[] moves = in.nextLine().split(" ");
		for (int i = 0; i < moves.length; i++) {
		    lastMove += moves[i];
		game.processMoves(moves);
            }
        } while(!game.isOver());

        System.out.println(game.getBoard());

	if (lastMove.equals("KKK") || lastMove.equals("QQQ") || lastMove.equals("JJJ"))
	    System.out.println("Winner");
	else {
            if(game.didWin())
                System.out.println("Winner");
            else
                System.out.println("Lost");
	}
    }
}
