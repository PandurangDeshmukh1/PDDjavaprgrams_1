public class constructor43 {
    int rollno;
    int marks1;
    int marks2;
    int total;

    // Constructor
    constructor43() {
        rollno = 2;
        marks1 = 30;
        marks2 = 40;    
    }  

    // Method to calculate total marks
    int calculateTotal() {
        total = marks1 + marks2;
        return total;
    }

    // Method to display student information
    void display() {
        System.out.println("Roll No: " + rollno);
        System.out.println("Marks 1: " + marks1);
        System.out.println("Marks 2: " + marks2);
        System.out.println("Total Marks: " + calculateTotal());
    }

    public static void main(String[] args) {
        constructor43 student = new constructor43();
        student.display();
    }
}

