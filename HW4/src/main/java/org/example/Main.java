package org.example;

public class Main {
    public static void main(String[] args) {


        String[] laurasPetHabits = {"eating", "running"};
        Pet laurasPet = new Pet("Dog", "Rex", 8, laurasPetHabits, 19);
        String[][] schedule = {{"Monday"},{"Do some stuff"}};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasPet, laurasFather, laurasMother, schedule);
        System.out.println(laura);
        laura.describePet();
        laura.feedPet(true);
        laura.feedPet(false);
        laura.getPet().eat();
        laura.getPet().foul();
        laura.getPet().respond();

        System.out.println("\n\n");

        String[] mikPetsHabits = {"walking", "jumping"};
        Pet mikesPet = new Pet();
        mikesPet.setSpecies("Cat");
        mikesPet.setNickname("Kitty");
        mikesPet.setHabits(mikPetsHabits);
        mikesPet.setAge(3);
        mikesPet.setTrickLevel(71);
        Human mikesFather = new Human("Peter", "Schulz", 1972);
        Human mikesMother = new Human("Loren", "Schulz", 1973);
        Human mike = new Human();
        mike.setName("Mike");
        mike.setFather(mikesFather);
        mike.setMother(mikesMother);
        mike.setPet(mikesPet);
        mike.setYear(2000);
        mike.setIq(92);
        mike.feedPet(false);
        mike.describePet();
        mike.greetPet();
        System.out.println(mike);
        mike.getPet().eat();
        mike.getPet().foul();
        mike.getPet().respond();
        mike.getPet().getTrickLevel();
        System.out.println(mike.getPet());

        System.out.println("\n\n");

        Pet tempPet = new Pet("Dog", "Max");
        tempPet.setTrickLevel(50);
        tempPet.setAge(4);
        String[] tempPetHabits = {"running", "walking", "eating"};
        tempPet.setHabits(tempPetHabits);
        System.out.println(tempPet);
        tempPet.eat();
        tempPet.foul();
        tempPet.respond();
    }
}