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

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Chirp");
    }
}

class Fish extends Animal {
    Fish(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Blub");
    }
}

public class Animal1 {
    public static void main(String[] args) {
        Animal myAnimal = new Animal("Generic Animal");
        myAnimal.display();
        myAnimal.makeSound();

        Dog myDog = new Dog("Buddy");
        myDog.display();
        myDog.makeSound();

        Cat myCat = new Cat("Whiskers");
        myCat.display();
        myCat.makeSound();

        Bird myBird = new Bird("Tweety");
        myBird.display();
        myBird.makeSound();

        Fish myFish = new Fish("Nemo");
        myFish.display();
        myFish.makeSound();
    }
}
