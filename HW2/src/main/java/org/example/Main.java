package org.example;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int inputRowIndex, inputColumnIndex;
        int xCounter = 0;

        int rowIndex = rand.nextInt(5);

        int columnIndex = rand.nextInt( 5);

        char[][] gameSquare = { {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'} };

        System.out.println("All set. Get ready to rumble!");


        // First part starts from here, if you want to run this part, please comment advanced part

        while(xCounter != 1){
            Utils.printGameSquare(gameSquare);
            System.out.println("\n");
            System.out.println("Please, enter row (first, 1- 5 inclusive) and column (second, 1 - 5 inclusive) for shooting. : ");
            inputRowIndex = sc.nextInt() - 1;
            inputColumnIndex = sc.nextInt() - 1;
            while(inputRowIndex < 0 || inputRowIndex > 4 || inputColumnIndex < 0 || inputColumnIndex > 4){
                System.out.println("Please, enter valid number!!!! Row (first, 1- 5 inclusive) and column (second, 1 - 5 inclusive) for shooting. : ");
                inputRowIndex = sc.nextInt() - 1;
                inputColumnIndex = sc.nextInt() - 1;
            }

            if(rowIndex == inputRowIndex && columnIndex == inputColumnIndex){
                gameSquare[inputRowIndex][inputColumnIndex] = 'X';
                xCounter++;
            }
            else{
                gameSquare[inputRowIndex][inputColumnIndex] = '*';
            }

        }

        // First part ends here



        /*
        //Advanced part starts from here. If you want to run this part, please comment first part


        int minRowIndexForDirection, maxRowIndexForDirection, minColumnIndexForDirection, maxColumnIndexForDirection;

        int tossForDirection = rand.nextInt( 2); // 0 for horizontal, 1 for vertical

        if(tossForDirection == 0){ // if horizontal, choose 1 point randomly and take its neighbours as a shooting area
            minRowIndexForDirection = rowIndex;
            maxRowIndexForDirection = rowIndex;
            minColumnIndexForDirection = columnIndex - 1;
            maxColumnIndexForDirection = columnIndex + 1;
            if(minColumnIndexForDirection < 0){ // this statement specify neighbours if randomly chosen point is on the edges
                minColumnIndexForDirection = 0;
                maxColumnIndexForDirection += 1;
            }
        }
        else{ // if vertical, choose 1 point randomly and take its neighbours as a shooting area
            minColumnIndexForDirection = columnIndex;
            maxColumnIndexForDirection = columnIndex;
            minRowIndexForDirection = rowIndex - 1;
            maxRowIndexForDirection = rowIndex + 1;
            if(minRowIndexForDirection < 0){ // this statement specify neighbours if randomly chosen point is on the edges
                minRowIndexForDirection = 0;
                maxRowIndexForDirection += 1;
            }
        }


        while(xCounter != 3){
            Utils.printGameSquare(gameSquare);
            System.out.println("Please, enter row (first, 1- 5 inclusive) and column (second, 1 - 5 inclusive) for shooting. : ");
            inputRowIndex = sc.nextInt() - 1;
            inputColumnIndex = sc.nextInt() - 1;
            while(inputRowIndex < 0 || inputRowIndex > 4 || inputColumnIndex < 0 || inputColumnIndex > 4){
                System.out.println("Please, enter valid number!!!! Row (first, 1- 5 inclusive) and column (second, 1 - 5 inclusive) for shooting. : ");
                inputRowIndex = sc.nextInt() - 1;
                inputColumnIndex = sc.nextInt() - 1;
            }

            if((minRowIndexForDirection <= inputRowIndex && maxRowIndexForDirection >= inputRowIndex) &&
               (inputColumnIndex >= minColumnIndexForDirection && inputColumnIndex <= maxColumnIndexForDirection)){
                gameSquare[inputRowIndex][inputColumnIndex] = 'X';
                xCounter += 1;
            }
            else{
                gameSquare[inputRowIndex][inputColumnIndex] = '*';
            }

        }


        // Advanced part ends here

         */




        Utils.printGameSquare(gameSquare);
        System.out.println("You have won!");






    }
}