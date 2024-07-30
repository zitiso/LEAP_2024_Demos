--------------------------------------------------
Generics

### Basic Example

Here’s a simple example using a generic class:

```kotlin
class Box<T>(var content: T) {
    fun getContent(): T {
        return content
    }
}

fun main() {
    val intBox = Box(123)
    val stringBox = Box("Hello")

    println(intBox.getContent())  // Output: 123
    println(stringBox.getContent())  // Output: Hello
}
```

### Explanation

1. **Generic Class:**
   ```kotlin
   class Box<T>(var content: T)
   ```
   - `class Box<T>` declares a generic class `Box` with a type parameter `T`.
   - `var content: T` defines a property `content` of type `T`.

2. **Generic Method:**
   ```kotlin
   fun getContent(): T
   ```
   - The method `getContent` returns a value of type `T`.

3. **Using the Generic Class:**
   ```kotlin
   val intBox = Box(123)
   val stringBox = Box("Hello")
   ```
   - `Box(123)` creates an instance of `Box` with `T` inferred as `Int`.
   - `Box("Hello")` creates an instance of `Box` with `T` inferred as `String`.

### Generic Functions

You can also define generic functions:

```kotlin
fun <T> printContent(content: T) {
    println(content)
}

fun main() {
    printContent(123)  // Output: 123
    printContent("Hello")  // Output: Hello
}
```

### Explanation

1. **Generic Function:**
   ```kotlin
   fun <T> printContent(content: T)
   ```
   - `fun <T>` declares a generic function with a type parameter `T`.
   - The function `printContent` takes a parameter `content` of type `T` and prints it.

### Constraints

You can constrain a generic type to be a subtype of a specific class or implement a specific interface:

```kotlin
fun <T : Number> addNumbers(a: T, b: T): Double {
    return a.toDouble() + b.toDouble()
}

fun main() {
    println(addNumbers(1, 2))  // Output: 3.0
    println(addNumbers(1.5, 2.5))  // Output: 4.0
    // println(addNumbers("1", "2"))  // Error: Type mismatch
}
```

### Explanation

1. **Constrained Generic Function:**
   ```kotlin
   fun <T : Number> addNumbers(a: T, b: T): Double
   ```
   - `fun <T : Number>` declares a generic function with a type parameter `T` constrained to be a subtype of `Number`.
   - The function `addNumbers` takes two parameters `a` and `b` of type `T` and returns their sum as a `Double`.

### Variance

Kotlin has two kinds of variance annotations: `in` and `out`. They help define how generic types can be used in different contexts.

1. **Covariance (`out`):**
   - Covariant types can only be returned from functions or used as property types.
   ```kotlin
   class Producer<out T>(private val value: T) {
       fun produce(): T {
           return value
       }
   }

   fun main() {
       val stringProducer: Producer<String> = Producer("Hello")
       val anyProducer: Producer<Any> = stringProducer  // This is allowed
       println(anyProducer.produce())  // Output: Hello
   }
   ```

2. **Contravariance (`in`):**
   - Contravariant types can only be consumed, i.e., passed as parameters to functions.
   ```kotlin
   class Consumer<in T> {
       fun consume(value: T) {
           println(value)
       }
   }

   fun main() {
       val stringConsumer: Consumer<String> = Consumer()
       val anyConsumer: Consumer<Any> = stringConsumer  // This is allowed
       anyConsumer.consume("Hello")  // Output: Hello
   }
   ```

### Summary

- **Generic Classes:** Define classes that can operate on any type.
- **Generic Functions:** Define functions that can operate on any type.
- **Constraints:** Restrict the types that can be used with generics.
- **Variance:** Control how generic types can be used with `in` (contravariance) and `out` (covariance) annotations.

Generics provide flexibility and type safety, allowing you to write more reusable and robust code.
