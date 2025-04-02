package lists;

import lists.interfaces.MyList;

public class MyArrayList <T> implements MyList<T> {
    private int size;
    private Object [] elements;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    private void increaseCapacity() {
        Object[] tempElements =  new Object[getLength() * 2];

        for (int i = 0; i < getLength(); i++) {
            tempElements[i] = elements[i];
        }
        elements = tempElements;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    public int getLength() {
        return elements.length;
    }

    @Override
    public void add(Object element) {
        if (size == getLength()) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < getLength() - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object getByIndex(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public void clear() {
        elements = new Object[10];
        this.size = 0;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < getLength(); i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }

        return false;
    }
}
