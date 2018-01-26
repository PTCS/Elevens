import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();
	System.out.println("Welcome to Elevens.");
	System.out.println("(Hint: type 'hint' without quotes for a hint)");
        do {
            System.out.println(game.getBoard());
	    String[] moves = null; 
            if (!game.isOver()) {
		do{
                	moves = in.nextLine().split(" ");
			if(moves[0].equals("hint") || moves[0].equals("Hint")){
				System.out.println("hint: "+game.getHint());
			}
			if(!game.validMoves(moves)){
				if(!moves[0].equals("hint")||moves[0].equals("Hint"))
					System.out.println("Invalid move");
			}
		}
		while(!game.validMoves(moves));
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
