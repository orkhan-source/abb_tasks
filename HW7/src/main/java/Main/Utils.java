package Main;
import Humans.Human;

import java.util.Arrays;
public class Utils {

    public static void modifyArray(Human[] children, int index){
        Human tempChild;
        for (int i = index; i < children.length - 1; i++) {
            tempChild = children[i];
            children[i] = children[i + 1];
            children[i + 1] = tempChild;
        }
    }

    public static boolean check2dArrayEquality(String[][] arr1, String[][] arr2){

        if(arr1 == arr2){
            return true;
        }

        if(arr1.length != arr2.length){
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if(!Arrays.equals(arr1[i], arr2[i])){
                return false;
            }
        }

        return true;
    }
}