import java.io.IOException;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        MonsterManager manager = new MonsterManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ____________________");
            System.out.println("| 1. Create Monster  |");
            System.out.println("| 2. View Monsters   |");
            System.out.println("| 3. Breed Monsters  |");
            System.out.println("| 4. Save Game       |");
            System.out.println("| 5. Load Game       |");
            System.out.println("| 6. Exit            |");
            System.out.println(" --------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(" -> Enter name:");
                    String name = scanner.nextLine();
                    System.out.println(" -> Enter color:");
                    String color = scanner.nextLine();
                    System.out.println(" -> Enter strength:");
                    int strength = scanner.nextInt();
                    System.out.println(" -> Enter speed:");
                    int speed = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Monster monster = new Monster(name, color, strength, speed) {
                        @Override
                        public void performSpecialAbility() {
                            System.out.println(getName() + " has no special ability.");
                        }
                    };
                    manager.addMonster(monster);
                    break;
                case 2:
                    manager.displayMonsters();
                    break;
                case 3:
                    manager.displayMonsters();
                    System.out.println("-> Select two monsters to breed:");
                    int index1 = scanner.nextInt();
                    int index2 = scanner.nextInt();
                    manager.breedMonsters(index1, index2);
                    break;
                case 4:
                    System.out.println("--> Enter filename to save:");
                    String saveFilename = scanner.next();
                    try {
                        manager.saveGame(saveFilename);
                        System.out.println("* Game saved successfully.");
                    } catch (IOException e) {
                        System.err.println("* Failed to save game: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("--> Enter filename to load:");
                    String loadFilename = scanner.next();
                    try {
                        manager.loadGame(loadFilename);
                        System.out.println("* Game loaded successfully.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("* Failed to load game: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("* Exiting game...");
                    return;
                default:
                    System.out.println("* Invalid choice!! ");
            }
        }
    }
}