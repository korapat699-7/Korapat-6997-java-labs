package seedamart.korapat.lab3;
import java.util.*;

/*Number Guessing Method Game:
 * The program also contains a static int variable answer 
 * which contains the answer number of the game.
 *
 * This program is contain subroutines :
 *  1. genAnswer() is a static void subroutine that will generate the answer 
 *     and then store the value in the variable answer.
 *  2. playGame() is a static void subroutine that runs the game. 
 *     The subroutine performs the following steps: 
 *          1. reads in the input 
 *          2. displays appropriate output 
 *          3. decrements the remaining guess. 
 * It repeats the steps if there are numbers of guesses remaining 
 * or the correct answer has not been entered.
 * 
 * The output should be:
 * "Welcome to a number guessing game !"
 * 
 * "Enter an integer between <min> and <max>:" <input>
 *  If number not equals to answer:
 *      > "Try a high number ! or Try a low number !"
 *  If not :
 *    If you lose this game program will desplay:
 *          > "You have tried <numTries> times. You ran out of guesses"
 *          > "The answer is <answer>"
 *    If not (You won this game.):
 *          > "Congratulations!"
 *          > "You have tried <numTries> time/times."
 *          
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 1 December 2023
 */

 public class NumberGuessingMethodGame {
    static int answer; // Variable to store the randomly generated answer
    final static int MIN = 1; // Constant representing the minimum value for the guessing range
    final static int MAX = 20; // Constant representing the maximum value for the guessing range

    // Method to generate a random answer within the specified range
    public static void genAnswer() {
        answer = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
         //System.out.println(answer); // Uncomment to check the generated answer
    }

    // Method to play the number guessing game
    public static void playGame() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to a number guessing game!");
        int time = 0; // Variable to track the number of attempts

        while (true) {
            System.out.print("Enter an integer between 1 and 20:");
            int num = s.nextInt();

            // Check if the user has reached the maximum number of attempts
            if (time == 4) {
                if (num == answer) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + (time + 1) + " times");
                    break;
                } else {
                    time += 1;
                    System.out.println("You have tried " + (time) + " times. " + "You ran out of guesses");
                    System.out.println("The answer is " + answer);
                    break;
                }
            } else if (num < answer) {
                time += 1;
                System.out.println("Try a higher number!");
            } else if (num > answer) {
                time += 1;
                System.out.println("Try a lower number!");
            } else {
                time += 1;
                // Check if the user won the game
                if (time == 1) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + time + " time");
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + time + " times");
                }
                break;
            }
        }
        s.close(); // Close the Scanner to avoid resource leaks
    }

    // Main method to start the program
    public static void main(String[] args) {
        genAnswer(); // Generate a random answer
        playGame(); // Start the number guessing game
    }
}
