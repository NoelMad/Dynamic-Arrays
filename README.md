Here is a clean, homework-ready **README** you can submit with your assignment.

---

# Homework 2 – Dynamic Arrays (MyVector<T>)

## Overview

This project implements a generic dynamic array class called **MyVector<T>** in Java. The class mimics the behavior of Java’s built-in `ArrayList` by automatically resizing when capacity is exceeded. The resizing strategy uses a **2× growth factor** to maintain efficient performance.

---

## Features Implemented

The `MyVector<T>` class supports the following methods:

### add(T element)

Adds an element to the end of the vector.
If the internal array is full, the capacity automatically doubles before adding the new element.

---

### get(int index)

Returns the element stored at the specified index.
Throws `IndexOutOfBoundsException` if the index is invalid.

---

### set(int index, T element)

Replaces the element at the specified index with a new value.
Throws `IndexOutOfBoundsException` if the index is invalid.

---

### remove(int index)

Removes the element at the specified index.
All elements to the right of the removed element are shifted left.
Returns the removed element.

---

### size()

Returns the number of elements currently stored in the vector.

---

### ensureCapacity(int minCapacity)

Ensures the internal array has enough space to store the required number of elements.
If necessary, the array size doubles until it meets the required capacity.

---

## Resizing Strategy

This implementation uses a **doubling growth strategy**:

* When capacity is reached, the array size is multiplied by 2.
* This reduces the number of resizing operations.
* Improves overall performance of adding elements.

---

## Time Complexity Analysis

| Method           | Amortized Complexity | Worst Case Complexity |
| ---------------- | -------------------- | --------------------- |
| add()            | O(1)                 | O(n)                  |
| get()            | O(1)                 | O(1)                  |
| set()            | O(1)                 | O(1)                  |
| remove()         | O(n)                 | O(n)                  |
| size()           | O(1)                 | O(1)                  |
| ensureCapacity() | O(1)                 | O(n)                  |

---

## Amortized vs Worst Case Explanation

* **Worst Case:** Occurs when resizing is required. The program must copy all elements to a new larger array, which takes O(n) time.
* **Amortized:** Although resizing is expensive, it happens infrequently. Most operations run in constant time, so the average cost remains O(1).

---

## Memory Usage

The vector stores elements in a contiguous array. Extra memory may exist due to unused capacity, but this helps reduce resizing frequency and improves performance.

---

## How to Run the Program

1. Compile the program:

```
javac MyVector.java Main.java
```

2. Run the program:

```
java Main
```

---

## Testing

The `Main` class demonstrates and tests:

* Adding elements
* Accessing elements
* Modifying elements
* Removing elements
* Automatic resizing behavior

---

