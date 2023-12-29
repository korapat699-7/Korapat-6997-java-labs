package seedamart.korapat.lab3;
/*Number Guessing Games :

 * This program will called NumberGuessingGames 
 * which allows the user to play the number guessing game 
 * in the version ConfigurableNumberGuessingGame several times 
 * until the user indicates that he/she wants to stop playing the game.
 * 
 * The output should be
 * "Enter the min value:<min>""
 *      If minimum value is less than 1 program will display:
 *          > "The min value must be more than 0"
 *             and repeat until a value greater than zero is entered.
 * 
 * "Enter the max value:<max>"
 *      If maximum value is less than minimum program will display:
 *          > "The max value must be at least equal to the min"
 *             and repeat until a value greater than minimum is entered.
 * 
 * "Enter the maximum number of tries:"<maxTries>
 *      If maximum of tries is negative value or zero program will display:
 *          > "The maximum number of tries must be greater than 0"
 *             and repeat until a value greater than zero is entered.
 * 
 * "Welcome to a number guessing game !"
 * 
 * "Enter an integer between <min> and <max>:" <input>
 *      If an integer is not between <min> and <max> program will display:
 *          > "The number must between <min> and <max>"
 *             and repeat until a number between min and max.
 *      If number not equals to answer:
 *          > "Try a high number ! or Try a low number !"
 *      If not :
 *              If you lose this game program will desplay:
 *                  > "You have tried <numTries> times. You ran out of guesses"
 *                  > "The answer is <answer>"
 *              If not (You won this game.):
 *                  > "Congratulations!"
 *                  > "You have tried <numTries> time/times."
 *          
 * 
 * "Want to play again (Y or y):"
 *      If user input "Y" or "y" program will loop this game,
 *      If not program will display:
 *          > "Thank you for playing our games. Bye!"
 * 
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 1 December 2023
 */
import java.util.*;

public class NumberGuessingGames {
    static int answer, min, max, numTries, maxTries; // Static variables to store game parameters
    static Scanner input = new Scanner(System.in); // Scanner object for user input

    public static void configure() { 
        // Method to configure game parameters
        System.out.print("Enter the min value:");
        min = input.nextInt();
     
        if (min < 1) { 
            // Validate minimum value
            while (true) {
                System.out.println("The min value must be more than 0");
                System.out.print("Enter the min value:");
                min = input.nextInt();
                if (min >= 1) {
                    break;
                }
            }
        }

        System.out.print("Enter the max value:");
        max = input.nextInt();

        if (max <= min) { 
            // Validate maximum value
            while (true) {
                System.out.println("The max value must be at least equal to the min");
                System.out.print("Enter the max value:");
                max = input.nextInt();
                if (max > min) {
                    break;
                }
            }
        }

        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();

        if (maxTries <= 0) { 
            // Validate maximum number of tries
            while (true) {
                System.out.println("The maximum number of tries must be greater than 0");
                System.out.print("Enter the maximum number of tries:");
                maxTries = input.nextInt();
                if (maxTries > 0) {
                    break;
                }
            }
        }
    }

    public static void genAnswer() { 
        // Method to generate a random answer within the specified range
        answer = min + (int) (Math.random() * ((max - min) + 1));
         //System.out.println(answer); // Uncomment to check the generated answer
    }

    public static void playGame() { 
        // Method to play the number guessing game
        Scanner check = new Scanner(System.in);
        
        while (true) {
            System.out.println("Welcome to a number guessing game!");
            int numTries = 0;

            while (true) {
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                int num = input.nextInt();

                
                if (num < min || num > max) {
                    // Validate user input range
                    while (true) {
                        System.out.println("The number must be between " + min + " and " + max);
                        System.out.print("Enter an integer between " + min + " and " + max + ":");
                        num = input.nextInt();
                        if (num >= min && num <= max) {
                            break;
                        }
                    }
                }
     
                if (numTries == maxTries - 1) { 
                    // Check if the user has run out of tries
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

            // Ask the user if they want to play again
            System.out.print("Want to play again (Y or y):");
            String YesNo = check.nextLine();

            if (YesNo.equals("Y") || YesNo.equals("y")) {
                genAnswer();
            } else {
                System.out.println("Thank you for playing our games. Bye!");
                // Close the Scanner to avoid resource leaks
                check.close();
                input.close();
                break; 
            }
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        configure(); // Set up game parameters
        genAnswer(); // Generate a random answer
        playGame(); // Start the number guessing game
    }
}
