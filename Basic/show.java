import java.util.ArrayList;
import java.util.Scanner;

public class show {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of integers you want to store: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            numbers.add(number);
        }

        System.out.println("The elements in the ArrayList are:");
        for (int num : numbers) {
            System.out.println(num);
        }

        scanner.close();
    }
}
