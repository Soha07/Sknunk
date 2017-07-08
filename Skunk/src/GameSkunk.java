import java.util.ArrayList;

public class GameSkunk {
	private boolean active = false;
	private Player currentPlayer;
	private ArrayList<Player> players;
	private int currentPlayerIndex = 0;
	private int turnScore = 0;
	private int kitty = 200;
	private boolean lasttrun;
	
	private final int END_SCORE = 100;
	
	private ArrayList<Player> finishedPlayers = new ArrayList<>();
	

	public GameSkunk(String[] playersNames) {
		players = new ArrayList<Player>();
		
		for(String playerName: playersNames){	
			players.add(new Player(playerName));
		}
		
		setFirstPlayer();
		active = true;
	}

	public void start() {
		this.active = true;
		setFirstPlayer();
	}

	public void end() {
		this.active = false;
	}

	public void nextPlayer() {

		currentPlayerIndex++;
		if(currentPlayerIndex == players.size()){
			currentPlayerIndex = 0;
		}

	}

	private void setFirstPlayer() {
		currentPlayer = players.get(currentPlayerIndex);
	}

	public void setTurnscore(int score) {
		this.turnScore = score;

	}

	public boolean isActive() {
		return finishedPlayers.size() < players.size();
	}

	public void addUser(Player user) {
		this.players.add(user);

	}

	public Player getCurrentPlayer() {
		Player nextPlayer = players.get(currentPlayerIndex);
		
		while(hasFinished(nextPlayer) && finishedPlayers.size() < players.size()){
			this.nextPlayer();
			nextPlayer = players.get(currentPlayerIndex);
		}
		
		return nextPlayer;
	}

	private boolean hasFinished(Player nextPlayer) {
		
		for(Player p: finishedPlayers){
			if(p == nextPlayer){
				return true;
			}
		}
		
		return false;
	}

	public Roll rollPlayer(Player player) throws Exception {
		if(player != getCurrentPlayer()){
			throw new Exception("this player is not allowed to roll");
		}
		
		Roll roll = player.roll();
		
		updateGameChips(roll);
		
		if(roll.hasSkunk()){
			this.currentPlayerHold();
		}
		
		return roll;
	}

	private void updateGameChips(Roll roll) {
		if(roll.hasSkunk()){
			
			// only one skunk
			if(!roll.hasTwoSkunk()){
				kitty += 1;
			}
			
			if(roll.hasSkunkAndDuce()){
				kitty += 2;
			}
			
			if(roll.hasTwoSkunk()){
				kitty += 4;
				
			}
		}
	}

	public void currentPlayerHold() {
		this.getCurrentPlayer().hold();
		
		if(lasttrun){
			finishedPlayers.add(getCurrentPlayer());
		}
		
		if(getCurrentPlayer().getScore() >= END_SCORE && !lasttrun){
			lasttrun = true;
			finishedPlayers.add(this.getCurrentPlayer());
			
		}
		
		nextPlayer();
		//test if the player has a score of > 100
		
	}

	public void printScore() {
		System.out.println("-------------------------------------");
		System.out.println("PlayerName \t\t CurrentScore \t\t" + "Chips");
		System.out.println("-------------------------------------");
		for(Player p: players){
			System.out.println(p.getUsername() + "\t\t " + p.getScore() + "\t\t " + p.getChips());
		}
		System.out.println("-------------------------------------");
		
	}

	public Player getPlayerWithMaxScore() {
		Player maxPlayer = getCurrentPlayer();
		
		for(Player p: players){
			if(p.getScore() > maxPlayer.getScore()){
				maxPlayer = p;
			}
		}
		
		return maxPlayer;
		
	}
	
	
}
