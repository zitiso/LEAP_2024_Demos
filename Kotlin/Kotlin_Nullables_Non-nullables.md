---------------------------------------------------------------
# Nullables vs Non-nullables

**Kotlin's type system is designed to eliminate null pointer exceptions, which are a common source of errors in many programming languages.** 

It does this by distinguishing between nullable and non-nullable types. Understanding how to work with these types and avoid errors when mixing them is crucial for writing robust Kotlin code.

### Nullable and Non-Nullable Types

1. **Non-Nullable Types:**
   - By default, variables in Kotlin cannot hold a null value.
   - Example:
     ```kotlin
     var nonNullableString: String = "Hello"
     nonNullableString = null  // Compile-time error
     ```

2. **Nullable Types:**
   - To allow a variable to hold a null value, you append a `?` to the type.
   - Example:
     ```kotlin
     var nullableString: String? = "Hello"
     nullableString = null  // This is allowed
     ```

### Safe Calls (`?.`)

The safe call operator `?.` is used to call methods or access properties on a nullable object without throwing a NullPointerException.

- Example:
  ```kotlin
  val nullableString: String? = "Hello"
  val length = nullableString?.length  // length is of type Int?
  ```

If `nullableString` is null, the expression `nullableString?.length` returns null. Otherwise, it returns the length of the string.

### Elvis Operator (`?:`)

The Elvis operator `?:` is used to provide a default value when a nullable expression evaluates to null.

- Example:
  ```kotlin
  val nullableString: String? = null
  val length = nullableString?.length ?: 0  // If nullableString is null, length will be 0
  ```

### Not-Null Assertion (`!!`)

The not-null assertion operator `!!` converts a nullable type to a non-nullable type and throws a `NullPointerException` if the value is null.

- Example:
  ```kotlin
  val nullableString: String? = null
  val length = nullableString!!.length  // Throws NullPointerException if nullableString is null
  ```

### Safe Casts (`as?`)

Safe casts attempt to cast an object to a specific type and return null if the cast is not possible.

- Example:
  ```kotlin
  val obj: Any? = "Hello"
  val str: String? = obj as? String  // Safe cast, returns null if obj is not a String
  ```

### Smart Casts

Kotlin can automatically cast a nullable type to a non-nullable type when it knows that the value cannot be null.

- Example:
  ```kotlin
  fun printLength(str: String?) {
      if (str != null) {
          println(str.length)  // Smart cast to non-nullable type
      }
  }
  ```

### Late-Initialized Properties (`lateinit`)

The `lateinit` modifier is used for properties that are not initialized at the time of object creation but will be initialized before they are accessed.

- Example:
  ```kotlin
  class Example {
      lateinit var name: String

      fun initialize() {
          name = "Hello"
      }

      fun printName() {
          println(name)  // Throws UninitializedPropertyAccessException if not initialized
      }
  }
  ```

### Using `let`

The `let` function allows you to perform an operation on a nullable object if it is not null.

- Example:
  ```kotlin
  val nullableString: String? = "Hello"
  nullableString?.let {
      println(it.length)  // Executes this block only if nullableString is not null
  }
  ```

### Summary and Best Practices

1. **Prefer Non-Nullable Types:** Use non-nullable types by default and nullable types only when necessary.
2. **Safe Calls and Elvis Operator:** Use safe calls (`?.`) and the Elvis operator (`?:`) to handle nullable types gracefully.
3. **Avoid Not-Null Assertions:** Avoid using `!!` unless you are absolutely sure that the value cannot be null.
4. **Smart Casts:** Utilize Kotlin's smart casts for safe and efficient type casting.
5. **Late Initialization:** Use `lateinit` for properties that will be initialized later but must not be null when accessed.
6. **Use `let` for Nullable Types:** Use the `let` function to execute code on nullable objects only when they are not null.

### Example

Combining these techniques in a practical example:

```kotlin
fun printNameLength(name: String?) {
    // Safe call and Elvis operator
    val length = name?.length ?: 0
    println("Length: $length")

    // Using let
    name?.let {
        println("The length of the name is ${it.length}")
    }

    // Smart cast
    if (name != null) {
        println("Smart cast length: ${name.length}")
    }
}

fun main() {
    printNameLength("Kotlin")
    printNameLength(null)
}
```

- Safe call and Elvis operator ensure that null values are handled without exceptions.
- `let` function allows actions to be taken only if the nullable object is not null.
- Smart casts provide a way to work with nullable types safely and efficiently.

By following these practices and understanding the tools Kotlin provides, you can avoid errors when mixing nullable and non-nullable types and write more robust, null-safe code.
