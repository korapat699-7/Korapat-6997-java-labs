package seedamart.korapat.lab5;
/*  GuessNumberGameVer1:
 *
 * GuessNumberGameVer1 class represents a number guessing game with customizable parameters.
 *
 * This class includes five protected attributes: minNum, maxNum, correctNum, maxTries, and numOfGames.
 * minNum and maxNum define the range of possible numbers, correctNum stores the target number to guess,
 * maxTries determines the maximum number of attempts allowed, and numOfGames counts the total number of games played (static).
 *
 * The class provides three constructors and six getter and setter methods for minNum, maxNum, and maxTries.
 * It also features the playGame method for executing the number guessing game.
 * Additionally, there is a toString method to generate a descriptive string representation of the object,
 * and a static method getNumOfGames to retrieve the total number of games played.
 *
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 19 January 2024
 */

import java.util.Scanner;

public class GuessNumberGameVer1 {

    // Instance variables to store game parameters
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    
    // Static variable to keep track of the number of games played
    protected static int numOfGames = 0;

    // Scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Default constructor
    public GuessNumberGameVer1() {
        // Default values for minNum, maxNum, and maxTries
        minNum = 1;
        maxNum = 10;
        maxTries = 3;
        
        // Generate a random correct number within the specified range
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        
        // Increment the number of games played
        numOfGames++;
    }

    // Constructor with custom minNum and maxNum
    public GuessNumberGameVer1(int minNum, int maxNum) {
        setMaxNum(maxNum);
        setMinNum(minNum);
        maxTries = 3;
        
        // Generate a random correct number within the specified range
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        
        // Increment the number of games played
        numOfGames++;
    }

    // Constructor with custom minNum, maxNum, and maxTries
    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        setMaxNum(maxNum);
        setMinNum(minNum);
        setMaxTries(maxTries);
        
        // Generate a random correct number within the specified range
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        
        // Increment the number of games played
        numOfGames++;
    }

    // Getter and setter methods for minNum, maxNum, and maxTries

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    // Method to play the game
    public void playGame() {
        int tries = 0;
        int guess = 0;
        
        // Welcome message
        System.out.println("Welcome to a number guessing game!");

        // Main game loop
        while (tries < maxTries) {
            // Prompt user for input
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ": ");
            guess = scanner.nextInt();
            
            // Check if the user input is within the specified range
            if (guess < minNum || guess > maxNum) {
                // If not, prompt the user until a valid input is received
                while (true) {
                    System.out.print("Your guess should be in [" + minNum + "," + maxNum + "]" + ":");
                    guess = scanner.nextInt();
                    if (guess >= minNum && guess <= maxNum) {
                        break;
                    }
                }
            }

            tries++; // Increment the number of tries

            // Check if the guess is correct
            if (guess == correctNum) {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + tries + ((tries == 1) ? " time" : " times"));
                break;
            }

            // Check if the maximum number of tries is reached
            if (tries == maxTries) {
                System.out.println(
                        "You have tried " + tries + ((tries == 1) ? " time" : " times") + ". You ran out of guesses");
                break;
            } else if (guess < correctNum) {
                System.out.println("Try a higher number!");
            } else if (guess > correctNum) {
                System.out.println("Try a lower number!");
            }
        }
    }

    // Static method to get the total number of games played
    public static int getNumOfGames() {
        return numOfGames;
    }

    // Override toString method for a descriptive string representation of the object
    @Override
    public String toString() {
        return "GuessNumberGame with min number as " + minNum + " max number as " + maxNum
                + " max number of tries as " + maxTries;
    }
}
