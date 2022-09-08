package org.example;

import java.util.Arrays;

public class Utils {


    static boolean searchInArr(int[] arr, int searced){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == searced){
                return true;
            }
        }
        return false;
    }


    static boolean parseStrToInt(String s) {
        boolean checked = false;

        try {
            int a = Integer.parseInt(s);
        } catch (Exception e) {
            checked = true;
        }

        return checked;
    }



    public static void sortAndPrint(int[] userInputs, int loopIndex){
        for (int i = 0; i < loopIndex; i++) {
            for (int j = 0; j < loopIndex; j++) {
                if(userInputs[i] > userInputs[j]){
                    int temp = userInputs[j];
                    userInputs[j] = userInputs[i];
                    userInputs[i] = temp;
                }
            }
        }

        System.out.println("Yout inputs :");
        for (int i = 0; i < loopIndex; i++) {
            System.out.print(userInputs[i] + " ");
        }
    }
}
