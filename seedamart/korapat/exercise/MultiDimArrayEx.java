package seedamart.korapat.exercise;

import java.util.*;

public class MultiDimArrayEx {
    public static void main(String[] args) {
        int[][] inputArray = {
                { 1, 8, 7, 6 },
                { 5, 3 },
                { 9, 9, 7 }
        };
        System.out.println("Initialize Arrays:");

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }

        //Id: 653040699-7
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[2].length; j++) {
                inputArray[2][j] = 7;
            }
        }

        for (int i = 0; i < inputArray.length; i++) {
            Arrays.sort(inputArray[i]);
        }

        System.out.println("Output:");

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}