import java.io.*;
import java.util.ArrayList;

abstract class Monster implements Serializable {
    private String name;
    private String color;
    private int strength;
    private int speed;

    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    public abstract void performSpecialAbility();

    public String toString() {
        return String.format("Name: %s, Color: %s, Strength: %d, Speed: %d", name, color, strength, speed);
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static Monster loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Monster) ois.readObject();
        }
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}
