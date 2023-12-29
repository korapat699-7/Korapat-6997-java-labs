package seedamart.korapat.lab4;

/*Matrix Operations Programnn:
 * Develop another version of the MatrixDisplay program that 
 * not only allows users to create a matrix in various ways but also includes 
 * functionalities for transposing the matrix, calculating row and column sums, 
 * finding minimum and maximum elements, and identifying diagonal elements. 
 * 
 * 
 * This programn is contain subroutine version of MatrixDisplay and add new subroutine :
 * 
 *  1. ope_transposeMatrix() 
 *      - to display transpose matrix row to column or column to row.
 *  2. ope_rowcolSum()
 *      - to find and display summation of row and summation of column 
 *  3. ope_rowcolSumTrans()
 *      - to find and display summation of row and summatin of column on transpose matrix.
 *  4. ope_rowcolSumCondition()
 *      - to change method between ope_rowcolSum() and ope_rowcolSumTrans()
 *  5. ope_minmaxMatrix()
 *      - to find and display min-max value of Matrix.
 *  6. ope_diagonalMatrix()
 *      - to display diagonal matrix. 
 *  7. operationMatrix()
 *      - the selector operation of matrix if user input '5' the program will exits.
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
 * 
 * <option from user input>
 * 
 * Choose an operation: <selector>
 * 1. Transpose Matrix
 * 2. Row and Column Sum
 * 3. Find Max/Min Value
 * 4. Diagonal Display 
 * 5. Exit
 * Enter choice (1-5): 1
 * 
 * <operation from user input>
 *          
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 * Date: 29 December 2023
 */
import java.util.*;

public class MatrixOperations {
    static int nrow, ncol, rand, nrowcol, sumMatrix, sumRow, sumCol, minMatrix, maxMatrix;
    static int randmin = 0, randmax = 9;// constant value minimum and maximum
    static int[][] list; // Variable to store each element of matix.
    static Scanner input = new Scanner(System.in);
    static String ope = "not_transpose"; // If this varible is "transpose" will change method
    static int nTrans = 2; // increse this variable and change method to find summation of row and column

