/**
*  Name: Tom Peacock
*  CSC 201 Final Project
*  Description:  Yahtzee class used with StartYahtzeeGame class
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee 
{
	Scanner keyboard = new Scanner(System.in);
	Random die = new Random();
	private int[] roll = new int[5];
	private int score;
	private int FINAL_SCORE = 500;
	private boolean winner = false;
	

//Makes first roll, sorts, and prints output
	public void firstRoll()
	{
		for(int i = 0; i < roll.length; i++)
			roll[i] = die.nextInt(5) + 1;
		
		Arrays.sort(roll);
		
		System.out.println("1 2 3 4 5 : Die number");
			
		for(int i = 0; i < roll.length; i++)
			System.out.print(roll[i] +" ");
//		System.out.println();
	}
	
//Re-rolls dice, sorts, and prints output
	public void secondRoll()
	{
		int newDie = -1;
		
		System.out.println();
		
		
		while(newDie != 0)
		{
			newDie = keyboard.nextInt();
			
			if(newDie == 1)
				roll[0] = die.nextInt(5) + 1;
			else if(newDie == 2)
				roll[1] = die.nextInt(5) + 1;
			else if(newDie == 3)
				roll[2] = die.nextInt(5) + 1;
			else if(newDie == 4)
				roll[3] = die.nextInt(5) + 1;
			else if(newDie == 5)
				roll[4] = die.nextInt(5) + 1;			
		}
		
		Arrays.sort(roll);	
		
		for(int i = 0; i < roll.length; i++)
			System.out.print(roll[i] +" ");
		System.out.println();
				
	}
	
//Inspects array for scoring hands and returns score 
	public void recordScore()
	{
		int straightCount = 0;
		int pairCount = 0;
		int threeOfAKindCount = 0;
		int sumScore = 0;
		
//Counts number of straights, pairs, and 3-Of-A-Kind
		for(int i = 0; i < roll.length - 1; i++)
		{
			if(roll[i] == (roll[i + 1] - 1))
				straightCount++;
		}
		for(int i = 0; i < roll.length - 1; i++)
		{
			if(roll[i] == roll[i + 1])
				pairCount++;
		}
		for(int i = 0; i < roll.length - 2; i++)
		{
			if((roll[i] == roll[i + 1]) && (roll[i] == roll[i + 2]))
				threeOfAKindCount++;		
		}

//Calculates the sum of the dice
		for(int i = 0; i < roll.length; i++)
			sumScore = sumScore + roll[i];
				
//Finds hands & increases score
		if(straightCount == 4)
		{
			score = score + 40;
			System.out.println("Large Straight: 40 points.");
		}else if(straightCount == 3)
		{
			score = score + 30;
			System.out.println("Small Straight: 30 points.");
		}
		if(pairCount == 4 && threeOfAKindCount == 3)
		{
			score = score + 50;
			System.out.println("Yahtzee!! 50 points.");	
		}					
		if(pairCount == 3 && threeOfAKindCount == 1)
		{
			score = score + 25;
			System.out.println("Full House: 25 points.");		
		}
		if(pairCount == 3 && threeOfAKindCount == 2)
		{
			score = score + sumScore;
			System.out.println("Four-Of-A-Kind: sum of the dice.");			
		}
		if(pairCount == 2 && threeOfAKindCount == 1)
		{
			score = score + sumScore;
			System.out.println("Three-Of-A-Kind: sum of the dice.");
		}if((threeOfAKindCount == 0) && (straightCount < 3))
		{
			score = score + sumScore;
			System.out.println("Chance: sum of the dice.");
		}
									
	}
	
	public int getScore()
	{
		return score;
	}
	
	public boolean gameOver()
	{
		if(getScore() >= FINAL_SCORE)
			winner = true;
		
		return winner;
		
	}
	
	
}
