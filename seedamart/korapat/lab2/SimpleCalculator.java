package seedamart.korapat.lab2;

/* Simple Calculator Program:
 * This program accepts three agrument then program
 * will display result.
 * 
 * "Check Error"
 * If there are exactly three arguments then program will display result. 
 * If not, display the error message as "Error: Please provide exactly three arguments.".
 * If the operation is division and the divisor is zero, 
 * display an error message as "Error: Invalid operator. Please use '+', '-', 'x', or '/'.". 
 * 
 * The output should be 
 * 
 * <operand1><operation><operand2>=result 
 * such as 2+2=4 
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 */

public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Error: Please provide exactly three arguments.");
            System.exit(1);
        }

        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        String operator = args[2];
        int math;

        if (operator.equals("+")) {
            math = first + second;
            System.out.println(first + operator + second + "=" + math);
        } else if (operator.equals("-")) {
            math = first - second;
            System.out.println(first + operator + second + "=" + math);
        } else if (operator.equals("x")) { 
            math = first * second;
            System.out.println(first + operator + second + "=" + math);
        } else if (operator.equals("/")) {
            if (second == 0) {
                System.out.println("Error: Division by zero is not allowed.");
            } else {
                math = (int) first / second; 
                System.out.println(first + operator + second + "=" + math);
            }
        } else {
            System.out.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
        }
    }
}
