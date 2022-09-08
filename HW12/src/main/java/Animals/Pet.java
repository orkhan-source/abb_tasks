package Animals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private Set<String> habits;
    private int trickLevel;

    public Pet(){

    };

    public Pet( String nickname){
        setNickname(nickname);
    }

    public Pet( String nickname, int age, HashSet<String> habits, int trickLevel){
        setNickname(nickname);
        setAge(age);
        setHabits(habits);
        setTrickLevel(trickLevel);
    };

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void setTrickLevel(int trickLevel) {
        if(trickLevel < 100 && trickLevel > 0){
            this.trickLevel = trickLevel;
        }
    }


    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getHabits() {
        return this.habits;
    }

    public int getTrickLevel() {
        return trickLevel;
    }


    public void eat(){
        System.out.println("I am eating!");
    }

    public abstract void respond();

    public String prettyFormat(){
        return "{species=" + this.species
                + ", nickname=" + this.nickname
                + ", age=" + this.age
                + ", trickLevel=" + this.trickLevel
                + ", habits=" + this.habits + "}";
    }



    @Override
    public String toString(){
        return this.species +  "{nickname = '" + this.nickname + "', age = " + this.age + ", trickLevel = " +  this.trickLevel  +
                ", habits = " + Arrays.toString(Set.of(this.habits).toArray()) + " }";
    }

    @Override
    public boolean equals(Object o){

        if(this == o){
            return true;
        }

        if((!(o instanceof Pet)) || o == null)
        {
            return false;
        }

        Pet p = (Pet) o;


        return this.age == p.age &&
                this.trickLevel == p.trickLevel &&
                this.nickname.equals(p.nickname) &&
                this.species.equals(p.species) ;

    }

    @Override
    public int hashCode(){
        int res = 37;
        res = 37 * res + this.age;
        res = 37 * res + this.trickLevel;
        res = 37 * res + this.species.hashCode();
        res = 37 * res + this.nickname.hashCode();

        return res;
    }

    @Override
    public void finalize() throws Throwable{
        System.out.println(this.getClass().getName() + " collected by GC");
    }


}