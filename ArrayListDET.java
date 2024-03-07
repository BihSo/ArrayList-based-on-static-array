package Debug.Entity.Team;
import java.util.Arrays;
/**
 * ArrayListDET is a simple custom implementation of an ArrayList for integers.
 * It allows dynamic resizing and provides basic ArrayList operations.
 */
public class ArrayListDET {
    // TODO : Fields //O(1)
    private int size = 10;          // Initial capacity of the array
    private int currentIndex = 0;   // Current index to track the size of the ArrayList
    private int[] array;            // The underlying array to store elements
    private double growthRate = 1.5; // Growth rate factor for dynamic resizing
    // TODO : Constructors
    /**
     * Default constructor creates an ArrayListDET with the default initial capacity.
     */
    public ArrayListDET(){
       array = new int[size];//O(1)
    }
    /**
     * Constructor that allows specifying the initial capacity of the ArrayListDET.
     * @param initialCapacity Initial capacity of the ArrayListDET.
    */
    public ArrayListDET(int initialCapacity){ // O(1)
        size = initialCapacity;
        array = new int[size];
    }
     /**
      * Constructor that allows specifying both initial capacity and growth rate.
      * @param initialCapacity Initial capacity of the ArrayListDET.
      * @param growthRate Growth rate factor for dynamic resizing.
      */
    public ArrayListDET(int initialCapacity, double growthRate){//O(1)
        size = initialCapacity;
        array = new int[size];
        this.growthRate = growthRate;
    }
    // TODO : Methods
    /**
     * Adds an element to the end of the ArrayListDET.
     * Automatically grows the ArrayListDET if the current index exceeds the capacity.
     * @param number The integer to be added.
     */
    public void add(int number){ // O(1) In most of the time
        if (currentIndex >= size) {
            grow(); // O(n) When the basic array is full
        }
        array[currentIndex++] = number; //O(1)
    }
    /**
     * Adds an element at a specific index in the ArrayListDET.
     * Automatically grows the ArrayListDET if the current index exceeds the capacity.
     * @param index The index at which to add the element.
     * @param number The integer to be added.
     */
    public void add(int index , int number){//O(n) In most of the time
        if (currentIndex >= size) {
            grow(); // O(n)
        }
        if (index <= currentIndex) { // O(n)
            for (int i = currentIndex-1; i >= index ; i--) {
                array[i+1] = array[i];
            }
            array[index] = number;
            currentIndex++;
        }
    }
    /**
     * Returns the current size of the ArrayListDET.
     * @return The current size.
     */
    public int size(){// O(1)
        return currentIndex;
    }
    /**
     * Increases the capacity of the ArrayListDET by a factor of growthRate.
     */
    private void grow(){//O(n)
        int newSize = (int)(size * growthRate);
        int[] newArray = new int[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = newSize;
    }
    /**
     * Clears the ArrayListDET by creating a new array with the original size.
     * Resets the currentIndex to 0.
     */
    public void clear(){// O(1)
        array = new int[size];
        currentIndex = 0;
    }
    /**
     * Retrieves the element at the specified index in the ArrayListDET.
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public int get(int index){//O(1)
        return array[index];
    }
    /**
     * Checks if the ArrayListDET contains a specific integer.
     * @param target The integer to check for.
     * @return True if the integer is found, false otherwise.
     */
    public boolean contains(int target){//O(n)
        for (int i = 0; i < currentIndex; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    } 
    /**
     * Finds the index of the first occurrence of a specific integer in the ArrayListDET.
     * @param target The integer to search for.
     * @return The index of the first occurrence, or -1 if not found.
     */
    public int indexOf(int target){//O(n) , Theta(n) , Omega(1)
        for (int i = 0; i < currentIndex; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Finds the index of the last occurrence of a specific integer in the ArrayListDET.
     * @param target The integer to search for.
     * @return The index of the last occurrence, or -1 if not found.
     */
    public int lastIndexOf(int target){//O(n) 
        for (int i = currentIndex-1;i >= 0; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Checks if the ArrayListDET is empty.
     * @return True if the ArrayListDET is empty, false otherwise.
     */
    public boolean isEmpty(){ // O(1)
        return currentIndex == 0;
    }
    /**
     * Removes the element at the specified index in the ArrayListDET.
     * Shifts any subsequent elements to the left.
     * @param index The index of the element to be removed.
     */
    public void remove(int index){ // O(n) Th(n)  Om(1)
        for (int i = index+1; i < currentIndex ; i++) {
            array[i-1] = array[i];
        }
        currentIndex--;
    }
    /**
     * Removes the first occurrence of a specific integer from the ArrayListDET.
     * @param target The integer to be removed.
     */
    public void remove(Integer target){//O(n)
        int i = indexOf(target); 
        if (i != -1 ) {
            remove(i);// one element only
        }
    }
    /**
     * Sets the element at the specified index in the ArrayListDET to a new value.
     * @param index The index of the element to be set.
     * @param newNumber The new value to set at the specified index.
     */
    public void set(int index , int newNumber){ //O(1)
        array[index] = newNumber;
    } 
    /**
     * Returns a new ArrayListDET that is a sublist of the original ArrayListDET.
     * @param fromIndex The starting index of the sublist (inclusive).
     * @param toIndex The ending index of the sublist (inclusive).
     * @return A new ArrayListDET containing elements from fromIndex to toIndex.
     */
    public ArrayListDET subList(int fromIndex , int toIndex){//O(n) , Th(n) , Om(1)
        ArrayListDET al = new ArrayListDET(toIndex-fromIndex+1);
        for (int i = fromIndex; i <= toIndex; i++) {
            al.add(array[i]);
        }
        return al;
    } 
    /**
     * @return An array containing all elements in the ArrayListDET.
     */
    public int[] toArray(){//O(n)
        int[] arr = new int[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            arr[i] = array[i];
        }
        return arr;
        // Alternatively: return Arrays.copyOf(array, currentIndex);//O(n)
    }
    /**
     * @return A string representation of the ArrayListDET.
     */
    @Override
    public String toString() {//O(n)
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < currentIndex; i++) {
            str.append(array[i] + (i == currentIndex-1 ? "" : ", "));
        }
        str.append("]");
        return str.toString();
    }
    /**
     * Trims the capacity of the ArrayListDET to its current size.
     * Reduces memory consumption if the ArrayListDET's size is less than its capacity.
     */
    public void trimToSize(){//O(n)    n -> currentLength
        array = toArray();
        size = array.length;
    }
    /**
     * @return The full capacity of the ArrayListDET.
     */
    public int fullCapacity(){ //O(1)
        return size;
    }
}
