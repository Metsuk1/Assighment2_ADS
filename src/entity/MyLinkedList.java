package entity;


import entity.interfaces.MyList;
import entity.nodes.MyNode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }



    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }
    /**
     * Inserts an element at a specific index.
     *
     * @param index the index to insert at
     * @param element the element to insert
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);

        if(index == 0) {
            addFirst(element);
        }
        else if(index == size - 1) {
            addLast(element);
        }
        else {
            MyNode<T> newNode = new MyNode<>(element);
            MyNode<T> current = head;

            for(int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);

            size++;
        }
    }
    /**
     * Replaces the element at the specified index with the provided element.
     *
     * @param index the index to update
     * @param element the new element to set
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        MyNode<T> current = head;

        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setNode(element);
    }
    /**
     * Adds an element to the beginning of the list.
     *
     * @param element the element to add
     */
    @Override
    public void addFirst(T element) {
        MyNode<T> temp = head;
        head = new MyNode<>(element);
        head.setNext(temp);
        size++;
    }
    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    @Override
    public void addLast(T element) {
        add(element);
    }
    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to remove
     */
    @Override
    public void remove(int index) {
        checkIndex(index);

        if (head == null) {
            head = head.getNext();
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }
    /**
     * Removes the first element of the list.
     */
    @Override
    public void removeFirst() {
        checkEmpty();
        head = head.getNext();
        size--;
    }
    /**
     * Removes the last element of the list.
     */
    @Override
    public void removeLast() {
        checkEmpty();
        if(size == 1) {
            head = null;
            tail = null;
        }else {
            MyNode<T> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
    }

    /**
     * Sorts the list using the provided comparator.
     *
     * @param cmp the comparator to determine order
     */
    @Override
    public void sort(Comparator<T> cmp) {
        MyNode<T> current = head;

        while(current.hasNext()){
            MyNode<T> next = current.getNext();

            if(cmp.compare(current.getNode(), next.getNode()) > 0) {
                T temp = current.getNode();
                current.setNode(next.getNode());
                next.setNode(temp);
            }

            current = current.getNext();
        }

    }

    /**
     * Returns the first index of the given element, or -1 if not found.
     *
     * @param object the element to search for
     * @return index of the element or -1
     */
    @Override
    public int indexOf(Object object) {
        return findIndexOfElement(object);
    }

    /**
     * Returns the last index of the given element, or -1 if not found.
     *
     * @param object the element to search for
     * @return last index of the element or -1
     */
    @Override
    public int lastIndexOf(Object object) {
        return findLastIndexOfElement(object);
    }

    /**
     * Checks whether the given element exists in the list.
     *
     * @param object the element to check
     * @return true if exists, false otherwise
     */
    @Override
    public boolean exists(Object object) {
        return contains((T) object);
    }

    /**
     * Converts the list to an array.
     *
     * @return an array containing all elements of the list
     */
    @Override
    public Object[] toArray() {
        int index = 0;
        MyNode<T> current = head;
        Object[] array = new Object[size];

        while(current.hasNext()) {
            array[index++] = current.getNode();
            current = current.getNext();
        }

        return array;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index to retrieve
     * @return the element at that index
     */
    @Override
    public T get(int index) {
        checkIndex(index);

        MyNode<T> current = head;

        for(int i = 0; i < index; i++) {
            checkCurrent(current.getNode());
            current = current.getNext();
            }

        return current.getNode();
    }

    /**
     * Returns the first element of the list.
     *
     * @return the first element or null if list is empty
     */
    @Override
    public T getFirst() {
        MyNode<T> current = head;
        if(current == null) {
            return null;
        } else {
            return current.getNode();
        }
    }

    /**
     * Returns the last element of the list.
     *
     * @return the last element
     */
    @Override
    public T getLast() {
        checkEmpty();
       return tail.getNode();
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * checks if the list empty
     * @return true or dalse
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return iterator over list elements
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
           private MyNode<T> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                T next = cursor.getNode();
                cursor = cursor.getNext();
                return next;
            }
        };
    }

    /**
     * Helper method to check if an element exists in the list.
     *
     * @param element the element to search for
     * @return true if found, false otherwise
     */
    private boolean contains(T element) {
        MyNode<T> current = head;

        while(current.hasNext()) {
            if(current.getNode().equals(element)) {

                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * Validates index bounds.
     *
     * @param index the index to check
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Throws exception if the element is null.
     *
     * @param element the element to check
     */
    private void checkCurrent(T element) {
        if (element == null) {
            throw new NullPointerException("there is no element");
        }
    }

    /**
     * Checks if the list is empty and throws exception if so.
     */
    private void checkEmpty(){
        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        }
    }

    /**
     * helper method to find first index
     * Finds the index of the first occurrence of an element.
     *
     * @param element the element to find
     * @return index or -1 if not found
     */
    private int  findIndexOfElement(Object element) {
        int index = 0;
        MyNode<T> current = head;

        while(current.hasNext()) {
            if(current.getNode().equals(element)) {

                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    /** helper method to find last index
     * Finds the index of the last occurrence of an element.
     *
     * @param element the element to find
     * @return index or -1 if not found
     */
    private int  findLastIndexOfElement(Object element){
        int index = -1;
        int currentIndex = 0;

        MyNode<T> current = head;
        while(current.hasNext()) {
            if(current.getNode().equals(element)) {
                index = currentIndex;
            }
            current = current.getNext();
            currentIndex++;
        }

        return index;
    }
}
