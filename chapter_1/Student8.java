// Student class definition
class Student {
    int id;
    String name;

    // Constructor to initialize id and name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to display student details
    public void display() {
        System.out.println(id + " " + name);
    }
}


public class Student8 {
    public static void main(String[] args) {
        Student s1 = new Student(111, "Karan");
        Student s2 = new Student(112, "Aryan");
        
        s1.display();
        s2.display();
    }
}
