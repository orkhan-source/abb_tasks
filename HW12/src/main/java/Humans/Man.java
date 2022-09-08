package Humans;

import Animals.Pet;
import Main.DayOfWeek;
import Utils.DateUtil;

import java.util.Map;

public final class Man extends Human{

    public Man(){

    }

    public Man(String name, String surname, String birthDate){
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, String birthDate, int iq, Pet pet, Map<DayOfWeek, String[]> schedule){
        super(name, surname, birthDate, iq, pet, schedule);
    }

    public Man(String name, String surname, String birthDate, int iq)  {
        super(name, surname, birthDate, iq);
    }


}
