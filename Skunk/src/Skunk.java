import java.util.Scanner;

public class Skunk {

	public static void main(String Args[]) throws Exception {
		
		String[] playersNames =  getPlayersNames();

		GameSkunk game = new GameSkunk(playersNames);
		
		
		while(game.isActive()){
			
			Player activePlayer = game.getCurrentPlayer();
			
			String action = promptAction(activePlayer);
			
			if(action.equals("roll")){
				
				Roll playersRoll = game.rollPlayer(activePlayer);
				System.out.println("Player "+activePlayer.getUsername()+" has rolled : ");
				System.out.println(playersRoll);
				
				
			}
			else if(action.equals("hold")){
				System.out.println("Player decided to pass");
				game.currentPlayerHold();
			}
			
			// if we change player player then lets print the score
			if(game.getCurrentPlayer() != activePlayer && game.isActive()){
				
				System.out.println("THE GAME SCOREBOARD IS:");
				game.printScore();
				
				
				System.out.println("NEXT PLAYER IS :" + game.getCurrentPlayer().getUsername());
				
			}
			
		}
		
		// END OF the GAME
		System.out.println("\nEND OF THE GAME\n");
		System.out.println("THE GAME SCOREBOARD IS:");
		game.printScore();
		
		System.out.println("\n**** THE WINNER IS : "+game.getPlayerWithMaxScore().getUsername()+" **** " );
		
		
		
		
	

	}


	public static String promptAction(Player player) {
		
		System.out.println("Current Player: "+player.getUsername()+", turnscore: "+player.getTurnScore()+", totalscore:"+player.getScore());

		String choice = "";
		Scanner choiceScanner = new Scanner(System.in);
		while(!validChoice(choice)){		
			System.out.println("Enter 'roll' to roll or 'hold' to hold");
			choice = choiceScanner.nextLine();
		}
		
		return choice;
		
	}
	
	private static boolean validChoice(String choice) {
		// TODO Auto-generated method stub
		return choice.equals("roll") || choice.equals("hold");
	}

	private static String[] getPlayersNames() {
		Scanner input = new Scanner(System.in); // int noOfPlayers= 2;
		System.out.println("Enter the number of players");
		int noOfPlayers = input.nextInt();
		System.out.println("Enter the name of the players"); //
		String name = input.nextLine();

		String[] players = new String[noOfPlayers];
		for (int i = 0; i < noOfPlayers; i++) {
			players[i] = input.nextLine();
		}
		
		return players;
	}
}
