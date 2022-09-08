package DAO;

import Humans.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao{
    private List<Family> families = new ArrayList<>();
    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if(families.contains(families.get(index))){
            families.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if(families.contains(family)){
            families.remove(family);
            return true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family family) {
        if(families.contains(family)){
            int indexOf = families.indexOf(family);
            families.set(indexOf, family);
        }
        else{
            families.add(family);
        }
    }
}
