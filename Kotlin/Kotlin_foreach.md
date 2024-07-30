-------------------------------------------------------------------
# The Kotlin `forEach` 

In Kotlin, the 'foreach' is a standard library function that provides a simple and idiomatic way to iterate over collections, such as lists, sets, and maps. It applies a given lambda function to each element of the collection.

### How `forEach` Works

The `forEach` function is an extension function on the `Iterable` interface, which means it can be used with any collection that implements this interface. The lambda function passed to `forEach` takes a single parameter, which represents each element of the collection.

### Basic Usage

Here is how you can use `forEach` with simple examples.

#### Example 1: Iterating Over a List

```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.forEach { number ->
        println(number)
    }
}
```
Output:
```
1
2
3
4
5
```

In this example:
- `numbers` is a list of integers.
- `forEach` takes a lambda function `{ number -> println(number) }` that prints each number.

#### Example 2: Iterating Over a Set

```kotlin
fun main() {
    val fruits = setOf("Apple", "Banana", "Cherry")
    fruits.forEach { fruit ->
        println(fruit)
    }
}
```
Output:
```
Apple
Banana
Cherry
```

In this example:
- `fruits` is a set of strings.
- `forEach` iterates over each element and prints it.

#### Example 3: Iterating Over a Map

When iterating over a map, the lambda function receives `Map.Entry` objects.

```kotlin
fun main() {
    val map = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    map.forEach { (key, value) ->
        println("Key: $key, Value: $value")
    }
}
```
Output:
```
Key: 1, Value: One
Key: 2, Value: Two
Key: 3, Value: Three
```

In this example:
- `map` is a map of integers to strings.
- `forEach` iterates over each entry and prints the key and value.

### How It Works

- `forEach` is an extension function on `Iterable<T>`, meaning it's available to all collections that implement this interface.
- The lambda function passed to `forEach` operates on each element in the collection.

### Typical Use Cases

1. **Printing Elements:**
   - Use `forEach` for simple tasks like printing elements or logging information.

2. **Performing Operations:**
   - Apply operations to each element of a collection, such as transforming data or performing side effects.

3. **Handling Nullability:**
   - Use `forEach` with nullable collections to safely perform actions on each element.

#### Example: Transforming Data

```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.forEach { number ->
        val square = number * number
        println("Square of $number is $square")
    }
}
```
Output:
```
Square of 1 is 1
Square of 2 is 4
Square of 3 is 9
Square of 4 is 16
Square of 5 is 25
```

#### Example: Handling Nullable Collections

```kotlin
fun main() {
    val nullableList: List<String?> = listOf("A", null, "B", "C", null)
    nullableList.forEach { element ->
        element?.let {
            println(it)
        }
    }
}
```
Output:
```
A
B
C
```

In this example:
- `nullableList` contains nullable strings.
- The `let` function is used inside `forEach` to perform an action only if the element is not null.

### Summary

- **`forEach`** is a higher-order function that applies a lambda function to each element of a collection.
- **Usage:** Iterate over lists, sets, and maps to perform operations on each element.
- **How It Works:** It is an extension function on the `Iterable` interface, making it available to all collections that implement this interface.
- **Typical Use Cases:** Printing elements, performing operations, handling nullability.

By understanding how `forEach` works and using it appropriately, you can write more concise and readable Kotlin code when dealing with collections.
