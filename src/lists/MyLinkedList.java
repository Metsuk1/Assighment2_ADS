package lists;


import lists.interfaces.MyList;
import lists.nodes.MyNode;

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
     * Метод нужен для того чтобы словить Exception при работе с индексами
     * @param index чекаем индекс с которым будем работать
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkCurrent(T element) {
        if (element == null) {
            throw new NullPointerException("there is no element");
        }
    }

    private void checkEmpty(){
        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        }
    }



    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);

        if(head == null) {
            head = newNode;
        }
        else {
            MyNode<T> current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public void add(int index, T element) {

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

    @Override
    public void removeFirst() {
        checkEmpty();
        head = head.getNext();
        size--;
    }

    @Override
    public void removeLast() {
        checkEmpty();
        tail = tail.getPrevious();
        size--;
    }

    @Override
    public void sort(Comparator<T> cmp) {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return contains((T) object);
    }

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


    @Override
    public int size() {
        return size;
    }

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

    @Override
    public T getFirst() {
        MyNode<T> current = head;
        if(current == null) {
            return null;
        } else {
            return current.getNode();
        }
    }

    @Override
    public T getLast() {
       return tail.getPrevious().getNode();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

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



}
