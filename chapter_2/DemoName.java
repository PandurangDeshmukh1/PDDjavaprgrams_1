import java.util.ArrayList;
import java.util.Scanner;

public class DemoName {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("1. Add Name");
            System.out.println("2. Remove Name");
            System.out.println("3. Display Names");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter name to add: ");
                    String nameToAdd = scanner.nextLine();
                    names.add(nameToAdd);
                    System.out.println(nameToAdd + " added.");
                    break;
                case "2":
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    if (names.remove(nameToRemove)) {
                        System.out.println(nameToRemove + " removed.");
                    } else {
                        System.out.println(nameToRemove + " not found.");
                    }
                    break;
                case "3":
                    System.out.println("Names List: " + names);
                    break;
                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
