package Main;

import java.util.Arrays;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private String[][] schedule;

    private Family family;

    public Human(){

    }

    public Human(String name, String surname, int year){
        setName(name);
        setSurname(surname);
        setYear(year);
    }


    public Human(String name, String surname, int year, int iq, Pet pet, String [][] schedule){
        setName(name);
        setSurname(surname);
        setYear(year);
        setIq(iq);
        setPet(pet);
        setSchedule(schedule);
    }




    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIq(int iq) {
        if(iq > 0 && iq < 100) {
            this.iq = iq;
        }
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public int getIq() {
        return iq;
    }

    public Pet getPet() {
        return pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void greetPet(){
        System.out.println("Hello, " + this.pet.getNickname());
    }

    public void describePet(){
        String slyLevel = this.pet.getTrickLevel() >= 50 ? "very sly" : "almost not sly";
        System.out.println("I have a " + this.pet.getSpecies() + ", he is " + slyLevel);
    }


    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.schedule.length; i++) {
            sb.append(Arrays.toString(this.schedule[i]));
        }

        return "Human{name = '" + this.name + "', surname = '" + this.surname + "', year = " + this.year +
                ", iq = " + this.iq + ", " +  sb.toString() + "}";
    }


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(!(o instanceof Human) || o == null){
            return false;
        }

        Human h = (Human) o;
        return this.year == h.year &&
                this.iq == h.iq &&
                this.name.equals(h.name) &&
                this.surname.equals(h.surname) &&
                Utils.check2dArrayEquality(this.schedule, h.schedule);
    }


    @Override
    public int hashCode(){
        int res = 37;
        res = 37 * res + this.iq;
        res = 37 * res + this.year;
        res = 37 * res + this.name.hashCode();
        res = 37 * res + this.surname.hashCode();
        res = 37 * res + this.pet.hashCode();
        res = 37 * res + this.schedule.hashCode();
        res = 37 * res + this.family.hashCode();
        return res;
    }



    //advanced complexity hw4 starts from here
    public boolean feedPet(boolean feedTime) {
        Random rand = new Random();
        int randomFeed = rand.nextInt(101);

        if(!feedTime){
            if(randomFeed > this.pet.getTrickLevel())
            {
                System.out.println("I think " + this.pet.getNickname() + " is not hungry.");
                return false;
            }
        }

        System.out.println("Hm... I will feed " + this.pet.getNickname());
        return true;
    }

    @Override
    public void finalize() throws Throwable{
        System.out.println(this.getClass().getName() + " collected by GC");
    }



}