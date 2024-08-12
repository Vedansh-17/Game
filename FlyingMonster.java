class FlyingMonster extends Monster {
    private int wingSpan;

    public FlyingMonster(String name, String color, int strength, int speed, int wingSpan) {
        super(name, color, strength, speed);
        this.wingSpan = wingSpan;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is flying with a wingspan of " + wingSpan + " meters!");
    }
}