package Main;

public enum Species {

    DOG(false, 4, true),
    CAT(false, 4, true),
    BIRD(true, 2, false),
    MONKEY(false, 4, true);

    private final boolean canFly;
    private final int numberOfLegs;
    private final boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
}
