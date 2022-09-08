package TestsClasses;
import Main.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HumanTest {

    @Test
    public void testHuman(){
        Human h1 = new Human("Orkhan", "B", 1999);
        Human h2 = new Human("Orkhan", "B", 1999);
        boolean equal = h1.equals(h2);
        assertTrue(equal);
    }

    @Test
    public void testHuman2(){
        Human h1 = new Human("Alexa", "Dean", 1972);
        Human h2 = new Human("Pete", "Dean", 1970);
        boolean equal = h1.equals(h2);
        assertFalse(equal);
    }

    @Test
    public void testHuman3(){

        String[] laurasPetHabits = {"eating", "running"};
        Pet laurasPet = new Pet(Species.DOG, "Rex", 8, laurasPetHabits, 19);
        String[][] lauraSchedule = {{DayOfWeek.MONDAY.name()},{"Do some stuff"}};
        Human laura = new Human("Laura", "Boff", 1999, 90, laurasPet, lauraSchedule);


        Human laura2 = new Human("Laura", "Boff", 1999, 90, laurasPet, lauraSchedule);

        boolean equal = laura.equals(laura2);
        assertTrue(equal);
    }


}
