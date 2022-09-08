package Humans;

import Animals.Pet;

public final class Man extends Human{
    public Man(){

    }

    public Man(String name, String surname, int year){
        super.setName(name);
        super.setSurname(surname);
        super.setYear(year);
    }


    public Man(String name, String surname, int year, int iq, Pet pet, String [][] schedule){
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

    public void repairCar(){
        System.out.println("I am repairing my car");
    }
}
