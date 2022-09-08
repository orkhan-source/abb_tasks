package TestsClasses;

import Animals.Dog;
import Animals.DomesticCat;
import Animals.Pet;
import Animals.Species;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PetTest {

    @Test
    void testPet1(){
        Pet p1 = new Dog( "Rex");
        Pet p2 = new Dog( "Rex");
        boolean equal = p1.equals(p2);
        assertTrue(equal);
    }

    @Test
    void testPet2(){
        Pet p1 = new DomesticCat( "Max");
        Pet p2 = new Dog( "Rex");
        boolean equal = p1.equals(p2);
        assertFalse(equal);
    }
}


