import java.util.Scanner;
import java.util.Arrays;	

public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
            System.out.println(game.getBoard());

            if (!game.isOver()) {
                String[] moves = in.nextLine().split(" ");
		if(moves.length!=2){
		    boolean contains = Arrays.asList(moves).contains("J");
		    contains = contains && Arrays.asList(moves).contains("Q");
		    contains = contains && Arrays.asList(moves).contains("K");
		    if(contains){
			game.processMoves(moves);	
		    }
		}
		else if(moves.length == 2){
		    if(moves[0].equals("A"))
			moves[0] = "1";
		    if(moves[1].equals("A"))
			moves[1]="1";
		    if(moves[0].equals("T"))
			moves[0]="10";
		    if(moves[1].equals("T"))
			moves[1]="10";
		    try{
		    	int temp = Integer.parseInt(moves[0]);
		    	int temp1 = Integer.parseInt(moves[1]);
		    	if(temp+temp1==11){
			    game.processMoves(moves);
		    	}
		    }catch(Exception e){
			System.out.println("Your input was not accepted" +"\n" + "Please enter another");
			
		    }	
		}
		else{
		    System.out.println("Your input was not accepted"+"\n"+"Please enter another");
		}
		System.out.println("");
                
            }
        } while(!game.isOver());

        System.out.println(game.getBoard());

        if(game.didWin())
            System.out.println("Winner");
        else
            System.out.println("Lost");


    }
}
