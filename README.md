# JavaIterables Library

Welcome to **JavaIterables**, the library that brings Python-like `list` and `dict` functionality to Java! Say goodbye to boilerplate code and hello to clean, efficient data manipulation. Whether you're managing collections or building complex data structures, `List` and `Dict` have got your back.

---

## What Does It Do?

- **`List`**: Think of it as a Java-powered `list` from Python. Append, remove, sort, reverse, and more—all with ease.
- **`Dict`**: A key-value store that feels like Python's `dict`. Add, update, search, and sort your data like a pro.

---

## Why Use It?

Because Java deserves to be fun too! With JavaIterables, you can:

- Write less code.
- Handle collections like a Pythonista.
- Impress your colleagues with clean, readable Java.

---

## Quick Examples

### **Using `List`**

```java
import javaiterables.List;

public class Main {
    public static void main(String[] args) {
        List myList = new List();
        myList.append("Java");
        myList.append("is");
        myList.append("awesome!");

        System.out.println("Original List:");
        myList.show();

        myList.reverse();
        System.out.println("Reversed List:");
        myList.show();
    }
}
```

### **Using `Dict`**

```java
import javaiterables.Dict;

public class Main {
    public static void main(String[] args) {
        Dict myDict = new Dict();
        myDict.add("language", "Java");
        myDict.add("type", "Object-Oriented");
        myDict.add("fun", true);

        System.out.println("Dictionary Contents:");
        System.out.println("Language: " + myDict.get("language"));
        System.out.println("Type: " + myDict.get("type"));
        System.out.println("Is it fun? " + String.valueOf(myDict.get("fun")));
    }
}
```

---

## Ready-to-Use `.jar`

No need to compile anything! Just grab the precompiled `javaiterables.jar` from the release section and add it to your project:

1. **As a module**: Add `requires javaiterables;` to your `module-info.java`.
2. **Without modules**: Add the `.jar` to your classpath and import the classes directly.

---

## Licence

This library is open-source and available under the MIT License. Feel free to use, modify, and distribute it as needed.

## Want More Details?

Check out the [full documentation](./docs/README.md) for a deep dive into all the features, methods, and examples.

## Special Thanks

- My programming professor
- Family and friends
- Everybody that helped me anyway

And of course, you, who is going to try this amazing library!
