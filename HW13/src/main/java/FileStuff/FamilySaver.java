package FileStuff;

import Humans.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilySaver {
    public static String filePath = "database.bin";

    public static void saveData(List<Family> families)  {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(families);
            oos.close();

        } catch (Exception ex) {
            Logging.error("[ERROR]");
        }

    }

    public static List<Family> loadData(){


        List<Family> families;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            families = (List<Family>) ois.readObject();
            ois.close();
        } catch (Exception e){
            Logging.error("[ERROR]");
            throw new RuntimeException("Exception occurred while file processing!");
        }


        return families;
    }
}
