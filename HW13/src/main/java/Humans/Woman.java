package Humans;

import Animals.Pet;
import Main.DayOfWeek;

import java.util.Map;

public final class Woman extends Human{

    public Woman(){

    }

    public Woman(String name, String surname, String birthDate){
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate, int iq, Pet pet, Map<DayOfWeek, String[]> schedule){
        super(name, surname, birthDate, iq, pet, schedule);
    }

    public Woman(String name, String surname, String birthDate, int iq)  {
        super(name, surname, birthDate, iq);
    }
}
