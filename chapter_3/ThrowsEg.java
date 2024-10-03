import java.util.Scanner;

public class ThrowsEg {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to divide 100: ");
        int number = scanner.nextInt();

        try {
            double result = divide(100, number);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        scanner.close();
    }

    // Method that may throw an ArithmeticException
    public static double divide(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }
}
