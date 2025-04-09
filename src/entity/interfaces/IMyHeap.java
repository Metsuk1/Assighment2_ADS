package entity.interfaces;

public interface IMyHeap<T> {

    /**
     * Returns whether the heap is empty
     * @return true or false
     */
    boolean empty();

    /**
     * Returns the size of the heap
     * @return the size of the heap
     */
    int size();

    /**
     * Adds the element to the heap
     * @param element to add in the heap
     */
    void insert(T element);

    /**
     * Returns a reference to the root element of the heap
     * @return max or min
     */
    T getMax();
    T getMin();

    /**
     * Retrieves and deletes the root element of the heap
     * @return max or min element in the heap
     */
    T extractMax();
    T extractMin();
}
