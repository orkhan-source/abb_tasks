package Humans;

import Animals.Pet;

public final class Woman extends Human{
    public Woman(){

    }

    public Woman(String name, String surname, int year){
        super.setName(name);
        super.setSurname(surname);
        super.setYear(year);
    }


    public Woman(String name, String surname, int year, int iq, Pet pet, String [][] schedule){
        super.setName(name);
        super.setSurname(surname);
        super.setYear(year);
        super.setIq(iq);
        super.setPet(pet);
        super.setSchedule(schedule);
    }

    @Override
    public void greetPet(){
        System.out.println("Hello " + this.getPet().getNickname());
    }

    public void makeUp(){
        System.out.println("I am doing makeup");
    }
}
