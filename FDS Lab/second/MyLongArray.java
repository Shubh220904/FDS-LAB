package second;

/**
 * The MyLongArray class represents an array of long integers with various
 * operations like insertion, deletion, finding, and more.
 */
public class MyLongArray {
    protected long[] a;
    protected int currentIndex;
    protected boolean legal=false;

    /**
     * Constructs a MyLongArray with the given size.
     *
     * @param size The size of the internal array.
     */
    public MyLongArray(int size) {
        a = new long[size];
        currentIndex = 0;
    }


    /**
     * Finds the index of a specified value in the array.
     *
     * @param searchKey The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int find(long searchKey) {
        
        for (int i = 0; i < currentIndex; i++) {
            if (searchKey == a[i]) {
                return i;
            }
            else if(legal==false){
                System.out.println("Invalid Request,insert an element first");
            }
        }
        return -1;
    }


    /**
     * Inserts a value at the end of the array.
     *
     * @param value The value to insert.
     */
    public void insert(long value) {
        if (currentIndex < a.length) {
            a[currentIndex] = value;
            currentIndex++;
        } else {
            System.out.println("Array is full.");
        }
        legal=true;
    }


    /**
     * Gets the element at a specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public long getElement(int index) {
        if (index >= 0 && index < currentIndex) {
            return a[index];
        }
        return -1;
    }


    /**
     * Deletes the first occurrence of a specified value from the array.
     *
     * @param value The value to delete.
     * @return True if the value was found and deleted, false otherwise.
     */
    public boolean delete(long value) {
        int index = find(value);
        if (index != -1) {
            for (int i = index; i < currentIndex - 1; i++) {
                a[i] = a[i + 1];
            }
            currentIndex--;
            return true;
        }
        return false;
    }


    /**
     * Displays all elements of the array.
     */
    public void display() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    /**
     * Deletes all occurrences of a specified value from the array.
     *
     * @param value The value to delete.
     * @return The number of elements deleted.
     */
    public int dupDelete(long value) {
        int count = 0;
        int index;
        while ((index = find(value)) != -1) {
            for (int i = index; i < currentIndex - 1; i++) {
                a[i] = a[i + 1];
            }
            currentIndex--;
            count++;
        }
        return count;
    }


    /**
     * Inserts a value at a specified index.
     *
     * @param index The index at which to insert the value.
     * @param value The value to insert.
     */
    public void insertAt(int index, long value) {
        if (index >= 0 && index <= currentIndex) {
            if (currentIndex < a.length) {
                for (int i = currentIndex; i > index; i--) {
                    a[i] = a[i - 1];
                }
                a[index] = value;
                currentIndex++;
            } else {
                System.out.println("Array is full.");
            }
        } else if(index>currentIndex){
            
            System.out.println("Warning: Index value is out of range.");
            System.out.println("Value inserted at end");
            insert(value);
        }
        legal=true;
    }
}

