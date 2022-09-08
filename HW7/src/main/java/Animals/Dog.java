package Animals;

public class Dog extends Pet implements Foul{

    public Dog(){
        super.setSpecies(Species.DOG);
    }



    public Dog( String nickname){
        super.setSpecies(Species.DOG);
        super.setNickname(nickname);
    }

    public Dog( String nickname, int age, String[] habits, int trickLevel){
        super.setSpecies(Species.DOG);
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
