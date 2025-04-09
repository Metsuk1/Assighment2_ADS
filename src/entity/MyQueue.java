package entity;

import entity.interfaces.IMyQueue;
import entity.interfaces.MyList;

public class MyQueue <T> implements IMyQueue<T> {
    private MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    /**
     *Returns whether the queue is empty
     * @return boolean meaning true or false
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the size of the queue
     * @return size of the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     *  Returns a reference to the front element of the queue
     * @return the first element in the queue
     */
    @Override
    public T peek() {
        return list.getFirst();
    }

    /**
     *  Adds the element at the end of the queue it is like insertion
     * @param item its element to the add
     * @return  the newly added element
     */
    @Override
    public T enqueue(T item) {
        list.addLast(item);
        return item;
    }

    /**
     * Retrieves and deletes the front element of the queue
     * @return the element at the front
     */
    @Override
    public T dequeue() {
        T tmp = peek();
        list.removeFirst();
        return tmp;
    }
}
