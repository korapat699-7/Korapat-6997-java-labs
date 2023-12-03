package seedamart.korapat.lab3;
/*Configurable Number Guessing Game:
 * 
 * This program will add method configure() from version NumberGuessingMethodGame.
 * User can input values for minimum, and the maximum number of tries.
 * 
 * The output should be:
 * 
 * "Enter the min value:<min>""
 * "Enter the max value:<max>"
 * "Enter the maximum number of tries:"<maxTries>
 * 
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
import java.util.*;

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numTries, maxTries; // Variables to store game parameters
    static Scanner input = new Scanner(System.in); // Scanner object for user input

    // Method to configure game parameters
    public static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
    }

    // Method to generate a random answer within the specified range
    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
        //System.out.println(answer); // Uncomment to check the generated answer
    }

    // Method to play the number guessing game
    public static void playGame() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to a number guessing game!");
        int numTries = 0;

        while (true) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int num = s.nextInt();

            // Check if the user has reached the maximum number of attempts
            if (numTries == maxTries - 1) {
                if (num == answer) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + (numTries + 1) + " times");
                    break;
                } else {
                    numTries += 1;
                    System.out.println("You have tried " + (numTries) + " times. " + "You ran out of guesses");
                    System.out.println("The answer is " + answer);
                    break;
                }
            } else if (num < answer) {
                numTries += 1;
                System.out.println("Try a higher number!");
            } else if (num > answer) {
                numTries += 1;
                System.out.println("Try a lower number!");
            } else {
                numTries += 1;
                // Check if the user won the game
                if (numTries == 1) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numTries + " time");
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numTries + " times");
                }
                break;
            }
        }
        s.close(); // Close the Scanner to avoid resource leaks
    }

    // Main method to start the program
    public static void main(String[] args) {
        configure(); // Set up game parameters
        genAnswer(); // Generate a random answer
        playGame(); // Start the number guessing game
    }
}

