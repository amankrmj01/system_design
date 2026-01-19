// Example of Builder Design Pattern in Java

// Product class
class Computer {
	// Required parameters
	private String CPU;
	private int RAM;

	// Optional parameters
	private int storage;
	private boolean isGraphicsCardEnabled;

	// Private constructor to enforce object creation via Builder
	private Computer(Builder builder) {
		this.CPU = builder.CPU;
		this.RAM = builder.RAM;
		this.storage = builder.storage;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
	}

	// Getters
	public String getCPU() { return CPU; }
	public int getRAM() { return RAM; }
	public int getStorage() { return storage; }
	public boolean hasGraphicsCard() { return isGraphicsCardEnabled; }

	// Builder static nested class
	public static class Builder {
		// Required parameters
		private String CPU;
		private int RAM;

		// Optional parameters - initialized to default values
		private int storage = 0;
		private boolean isGraphicsCardEnabled = false;

		// Builder constructor for required parameters
		public Builder(String CPU, int RAM) {
			this.CPU = CPU;
			this.RAM = RAM;
		}

		// Setter for optional parameter
		public Builder setStorage(int storage) {
			this.storage = storage;
			return this;
		}

		public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		// Build method to create Computer object
		public Computer build() {
			return new Computer(this);
		}
	}

	@Override
	public String toString() {
		return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB, GraphicsCard=" + isGraphicsCardEnabled + "]";
	}
}

// Client code to use the Builder
public class Without_Builder_Design_Pattern {
	public static void main(String[] args) {
		// Creating a Computer object using Builder
		Computer computer = new Computer.Builder("Intel i7", 16)
				.setStorage(512)
				.setGraphicsCardEnabled(true)
				.build();

		System.out.println(computer);

		// Creating another Computer object with only required parameters
		Computer basicComputer = new Computer.Builder("AMD Ryzen 5", 8)
				.build();

		System.out.println(basicComputer);
	}
}
