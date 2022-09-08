package Main;

import Animals.Pet;
import Animals.Species;
import Humans.Family;
import Humans.Human;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*

        String[] laurasPetHabits = {"eating", "running"};
        Pet laurasPet = new Pet(Species.DOG, "Rex", 8, laurasPetHabits, 19);
        String[][] lauraSchedule = {{DayOfWeek.MONDAY.name()},{"Do some stuff"}};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasPet, lauraSchedule);

        Family boff = new Family(laurasFather, laurasMother);
        boff.addChild(laura);


        String[] petersPetHabits = {"walking", "sleeping"};
        Pet petersPet = new Pet(Species.CAT, "Rex", 8, laurasPetHabits, 19);
        String[][] peterSchedule = {{DayOfWeek.THURSDAY.name()},{"Do some stuff"}};
        Human petersMother = new Human("Alexa", "Dean", 1972);
        Human petersFather = new Human("Pete", "Dean", 1970);
        Human peter = new Human("Peter", "Dean", 1999, 90, petersPet, peterSchedule);
        Family boff2 = new Family(petersFather, petersMother);
        boff2.addChild(peter);

        boff.deleteChild(peter);

        boolean check = boff.equals(boff2);
        System.out.println(check);

        // for getting output that Human object will be collected by GC. If you wanna see result, uncomment for loop
        /*
        for (int i = 0; i < 1000000; i++) {
            new Human();
            new Pet();
        }
        */

        Set<String> name = new HashSet<>();
        name.add("Orkhan");
        name.add("Jane");
        name.add("Kane");

        System.out.println(Set.of(name).toString());




    }
}