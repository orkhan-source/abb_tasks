package DAO;

import Animals.Pet;
import Humans.Family;
import Humans.Human;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService){
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies(){
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies(){ familyService.displayAllFamilies(); }

    public List<Family> getFamiliesBiggerThan(int bigger){ return familyService.getFamiliesBiggerThan(bigger); }

    public List<Family> getFamiliesLessThan(int less){ return familyService.getFamiliesLessThan(less); }

    public Family createNewFamily(Human father, Human mother){ return familyService.createNewFamily(father, mother); }

    public void deleteFamilyByIndex(int index){
        familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String masculine, String feminine) { return familyService.bornChild(family, masculine, feminine); }

    public Family adoptChild(Family family, Human child){ return familyService.adoptChild(family, child); }

    public void deleteAllChildrenOlderThen(int older){ familyService.deleteAllChildrenOlderThen(older); }

    public int countFamiliesWithMemberNumber(int number){ return familyService.countFamiliesWithMemberNumber(number); }

    public int count(){ return familyService.count(); }

    public Family getFamilyById(int index){
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPet(int index){ return familyService.getPet(index); }

    public void addPet(int index, Pet pet){ familyService.addPet(index, pet); }


}
