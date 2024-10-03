import java.util.Scanner;

public class Throws {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String input = scanner.nextLine();

        try {
            int number = parseNumber(input);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }

        scanner.close();
    }

    public static int parseNumber(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
}

