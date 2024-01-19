package seedamart.korapat.lab5;
/* GuessNumberGameVer2:
 *
 * GuessNumberGameVer2 inherited from GuessNumberGameVer1
 *
 * This class is contain three new method :
 * 
 *  1.  showSpecific() - This method will display the guess number at a 
 *      specific position after the user types ‘g’ or ‘G’ and then the specific position.
 *  2.  showGuesses() - This method will list all the user’s guesses after the game ends 
 *      and the user types ‘a’ or ‘A’.
 *  3.  playGames() - This method will call other methods: playGame(), showSpecific(), 
 *      and showGuesses() and keep running until the user types ‘q’.
 *
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 19 January 2024
 */
import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {

    // Static variables to store guesses and game statistics
    protected static int[] guesses;
    protected static int num, numTries, minimum, gamePlayed = 0, allGuess = 0;
    protected static int numGuesses = 0;
    protected static final int MAX_GUESSES = 20;
    
    // Scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    // Default constructor
    public GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    // Constructor with custom minNum and maxNum
    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    // Constructor with custom minNum, maxNum, and maxTries
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    // Method to show a specific guess based on user input
    public void showSpecific() {
        System.out.println("Enter which guess in range (1-" + numTries + ")");
        int num = scanner.nextInt();
        if (num >= 1 && num <= numTries) {
            System.out.println("Guess number " + num + " is " + guesses[num - 1]);
        } else {
            System.out.println("Invalid input. Please enter a number between 1 and " + numTries);
        }
    }

    // Method to display all guesses
    public void showGuesses() {
        for (int i = 0; i < numTries; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    // Overridden method to play the game with additional features
    @Override
    public void playGame() {
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        guesses = new int[MAX_GUESSES]; // Initialize the array to store guesses
        System.out.println("Welcome to a number guessing game!");
        numTries = 0;
        allGuess = 0;

        // Main game loop
        while (true) {
            if (num == correctNum) {
                System.out.println("Congratulations!");
                break;

            } else if (numTries == maxTries) {
                System.out.println("You ran out of guesses. The answer was " + correctNum);
                break;

            }
            while (true) {
                System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
                numTries++;
                num = scanner.nextInt();
                if (num < minNum || num > maxNum) {
                    while (true) {
                        System.out.print("Your guess should be in [" + minNum + "," + maxNum + "]" + ":");
                        num = scanner.nextInt();
                        if (num >= minNum && num <= maxNum) {
                            guesses[numTries - 1] = num;
                            allGuess += num;
                            break;
                        }
                    }
                }

                if (num == correctNum || numTries == maxTries) {
                    allGuess += num;
                    guesses[numTries - 1] = num;
                    break;
                }

                if (num < correctNum) {
                    System.out.println("Try a higher number!");
                    allGuess += num;
                    guesses[numTries - 1] = num;

                    break;
                }

                if (num > correctNum) {
                    System.out.println("Try a lower number!");
                    allGuess += num;
                    guesses[numTries - 1] = num;
                    break;
                }

            }

        }
    }

    // Method to play the game with additional features (play again, view guesses)
    public void playGames() {
        playGame();

        while (true) {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit :");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
            String question = scanner.next();
            if (question.equals("g") || question.equals("G")) {
                showSpecific();
            } else if (question.equals("a") || question.equals("A")) {
                showGuesses();
            } else if (question.equals("q")) {
                break;
            } else if (question.equals("y")) {
                this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
                playGame();
            }

        }
    }
}
