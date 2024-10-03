public class Vehicle1 {
    int speed;
    
    Vehicle1(int s) {
        speed = s;
    }
}

class Car extends Vehicle1 {
    int speed;
    
    Car(int maxSpeed, int minSpeed) {
        super(maxSpeed);
        speed = minSpeed;
    }
    
    void display() {
        System.out.println("Max speed (Superclass) = " + super.speed);
        System.out.println("Min speed (Subclass) = " + speed);
    }
}

class TestVehicle {
    public static void main(String[] args) {
        Car myCar = new Car(180, 60);
        myCar.display();
    }
}
