package org.example;

public class Utils {

    static void printGameSquare(char[][] gameSquare){
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
        for (int i = 0; i < gameSquare.length ; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < gameSquare[i].length; j++) {
                System.out.print(gameSquare[i][j] + " | ");
            }

            System.out.println();
        }
    }

}
