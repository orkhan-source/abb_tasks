package Main;

import Animals.*;
import Humans.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] laurasPetHabits = {"eating", "running"};
        Pet laurasPet = new Dog( "Rex", 8, laurasPetHabits, 19);
        String[][] lauraSchedule = {{DayOfWeek.MONDAY.name()},{"Do some stuff"}};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasPet, lauraSchedule);

        Family boff = new Family(laurasFather, laurasMother);
        boff.addChild(laura);

        boff.bornChild();




    }
}