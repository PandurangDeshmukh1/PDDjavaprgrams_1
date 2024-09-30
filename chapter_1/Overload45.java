public class Overload45 {
    int m, n;

    Overload45() {
        m = 5;
        n = 28;
    }

    Overload45(int p, int q) {
        m = p;
        n = q;
    }

    Overload45(double x, double y) {
        m = (int) x;
        n = (int) y;
    }

    void display() {
        System.out.println("m: " + m);
        System.out.println("n: " + n);
    }

    public static void main(String[] args) {
        Overload45 obj1 = new Overload45();
        Overload45 obj2 = new Overload45(10, 20);
        Overload45 obj3 = new Overload45(15.5, 25.5);

        System.out.println("Using default constructor:");
        obj1.display();
        
        System.out.println("Using integer constructor:");
        obj2.display();
        
        System.out.println("Using double constructor:");
        obj3.display();
    }
}
