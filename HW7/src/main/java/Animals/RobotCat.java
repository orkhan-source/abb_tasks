package Animals;

public class RobotCat extends Pet  implements Foul{

    public RobotCat(){
        super.setSpecies(Species.ROBOTCAT);
    }



    public RobotCat( String nickname){
        super.setSpecies(Species.ROBOTCAT);
        super.setNickname(nickname);
    }

    public RobotCat( String nickname, int age, String[] habits, int trickLevel){
        super.setSpecies(Species.ROBOTCAT);
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
