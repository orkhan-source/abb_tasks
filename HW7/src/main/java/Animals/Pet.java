package Animals;

import java.util.Arrays;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private String[] habits;
    private int trickLevel;

    public Pet(){

    };

    public Pet( String nickname){
        setNickname(nickname);
    }

    public Pet( String nickname, int age, String[] habits, int trickLevel){
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

    public void setHabits(String[] habits) {
        this.habits = new String[habits.length];
        System.arraycopy(habits, 0, this.habits, 0, habits.length);

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

    public abstract void respond();




    @Override
    public String toString(){
        return this.species +  "{nickname = '" + this.nickname + "', age = " + this.age + ", trickLevel = " +  this.trickLevel  +
                ", habits = " + Arrays.toString(this.habits) + " }";
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
                this.species.equals(p.species) &&
                Arrays.equals(this.habits, p.habits);
    }

    @Override
    public int hashCode(){
        int res = 37;
        res = 37 * res + this.age;
        res = 37 * res + this.trickLevel;
        res = 37 * res + this.habits.hashCode();
        res = 37 * res + this.species.hashCode();
        res = 37 * res + this.nickname.hashCode();

        return res;
    }

    @Override
    public void finalize() throws Throwable{
        System.out.println(this.getClass().getName() + " collected by GC");
    }


}