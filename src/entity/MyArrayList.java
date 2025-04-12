package entity;

import entity.interfaces.MyList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList <T> implements MyList<T> {
    private int length; // Number of elements in the list
    private Object [] elements; // Array to store elements

    public MyArrayList() {
        elements = new Object[10];
        length = 0;
    }

    /**
     * Adds an element to the end of the list
     */
    @Override
    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    /**
     * Adds an element at a specific index
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }

        if (length == elements.length) {
            increaseCapacity();
        }
        moveRight(index);
        elements[index] = element;
        length++;
    }

    /**
     * Replaces the element at the specified index
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    /**
     * Adds an element at the beginning of the list
     */
    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * Adds an element at the end of the list (alias for add)
     */
    @Override
    public void addLast(T element) {
        add(element);
    }

    /**
     * Removes the element at the specified index
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        moveLeft(index);
        elements[--length] = null;
        length--;
    }

    /**
     * Removes the first element
     */
    @Override
    public void removeFirst() {
       remove(0);
    }

    /**
     * Removes the last element
     */
    @Override
    public void removeLast() {
        if (length == 0) {throw new NoSuchElementException("List is empty");}

        //remove(length - 1);
        elements[--length] = null;
    }

    /**
     * Sorts the list using the given comparator (bubble sort)
     */
    @Override
    public void sort(Comparator<T> cmp) {
        if(cmp == null) {
            throw new NullPointerException();
        }

        for(int i = 0; i < length - 1; i++) {
            for(int j = 0; j < length - i - 1; j++) {
                T current = (T )elements[j];
                T next = (T )elements[j+1];

                if(cmp.compare(current, next) > 0) {
                    elements[j] = next;
                    elements[j+1] = current;
                }
            }
        }
    }


    /**
     * Returns the index of the first occurrence of the object
     */
    @Override
    public int indexOf(Object object) {
        return findIndexOf(object);
    }

    /**
     * Returns the index of the last occurrence of the object
     */
    @Override
    public int lastIndexOf(Object object) {
       return findLastIndexOf(object);
    }

    /**
     * Checks if the element exists in the list
     */
    @Override
    public boolean exists(Object object) {
        return contains((T) object);
    }

    /**
     * Converts the list into an array
     */
    @Override
    public Object[] toArray() {
        int index = 0;

        for (int i = 0; i < length; i++) {
            elements[index++] = elements[i];
        }

        return elements;
    }

    /**
     * Returns the number of elements in the list
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Clears the list and resets it to initial state
     */
    @Override
    public void clear() {
        elements = new Object[10];
        this.length = 0;
    }

    /**
     * Checks if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Gets the element at the specified index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T)elements[index];
    }

    /**
     * Gets the first element in the list
     */
    @Override
    public T getFirst() {
        checkIndex(0);
        return (T)elements[0];
    }

    /**
     * Gets the last element in the list
     */
    @Override
    public T getLast() {
        checkIndex(length - 1);
        return (T) elements[length-1];
    }

    /**
     * Checks whether the list contains the specified element
     */
    private boolean contains(T element) {
        if (isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < length; i++) {
                if (elements[i].equals(element)) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Returns the iterator for using
     * @return iterator
     */
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return (T) elements[index++];
            }
        };

    }

    /**
     * Increases the capacity of the internal array (doubles it)
     */
    private void increaseCapacity() {
        Object[] tempElements =  new Object[length * 2];

        for (int i = 0; i < length; i++) {
            tempElements[i] = elements[i];
        }
        elements = tempElements;
    }

    /**
     * Shifts all elements one position to the left starting from the given index
     */
    private void moveLeft(int index) {

        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[length-1] = null;
    }

    /**
     * Shifts all elements one position to the right starting from the given index
     */
    private void moveRight(int index) {
        checkIndex(index);

        if (length == elements.length) {
            increaseCapacity();
        }

        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        length++;
    }

    /**
     * Validates that the index is within bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    /**
     * Finds the first index of the given object
     */
    private int findIndexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Finds the last index of the given object
     */
    private int findLastIndexOf(Object object) {
        int index = -1;
        for(int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                index = i;
            }
        }

        return index;
    }


}
