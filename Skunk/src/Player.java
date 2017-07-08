
public class Player {
	private int totalScore;
	private int turnScore;
	private int chips;

	private String username;
	private String action = "";
	private boolean human;

	public Player(String username) {
		this.username = username;
		initScore();

	}

	private void initScore() {
		totalScore = 0;
		turnScore = 0;
		chips = 50;
	}


	public void hold() {
		totalScore += turnScore;
		turnScore = 0;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return totalScore;
	}

	public void setScore(int score) {
		// TODO Auto-generated method stub
		this.totalScore = score;
	}

	public int getTurnScore() {
		// TODO Auto-generated method stub
		return this.turnScore;
	}

	public void setTurnScore(int score) {
		this.turnScore = score;
	}


	public String getUsername() {
		return this.username;

	}

	public void setUsername(final String name) {
		this.username = name;
	}

	public Roll roll() {
		Roll roll = new Roll();
		
		updatePlayerScore(roll);
		
		return roll;
		
	}

	private void updatePlayerScore(Roll roll) {
		
		if(roll.hasSkunk()){
			
			
			// only one skunk
			if(!roll.hasTwoSkunk()){
				turnScore = 0;
				chips--;
			}
			
			if(roll.hasSkunkAndDuce()){
				turnScore = 0;
				chips -= 2;
			}
			
			if(roll.hasTwoSkunk()){
				turnScore =0;
				totalScore = 0;
				chips -= 4;
				
			}
		}
		else // didn't roll any skunk 
		{
			turnScore += roll.getRollScore(); 
		}
		
	}

	public int getChips() {
		// TODO Auto-generated method stub
		return chips;
	}
	
	
	

	

}
