import java.util.*;

interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow");
    }
}

abstract class AnimalFactory {
    // Factory method
    public abstract Animal createAnimal();

    // Some other logic
    public void speak() {
        Animal animal = createAnimal();
        animal.speak();
    }
}

class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}


public class FactoryMethodPattern {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        dogFactory.speak(); // Output: Woof
        catFactory.speak(); // Output: Meow
    }
}