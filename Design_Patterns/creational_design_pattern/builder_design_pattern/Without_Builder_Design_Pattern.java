// Example WITHOUT Builder Design Pattern
// This shows how object creation becomes messy and error-prone without the builder pattern.

// Product - House
class House {
	private String foundation;
	private String structure;
	private String roof;

	// All properties must be set manually, no step-by-step construction
	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	@Override
	public String toString() {
		return "House [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + "]";
	}
}

// Client code WITHOUT builder pattern
public class Without_Builder_Design_Pattern {
	public static void main(String[] args) {
		// Building a Wooden House manually
		House woodenHouse = new House();
		// The client must remember the construction steps and order
		woodenHouse.setFoundation("Wooden Foundation");
		woodenHouse.setStructure("Wooden Structure");
		woodenHouse.setRoof("Wooden Roof");
		System.out.println(woodenHouse);

		// Building a Stone House manually
		House stoneHouse = new House();
		// Again, the client is responsible for all steps
		stoneHouse.setFoundation("Stone Foundation");
		stoneHouse.setStructure("Stone Structure");
		stoneHouse.setRoof("Stone Roof");
		System.out.println(stoneHouse);

		// What if a step is missed?
		House incompleteHouse = new House();
		incompleteHouse.setFoundation("Mud Foundation");
		// Oops! Structure and roof are not set
		System.out.println(incompleteHouse);

		// Drawbacks:
		// - No control over construction process (steps/order can be missed)
		// - Code duplication for each house type
		// - Hard to maintain and error-prone
		// - No abstraction for complex construction logic
	}
}
