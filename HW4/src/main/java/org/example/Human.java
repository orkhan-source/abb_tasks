package org.example;

import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public Human(){

    }

    public Human(String name, String surname, int year){
        setName(name);
        setSurname(surname);
        setYear(year);
    }

    public Human(String name, String surname, int year, Human father, Human mother){
        setName(name);
        setSurname(surname);
        setYear(year);
        setFather(father);
        setMother(mother);
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human father, Human mother, String [][] schedule){
        setName(name);
        setSurname(surname);
        setYear(year);
        setIq(iq);
        setPet(pet);
        setFather(father);
        setMother(mother);
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

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
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

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
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
        return "Human{name = '" + this.name + "', surname = '" + this.surname + "', year = " + this.year +
                ", iq = " + this.iq + ", mother = " + this.mother.getName() + " " + this.mother.getSurname() +
                ", father = " + this.father.getName() + " " + this.father.getSurname() + ", " +  this.pet.toString() + "}";
    }


    //advanced complexity starts from here
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



}
