package entity;

import entity.interfaces.IMyStack;
import entity.interfaces.MyList;

public class MyStack <T> implements IMyStack<T> {
    private MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }

    /**
     * Returns whether the stack is empty
     * @return boolean meaning  true or false
     */
    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     *Returns the size of the stack by using method size in the list
     * @return the size of stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns a reference to the topmost element of the stack
     * @return  the topmost element with method getLast()
     */
    @Override
    public T peek() {
        return list.getLast();
    }
    /**
     * Pushes the element to the top and returns the just added element
     * @param item  element to add
     * @return the just added element
     */
    @Override
    public T push(T item) {
        list.add(item);
        return item;
    }

    /**
     * Deletes the top most element and returns it.
     * @return the top most element
     */
    @Override
    public T pop() {
        T tmp = list.getLast();
        list.removeLast();
        return tmp;
    }
}
