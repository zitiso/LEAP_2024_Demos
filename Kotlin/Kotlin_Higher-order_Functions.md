---------------------------------------------------------------------------------
# Kotlin built-in higher-order functions

### Collection Higher-Order Functions

1. **`map`**
   - Transforms each element in the collection with a given function.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val doubled = numbers.map { it * 2 }
   // doubled: [2, 4, 6]
   ```

2. **`filter`**
   - Filters elements in the collection that match a given predicate.
   ```kotlin
   val numbers = listOf(1, 2, 3, 4)
   val even = numbers.filter { it % 2 == 0 }
   // even: [2, 4]
   ```

3. **`forEach`**
   - Performs a given action on each element of the collection.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   numbers.forEach { println(it) }
   // Output: 1 2 3
   ```

4. **`reduce`**
   - Accumulates value starting with the first element and applying the operation from left to right.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val sum = numbers.reduce { acc, num -> acc + num }
   // sum: 6
   ```

5. **`fold`**
   - Accumulates value starting with an initial value and applying the operation from left to right.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val sum = numbers.fold(0) { acc, num -> acc + num }
   // sum: 6
   ```

6. **`find`**
   - Returns the first element matching the given predicate or `null` if no such element is found.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val firstEven = numbers.find { it % 2 == 0 }
   // firstEven: 2
   ```

7. **`any`**
   - Returns `true` if at least one element matches the given predicate.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val hasEven = numbers.any { it % 2 == 0 }
   // hasEven: true
   ```

8. **`all`**
   - Returns `true` if all elements match the given predicate.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val allEven = numbers.all { it % 2 == 0 }
   // allEven: false
   ```

9. **`none`**
   - Returns `true` if no elements match the given predicate.
   ```kotlin
   val numbers = listOf(1, 2, 3)
   val noneEven = numbers.none { it % 2 == 0 }
   // noneEven: false
   ```

10. **`groupBy`**
    - Groups elements of the collection by a given key selector function.
    ```kotlin
    val words = listOf("one", "two", "three", "four")
    val groupedByLength = words.groupBy { it.length }
    // groupedByLength: {3=[one, two], 5=[three], 4=[four]}
    ```

11. **`partition`**
    - Splits the collection into a pair of lists based on a predicate.
    ```kotlin
    val numbers = listOf(1, 2, 3, 4)
    val (even, odd) = numbers.partition { it % 2 == 0 }
    // even: [2, 4], odd: [1, 3]
    ```

### Sequence Higher-Order Functions

Sequences provide a way to work with collections lazily.

12. **`asSequence`**
    - Converts a collection into a sequence.
    ```kotlin
    val numbers = listOf(1, 2, 3).asSequence()
    ```

13. **`toList`**
    - Converts a sequence back to a list.
    ```kotlin
    val numbers = sequenceOf(1, 2, 3).toList()
    ```

14. **`generateSequence`**
    - Generates a sequence based on a seed value and a function to produce the next value.
    ```kotlin
    val naturalNumbers = generateSequence(0) { it + 1 }
    val first10 = naturalNumbers.take(10).toList()
    // first10: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    ```

### Function Higher-Order Functions

15. **`apply`**
    - Calls the specified function `block` with `this` value as its receiver and returns `this` value.
    ```kotlin
    val person = Person().apply {
        name = "John"
        age = 30
    }
    ```

16. **`run`**
    - Calls the specified function `block` with `this` value as its receiver and returns the result of the block.
    ```kotlin
    val result = "Hello".run {
        length
    }
    // result: 5
    ```

17. **`with`**
    - Calls the specified function `block` with the given receiver and returns the result of the block.
    ```kotlin
    val result = with("Hello") {
        length
    }
    // result: 5
    ```

18. **`let`**
    - Calls the specified function `block` with `this` value as its argument and returns the result of the block.
    ```kotlin
    val result = "Hello".let {
        it.length
    }
    // result: 5
    ```

19. **`also`**
    - Calls the specified function `block` with `this` value as its argument and returns `this` value.
    ```kotlin
    val person = Person().also {
        it.name = "John"
        it.age = 30
    }
    ```

20. **`takeIf`**
    - Returns `this` value if it satisfies the given predicate, otherwise returns `null`.
    ```kotlin
    val number = 5.takeIf { it > 0 }
    // number: 5
    ```

21. **`takeUnless`**
    - Returns `this` value if it does not satisfy the given predicate, otherwise returns `null`.
    ```kotlin
    val number = 5.takeUnless { it < 0 }
    // number: 5
    ```

These higher-order functions are widely used in Kotlin to write concise, expressive, and functional code. They leverage the power of lambda expressions to perform operations on collections and other objects in a more declarative way.
