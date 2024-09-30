public class Interface50 {
    int i, j;

    void show() {
        System.out.println("i and j:");
        System.out.println(i + " " + j);
    }
}

class Sub extends Interface50 {
    int k;

    void display() {
        System.out.println("K: " + k);
    }

    void sum() {
        System.out.println("i + j + k: " + (i + j + k));
    }
}
public class Interface50 {
    public static void main(String[] args) {
        Sub a = new Sub();
        a.i = 5;
        a.j = 10;
        a.k = 15;

        a.show();
        a.display();
        a.sum();
    }
}
