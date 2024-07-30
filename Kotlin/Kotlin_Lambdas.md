-----------------------------------------------------------
# Lambdas


### What are Lambdas?

A lambda expression is an anonymous function that you can treat as a value: you can pass it as a parameter, return it from a function, or do anything else you can do with a regular object.

### Syntax

The basic syntax of a lambda expression is:
```kotlin
{ parameterList -> body }
```
- The parameters are optional. If there are no parameters, you can omit the parameter list and the arrow (`->`).
- The body is the function body.

### How They Work

Let's see some examples to understand how lambdas work.

#### Example 1: Simple Lambda

```kotlin
val greet = { println("Hello, World!") }

fun main() {
    greet()  // Output: Hello, World!
}
```
- `val greet = { println("Hello, World!") }` defines a lambda that prints "Hello, World!".
- `greet()` calls the lambda function.

#### Example 2: Lambda with Parameters

```kotlin
val add: (Int, Int) -> Int = { a, b -> a + b }

fun main() {
    println(add(2, 3))  // Output: 5
}
```
- `val add: (Int, Int) -> Int = { a, b -> a + b }` defines a lambda that takes two integers and returns their sum.
- `add(2, 3)` calls the lambda function with arguments 2 and 3.

### Using Lambdas with Higher-Order Functions

Lambdas are often used with higher-order functions. Let's see some common scenarios.

#### Example 3: Using `map` with a Lambda

```kotlin
val numbers = listOf(1, 2, 3)
val doubled = numbers.map { it * 2 }

fun main() {
    println(doubled)  // Output: [2, 4, 6]
}
```
- `numbers.map { it * 2 }` applies the lambda `{ it * 2 }` to each element in the list `numbers`.
- `it` is a shorthand for the single parameter of the lambda.

#### Example 4: Using `filter` with a Lambda

```kotlin
val numbers = listOf(1, 2, 3, 4)
val evenNumbers = numbers.filter { it % 2 == 0 }

fun main() {
    println(evenNumbers)  // Output: [2, 4]
}
```
- `numbers.filter { it % 2 == 0 }` applies the lambda `{ it % 2 == 0 }` to filter only even numbers from the list.

### Inline Functions and Lambda

Inline functions can improve performance when working with lambdas, as they avoid the overhead of creating function objects.

#### Example 5: Inline Function with Lambda

```kotlin
inline fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main() {
    val result = performOperation(10, 5) { a, b -> a - b }
    println("Result: $result")  // Output: Result: 5
}
```
- `inline fun performOperation` defines an inline function that takes a lambda `operation`.
- The lambda `{ a, b -> a - b }` is passed to `performOperation` and executed.

### When and Where to Use Lambdas

1. **Functional Programming:**
   - Use lambdas to create concise and functional code.
   - Examples: transformations (`map`, `filter`, `reduce`), functional interfaces.

2. **Callbacks:**
   - Lambdas are useful for defining callbacks without creating separate classes or functions.
   - Example: event listeners in Android.

3. **Higher-Order Functions:**
   - Use lambdas to pass behavior as arguments to higher-order functions.
   - Example: custom sorting, operations on collections.

4. **Simplifying Code:**
   - Use lambdas to simplify code that would otherwise require verbose anonymous classes or separate function declarations.

#### Example 6: Callback with Lambda

```kotlin
fun fetchData(callback: (String) -> Unit) {
    // Simulate fetching data
    callback("Data fetched successfully")
}

fun main() {
    fetchData { result ->
        println(result)  // Output: Data fetched successfully
    }
}
```
- `fetchData` takes a lambda `callback` that gets called with a string.
- The lambda `{ result -> println(result) }` is passed to `fetchData`.

### Summary

- **Lambdas** are anonymous functions that can be treated as values.
- **Syntax**: `{ parameterList -> body }`.
- **Higher-Order Functions**: Functions that take or return lambdas.
- **Inline Functions**: Improve performance by inlining lambdas.
- **Usage**: Functional programming, callbacks, higher-order functions, simplifying code.

Lambdas are a powerful feature in Kotlin, enabling concise and expressive code, especially when used with higher-order functions and in functional programming paradigms.
