
public class Roll {
	
	int diceOneResult;
	int diceTwoResult;
	
	public Roll(){
		
		diceOneResult = Dice.roll();
		diceTwoResult = Dice.roll();
	}
	
	public boolean hasSkunk(){
		
		return diceOneResult == 1 || diceTwoResult == 1;
		
	}
	
	public boolean hasTwoSkunk(){
		
		return diceOneResult == 1 && diceTwoResult == 1;
	}
	
	public boolean hasSkunkAndDuce(){
		
		return hasSkunk() && (diceOneResult == 2 || diceTwoResult == 2);
	}
	
	public int getRollScore(){
		return diceOneResult + diceTwoResult;
	}
	
	
	public String toString(){
		String rollToString =  diceOneResult + " - " +diceTwoResult + "\n";
		if(hasSkunk()){
			
			// only one skunk
			if(!hasTwoSkunk() && ! hasSkunkAndDuce()){
				rollToString += "  the player rolled 'A SKUND' so he lost his trurn and 1 chip\n";
			}
			
			if(hasSkunkAndDuce()){
				rollToString += "  the player rolled  'A SKUND AND A DUCE' so he lost his trurn and 2 chips\n";
			}
			
			if(hasTwoSkunk()){

				rollToString += "  the player rolled 'TWO SKUNKs' so he lost his trurn, score,  and 4 chips\n";
			}
			
			
		}
		return rollToString;
		
	}
}
