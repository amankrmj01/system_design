// Builder Design Pattern Example in Java
// The Builder pattern is used to construct a complex object step by step.

// Product class
class Computer {
    // Required parameters
    private String CPU;
    private String RAM;
    // Optional parameters
    private int storage;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    // Private constructor to enforce object creation via Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Static Builder class
    public static class Builder {
        // Required parameters
        private String CPU;
        private String RAM;
        // Optional parameters - initialized to default values
        private int storage = 0;
        private boolean isGraphicsCardEnabled = false;
        private boolean isBluetoothEnabled = false;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Build method to create Computer object
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
                ", GraphicsCard=" + isGraphicsCardEnabled + ", Bluetooth=" + isBluetoothEnabled + "]";
    }
}

// Client code to use the Builder
public class Builder_Design_Pattern {
    public static void main(String[] args) {
        // Building a Computer object using the Builder
        Computer computer = new Computer.Builder("Intel i7", "16GB")
                .setStorage(512)
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println(computer);
    }
}
