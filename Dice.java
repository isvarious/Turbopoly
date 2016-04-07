package Turbopoly;
import java.util.Random;
public class Dice
{	
	//Used to generate a random int from 2 to 12
	Random rand = new Random();

	private int currentDiceTotal, die1, die2;
	
	//returns a combined total of both die rolls, (random int's from 0-5) 
	public int roll_Dice()
	{		
		die1 = rand.nextInt(6);
		die2 = rand.nextInt(6);
		
		//Used to update the value in die1 and die2 so that zero never gets rolled. 		
		if(die1 == 0){	die1++;	} //if value is 0, it increments to 1. 
		if(die2 == 0){	die2++;	} //if value is 0, it increments to 1. 
		
		currentDiceTotal = die1 + die2;
		
		return currentDiceTotal; //returns the current dice roll.
	}
	
	//Get methods for die1 and die2
	public int getDie1()
	{
		return die1;
	}
	public int getDie2()
	{
		return die2;
	}
}