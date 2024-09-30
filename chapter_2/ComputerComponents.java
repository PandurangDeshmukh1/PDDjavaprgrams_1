class Component {
    private String name;
    private String type;
    private double price;


    public Component(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

 
    public void displayInfo() {
        System.out.println("Component Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}

public class ComputerComponents {
    public static void main(String[] args) {
        Component cpu = new Component("Intel Core i7", "CPU", 299.99);
        Component ram = new Component("Corsair Vengeance 16GB", "RAM", 89.99);
        Component hdd = new Component("Seagate 1TB", "Hard Drive", 49.99);

        System.out.println("Computer Components:");
        cpu.displayInfo();
        ram.displayInfo();
        hdd.displayInfo();
    }
}
