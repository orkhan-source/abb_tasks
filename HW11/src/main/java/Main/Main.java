package Main;

import Animals.Dog;
import Animals.Pet;
import Animals.Species;
import DAO.CollectionFamilyDao;
import DAO.FamilyController;
import DAO.FamilyService;
import Humans.Family;
import Humans.Human;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) {

        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

        Human laurasMother = new Human("Jane", "Boff", 1972);
        Human laurasFather = new Human("Alex", "Boff", 1970);

        familyController.displayAllFamilies();
        Family boff = familyController.createNewFamily(laurasFather, laurasMother);
        familyController.bornChild(boff, "Alex", "Laura");
        Human childofBoff = new Human("AA", "Boff", 2002);
        familyController.adoptChild(boff, childofBoff);
        Set<String> habits = new HashSet<>(Arrays.asList("walking", "running"));
        Pet p = new Dog("Rex", 3, habits, 50);
        familyController.addPet(0, p);
        familyController.displayAllFamilies();
        System.out.println(familyController.count());

        Human petersMother = new Human("Alexa", "Dean", 1972);
        Human petersFather = new Human("Pete", "Dean", 1970);

        Family dean = familyController.createNewFamily(petersFather, petersMother);
        familyController.bornChild(dean, "Alexx", "Rossee");
        Human childofDean = new Human("AA", "Dean", 2002);
        Human childofDean1 = new Human("bb", "Dean", 2000);
        Human childofDean2 = new Human("cc", "Dean", 1998);

        familyController.deleteAllChildrenOlderThen(20);
        System.out.println(familyController.count());

        Human h1 = new Human("a", "b", "20/03/2016", 33);
        System.out.println(h1.describeAge());




    }
}