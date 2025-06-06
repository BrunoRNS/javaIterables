# JavaIterables Library Documentation

The **JavaIterables** library provides two main classes, `List` and `Dict`, which offer flexible and powerful data structures for managing collections of data. These classes are designed to be like Python's `list` and `dict` while being implemented in Java.

---

## Table of Contents

1. Building from source
2. Usage
3. Classes
   - List
   - Dict
4. Examples
   - Using `List`
   - Using `Dict`
5. Testing
6. License

---

## Building from source

1. Compile the library and package it into a `.jar` file:

   ```bash
   cd javaiterables-main/
   ./build
   ```

   It will generate a `javaiterables.jar` on `out` directory.

2. Add the `javaiterables.jar` file to your project's classpath.

---

## Usage

You can use the library in two ways:

1. **As a module**:
   Add the following to your `module-info.java`:

   ```java
   module yourmodule {
       requires javaiterables;
   }
   ```

2. **Without modules**:
   Add the `.jar` file to your classpath and import the classes directly:

   ```java
   import javaiterables.List;
   import javaiterables.Dict;
   ```

---

## Classes

### **List**

The `List` class is a flexible data structure for managing ordered collections of elements. It supports various data types and provides methods for manipulation, iteration, and analysis.

#### **List Methods**

| Method                          | Description                                                                 |
|---------------------------------|-----------------------------------------------------------------------------|
| `void append(Object val)`       | Adds an element to the end of the list.                                     |
| `void remove(int index)`        | Removes the element at the specified index.                                 |
| `Object get(int index)`         | Retrieves the element at the specified index.                               |
| `void set(int index, Object val)` | Replaces the element at the specified index with a new value.               |
| `int len()`                     | Returns the number of elements in the list.                                 |
| `void reverse()`                | Reverses the order of elements in the list.                                 |
| `boolean isEqualTo(List list)`  | Checks if the current list is equal to another list.                        |
| `void clear()`                  | Removes all elements from the list.                                         |
| `List copyList()`               | Creates a copy of the current list.                                         |
| `boolean contains(Object val)`  | Checks if the list contains a specific value.                               |
| `void extend(List list)`        | Appends all elements from another list to the current list.                 |
| `void insert(int index, Object val)` | Inserts an element at the specified index.                              |
| `void show()`                   | Prints the list in a readable format.                                       |
| `double sum()`                  | Returns the sum of all numeric elements in the list.                        |
| `double avg()`                  | Returns the average of all numeric elements in the list.                    |
| `double min()`                  | Returns the smallest numeric element in the list.                           |
| `double max()`                  | Returns the largest numeric element in the list.                            |
| `String uniteListString(String sep)` | Joins all elements into a single string, separated by the given delimiter. |
| `java.util.List<Object> listIterate()` | Returns a Java `List` containing all elements.                        |
| `Object[] arrayIterate()`       | Returns an array containing all elements.                                   |
| `List sort(boolean ascending)`  | Returns a sorted version of the list (ascending or descending).             |

---

### **Dict**

The `Dict` class is a key-value data structure similar to Python's `dict`. It allows for efficient storage and retrieval of data based on unique keys.

#### **Dict Methods**

| Method                          | Description                                                                 |
|---------------------------------|-----------------------------------------------------------------------------|
| `void add(String key, Object value)` | Adds a key-value pair to the dictionary.                                |
| `void set(String key, Object value)` | Updates the value associated with a key.                                |
| `Object get(String key)`        | Retrieves the value associated with a key.                                 |
| `void remove(String key)`       | Removes a key-value pair from the dictionary.                              |
| `void anullValue(String key)`   | Sets the value of a key to `null`.                                         |
| `void sortByKeys(boolean ascending)` | Sorts the dictionary by its keys (ascending or descending).             |
| `void sortByValues(boolean ascending)` | Sorts the dictionary by its values (ascending or descending).         |
| `List keys()`                   | Returns a `List` of all keys in the dictionary.                            |
| `List values()`                 | Returns a `List` of all values in the dictionary.                          |
| `void restart()`                | Resets the internal iterator for the dictionary.                           |
| `void clear()`                  | Removes all key-value pairs from the dictionary.                           |
| `List next(int step)`           | Retrieves the next key-value pair based on the internal iterator.          |
| `int size()`                    | Returns the number of key-value pairs in the dictionary.                   |
| `boolean containsKey(String key)` | Checks if the dictionary contains a specific key.                        |
| `boolean containsValue(Object value)` | Checks if the dictionary contains a specific value.                   |
| `boolean contains(Object any)`  | Checks if the dictionary contains a specific key or value.                 |
| `boolean isEqualTo(Dict other)` | Checks if the current dictionary is equal to another dictionary.           |

---

## Examples

### **Using `List`**

```java
import javaiterables.List;

public class Main {
    public static void main(String[] args) {
        List myList = new List();
        myList.append("Hello");
        myList.append(42);
        myList.append(3.14);

        System.out.println("List contents:");
        for (int i = 0; i < myList.len(); i++) {
            System.out.println(myList.get(i));
        }

        myList.sort(true); // Ascending is the variable which is given as true
        System.out.println("Sorted list:");
        myList.show();
    }
}
```

---

### **Using `Dict`**

```java
import javaiterables.Dict;

public class Main {
    public static void main(String[] args) {
        Dict myDict = new Dict();
        myDict.add("name", "Alice");
        myDict.add("age", 30);
        myDict.add("height", 5.5);

        System.out.println("Dictionary contents:");
        System.out.println("Name: " + myDict.get("name"));
        System.out.println("Age: " + myDict.get("age"));
        System.out.println("Height: " + myDict.get("height"));

        myDict.remove("age");
        System.out.println("After removing 'age':");
        System.out.println("Contains 'age': " + myDict.containsKey("age"));
    }
}
```

---

## Testing

The library includes a `Test` class in the tests package to validate the functionality of `List` and `Dict`. To run the tests:

1. Compile the tests:

   ```bash
   javac -cp ./out/javaiterables.jar -d out ./tests/Test.java
   ```

2. Run the tests:

   ```bash
   java -cp ./out/javaiterables.jar:out ./tests.Test
   ```

3. Log file:

   Look into the file test.log in the folder tests to see the last results of the tests.

---

## License

This library is open-source and available under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and distribute it as needed.
