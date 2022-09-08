package TestsClasses;

import Animals.Dog;
import Animals.Species;
import Humans.Family;
import Humans.Human;
import Main.*;
import Animals.Pet;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {

    @Test
    void familyTest1(){
        Set<String> laurasPetHabits = new HashSet<>(Arrays.asList("eating", "running"));
        Pet laurasDog = new Dog("Rex", 8, laurasPetHabits, 19);
        Map<DayOfWeek, String[]> lauraSchedule = new HashMap<DayOfWeek, String[]>(){{
            put(DayOfWeek.MONDAY, new String[]{"Do some stuff"});
        }};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasDog, lauraSchedule);

        Family boff = new Family(laurasFather, laurasMother);
        boff.addChild(laura);


        Set<String> petersPetHabits = new HashSet<>(Arrays.asList("walking", "sleeping"));
        Pet petersDog = new Dog( "Rex", 8, petersPetHabits, 19);
        Map<DayOfWeek, String[]> peterSchedule = new HashMap<DayOfWeek, String[]>(){{
            put(DayOfWeek.THURSDAY, new String[]{"Do some stuff"});
        }};

        Human petersMother = new Human("Alexa", "Dean", 1972);
        Human petersFather = new Human("Pete", "Dean", 1970);
        Human peter = new Human("Peter", "Dean", 1999, 90, petersDog, peterSchedule);
        Family dean = new Family(petersFather, petersMother);
        dean.addChild(peter);

        boolean equals = boff.equals(dean);
        assertFalse(equals);

    }

    @Test
    void familyTest2(){
        Set<String> laurasPetHabits = new HashSet<>(Arrays.asList("eating", "running"));
        Pet laurasDog = new Dog("Rex", 8, laurasPetHabits, 19);
        Map<DayOfWeek, String[]> lauraSchedule = new HashMap<DayOfWeek, String[]>(){{
            put(DayOfWeek.MONDAY ,new String[]{"Do some stuff"});
        }};
        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasDog, lauraSchedule);

        Family boff = new Family(laurasFather, laurasMother);
        boff.addChild(laura);


        Set<String> petersPetHabits = new HashSet<>(Arrays.asList("eating", "running"));
        Pet petersPet = new Dog( "Rex", 8, laurasPetHabits, 19);
        Map<DayOfWeek, String[]> peterSchedule = new HashMap<>(){{
            put(DayOfWeek.MONDAY ,new String[]{"Do some stuff"});
        }};
        Human petersMother = new Human("Jane", "Boff", 1972);
        Human petersFather = new Human("Alex", "Boff", 1970);
        Human peter = new Human("Laura", "Boff", 1999, 90, laurasDog, lauraSchedule);
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
        boolean equals = boff.countFamily() == (boff.getChildren().size() + 2);
        assertTrue(equals);

    }

}
