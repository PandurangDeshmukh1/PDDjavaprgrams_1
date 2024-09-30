import java.util.Scanner;

public class Chapter1_39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0.0; 
        System.out.println("Enter numbers to calculate the average (type 'done' to finish):");

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
                count++;
            } else {
                String str = scanner.next();
                if (str.equals("done")) { 
                    break;
                } else {
                    System.out.println("Data format error. Please enter a valid number or 'done' to finish.");
                    scanner.nextLine(); 
                }
            }
        }

        if (count > 0) {
            System.out.println("Average is " + (sum / count));
        } else {
            System.out.println("No numbers were entered.");
        }

        scanner.close(); 
    }
}


