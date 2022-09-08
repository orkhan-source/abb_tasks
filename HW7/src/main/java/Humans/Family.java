package Humans;


import Main.Utils;

import java.util.Arrays;

public class Family implements HumanCreator {
    private Human father;
    private Human mother;
    private Human[] children;

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        this.children = new Human[0];
    }

    public Family(Human father, Human mother, Human[] children) {
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

    public Human[] getChildren() {
        return children;
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


    public void addChild(Human child){
        this.children = Arrays.copyOf(this.children, this.children.length + 1);
        this.children[this.children.length - 1] = child;


    }

    public boolean deleteChild(int index){
        if(index < 0 || index > this.children.length){
            return false;
        }
        Utils.modifyArray(this.children, index);
        this.children = Arrays.copyOf(this.children, this.children.length - 1);

        return true;
    }


    public boolean deleteChild(Human child){

        int index = Arrays.asList(this.children).indexOf(child); // indexof will find index of child by comparing it with Human.equals method
        if(index == -1)
        {
            return false;
        }

        Utils.modifyArray(this.children, index);
        this.children = Arrays.copyOf(this.children, this.children.length - 1);

        return true;
    }

    public int countFamily(){
        return this.children.length + 2;
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

    @Override
    public void finalize() throws Throwable{
        System.out.println(this.getClass().getName() + " collected by GC");
    }

    @Override
    public void bornChild() {
        int iq = (int)(this.father.getIq() * 0.5 + this.mother.getIq() * 0.5);

        Human child = HumanCreator.getSex ? new Man(HumanCreator.getManName(), this.father.getSurname(), 2022, iq, null, null):
                new Woman(HumanCreator.getWomanName(), this.father.getSurname(), 2022, iq, null, null);

        child.setFamily(this);
        this.addChild(child);

        System.out.println(child.getName() + " bornt");

    }
}