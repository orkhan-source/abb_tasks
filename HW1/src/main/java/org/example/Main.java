package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String userName;
        String userInputstr = "";
        boolean checker = false;
        int[] userInputs = new int[100];
        int userInput ;

        System.out.println("Enter your name for starting: ");
        userName = sc.nextLine();
        System.out.println("Let the game begin!, " + userName + '\n' + "Enter 'q' for exit from game.");

        // First part starts from here. For running this part, please comment advanced part

        int guessedNumber = rand.nextInt(101);


        int loopIndex = 0;

        while(true){
            System.out.println("Enter number: ");
            userInputstr = sc.nextLine();

            while (Utils.parseStrToInt(userInputstr)) {
                if(userInputstr.equals("q")){
                    checker = true;
                    break;
                }
                System.out.println("Please, enter valid input(Might not be entered previous number): ");
                userInputstr = sc.nextLine();
            }
            if (checker){
                break;
            }

            userInput = Integer.parseInt(userInputstr);

            if(Utils.searchInArr(userInputs, userInput)){
                System.out.println("Might not be entered previous number");
                continue;
            }
            userInputs[loopIndex++] = userInput;

            if(guessedNumber > userInput){
                System.out.println("Your number is too small. Please, try again.");
            }
            else if(guessedNumber < userInput){
                System.out.println("Your number is too big. Please, try again.");
            }
            else{
                System.out.println("Congratulations, " + userName);

                Utils.sortAndPrint(userInputs, loopIndex);
                break;
            }

        }













        /*
        Advanced part stars from here. For running this part, please comment first part.


        int rowIndex = rand.nextInt(2);
        int columnIndex = rand.nextInt(5);

        int[][] numbersForGuessing = {{1896, 1991, 1904, 1865, 1914}, {1895, 1821, 1776, 1961, 1980}};
        String[][] informationForGuessing = {{"First modern Olympic Games held at Athens",
                "Dissolution of USSR", "Russiao-Japan war",
                "Assassination of Abraham Lincoln", "Beginning of World War I"},
                {"Roentgen discovered X-Rays", "Death of Napolean",
                        "Declaration of American Independence", "Yuri Gagarin of USSR becomes the first spaceman",
                        "War starts between Iran and Iraq, Ronald Reagon elected USA President"}};


        int loopIndex = 0;
        while (true) {

            System.out.println("\nHint: " + informationForGuessing[rowIndex][columnIndex]);
            System.out.println("Enter number: ");
            userInputstr = sc.nextLine();

            while (Utils.parseStrToInt(userInputstr)) {
                if(userInputstr.equals("q")){
                    checker = true;
                    break;
                }
                System.out.println("Please, enter valid input: ");
                userInputstr = sc.nextLine();
            }

            if(checker){
                break;
            }

            userInput = Integer.parseInt(userInputstr);
            userInputs[loopIndex++] = userInput;

            if(userInput == numbersForGuessing[rowIndex][columnIndex]){
                System.out.println("Congratulations, " + userName + "!");
                break;
            }
            else{
                if(userInput > numbersForGuessing[rowIndex][columnIndex]){
                    System.out.println("Your number is too big. Please, try again.");
                }
                else{
                    System.out.println("Your number is too small. Please, try again.");
                }
            }


        }

        if(!checker){
            Utils.sortAndPrint(userInputs, loopIndex);
        }else
            System.out.println("Bye, see  you soon!");

        //Advanced part ends here
        */

    }


}