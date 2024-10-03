class Vehicle {
    protected String model;
    protected double rentalPrice;

    public Vehicle(String model, double rentalPrice) {
        this.model = model;
        this.rentalPrice = rentalPrice;
    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Rental Price: $" + rentalPrice);
    }

    public void rent() {
        System.out.println(model + " has been rented.");
    }
}

class Car extends Vehicle {
    private int doors;

    public Car(String model, double rentalPrice, int doors) {
        super(model, rentalPrice);
        this.doors = doors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Doors: " + doors);
    }
}

class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String model, double rentalPrice, boolean hasCarrier) {
        super(model, rentalPrice);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry", 40.0, 4);
        car.displayDetails();
        car.rent();

        Bike bike = new Bike("Mountain Bike", 15.0, true);
        bike.displayDetails();
        bike.rent();
    }
}
