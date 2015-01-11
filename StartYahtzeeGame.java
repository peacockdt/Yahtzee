/**
*  Name: Tom Peacock
*  CSC 201 Final Project
*  Description:  Uses Yahtzee class to play a game of Yahtzee until the player reached a score of 500
*/
public class StartYahtzeeGame 
{

	public static void main(String[] args) 
	{
		Yahtzee game = new Yahtzee();
		
		//Prints the instructions:
		System.out.println("Please enter the die number(s) you wish to re-roll with a space between each number.");
		System.out.println("Once you have finished making your selection, or if you want to keep all dice.");
		System.out.println("Enter zero, then press enter.");
		System.out.println();
		
		while(game.gameOver() == false)
		{
			game.firstRoll();
			game.secondRoll();
			game.recordScore();
			System.out.println("Your total score is: " + game.getScore());
			System.out.println();
		}
		
		System.out.println("Game Over!");

	}

}
