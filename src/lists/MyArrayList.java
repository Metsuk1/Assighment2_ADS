package lists;

import lists.interfaces.MyList;

public class MyArrayList <T> implements MyList<T> {
    private int length;
    private Object [] elements;

    public MyArrayList() {
        elements = new Object[10];
        length = 0;
    }


    @Override
    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);

        if(index++ == length) {
            increaseCapacity();


        }


    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public void addFirst(T element) {


    }

    @Override
    public void addLast(T element) {

    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        shift(index);
        length--;
    }

    @Override
    public void removeFirst() {
       remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
       // sorting();
    }

    @Override
    public int indexOf(Object object) {
        return findIndexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
       return findLastIndexOf(object);
    }

    @Override
    public boolean exists(Object object) {
        return contains((T) object);
    }

    @Override
    public Object[] toArray() {
        int index = 0;

        for (int i = 0; i < length; i++) {
            elements[index++] = elements[i];
        }

        return elements;
    }

    @Override
    public int size() {
        return length;
    }


    @Override
    public void clear() {
        elements = new Object[10];
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T)elements[index];
    }

    @Override
    public T getFirst() {
        return (T)elements[0];
    }

    @Override
    public T getLast() {
        return (T) elements[length-1];
    }

    public boolean contains(T element) {
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

    private void increaseCapacity() {
        Object[] tempElements =  new Object[length * 2];

        for (int i = 0; i < length; i++) {
            tempElements[i] = elements[i];
        }
        elements = tempElements;
    }

    private void shift(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        length--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    private int findIndexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }


    private int findLastIndexOf(Object object) {
        for(int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    private void sorting(Comparable[] array) {

    }


}
