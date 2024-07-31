------------------------------------------------------------------------
## Interfaces and abstract classes

In Kotlin, both interfaces and abstract classes are used to define types that cannot be instantiated on their own and must be subclassed or implemented by other classes. However, they have different use cases and capabilities. Here are the key differences between an interface and an abstract class in Kotlin:

### Interfaces

1. **Declaration:**
   ```kotlin
   interface MyInterface {
       fun doSomething()
       fun doSomethingElse() {
           // default implementation
       }
   }
   ```

2. **Multiple Inheritance:**
   - A class can implement multiple interfaces.
   ```kotlin
   class MyClass : MyInterface, AnotherInterface {
       override fun doSomething() {
           // implementation
       }
   }
   ```

3. **Members:**
   - Interfaces can have abstract methods (without implementation) and concrete methods (with default implementation).
   - Interfaces cannot hold state; they cannot have fields or properties with initializers.
   - Interfaces can have properties but these are abstract or have default implementations that delegate to getters.
   ```kotlin
   interface MyInterface {
       val property: String // abstract property
       val propertyWithDefault: String
           get() = "Default value"
   }
   ```

4. **Constructors:**
   - Interfaces do not have constructors.

### Abstract Classes

1. **Declaration:**
   ```kotlin
   abstract class MyAbstractClass {
       abstract fun doSomething()
       open fun doSomethingElse() {
           // default implementation
       }
       val concreteProperty: String = "Concrete value"
   }
   ```

2. **Single Inheritance:**
   - A class can inherit from only one abstract class (or any other class).
   ```kotlin
   class MyClass : MyAbstractClass() {
       override fun doSomething() {
           // implementation
       }
   }
   ```

3. **Members:**
   - Abstract classes can have both abstract and concrete methods.
   - Abstract classes can hold state; they can have fields, properties with initializers, and backing fields.
   - Abstract classes can define properties with initial values.
   ```kotlin
   abstract class MyAbstractClass {
       abstract val abstractProperty: String
       val concreteProperty: String = "Concrete value"
   }
   ```

4. **Constructors:**
   - Abstract classes can have constructors, including primary and secondary constructors.
   ```kotlin
   abstract class MyAbstractClass(val param: String) {
       abstract fun doSomething()
   }
   ```

### Use Cases

- **Use an interface** when you need to define a contract that can be implemented by any class from any inheritance tree. Interfaces are ideal for defining capabilities or behaviors that can be shared across multiple, unrelated classes.

- **Use an abstract class** when you want to provide a common base class that shares code among several closely related classes. Abstract classes are useful when you have a set of classes that share a common state or common implementations of some methods, and you want to enforce this commonality.

### Summary

- **Interfaces** allow for multiple inheritance, do not have state, and are used to define behavior contracts.
- **Abstract classes** allow for single inheritance, can hold state, and are used to define common behavior and state that can be shared among subclasses.

Here's a simple example illustrating both concepts:

```kotlin
// Interface
interface Drivable {
    fun drive()
    fun stop() {
        println("Vehicle stopped.")
    }
}

// Abstract Class
abstract class Vehicle(val name: String) {
    abstract fun drive()
    open fun stop() {
        println("$name stopped.")
    }
}

// Implementing the interface
class Car : Drivable {
    override fun drive() {
        println("Car is driving.")
    }
}

// Extending the abstract class
class Bike(name: String) : Vehicle(name) {
    override fun drive() {
        println("$name is biking.")
    }
}

// Usage
fun main() {
    val car = Car()
    car.drive()  // Output: Car is driving.
    car.stop()   // Output: Vehicle stopped.

    val bike = Bike("Mountain Bike")
    bike.drive() // Output: Mountain Bike is biking.
    bike.stop()  // Output: Mountain Bike stopped.
}
```

In this example, `Drivable` is an interface with one abstract method and one concrete method. `Vehicle` is an abstract class with one abstract method and one concrete method. `Car` implements the `Drivable` interface, and `Bike` extends the `Vehicle` abstract class.
