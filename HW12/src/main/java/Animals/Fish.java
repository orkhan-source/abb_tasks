package Animals;

import java.util.Set;

public class Fish extends Pet implements Foul{

    public Fish(){
        super.setSpecies(Species.FISH);
    }



    public Fish( String nickname){
        super.setSpecies(Species.FISH);
        super.setNickname(nickname);
    }

    public Fish(String nickname, int age, Set<String> habits, int trickLevel){
        super.setSpecies(Species.FISH);
        super.setNickname(nickname);
        super.setAge(age);
        super.setHabits(habits);
        super.setTrickLevel(trickLevel);
    };

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am " + this.getNickname() + ". I miss you!");
    }

    @Override
    public void foul(){
        System.out.println("I need to cover it up!");
    }
}
