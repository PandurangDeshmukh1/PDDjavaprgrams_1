public class StaticExample47{
    static int staticField = 0;

    static void increment() {
        staticField++;
    }

    static void display() {
        System.out.println("Static Field: " + staticField);
    }

    public static void main(String[] args) {
        StaticExample47.display();
        StaticExample47.increment();
        StaticExample47.display();
        StaticExample47.increment();
        StaticExample47.display();
    }
}
