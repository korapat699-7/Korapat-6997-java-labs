package seedamart.korapat.lab2;

/*Camel Case Naming Program:
 * This program accepts two arguments then program
 * 
 * The program will process both words to form a camel case string: 
 * The first letter of the first word is capitalized, 
 * and the remaining letters are converted to lowercase.
 * same process is applied to the second word. Then, both words are concatenated.
 * 
 * The output should be
 * <firstname_convert><lastname_convert> 
 * such as 
 * Input: kORapat sEEdaMaRT
 * Output: KorapatSeedamart 
 * 
 * Author: Korapat Seedamart
 * ID : 653040699-7
 * Sec : 2
 */

public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Please provide exactly two arguments.");
            System.exit(1);
        }
        String firstname = args[0];
        String lastname = args[1];

        String con_firstname = firstname.substring(0, 1).toUpperCase()
                + firstname.substring(1).toLowerCase();
        String con_lastname = lastname.substring(0, 1).toUpperCase()
                + lastname.substring(1).toLowerCase();
        System.out.println(con_firstname + con_lastname);

    }
}
