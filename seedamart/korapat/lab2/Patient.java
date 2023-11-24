package seedamart.korapat.lab2;

/**
 * The Patient Program:
 * This program accepts three arguments then program
 * will displays patient information.
 * The output should be
 * Patient's name : <patient_name>.
 * Nationality : <patient_age>
 * Gender : <patient_gender>
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 */

public class Patient {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments.");
            System.exit(0);
        }
        String patient_name = args[0];
        String patient_age = args[1];
        String patient_gender = args[2];
        System.out.println("Patient's Name: " + patient_name);
        System.out.println("Age: " + patient_age);
        System.out.println("Gender: " + patient_gender);
    }

}
