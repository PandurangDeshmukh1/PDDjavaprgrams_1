import java.util.Scanner;

public class studentarray11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        double[] numbers = new double[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / size;
        System.out.println("The average is: " + average);

        scanner.close();
    }
}
//Average finding  using aaray;'
'