package DAO;

import FileStuff.FamilySaver;
import FileStuff.Logging;
import Humans.Family;

import java.time.LocalDate;
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
            Logging.info(LocalDate.now() + "[DEBUG]");
            return true;
        }
        Logging.error("[ERROR]");
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if(families.contains(family)){
            families.remove(family);
            Logging.info(LocalDate.now() + "[DEBUG]");
            return true;
        }
        Logging.error("[ERROR]");
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

        Logging.info(LocalDate.now() + "[DEBUG]");
    }

    @Override
    public List<Family> loadData() {
        return FamilySaver.loadData();
    }

    @Override
    public void saveData(List<Family> families){
        FamilySaver.saveData(families);
    }
}
