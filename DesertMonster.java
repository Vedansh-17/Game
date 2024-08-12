class DesertMonster extends Monster {
    private int heatResistance;

    public DesertMonster(String name, String color, int strength, int speed, int heatResistance) {
        super(name, color, strength, speed);
        this.heatResistance = heatResistance;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println("The maximum heat " + getName() + "can resist is : " + heatResistance);
    }
}