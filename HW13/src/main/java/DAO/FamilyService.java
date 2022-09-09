package DAO;

import Animals.Pet;
import Humans.Family;
import Humans.Human;
import Humans.Man;
import Humans.Woman;
import Utils.DateUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class FamilyService {
    private FamilyDao familyDao;

    public FamilyService(CollectionFamilyDao collectionFamilyDao){
        this.familyDao = collectionFamilyDao;
    }

    public List<Family> getAllFamilies(){
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies(){

        familyDao.getAllFamilies().forEach(f-> System.out.print( f.prettyFormat()));
    }

    public List<Family> getFamiliesBiggerThan(int bigger){
        List<Family> families =  familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() > bigger)
                .collect(Collectors.toList());

        families.forEach(f-> System.out.printf(" %d. %s \n", getAllFamilies().indexOf(f) , f));
        return families;
    }

    public List<Family> getFamiliesLessThan(int less){
        List<Family> families =  familyDao.getAllFamilies().stream()
                .filter(f -> f.countFamily() < less)
                .collect(Collectors.toList());

        families.forEach(f-> System.out.printf(" %d. %s \n", getAllFamilies().indexOf(f) , f));
        return families;

    }

    public Family createNewFamily(Human father, Human mother){
        Family createdFam = new Family(father, mother);
        this.familyDao.saveFamily(createdFam);
        return createdFam;
    }

    public void deleteFamilyByIndex(int index){
        this.familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String masculine, String feminine) {
        Random rand = new Random();
        boolean boyOrGirl = rand.nextBoolean();

        Human child = boyOrGirl ? new Man(masculine, family.getFather().getSurname(), DateUtil.convertCorrectFormat(LocalDate.now()))  : new Woman(feminine, family.getFather().getSurname(), DateUtil.convertCorrectFormat(LocalDate.now()));
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child){
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int older){
        familyDao.getAllFamilies().forEach(f -> f.getChildren().
                removeIf(c -> (LocalDate.now().getYear() - LocalDate.ofEpochDay(c.getBirthDate()).getYear()) > older));
    }

    public int countFamiliesWithMemberNumber(int number){
        return familyDao.getAllFamilies()
                .stream()
                .filter(x -> x.countFamily() == number)
                .toList()
                .size();
    }

    public int count(){
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index){
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPet(int index){
        return familyDao.getFamilyByIndex(index).getPets();
    }

    public void addPet(int index, Pet pet){
        familyDao.getFamilyByIndex(index).getPets().add(pet);
    }


}
