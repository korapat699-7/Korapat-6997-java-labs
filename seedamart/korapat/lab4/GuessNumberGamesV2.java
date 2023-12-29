package seedamart.korapat.lab4;
/* Guess Number Games V2:

 * Develop a Java program named GuessNumberGamesV2
 * This program is an advanced iteration of NumberGuessingGames
 * designed with enhanced features to elevate player engagement and interaction. 
 * GuessNumberGamesV2 maintains the core gameplay of its predecessor, 
 * challenging players to guess a randomly generated number within a specified range.
 * 
 * After game is end the output should be:
 * 
 * Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: a
 * All guesses:
 * 1 2 3 
 * Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: g
 * Enter the number of guesses you want to see (1-3):2
 * Guess 2: 2
 * Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: 
 * Want to play again (Y or y):x
 * Thank you for playing our games. Bye!
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 29 December 2023
 */

import java.util.*;

public class GuessNumberGamesV2 {
    static int answer, min, max, numTries, maxTries, num; // Static variables to store game parameters
    static int[] list; // Array to store guesses
    static Scanner input = new Scanner(System.in); // Scanner object for user input
    static String question_list, question_game;

    public static void configure() {
        // Method to configure game parameters
        do {
            System.out.print("Enter the min value:");
            min = input.nextInt();
            if (min < 1) {
                System.out.println("The min value must be more than 0");
            }
        } while (min < 1);

        do {
            System.out.print("Enter the max value:");
            max = input.nextInt();
            if (max <= min) {
                System.out.println("The max value must be at least equal to the min");
            }
        } while (max <= min);

        do {
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
            if (maxTries <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
            }
        } while (maxTries <= 0);
    }

    public static void genAnswer() {
        // Method to generate a random answer within the specified range
        answer = min + (int) (Math.random() * ((max - min) + 1));
        // System.out.println("The answer is " + answer);
    }

    public static void printList() {
        System.out.println("All guesses:");
        for (int i = 0; i < numTries; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println(); // Move this line outside the loop to print a newline after all guesses
    }

    public static void playGame() {
        // Method to play the number guessing game
        while (true) {
            list = new int[maxTries]; // Initialize the array to store guesses
            System.out.println("Welcome to a number guessing game!");
            numTries = 0;
            while (true) {
                if (num == answer) {
                    System.out.println("Congratulations!");
                    // System.out.println("You have tried " + numTries + " time" + (numTries > 1 ?
                    // "s" : ""));
                    break;

                } else if (numTries == maxTries) {
                    System.out.println("You ran out of guesses. The answer was " + answer);
                    break;

                }

                while (true) {
                    System.out.print("Enter an integer between " + min + " and " + max + ":");
                    numTries++;
                    num = input.nextInt();
                    if (num < min || num > max) {
                        while (true) {
                            System.out.print("Your guess should be in [" + min + "," + max + "]" + ":");
                            num = input.nextInt();
                            if (num >= min && num <= max) {
                                list[numTries - 1] = num;
                                break;
                            }
                        }
                    }

                    if (num == answer || numTries == maxTries) {
                        list[numTries - 1] = num;
                        break;
                    }

                    if (num < answer) {
                        System.out.println("Try a higher number!");
                        list[numTries - 1] = num;
                        break;
                    }

                    if (num > answer) {
                        System.out.println("Try a lower number!");
                        list[numTries - 1] = num;
                        break;
                    }
                }

            }

            while (true) {
                System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
                question_list = input.next();

                if (question_list.equals("a")) {
                    printList();
                } else if (question_list.equals("g")) {
                    System.out.print("Enter the number of guesses you want to see (1" + "-" + list.length + "):");
                    num = input.nextInt();
                    System.out.println("Guess " + num + ": " + list[num - 1]);
                } else {
                    break;
                }
            }

            System.out.print("Want to play again (Y or y):");
            question_game = input.next();

            if (question_game.equals("Y") || question_game.equals("y")) {
                genAnswer();
            } else {
                System.out.println("Thank you for playing our games. Bye!");
                break;
            }

        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        configure(); // Set up game parameters
        genAnswer(); // Generate a random answer
        playGame(); // Start the number guessing game
        input.close();
    }
}
