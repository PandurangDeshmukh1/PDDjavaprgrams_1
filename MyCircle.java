import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Circle41 {
    int radius;
    float perimeter;
    float area;
}

public class MyCircle {
    public static void main(String[] args) {
        final float pi = 3.14f;
        Circle c = new Circle();
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the radius:");
            c.radius = Integer.parseInt(in.readLine()); // Corrected method name and casing
            c.perimeter = 2 * pi * c.radius; // Corrected method of accessing perimeter calculation
            c.area = pi * c.radius * c.radius; // Calculate area

            System.out.println("Perimeter: " + c.perimeter);
            System.out.println("Area: " + c.area);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer for the radius.");
        }
    }
}
