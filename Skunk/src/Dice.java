import java.util.Random;

public class Dice {

	public static int roll(){
		return (int) (Math.random()*6 + 1);
	}
	
	
	public static void main(String Args[]) {
		System.out.println("Roll 1:"+Dice.roll());
		System.out.println("Roll 2:"+Dice.roll());
		System.out.println("Roll 3:"+Dice.roll());
		System.out.println("Roll 1:"+Dice.roll());
		System.out.println("Roll 2:"+Dice.roll());
		System.out.println("Roll 3:"+Dice.roll());
		System.out.println("Roll 1:"+Dice.roll());
		System.out.println("Roll 2:"+Dice.roll());
		System.out.println("Roll 3:"+Dice.roll());
	}
}
