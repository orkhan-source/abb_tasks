package TestsClasses;

import Main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {

    @Test
    void familyTest1(){
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
        Family dean = new Family(petersFather, petersMother);
        dean.addChild(peter);

        boolean equals = boff.equals(dean);
        assertFalse(equals);

    }

    @Test
    void familyTest2(){
        String[] laurasPetHabits = {"eating", "running"};
        Pet laurasPet = new Pet(Species.DOG, "Rex", 8, laurasPetHabits, 19);
        String[][] lauraSchedule = {{DayOfWeek.MONDAY.name()},{"Do some stuff"}};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasPet, lauraSchedule);

        Family boff = new Family(laurasFather, laurasMother);
        boff.addChild(laura);


        String[] petersPetHabits = {"eating", "running"};
        Pet petersPet = new Pet(Species.DOG, "Rex", 8, petersPetHabits, 19);
        String[][] peterSchedule = {{DayOfWeek.MONDAY.name()},{"Do some stuff"}};
        Human petersMother = new Human("Jane", "Boff", 1972);
        Human petersFather = new Human("Alex", "Boff", 1970);
        Human peter = new Human("Laura", "Boff", 1999, 90, petersPet, peterSchedule);
        Family dean = new Family(petersFather, petersMother);
        dean.addChild(peter);

        boolean equals = boff.equals(dean);
        assertTrue(equals);

    }

    @Test
    void familyTest3(){
        Human petersMother = new Human("Jane", "Boff", 1972);
        Human petersFather = new Human("Alex", "Boff", 1970);
        Family boff = new Family(petersFather, petersMother);
        boff.addChild(new Human());
        boff.addChild(new Human());
        boolean equals = boff.countFamily() == (boff.getChildren().length + 2);
        assertTrue(equals);

    }

}