    public static void inputMatrix() {
        // input size of matrix method.
        while (true) {
            System.out.print("Enter the number of rows: ");
            nrow = input.nextInt();

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

            if (ncol < 1) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }
        }
    }

    public static void inputElement() {
        // input size of matrix.
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                System.out.print("Enter element [" + row + "]" + "[" + col + "]: ");
                list[row][col] = input.nextInt();
            }
        }
    }

    public static void displayMatrix() {
        // show matrix.
        System.out.println("Displaying Matrix:");
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                System.out.print(list[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void optionMatrix() {
        // option matrix .
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
                // show error if the selector out of range 1-5.
                System.err.println("Error: Please enter choice (1-5): ");
            }
        }

    }

    public static void userInput() {
        // If user select method userInput() user must input element of matrix.
        inputMatrix(); // call method inputMatrix to input size of matrix.
        inputElement(); // call method inputElement to input matrix element .
        displayMatrix(); // display this matrix
    }

    public static void randomMatrix() {
        // random matrix range 0-9.
        inputMatrix(); // input size of matrix method.
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                rand = randmin + (int) (Math.random() * ((randmax - randmin) + 1)); // random range 0-9.
                list[row][col] = rand; // store random number 0-9.
            }
        }
        displayMatrix();
    }

    public static void allZeros() {
        // row and columnn is zero.
        inputMatrix();
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                list[row][col] = 0; // all element should be zero.
            }
        }
        displayMatrix();
    }

    public static void allOnes() {
        // row and columnn is ones.
        inputMatrix();
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                list[row][col] = 1;
            }
        }
        displayMatrix();

    }

    public static void diagonalMatrix() {
        // show diagonal matrix by user input . matrix should be row = colummn such as 3
        // x 3 , 4 x 4.
        while (true) {
            System.out.print("Enter the number of row and columns for diagonal matrix: ");
            nrowcol = input.nextInt();
            ncol = nrowcol;
            nrow = nrowcol;

            // show error if user input number < 0 and Enter the number again.
            if (nrowcol < 1) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            } else {
                list = new int[nrow][ncol];
                break;
            }
        }

        // if row is equal column the program will display '1',if not it's be '0'.
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                if (row == col) {
                    list[row][col] = 1;
                } else {
                    list[row][col] = 0;
                }
            }
            displayMatrix();
        }
    }

    public static void ope_transposeMatrix() {
        // swap row and column.
        if (nTrans % 2 == 0) {
            System.out.println("Displaying Matrix:");
            for (int row = 0; row < ncol; row++) {
                for (int col = 0; col < nrow; col++) {
                    System.out.print(list[col][row] + " ");
                }
                System.out.println();
            }
            ope = "transpose";

            // If transpose varible modulo is 1. string ope will be "not_transpose"
        } else if (nTrans % 2 == 1) {
            displayMatrix();
            ope = "not_transpose";
        }

    }

    public static void ope_rowcolSum() {
        // calculate sum of row and sum of column
        System.out.println("Row Sums:");
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                sumMatrix += list[row][col];
            }
            // display row n :
            System.out.println("Row " + (row + 1) + ": " + sumMatrix);
            sumMatrix = 0;
        }

        System.out.println("Column Sums:");
        for (int col = 0; col < ncol; col++) {
            for (int row = 0; row < nrow; row++) {
                sumMatrix += list[row][col];
            }
            // display column n :
            System.out.println("Column " + (col + 1) + ": " + sumMatrix);
            sumMatrix = 0;
        }

    }

    public static void ope_rowcolSumTrans() {
        /*
         * if string ope = "transpose" this method
         * will calculate summation of row and col on this matrix transpose.
         */

        System.out.println("Row Sums:");
        for (int row = 0; row < ncol; row++) {
            for (int col = 0; col < nrow; col++) {
                // swap row and column.
                sumMatrix += list[col][row];
            }
            // display row n :
            System.out.println("Row " + (row + 1) + ": " + sumMatrix);
            sumMatrix = 0;
        }

        System.out.println("Column Sums:");
        for (int col = 0; col < nrow; col++) {
            for (int row = 0; row < ncol; row++) {
                sumMatrix += list[col][row];
            }
            // display column n :
            System.out.println("Column " + (col + 1) + ": " + sumMatrix);
            sumMatrix = 0; // add and store number to sumMatrix.
        }

    }

    public static void ope_rowcolSumCondition() {
        // summation condition method between transpose matrix and not transpose matrix.
        if (ope == "transpose") {
            ope_rowcolSumTrans();
        } else if (ope == "not_transpose") {
            ope_rowcolSum();
        }
    }

    public static void ope_minmaxMatrix() {
        // find min and max in matrix and display.
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                if (maxMatrix < list[row][col]) {
                    maxMatrix = list[row][col];
                }
            }
        }
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                if (minMatrix > list[row][col]) {
                    minMatrix = list[row][col];
                }
            }
        }
        // display min and max.
        System.out.println("Maximum Value: " + maxMatrix);
        System.out.println("Minimum Value: " + minMatrix);

    }

    public static void ope_diagonalMatrix() {
        // display diagonal matrix such as i == j or row == column.
        System.out.println("Main Diagonal:");
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                if (row == col) {
                    System.out.print(list[row][col] + " ");
                }
            }
        }
        System.out.println();
    }

    public static void operationMatrix() {
        // option matrix user
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Transpose Matrix");
            System.out.println("2. Row and Column Sum");
            System.out.println("3. Find Max/Min Value");
            System.out.println("4. Diagonal Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int selector = input.nextInt();

            if (selector == 1) {
                ope_transposeMatrix();
                nTrans++;
            } else if (selector == 2) {
                ope_rowcolSumCondition();
            } else if (selector == 3) {
                ope_minmaxMatrix();
            } else if (selector == 4) {
                ope_diagonalMatrix();
            } else if (selector == 5) {
                break;
            } else {
                System.err.println("Error: Please enter choice (1-5): ");
            }

        }

    }

    public static void main(String[] args) {
        optionMatrix();
        operationMatrix();
        input.close();// Close the Scanner to avoid resource leaks
    }
}
