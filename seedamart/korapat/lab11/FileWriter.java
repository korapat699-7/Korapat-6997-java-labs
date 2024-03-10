package seedamart.korapat.lab11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWriter {
    public static void main(String[] args) {

         Scanner guy = new Scanner(System.in);
         System.out.println("Enter string: ");
         String at = guy.nextLine();
        
         
         try {
            PrintWriter p = new PrintWriter("korapat.txt");
            switch (at) {
                case "change":
                    String change = guy.nextLine();
                    p.write(change);
                    break;
    
                case "append":
                    String read = guy.nextLine();
                    p.append("\n" + read);
                    break;
                
             
                default:
                    break;
            }
            p.close();

        } catch (IOException ex) {
            System.out.println("5555");
            ex.printStackTrace();
        }
    }
    
}
