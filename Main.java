class MyVector<T> {

    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    @SuppressWarnings("unchecked")
    public MyVector() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // add(T element)
    public void add(T element) {
        ensureCapacity(size + 1);
        data[size] = element;
        size++;
    }

    // get(int index)
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // set(int index, T element)
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    // remove(int index)
    public T remove(int index) {
        checkIndex(index);
        T removed = data[index];

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null; // Avoid memory leak
        size--;

        return removed;
    }

    // size()
    public int size() {
        return size;
    }

    // ensureCapacity(int minCapacity)
    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {

            int newCapacity = data.length * 2;

            // Ensure capacity is at least minCapacity
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            T[] newArray = (T[]) new Object[newCapacity];

            // Copy elements
            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }

            data = newArray;
        }
    }

    // Helper method to validate index
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        MyVector<Integer> vector = new MyVector<>();

        // Test add()
        System.out.println("Adding elements:");
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);

        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }

        System.out.println("\nSize: " + vector.size());

        // Test get()
        System.out.println("\nElement at index 2: " + vector.get(2));

        // Test set()
        System.out.println("\nSetting index 1 to 99");
        vector.set(1, 99);

        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }

        // Test remove()
        System.out.println("\n\nRemoving element at index 2");
        vector.remove(2);

        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }

        System.out.println("\nSize after removal: " + vector.size());

        // Test ensureCapacity indirectly by adding many elements
        System.out.println("\nAdding more elements to trigger resizing:");
        for (int i = 0; i < 20; i++) {
            vector.add(i);
        }

        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }

        System.out.println("\nFinal Size: " + vector.size());
    }
}

    

