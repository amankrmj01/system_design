// Builder Design Pattern Example: House Construction

// Product - House
class House {
    private String foundation;
    private String structure;
    private String roof;

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

// Builder Interface defines the steps to build a house
interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    House getHouse();
}

// Concrete Builder for Wooden House
class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    public void buildFoundation() {
        house.setFoundation("Wooden Foundation");
    }

    public void buildStructure() {
        house.setStructure("Wooden Structure");
    }

    public void buildRoof() {
        house.setRoof("Wooden Roof");
    }

    public House getHouse() {
        return this.house;
    }
}

// Concrete Builder for Stone House
class StoneHouseBuilder implements HouseBuilder {
    private House house;

    public StoneHouseBuilder() {
        this.house = new House();
    }

    public void buildFoundation() {
        house.setFoundation("Stone Foundation");
    }

    public void buildStructure() {
        house.setStructure("Stone Structure");
    }

    public void buildRoof() {
        house.setRoof("Stone Roof");
    }

    public House getHouse() {
        return this.house;
    }
}

// Director class controls the building process
class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // Construct the house step by step
    public void constructHouse() {
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
    }
}

// Client code demonstrating the Builder pattern
public class Builder_Design_Pattern {
    public static void main(String[] args) {
        // Build a Wooden House
        HouseBuilder woodenHouseBuilder = new WoodenHouseBuilder();
        HouseDirector director1 = new HouseDirector(woodenHouseBuilder);
        director1.constructHouse();
        House woodenHouse = woodenHouseBuilder.getHouse();
        System.out.println(woodenHouse);

        // Build a Stone House
        HouseBuilder stoneHouseBuilder = new StoneHouseBuilder();
        HouseDirector director2 = new HouseDirector(stoneHouseBuilder);
        director2.constructHouse();
        House stoneHouse = stoneHouseBuilder.getHouse();
        System.out.println(stoneHouse);
    }
}
