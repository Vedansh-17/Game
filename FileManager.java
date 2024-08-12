import java.io.*;
import java.util.ArrayList;

public class FileManager {


    public static void saveMonsters(ArrayList<Monster> monsters, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Monster monster : monsters) {
                // Save each monster's details in the format: Name,Color,Strength,Speed
                writer.write(monster.getName() + "," + monster.getColor() + "," +
                        monster.getStrength() + "," + monster.getSpeed());
                writer.newLine();  // Move to the next line for the next monster
            }
        } catch (IOException e) {
            System.out.println("Error saving monsters to file: " + e.getMessage());
            throw e;
        }
    }


    public static ArrayList<Monster> loadMonsters(String filename) throws IOException {
        ArrayList<Monster> monsters = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String color = parts[1];
                    int strength = Integer.parseInt(parts[2]);
                    int speed = Integer.parseInt(parts[3]);

                    // Create a new Monster object and add it to the list
                    Monster monster = new Monster(name, color, strength, speed) {
                        @Override
                        public void performSpecialAbility() {

                        }
                    };
                    monsters.add(monster);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading monsters from file: " + e.getMessage());
            throw e;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing monster attributes: " + e.getMessage());
            throw new IOException("Invalid data format in file", e);
        }

        return monsters;
    }
}
