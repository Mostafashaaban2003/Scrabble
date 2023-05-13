
public class Scrabble   {
	
	public static void main(String[] args) {
		
		 // get the names for players and IDs
		Game.info();
		
		// Start Quarter Final
		System.out.println("\n\nQuarter Final\n\n");
		Game.competitions(8);
		Game.Match(8,4);
		
		// Start semi Final
		System.out.println("\n\nSemi Final\n\n");
		Game.competitions(4);
		Game.Match(4,2);
		
		// Start Final
		System.out.println("\n\nFinal\n\n");
		Game.competitions(1);
		Game.Match(1,0);
		
		// To announce the winner
		Game.winner();
		
		
		
	}
}
