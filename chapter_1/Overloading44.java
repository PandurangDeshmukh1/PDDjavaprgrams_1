public class Overloading44 {
    int id;
    String name;
    int age;

    Overloading44(int i, String n) {
        id = i;
        name = n;
        age = 0; 
    }

    
    Overloading44(int i, String n, int a) {
        id = i;
        name = n;
        age = a;
    }

    // Method to display student information
    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Overloading44 s1 = new Overloading44(1, "Hardik", 22);
        Overloading44 s2 = new Overloading44(2, "Rohit"); // Using two-parameter constructor
        s2.age = 20; // Setting age for the second student

        s1.display();
        s2.display();
    }
}
