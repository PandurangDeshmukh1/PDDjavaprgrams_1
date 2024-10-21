import java.util.Scanner;

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class DoctorNameValidation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();
        
        try {
            if (!doctorName.matches("[a-zA-Z\\s]+")) {
                throw new InvalidNameException("Name is Invalid");
            } else {
                System.out.println("Doctor's Name: " + doctorName);
            }
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
