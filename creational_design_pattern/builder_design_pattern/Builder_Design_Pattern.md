# Builder Design Pattern
The Builder Design Pattern is a creational design pattern that separates the construction of a complex object from its representation, allowing the same construction process to create different representations. This pattern is particularly useful when an object needs to be created in multiple steps or when the construction process involves several optional parameters.

## Table of Contents
- [Intent](#intent)
- [Structure](#structure)
- [Example](#example)
- [Benefits](#benefits)
- [Drawbacks](#drawbacks)
- [When to Use](#when-to-use)

## Intent
The intent of the Builder Pattern is to provide a flexible solution for constructing complex objects step by step. It allows for the creation of different representations of an object using the same construction process.

## Structure
The Builder Pattern typically involves the following components:
- **Builder**: An interface that defines the methods for creating the different parts of a complex object.
- **Concrete Builder**: A class that implements the Builder interface and constructs the complex object.
- **Director**: A class that constructs the complex object using the Builder interface.
- **Product**: The complex object that is being constructed.

## Example
Consider a scenario where we want to build different types of houses (e.g., wooden house and stone house) using the same construction process.

```java// Product - House
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

// Builder Interface
interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    House getHouse();
}   

// Concrete Builder - Wooden House
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

// Concrete Builder - Stone House
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

// Director
class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse() {
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
    }
}

// Client
public class BuilderPatternExample {
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
```

In this example, we have a `House` class that represents the complex object being built. The `HouseBuilder` interface defines the methods for building different parts of the house. The `WoodenHouseBuilder` and `StoneHouseBuilder` classes are concrete builders that implement the `HouseBuilder` interface to construct wooden and stone houses, respectively. The `HouseDirector` class orchestrates the construction process using a `HouseBuilder`. Finally, the client code demonstrates how to use the builder pattern to create different types of houses.

## Benefits
- **Separation of Concerns**: The construction logic is separated from the representation, making the code easier to maintain and understand.
- **Flexibility**: The same construction process can create different representations of an object.         
- **Step-by-Step Construction**: Complex objects can be constructed step by step, allowing for more control over the construction process.
- **Immutability**: The final product can be made immutable since it is constructed in a controlled manner.

## Drawbacks
- **Increased Complexity**: The pattern introduces additional classes and interfaces, which can increase the complexity of the codebase.
- **Overhead**: For simple objects, using the builder pattern may introduce unnecessary overhead.       

## When to Use
- When the construction process of an object is complex and involves multiple steps.    
- When you want to create different representations of an object using the same construction process.

<div align="center">
<p> Made with ❤️ for the Open Source Community</p>
</div>