package org.example;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private String[] habits;
    private int trickLevel;

    public Pet(){

    };

    public Pet(String species, String nickname){
        setSpecies(species);
        setNickname(nickname);
    }

    public Pet(String species, String nickname, int age, String[] habits, int trickLevel){
        setSpecies(species);
        setNickname(nickname);
        setAge(age);
        setHabits(habits);
        setTrickLevel(trickLevel);
    };

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(String[] habits) {
        this.habits = new String[habits.length];
        System.arraycopy(habits, 0, this.habits, 0, habits.length);

    }

    public void setTrickLevel(int trickLevel) {
        if(trickLevel < 100 && trickLevel > 0){
            this.trickLevel = trickLevel;
        }
    }


    public String getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String[] getHabits() {
        String[] copy = new String[this.habits.length];
        System.arraycopy(this.habits, 0, copy, 0, copy.length);
        return copy;
    }

    public int getTrickLevel() {
        return trickLevel;
    }


    public void eat(){
        System.out.println("I am eating!");
    }

    public void respond(){
        System.out.println("Hello, owner. I am " + this.nickname + ". I miss you!");
    }

    public void foul(){
        System.out.println("I need to cover it up!");
    }


    @Override
    public String toString(){
    return this.species +  "{nickname = '" + this.nickname + "', age = " + this.age + ", trickLevel = " +  this.trickLevel  +
            ", habits = " + Arrays.toString(this.habits) + " }";
    }
}
