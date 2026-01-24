# Liskov Substitution Principle
The Liskov Substitution Principle (LSP) is one of the five SOLID principles of object-oriented design. It states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, if S is a subtype of T, then objects of type T should be able to be replaced with objects of type S without altering any of the desirable properties of the program (e.g., correctness, task performed, etc.). 

## Key Concepts
- **Substitutability**: Subtypes must be substitutable for their base types. This means that the derived class should extend the base class without changing its behavior.
- **Behavioral Compatibility**: The derived class should adhere to the expectations set by the base class. This includes maintaining preconditions, postconditions, and invariants.
- **Design by Contract**: The principle encourages designing classes based on contracts, where the derived class must fulfill the contract established by the base class.

## Benefits
- **Improved Code Reusability**: By adhering to LSP, subclasses can be used interchangeably with their base classes, promoting code reuse.
- **Enhanced Maintainability**: Systems designed with LSP in mind are easier to maintain and extend, as changes to subclasses do not affect the base class behavior.
- **Increased Flexibility**: LSP allows for more flexible and dynamic code, as objects can be substituted without concern for breaking functionality.
- **Better Testability**: Code that follows LSP is easier to test, as subclasses can be tested in place of their base classes without unexpected side effects.  
- **Reduced Bugs**: Adhering to LSP helps prevent subtle bugs that can arise from incorrect assumptions about object behavior in inheritance hierarchies.

