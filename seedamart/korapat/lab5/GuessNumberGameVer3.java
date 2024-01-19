package seedamart.korapat.lab5;
/* GuessNumberGameVer3:
 *
 * GuessNumberGameVer3 inherited from GuessNumberGameVer3
 * three new methods, which are guessAverage(), guessMin() and guessMax() 
 * to calculate the average, minimum and maximum of the guesses respectively.
 * 
 * This class is contain three new method :
 * 
 *  1.  guessAverage() to display the average value of all the guesses.
 *  2.  guessMin() to show the minimum of the guesses the user entered.
 *  3.  guessMax() to display the maximum of all the guesses.
 * 
 *  When the user types in an incorrect command, the program displays the message 
 *  "Invalid command" repeats the question.
 *
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 19 January 2024
 */
public class GuessNumberGameVer3 extends GuessNumberGameVer2 {

    // Static variables to store additional game statistics
    protected static float avg;
    protected static int minimum, maximum;

    // Default constructor
    public GuessNumberGameVer3() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    // Constructor with custom minNum and maxNum
    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    // Constructor with custom minNum, maxNum, and maxTries
    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    // Method to calculate and display the average of the guesses
    public void guessAverage() {
        avg = (float) allGuess / numTries;
    }

    // Method to find and display the minimum guess
    public void guessMin() {
        minimum = guesses[0]; // Initialize with the first guess

        for (int i = 1; i < numTries; i++) {
            if (guesses[i] < minimum) {
                minimum = guesses[i];
            }
        }

        System.out.println("Min = " + minimum);
    }

    // Method to find and display the maximum guess
    public void guessMax() {
        maximum = guesses[0]; // Initialize with the first guess

        for (int i = 1; i < numTries; i++) {
            if (guesses[i] > maximum) {
                maximum = guesses[i];
            }
        }

        System.out.println("Max = " + maximum);
    }

    // Overridden method to play the game with additional features
    @Override
    public void playGames() {
        super.playGame();
        guessAverage();

        // Main game loop with additional commands
        while (true) {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit :");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
            System.out.println(
                    "Type 'v' to show the average of the guesses, 'm' to show the minimum of the guesses, or 'x' show the maximum of the guesses");
            String question = scanner.next();
            
            // Process user commands
            if (question.equals("g") || question.equals("G")) {
                showSpecific();
            } else if (question.equals("a") || question.equals("A")) {
                showGuesses();
            } else if (question.equals("v") || question.equals("V")) {
                guessAverage();
                System.out.printf("Average = %.2f\n", avg);
            } else if (question.equals("m") || question.equals("M")) {
                guessMin();
            } else if (question.equals("x") || question.equals("X")) {
                guessMax();
            } else if (question.equals("q") || question.equals("Q")) {
                break;
            } else if (question.equals("y") || question.equals("Y")) {
                playGame();
                this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
            } else {
                System.err.println("Invalid command");
            }
        }
    }
}
