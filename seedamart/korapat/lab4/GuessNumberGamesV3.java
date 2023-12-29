package seedamart.korapat.lab4;

/* Guess Number Games V3:

 * Develop a Java program called GuessNumberGameV3, an advanced version of GuessNumberGameV2
 * with additional functionalities and statistical tracking. 
 * This program will reinforce concepts of loops, conditionals, arrays, 
 * and basic statistics in Java.
 * 
 * In game log the output should be:
 *  > Game Log: Answer: <answe>, Guesses: <numTries>, Win: false
 * 
 * After the game is end the output should be:
 *  > ----- Game Statistics -----
 *  > Total games played: <gamePlayed>
 *  > Total win: <gameWin>
 *  > Win Ratio: <winRatio>
 *  > Average guess per game: <avgGuess>
 *  > High Score (Least Guesses): <highscore>
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 29 December 2023
 */
import java.util.*;

public class GuessNumberGamesV3 {
    static int answer, min, max, numTries, maxTries, num, allGuess, gamePlayed, gameWin, highScore ; // Static variables to store game parameters
    static float winRatio, avgGuess ;
    static boolean winGame ;
    static int[] list; // Array to store guesses
    static int[] num_guess;
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
        //System.out.println("The answer is " + answer);
    }

    public static void printList() {
        System.out.println("All guesses:");
        for (int i = 0; i < numTries; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println(); // Move this line outside the loop to print a newline after all guesses
        
    }

    public static void statGame() {
        winRatio = ((float)gameWin / (float)gamePlayed) * 100;
        avgGuess = (allGuess / (float)gamePlayed);
        String winRatiof = String.format("%.1f",winRatio);
        String avgGuessf = String.format("%.1f", avgGuess);
        System.out.println("----- Game Statistics -----");
        System.out.println("Total games played: " + gamePlayed );
        System.out.println("Total win: " + gameWin );
        System.out.println("Win Ratio: " + winRatiof + "%");
        System.out.println("Average guess per game: " + avgGuessf);
        if (highScore == 0) {
            System.out.println("High Score (Least Guesses): N/A");
        } else {
            System.out.println("High Score (Least Guesses): " + highScore);
        }

    }
    public static void gameLog() {
        System.out.println("Game Log: Answer: " + answer + ", Guesses: " + numTries + ", Win: " + winGame);
    }
    public static void playGame() {
        // Method to play the number guessing game
        while (true) {
            gamePlayed ++;
            list = new int[maxTries]; // Initialize the array to store guesses
            System.out.println("Welcome to a number guessing game!");
            numTries = 0;
            while (true) {
                if (num == answer) {
                    System.out.println("Congratulations!");
                    gameWin += 1;
                    winGame = true;
                    if (numTries < highScore || highScore == 0) {
                        highScore = numTries;
                    }
                    // System.out.println("You have tried " + numTries + " time" + (numTries > 1 ? "s" : ""));
                    break;             
                } else if (numTries == maxTries) {
                    System.out.println("You ran out of guesses. The answer was " + answer);
                    winGame = false;
                    break;
                }

                while (true) {
                    System.out.print("Enter an integer between " + min + " and " + max + ":");
                    numTries++;
                    allGuess++ ;
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
            gameLog();
            System.out.print("Want to play again (Y or y):");
            question_game = input.next();
            if (question_game.equals("Y") || question_game.equals("y")) {
                genAnswer();
                num = -1;
            } else {
                statGame();
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
