/*
 * Example of Abstract Factory Design Pattern in Java
 * This example demonstrates how to use the Abstract Factory pattern
 * to create families of related objects without specifying their concrete classes.
 */

// Abstract Product A
interface Button {
    void paint();
}

// Concrete Product A1
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a button in Windows style.");
    }
}

// Concrete Product A2
class MacOSButton implements Button {
    public void paint() {
        System.out.println("Rendering a button in MacOS style.");
    }
}

// Abstract Product B
interface Checkbox {
    void paint();
}

// Concrete Product B1
class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}

// Concrete Product B2
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

// Concrete Factory 1
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2
class MacOSFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client code demonstrating usage
public class Abstract_Factory_Design_Pattern {
    private static GUIFactory factory;

    public static void main(String[] args) {
        // Choose factory based on some configuration or environment
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }

        // Use the factory to create products
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Paint the products
        button.paint();
        checkbox.paint();
    }
}
