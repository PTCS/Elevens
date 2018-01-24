import java.util.Scanner;
import java.util.ArrayList;
public class Driver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Elevens game = new Elevens();

        do {
	    System.out.println();
            System.out.println(game.getBoard());
	    System.out.println();
	    System.out.println("There are "+game.getDeckSize()+" cards left in the deck.");
	    System.out.println("Please enter your move below:");
	    
	    boolean moveValidity=true;
            if (!game.isOver()) {
                String[] movesArray = in.nextLine().split(" ");
		ArrayList<String> movesList = new ArrayList<String>();
		for(int i=0;i<movesArray.length;i++){
		    movesList.add(movesArray[i]);
		}
		if(!(movesList.contains("J")&&movesList.contains("Q")&&movesList.contains("K"))){
		    if(movesList.size()==2){
			if(!movesList.contains("T")&&!movesList.contains("J")&&!movesList.contains("Q")&&!movesList.contains("K")&&!movesList.contains("A")){
		        	if(Integer.parseInt(movesList.get(0))+Integer.parseInt(movesList.get(1))!=11||!game.getBoard().contains(movesList.get(0))||!game.getBoard().contains(movesList.get(1))){
			            System.out.println("That is an invalid move, please try again.");
				    moveValidity=false;
			        }
			}
			else{
			    if(!(movesList.contains("A")&&movesList.contains("T"))||!game.getBoard().contains(movesList.get(0))||!game.getBoard().contains(movesList.get(1))){
				System.out.println("That is an invalid move, please try again.");
				moveValidity=false;
			    }
			}
		    }
		}
		if(moveValidity){
                    game.processMoves(movesArray);
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
