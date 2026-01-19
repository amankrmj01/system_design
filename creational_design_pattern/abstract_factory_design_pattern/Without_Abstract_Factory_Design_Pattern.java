// Example code demonstrating object creation WITHOUT Abstract Factory Design Pattern
// This leads to tight coupling and less flexibility when adding new products or families

// Product interfaces
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

// Concrete Products for Windows
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a Windows button.");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Windows checkbox.");
    }
}

// Concrete Products for Mac
class MacButton implements Button {
    public void paint() {
        System.out.println("Rendering a Mac button.");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Mac checkbox.");
    }
}

// Client code WITHOUT Abstract Factory
class Application {
    private Button button;
    private Checkbox checkbox;

    // The client directly instantiates concrete classes
    public Application(String osType) {
        if (osType.equalsIgnoreCase("Windows")) {
            button = new WindowsButton();
            checkbox = new WindowsCheckbox();
        } else if (osType.equalsIgnoreCase("Mac")) {
            button = new MacButton();
            checkbox = new MacCheckbox();
        } else {
            throw new IllegalArgumentException("Unknown OS type");
        }
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

// Demo
public class Without_Abstract_Factory_Design_Pattern {
    public static void main(String[] args) {
        // Client must know about all concrete classes
        Application appWin = new Application("Windows");
        appWin.paint();

        Application appMac = new Application("Mac");
        appMac.paint();
    }
}
