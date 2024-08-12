class MountainMonster extends Monster {
    private int climbingSkill;

    public MountainMonster(String name, String color, int strength, int speed, int climbingSkill) {
        super(name, color, strength, speed);
        this.climbingSkill = climbingSkill;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is climbing at a speed of " + climbingSkill + " knots!");
    }
}