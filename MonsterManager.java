import java.io.IOException;
import java.util.ArrayList;

class MonsterManager {
    private ArrayList<Monster> monsters;

    public MonsterManager() {
        monsters = new ArrayList<>();
    }

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    public void breedMonsters(int index1, int index2) {
        // Simple breeding logic
        Monster parent1 = monsters.get(index1);
        Monster parent2 = monsters.get(index2);

        String childName = parent1.getName() + "-" + parent2.getName();
        String childColor = parent1.getColor();
        int childStrength = (parent1.getStrength() + parent2.getStrength()) / 2;
        int childSpeed = (parent1.getSpeed() + parent2.getSpeed()) / 2;

        Monster child = new Monster(childName, childColor, childStrength, childSpeed) {
            @Override
            public void performSpecialAbility() {
                // Define special ability for the child
            }
        };
        monsters.add(child);

        System.out.println("Bred a new monster: " + child);
    }

    public void displayMonsters() {
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println(i + ": " + monsters.get(i));
        }
    }

    public void saveGame(String filename) throws IOException {
        FileManager.saveMonsters(monsters, filename);
    }

    public void loadGame(String filename) throws IOException, ClassNotFoundException {
        monsters = FileManager.loadMonsters(filename);
    }
}
