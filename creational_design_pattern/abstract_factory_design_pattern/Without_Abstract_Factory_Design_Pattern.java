class Without_Abstract_Design_Pattern {
    public static void main(String[] args) {
        // Creating a Dog object directly
        Dog dog = new Dog();
        dog.speak();

        // Creating a Cat object directly
        Cat cat = new Cat();
        cat.speak();
    }
}

class Dog {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat {
    public void speak() {
        System.out.println("Meow!");
    }
}