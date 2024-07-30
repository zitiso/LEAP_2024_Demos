--------------------------------------------------------------------
# Higher-order functions

### Basic Example

Let's start with a simple example where a higher-order function takes another function as a parameter:

```kotlin
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main() {
    val sum = calculate(3, 4) { a, b -> a + b }
    val product = calculate(3, 4) { a, b -> a * b }

    println("Sum: $sum")        // Output: Sum: 7
    println("Product: $product") // Output: Product: 12
}
```

### Explanation

1. **Higher-Order Function Declaration:**
   ```kotlin
   fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int
   ```
   - `calculate` is a function that takes three parameters:
     - `x` and `y` are integers.
     - `operation` is a function parameter that takes two integers and returns an integer.

2. **Using the Higher-Order Function:**
   ```kotlin
   val sum = calculate(3, 4) { a, b -> a + b }
   val product = calculate(3, 4) { a, b -> a * b }
   ```
   - The lambda expressions `{ a, b -> a + b }` and `{ a, b -> a * b }` are passed as the `operation` parameter to the `calculate` function.

### Returning a Function

Here's an example where a higher-order function returns another function:

```kotlin
fun operationGenerator(operator: String): (Int, Int) -> Int {
    return when (operator) {
        "add" -> { a, b -> a + b }
        "multiply" -> { a, b -> a * b }
        else -> { _, _ -> 0 }
    }
}

fun main() {
    val addOperation = operationGenerator("add")
    val multiplyOperation = operationGenerator("multiply")

    println("Add: ${addOperation(2, 3)}")        // Output: Add: 5
    println("Multiply: ${multiplyOperation(2, 3)}") // Output: Multiply: 6
}
```

### Explanation

1. **Higher-Order Function Returning a Function:**
   ```kotlin
   fun operationGenerator(operator: String): (Int, Int) -> Int
   ```
   - `operationGenerator` takes a string parameter `operator`.
   - It returns a function of type `(Int, Int) -> Int`.

2. **Using the Higher-Order Function:**
   ```kotlin
   val addOperation = operationGenerator("add")
   val multiplyOperation = operationGenerator("multiply")
   ```
   - `operationGenerator("add")` returns a function that adds two integers.
   - `operationGenerator("multiply")` returns a function that multiplies two integers.

### Inline Functions

Using higher-order functions can sometimes lead to performance overhead due to the creation of function objects. To mitigate this, Kotlin provides `inline` functions:

```kotlin
inline fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main() {
    val result = performOperation(10, 5) { a, b -> a - b }
    println("Result: $result") // Output: Result: 5
}
```

### Explanation

1. **Inline Function Declaration:**
   ```kotlin
   inline fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int
   ```
   - The `inline` keyword is used to instruct the compiler to inline the function, replacing the function call with the actual code of the function.

### Using Higher-Order Functions in Standard Library

Kotlin’s standard library provides many higher-order functions for collections. Here’s an example using `map`:

```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 }
    println(doubled) // Output: [2, 4, 6, 8, 10]
}
```

### Explanation

1. **map Function:**
   ```kotlin
   val doubled = numbers.map { it * 2 }
   ```
   - `map` is a higher-order function that takes a lambda function as a parameter.
   - The lambda function `it * 2` is applied to each element of the list `numbers`.

### Summary

- **Higher-Order Functions:** Functions that take other functions as parameters, return functions, or both.
- **Function Parameters:** Allow passing behavior as an argument.
- **Returning Functions:** Enable generating functions dynamically.
- **Inline Functions:** Optimize performance by inlining code.
- **Standard Library Functions:** Provide powerful operations on collections using higher-order functions.

Higher-order functions are a cornerstone of functional programming in Kotlin, allowing you to write concise, expressive, and flexible code.
