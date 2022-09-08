package org.example;


import java.util.Arrays;
import java.util.Random;

public class Family {
    private Human father;
    private Human mother;
    private Human[] children;

    private Pet pet;

    private static int countFamily = 2;

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        this.children = new Human[0];
    }

    public Family(Human father, Human mother, Human[] children, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pet = pet;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Pet getPet() {
        return pet;
    }

    public Human[] getChildren() {
        return children;
    }


    public static int getCountFamily() {
        return countFamily;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child){
        this.children = Arrays.copyOf(this.children, this.children.length + 1);
        this.children[this.children.length - 1] = child;
        countFamily++;
    }

    public boolean deleteChild(int index){
        if(index < 0 || index > this.children.length){
            return false;
        }
        Utils.modifyArray(this.children, index);
        this.children = Arrays.copyOf(this.children, this.children.length - 1);
        countFamily--;
        return true;
    }


    public boolean deleteChildAdvanced(Human child){

        int index = Arrays.asList(this.children).indexOf(child); // indexof will find index of child by comparing it with Human.equals method

        Utils.modifyArray(this.children, index);

        this.children = Arrays.copyOf(this.children, this.children.length - 1);
        countFamily--;
        return true;
    }
    
    public void greetPet(){
        System.out.println("Hello, " + this.pet.getNickname());
    }

    public void describePet(){
        String slyLevel = this.pet.getTrickLevel() >= 50 ? "very sly" : "almost not sly";
        System.out.println("I have a " + this.pet.getSpecies() + ", he is " + slyLevel);
    }
    
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
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if((!(o instanceof Family)) || o == null )
        {
            return false;
        }

        Family family = (Family) o;
        return Arrays.equals(this.children, family.children)
                && this.father.equals(family.father)
                && this.mother.equals(family.mother);

    }


    @Override
    public int hashCode(){
        int res = 37;
        res = 37 * res + this.father.hashCode();
        res = 37 * res + this.mother.hashCode();
        res = 37 * res + this.children.hashCode();
        return res;
    }



    @Override
    public String toString(){
        return "Father: " + this.father.toString() + "\n" +
                "Mother: " + this.mother.toString() + "\n" +
                "Children: " + Arrays.toString(children) + "\n";
    }
}