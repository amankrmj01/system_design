class Abstract_Design_Pattern {
    public static void main(String[] args) {
        // Using the AnimalFactory to create Dog and Cat objects
        Animal dog = AnimalFactory.createAnimal("Dog");
        dog.speak();

        Animal cat = AnimalFactory.createAnimal("Cat");
        cat.speak();
    }
}

// Abstract Product
abstract class Animal {
    public abstract void speak();
}

// Concrete Product - Dog
class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

// Concrete Product - Cat
class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Abstract Factory
class AnimalFactory {
    public static Animal createAnimal(String type) {
        switch (type) {
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            default:
                throw new IllegalArgumentException("Unknown animal type");
        }
    }
}