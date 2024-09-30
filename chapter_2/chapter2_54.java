class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }

    void display() {
        System.out.println("Animal Name: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class chapter2_54 {
    public static void main(String[] args) {
        Animal myAnimal = new Animal("Generic Animal");
        myAnimal.display();
        myAnimal.makeSound();

        Dog myDog = new Dog("Buddy");
        myDog.display();
        myDog.makeSound();
    }
}

// above program is uding Extend and this keyword in Interface and class 