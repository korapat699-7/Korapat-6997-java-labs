package seedamart.korapat.lab4;

/* Display Matrix Options Programnn:

 * Develop another version of the MatrixDisplay called MatrixDisplayOptions
 * This version introduces a menu that allows the user to create a matrix 
 * in various ways, emphasizing array manipulation, user input handling, 
 * and conditional logic in Java.
 * 
 * This programn is contain subroutine version of MatrixDisplay and add new subroutine :
 *  
 *  1. optionMatrix() 
 *      - For options 1-4, ask the user to enter the number of rows and columns.
 *      - Validate that both are greater than 0.
 *      - Initialize the matrix based on the dimensions.
 *  2. randomMatrix()
 *      - Fill the matrix with random numbers between 0 and 9.
 *  3. allZeros()
 *      - Initialize all elements of the matrix to 0.
 *  4. allOnes()
 *      - Initialize all elements of the matrix to 1.
 *  5. diagonalMatrix() 
 *      - Create a square matrix with 0s, except for 1s on the diagonal.
 * 
 * The output should be:
 * 
 * Select Matrix initialization method:
 * 1. User Input 
 * 2. Random Numbers
 * 3. All Zeros
 * 4. All Ones
 * 5. Diagonal Matrix
 * Enter choice (1-5): <selector>
 * <display method 1-5 from user input>
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 29 December 2023
 */
import java.util.*;

public class MatrixDisplayOptions {
    static int nrow, ncol, rand, nrowcol;
    final static int randmin = 0, randmax = 9; // constant value minimum and maximum
    static int[][] list; // Variable to store each element of matix.
    static Scanner input = new Scanner(System.in);

    public static void inputMatrix() {
        // Method input size of matrix.
        while (true) {
            System.out.print("Enter the number of rows: ");
            nrow = input.nextInt();
            ;

            if (nrow < 1) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }
        }

        while (true) {
            System.out.print("Enter the number of columns: ");
            ncol = input.nextInt();
            ;

            if (ncol < 1) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }

        }
    }

    public static void inputElement() {
        // Method input each element .
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                System.out.print("Enter element [" + row + "]" + "[" + col + "]: ");
                list[row][col] = input.nextInt();
            }
        }
    }

    public static void displayMatrix() {
        // method display matrix.
        System.out.println("Displaying Matrix:");
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                System.out.print(list[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void optionMatrix() {
        // Metohd select option matrix.
        System.out.println("Select Matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matrix");
        while (true) {
            System.out.print("Enter choice (1-5): ");
            int selector = input.nextInt();
            if (selector == 1) {
                userInput();
                break;
            } else if (selector == 2) {
                randomMatrix();
                break;
            } else if (selector == 3) {
                allZeros();
                break;
            } else if (selector == 4) {
                allOnes();
                break;
            } else if (selector == 5) {
                diagonalMatrix();
                break;
            } else {
                System.err.println("Error: Please enter choice (1-5): ");
            }
        }

    }

    public static void userInput() {
        inputMatrix();
        inputElement();
    }

    public static void randomMatrix() {
        // Method to random and store to each element of matrix
        inputMatrix(); // for input size of matrix
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                rand = randmin + (int) (Math.random() * ((randmax - randmin) + 1));
                list[row][col] = rand;
            }
        }

    }

    public static void allZeros() {
        // Method to make all row and column is 0.
        inputMatrix(); // for input size of matrix
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                list[row][col] = 0;
            }
        }

    }

    public static void allOnes() {
        // Method to make all row and column is 1.
        inputMatrix(); // for input size of matrix
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                list[row][col] = 1;
            }
        }

    }

    public static void diagonalMatrix() {
        while (true) {
            System.out.print("Enter the number of row and columns for diagonal matrix: ");
            nrowcol = input.nextInt();
            ncol = nrowcol;
            nrow = nrowcol;

            if (nrowcol < 1) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }
        }

        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                if (row == col) {
                    list[row][col] = 1;
                } else {
                    list[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        optionMatrix();
        displayMatrix();
        input.close();// Close the Scanner to avoid resource leaks
    }
}
