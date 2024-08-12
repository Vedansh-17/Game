class AquaticMonster extends Monster {
    private int swimSpeed;

    public AquaticMonster(String name, String color, int strength, int speed, int swimSpeed) {
        super(name, color, strength, speed);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is swimming at a speed of " + swimSpeed + " knots!");
    }
}