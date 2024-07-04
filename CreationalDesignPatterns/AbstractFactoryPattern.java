// The Abstract Factory Design Pattern is a creational pattern that provides an interface for 
// creating families of related or dependent objects without specifying their concrete classes.

import java.util.*;

// Animal Interface
interface Animal {
    void speak();
}

// Dog Interface
interface Dog extends Animal {}

// Cat Interface
interface Cat extends Animal {}

// Wild Dog
class WildDog implements Dog {
    @Override
    public void speak() {
        System.out.println("Wild Dog says: Woof Woof!");
    }
}

// Wild Cat
class WildCat implements Cat {
    @Override
    public void speak() {
        System.out.println("Wild Cat says: Roar!");
    }
}

// Pet Dog
class PetDog implements Dog {
    @Override
    public void speak() {
        System.out.println("Pet Dog says: Bark Bark!");
    }
}

// Pet Cat
class PetCat implements Cat {
    @Override
    public void speak() {
        System.out.println("Pet Cat says: Meow!");
    }
}

// Animal Factory Interface
interface AnimalFactory {
    Dog createDog();
    Cat createCat();
}

// Wild Animal Factory
class WildAnimalFactory implements AnimalFactory {
    @Override
    public Dog createDog() {
        return new WildDog();
    }

    @Override
    public Cat createCat() {
        return new WildCat();
    }
}

// Pet Animal Factory
class PetAnimalFactory implements AnimalFactory {
    @Override
    public Dog createDog() {
        return new PetDog();
    }

    @Override
    public Cat createCat() {
        return new PetCat();
    }
}

class AnimalWorld {
    public Dog dog;
    public Cat cat;

    public AnimalWorld(AnimalFactory factory) {
        dog = factory.createDog();
        cat = factory.createCat();
    }

    public void makeAnimalsSpeak() {
        dog.speak();
        cat.speak();
    }
}

public class AbstractFactoryPattern {
	
	public static void main(String[] args) {
        // Create wild animals
        AnimalFactory wildFactory = new WildAnimalFactory();
        AnimalWorld wildAnimalWorld = new AnimalWorld(wildFactory);
        System.out.println("Wild Animals:");
        wildAnimalWorld.makeAnimalsSpeak();

        // Create pet animals
        AnimalFactory petFactory = new PetAnimalFactory();
        AnimalWorld petAnimalWorld = new AnimalWorld(petFactory);
        System.out.println("Pet Animals:");
        petAnimalWorld.makeAnimalsSpeak();
    }
	
}