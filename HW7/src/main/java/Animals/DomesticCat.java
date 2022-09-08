package Animals;

public class DomesticCat extends Pet implements Foul{

    public DomesticCat(){
        super.setSpecies(Species.DOMESTICCAT);
    }



    public DomesticCat( String nickname){
        super.setSpecies(Species.DOMESTICCAT);
        super.setNickname(nickname);
    }

    public DomesticCat( String nickname, int age, String[] habits, int trickLevel){
        super.setSpecies(Species.DOMESTICCAT);
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
