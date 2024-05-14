/*Anthony Ma
 * 10/3/2023
 * This is a game that has the user guess a random number
 */
import java.util.*;
public class GuessingGame {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name?");
		String userName = input.nextLine();
		System.out.println("Hello "+userName+", let's play a guessing game.\nI will pick a random number and you can try to guess it");
		String keepPlaying = "b";
		while (!keepPlaying.equals("n")) {
			System.out.println("Please tell me the maximum and minimum number:");
			System.out.print("Max:");
			int max = Integer.parseInt(input.next());
			System.out.print("Min:");
			int min = Integer.parseInt(input.next());
			if (min>max) {
				throw new IllegalArgumentException("Min can't be greater than max.");
			}
			int range = (max-min)+1;
			int myNum = (int)(range*Math.random())+min;
			int count = 0;
			int guess;
				do {
					System.out.print("Enter your guess: ");
					guess = Integer.parseInt(input.next());
					if (guess<min||guess>max) {
						throw new IllegalArgumentException("Guess outside of range!");
					}else if (guess<myNum) {
						System.out.println("Too Low. Try again.");
					}else if (guess>myNum){
						System.out.println("Too High. Try again.");
					}
					count++;
				}while (guess!=myNum);
			System.out.println("Correct! You took "+count+" tries to get the right answer.");
			System.out.print("Play again (Y/N)?");
			keepPlaying = input.next();
			keepPlaying = keepPlaying.toLowerCase();
		}
	}
}
