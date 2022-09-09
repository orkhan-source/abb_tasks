package Animals;

public enum Species {

    DOG(false, 4, true),
    DOMESTICCAT(false, 4, true),
    FISH(false, 0, false),
    ROBOTCAT(false, 4, false),
    UNKNOWN();

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(){

    }
    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
}
