package TestsClasses;

import Animals.Dog;
import DAO.CollectionFamilyDao;
import DAO.FamilyService;
import Humans.Family;
import Humans.Human;
import Main.*;
import Animals.Pet;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {

    FamilyService familyService = new FamilyService(new CollectionFamilyDao());

    @Test
    void getAllFamiliesTest(){
        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);
        assertEquals(familyService.count(), 1);
    }


    @Test
    void getFamiliesBiggerThanTest(){

        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);
        Human laura = new Human();
        boff.addChild(laura);
        assertEquals(familyService.getFamiliesBiggerThan(2).size(), 1);
    }

    @Test
    void createNewFamily(){
        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);

        assertEquals(familyService.count(), 1);
    }

    @Test
    void bornChild(){
        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);
        boff = familyService.bornChild(boff, "Alexx", "Laura");
        assertEquals(familyService.countFamiliesWithMemberNumber(3), 1);
    }

    @Test
    void adoptChildTest(){

        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);
        Human laura = new Human();
        familyService.adoptChild(boff, laura);

        assertEquals(boff.countFamily(), 3);

    }

    @Test
    void getFamilyByIdTest(){
        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);
        assertEquals(boff, familyService.getFamilyById(0));
    }


    @Test
    void getPetTest(){
        Human laurasMother = new Human("Jane", "Boff", "10/01/1970");
        Human laurasFather = new Human("Alex", "Boff", "10/01/1970");
        Family boff = familyService.createNewFamily(laurasFather, laurasMother);
        Set<Pet> boffPet = new HashSet<>(Arrays.asList(new Dog("rex")));
        boff.setPets(boffPet);
        assertEquals(familyService.getPet(0), boffPet);
    }


}
