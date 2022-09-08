package Humans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public interface HumanCreator {

    Random rand = new Random();

    boolean getSex = rand.nextBoolean();

    ArrayList<String> namesOfMen = new ArrayList<>(Arrays.asList(
            "James",
            "John",
            "Robert",
            "Michael",
            "William",
            "David",
            "Richard",
            "Charles"));

    ArrayList <String> namesOfWomen = new ArrayList<>(Arrays.asList(
                    "Olivia",
                    "Emma",
                    "Charlotte",
                    "Amelia",
                    "Ava",
                    "Sophia",
                    "Isabella",
                    "Mia"
    ));

    static String getManName(){
        return namesOfMen.get(rand.nextInt(namesOfMen.size()));
    }

    static String getWomanName(){
        return  namesOfWomen.get(rand.nextInt(namesOfWomen.size()));
    }

    void bornChild();
}
