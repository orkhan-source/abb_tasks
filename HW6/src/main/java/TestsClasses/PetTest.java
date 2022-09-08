package TestsClasses;

import Main.Pet;
import Main.Species;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    @Test
    void testPet1(){
        Pet p1 = new Pet(Species.DOG, "Rex");
        Pet p2 = new Pet(Species.DOG, "Rex");
        boolean equal = p1.equals(p2);
        assertTrue(equal);
    }

    @Test
    void testPet2(){
        Pet p1 = new Pet(Species.CAT, "Max");
        Pet p2 = new Pet(Species.DOG, "Rex");
        boolean equal = p1.equals(p2);
        assertFalse(equal);
    }
}
