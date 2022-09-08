package Humans;


import Animals.Pet;

import java.util.*;

public class Family {
    private Human father;
    private Human mother;
    private List<Human> children;
    private Set<Pet> pets = new HashSet<>();

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Family(Human father, Human mother, List<Human> children) {
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addChild(Human child){
        this.getChildren().add(child);
    }

    public boolean deleteChild(int index){
        if(index < 0 || index > this.children.size()){
            return false;
        }

        this.children.remove(index);
        return true;
    }


    public boolean deleteChild(Human child){

        int index = Arrays.asList(this.children).indexOf(child); // indexof will find index of child by comparing it with Human.equals method
        if(index == -1)
        {
            return false;
        }

        this.children.remove(child);

        return true;
    }

    public int countFamily(){
        return this.children.size() + 2;
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
        return  family.children.equals(this.children)
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
                "Children: " + List.of(this.children).toString() + "\n";
    }

    @Override
    public void finalize() throws Throwable{
        System.out.println(this.getClass().getName() + " collected by GC");
    }
}