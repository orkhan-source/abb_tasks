package org.example;

public class Main {
    public static void main(String[] args) {
        String[] laurasPetHabits = {"eating", "running"};
        Pet laurasPet = new Pet("Dog", "Rex", 8, laurasPetHabits, 19);
        String[][] schedule = {{"Monday"},{"Do some stuff"}};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, schedule);

        Family boff = new Family(laurasFather, laurasMother);
        boff.addChild(laura);
        boff.setPet(laurasPet);


        String[] petersPetHabits = {"eating", "running"};
        Pet petersPet = new Pet("Dog", "Rex", 8, laurasPetHabits, 19);
        String[][] petersschedule = {{"Monday"},{"Do some stuff"}};
        Human petersMother = new Human("Jane", "Boff", 1972);
        Human petersFather = new Human("Alex", "Boff", 1970);
        Human peter = new Human("Laura", "Boff", 1999, 90, petersschedule);// make same for comparison
        Family boff2 = new Family(petersFather, petersMother);
        boff2.addChild(peter);
        boff2.setPet(petersPet);

        boff.addChild(peter);// add for searching
        boff.deleteChildAdvanced(peter);

        for (Human h: boff.getChildren()) {
            System.out.println(h.getName());
        }



       boolean check = boff.equals(boff2);
        System.out.println(check);


    }
}