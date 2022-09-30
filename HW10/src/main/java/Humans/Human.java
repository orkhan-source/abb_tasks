package Humans;

import Animals.Pet;
import Main.DayOfWeek;
import Utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class Human {
    private String name;
    private String surname;

    private long birthDate;
    private int iq;
    private Pet pet;
    private Map<DayOfWeek, String[]> schedule;

    private Family family;

    public Human(){

    }

    public Human(String name, String surname, String birthDate){
        this.name = name;
        this.surname = surname;
        this.birthDate = DateUtil.dateStrToUnix(birthDate);
    }


    public Human(String name, String surname, String birthDate, int iq, Pet pet, Map<DayOfWeek, String[]> schedule){
        this.name = name;
        this.surname = surname;
        this.birthDate = DateUtil.dateStrToUnix(birthDate);
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthDate, int iq)  {
        this.name = name;
        this.surname = surname;
        this.birthDate = DateUtil.dateStrToUnix(birthDate);
        this.iq = iq;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setIq(int iq) {
        if(iq > 0 && iq < 100) {
            this.iq = iq;
        }
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setSchedule(Map<DayOfWeek, String[]> schedule) {
        this.schedule = schedule;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public long getBirthDate() {
        return birthDate;
    }

    public int getIq() {
        return iq;
    }

    public Pet getPet() {
        return pet;
    }

    public Map<DayOfWeek, String[]> getSchedule() {
        return schedule;
    }

    public void greetPet(){
        System.out.println("Hello, " + this.pet.getNickname());
    }

    public void describePet(){
        String slyLevel = this.pet.getTrickLevel() >= 50 ? "very sly" : "almost not sly";
        System.out.println("I have a " + this.pet.getSpecies() + ", he is " + slyLevel);
    }

    public String describeAge(){
        Date dt = new Date(birthDate);
        LocalDate date = DateUtil.convertDateToLocal(dt);
        Period datePeriod = Period.between(date, LocalDate.now());

        return datePeriod.getYears() +
                " years " + datePeriod.getMonths() +
                " months " + datePeriod.getDays()  +  " days.";

    }

    @Override
    public String toString() {
        return String.format("Human{ name = %s, surname = %s, birthDate = %s, iq= %d }", name, surname, DateUtil.dateUnixToStr(birthDate), iq);
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
        return this.birthDate == h.birthDate &&
                this.iq == h.iq &&
                this.name.equals(h.name) &&
                this.surname.equals(h.surname);
    }


    @Override
    public int hashCode(){
        int res = 37;
        res = 37 * res + this.iq;
        res = 37 * res + (int)this.birthDate;
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