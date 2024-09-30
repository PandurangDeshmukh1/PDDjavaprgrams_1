abstract class AbstractShape {
    abstract void draw();
}

class Rectangle extends AbstractShape {
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle extends AbstractShape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class TestAbstraction1 {
    public static void main(String[] args) {
        AbstractShape s = new Circle();
        s.draw();
        
        s = new Rectangle(); // Example of using Rectangle as well
        s.draw();
    }
}
