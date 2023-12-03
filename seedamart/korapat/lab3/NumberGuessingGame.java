package seedamart.korapat.lab3;
import java.util.Scanner;

/*Number Gussing Game:
 * This program called NumberGuessingGame that simulates 
 * a guessing game of which a user guesses a number from 1 to 20. 
 * The answer is randomly generated then a user enters a number via the console. 

 * The output should be:
 * 
 * "Welcome to a number guessing game !"
 * "Enter an integer between <min> and <max>:" <input>
 *  If number is not equals to answer:
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

 public class NumberGuessingGame {
     public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         System.out.println("Welcome to a number guessing game!");
 
         // Generate a random number between 1 and 20
         int answer = 1 + (int) (Math.random() * ((20 - 1) + 1));
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
                 // Uncomment the following line to display the guessed and correct numbers
                 // System.out.println(num + " " + answer);
             } else if (num > answer) {
                 time += 1;
                 System.out.println("Try a lower number!");
                 // Uncomment the following line to display the guessed and correct numbers
                 // System.out.println(num + " " + answer);
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
 }
 