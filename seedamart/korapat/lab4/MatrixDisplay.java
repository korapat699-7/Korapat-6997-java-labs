package seedamart.korapat.lab4;

/* Display Matrix Programnn:

 * this program called MatrixDisplay
 * that allows users to specify the dimensions of 
 * a matrix and input its elements, followed by displaying the matrix. 
 * 
 * This programn is contain subroutine version of MatrixDisplay and add new subroutine :
 *  1. inputMatrix() 
 *      - to input size of matrix (row and columns).
 *      - include method inputElement().
 *      - to display matrix from user inpout.
 *  2. inputElement()
 *      - Prompt the user to input each element of the matrix, iterating row-wise 
 *        from the top-left to the bottom-right element.
 *  3. displayMatrix()
 *      - Implement a method to iterate through the matrix and 
 *        display its content in a grid format.
 * 
 * The output should be:
 * 
 * Enter the number of rows: 2
 * Enter the number of columns: 2
 * Enter element [0][0]: 1
 * Enter element [0][1]: 2
 * Enter element [1][0]: 3
 * Enter element [1][1]: 4
 * Displaying Matrix:
 * 1 2 
 * 3 4 
 * 
 * Error if row or column less than 1 the ouput should be:
 * Both rows and columns must be greater than 0. Please try again.
 *          
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 29 December 2023
 */
import java.util.*;

public class MatrixDisplay {
    static int nrow, ncol; // Variable to store row and column
    static int[][] list; // Variable to store the element of matrix
    static Scanner input = new Scanner(System.in);

    public static void inputMatrix() {
        // method inputMatrix
        while (true) {
            // input size of row
            System.out.print("Enter the number of rows: ");
            nrow = input.nextInt();
            ;

            if (nrow < 1) {
                // if row less than 1 will show error
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }
        }

        while (true) {
            // input size of column
            System.out.print("Enter the number of columns: ");
            ncol = input.nextInt();
            ;

            if (ncol < 1) {
                // if columnn less than 1 will show error
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }

        }
    }

    public static void inputElement() {
        // store element to list method
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                System.out.print("Enter element [" + row + "]" + "[" + col + "]: ");
                list[row][col] = input.nextInt();
            }
        }
    }

    public static void displayMatrix() {
        // display matrix
        System.out.println("Displaying Matrix:");
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                System.out.print(list[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        inputMatrix();
        inputElement();
        displayMatrix();
        input.close(); // Close the Scanner to avoid resource leaks
    }

}
