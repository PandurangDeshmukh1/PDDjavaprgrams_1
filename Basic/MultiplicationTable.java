import java.util.Scanner;

public class MultiplicationTable {


    public static void generateTable(int number) {
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter a number: ");
     
        try {
            int number = scanner.nextInt();
           
            generateTable(number);
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        } finally {
           
            scanner.close();
        }
    }
}
