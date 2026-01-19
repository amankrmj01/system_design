# Abstract Factory Design Pattern
The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is particularly useful when the system needs to be independent of how its objects are created, composed, and represented.

## Table of Contents
- [Intent](#intent)
- [Structure](#structure)
- [Example](#example)
- [Benefits](#benefits)
- [Drawbacks](#drawbacks)
- [When to Use](#when-to-use)

## Intent
The intent of the Abstract Factory Pattern is to encapsulate a group of individual factories that have a common theme. It allows clients to create objects from these factories without needing to know the specifics of their creation.

## Structure
The Abstract Factory Pattern typically involves the following components:
- **Abstract Factory**: An interface that declares a set of methods for creating abstract products.
- **Concrete Factory**: A class that implements the Abstract Factory interface and creates concrete products.
- **Abstract Product**: An interface for a type of product.
- **Concrete Product**: A class that implements the Abstract Product interface.

## Example
Consider a scenario where we want to create different types of UI components (buttons and checkboxes) for different operating systems (Windows and MacOS).

```java// Abstract Product - Button
interface Button {
    void paint();
}

// Abstract Product - Checkbox
interface Checkbox {
    void paint();
}

// Concrete Product - Windows Button
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a button in Windows style.");
    }
}

// Concrete Product - MacOS Button
class MacOSButton implements Button {   
    public void paint() {
        System.out.println("Rendering a button in MacOS style.");
    }
}

// Concrete Product - Windows Checkbox
class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}

// Concrete Product - MacOS Checkbox
class MacOSCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a checkbox in MacOS style.");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory - Windows
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory - MacOS
class MacOSFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}   

// Usage
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        GUIFactory factory;
        String osType = System.getProperty("os.name").toLowerCase();

        if (osType.contains("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }

        Application app = new Application(factory);
        app.paint();
    }
} 
```

In this example, the `GUIFactory` interface defines methods for creating abstract products (`Button` and `Checkbox`). The `WindowsFactory` and `MacOSFactory` classes are concrete factories that implement the `GUIFactory` interface to create Windows and MacOS specific UI components, respectively. The `Application` class uses the factory to create and render the UI components without needing to know their concrete classes.

## Benefits
- Promotes consistency among products of the same family.
- Enhances flexibility and scalability by allowing easy addition of new product families.
- Encapsulates object creation, reducing dependencies on concrete classes.

## Drawbacks
- Can lead to a proliferation of classes and interfaces.
- May introduce complexity in the codebase. 

## When to Use
- When the system needs to be independent of how its products are created., composed, and represented.
- When the system needs to work with multiple families of related products.


<div align="center">
<p> Made with ❤️ for the Open Source Community</p>
</div>