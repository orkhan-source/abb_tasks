package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] weekPlan = {{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
                {"Sunday's plan", "Monday's plan", "Tuesday's plan", "Wednesday's plan", "Thursday's plan", "Friday's plan", "Saturday's plan"}};

        String userInput, userInputChange = "";
        int taskForInput;
        boolean check;

        while (true) {

            System.out.println("Use 'change' or 'reschedule' for change task ");
            System.out.println("Please, input the day of the week: ");
            userInput = sc.nextLine().toLowerCase().trim();
            String[] userInputStr = userInput.split(" ");

            if(userInputStr.length == 2){
                    userInput = userInputStr[1];
                    userInputChange = userInputStr[0];
                    check = false;
            }
            else{
                check = true;
            }

            if (userInput.equals("exit")) {
                break;
            }

            if(!check){
                if(!userInputChange.equals("change") && !userInputChange.equals("reschedule")){
                    System.out.println("Please enter correct keyword for changing task");
                    continue;
                }
            }


            switch (userInput) {
                case "sunday":
                    taskForInput = 0;
                    break;
                case "monday":
                    taskForInput = 1;
                    break;
                case "tuesday":
                    taskForInput = 2;
                    break;
                case "wednesday":
                    taskForInput = 3;
                    break;
                case "thursday":
                    taskForInput = 4;
                    break;
                case "friday":
                    taskForInput = 5;
                    break;
                case "saturday":
                    taskForInput = 6;
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again: ");
                    continue;
            }

            if(check){
                System.out.printf("Your tasks for %s : %s. \n", weekPlan[0][taskForInput] ,weekPlan[1][taskForInput]);
            }
            else{
                System.out.printf("Please, input new tasks for %s. \n", weekPlan[0][taskForInput]);
                String newTask = sc.nextLine();
                weekPlan[1][taskForInput] = newTask;
                System.out.println("Task changed");
            }

        }

    }
}