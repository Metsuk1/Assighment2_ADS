package lists;


import lists.interfaces.MyList;
import lists.nodes.MyNode;

public class MyLinkedList <T> implements MyList<T> {
    private MyNode<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
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

    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);

        if(head == null) {
            head = newNode;
        }
        else {
            MyNode<T> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
//        checkIndex(index);
//
//        MyNode<T> current = head;
//        if(head == null) {
//            head = current.next;
//            return;
//        }
//        size--;

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
            current = current.next;
            }

        return current.data;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }




}
