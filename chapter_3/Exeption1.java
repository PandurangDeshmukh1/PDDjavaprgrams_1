import java.util.InputMismatchException;
import java.util.Scanner;

public class Exeption1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numerator = 0;
        double denominator = 0;

        while (true) {
            try {
                System.out.print("Enter the numerator: ");
                numerator = scanner.nextDouble();
                System.out.print("Enter the denominator: ");
                denominator = scanner.nextDouble();

                double result = numerator / denominator;
                System.out.println("Result: " + result);
                break;

            } catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero. Please try again.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter numeric values.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close();
    }
}
