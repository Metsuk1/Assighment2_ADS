package entity;

import entity.interfaces.IMyHeap;
import entity.interfaces.MyList;
/**
 * A generic implementation of a min-heap using a list.
 * Maintains the heap property where the parent is always less than its children.
 *
 * @param <T> the type of elements held in this heap; must be comparable
 */
public class MyMinHeap<T extends Comparable<T>> implements IMyHeap<T> {
    private MyList<T> list;

    public MyMinHeap(MyList<T> list) {
        this.list = list;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap contains no elements
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the current size of the heap
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Inserts a new element into the heap and maintains the heap property.
     *
     * @param element the element to insert
     */
    @Override
    public void insert(T element) {
        list.addLast(element);
        int index = list.size() - 1;
        traverseUp(index);// Reheap upwards
    }

    /**
     * Returns the minimum element in the heap without removing it.
     *
     * @return the minimum element or null if heap is empty
     */
    @Override
    public T getMin() {
        if (size() == 0) return null;
        return list.get(0);// Root is always min
    }

    /**
     * Removes and returns the minimum element in the heap.
     * Replaces root with the last element and heapifies down.
     *
     * @return the removed minimum element, or null if heap is empty
     */
    @Override
    public T extractMin() {
        if (size() == 0) return null;

        T min = list.get(0);
        T last = list.get(list.size() - 1);

        list.removeLast();

        if(size() > 0 ){
            list.set(0, last);// Replace root
            heapify(0);// Reheapify from root
        }

        return min;
    }

    /**
     * Restores the heap property going down from the given index.
     *
     * @param index the index to start heapifying from
     */
    private void heapify(int index) {
        int size = list.size();

        while(true){
            int right = rightChildOf(index);
            int left = leftChildOf(index);
            int smallest = index;

            if(right < size && list.get(right).compareTo(list.get(smallest)) < 0){
                smallest = right;
            }

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }

            if(smallest != index){
                swap(index, smallest);// Swap with smaller child
                index = smallest;// Continue from new index
            }else {
                break;// Heap property is satisfied
            }
        }

    }

    /**
     * Moves an element up the tree to restore the heap property.
     * Called after insertion.
     *
     * @param index the index of the newly inserted element
     */
    private void traverseUp(int index) {
        while(index > 0){
            int parentInd = parentOf(index);
            T current = list.get(index);
            T parent = list.get(parentInd);

            if(current.compareTo(parent) < 0){
                swap(index, parentInd);
                index = parentInd;
            }else {
                break;
            }
        }
    }

    /**
     * Swaps two elements in the list.
     *
     * @param index1 the index of the first element
     * @param index2 the index of the second element
     */
    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    /**
     * Returns the index of the parent of the given node.
     *
     * @param index the index of the child node
     * @return the index of the parent node
     */
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    /**
     * Returns the index of the left child of the given node.
     *
     * @param index the index of the parent node
     * @return the index of the left child
     */
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns the index of the right child of the given node.
     *
     * @param index the index of the parent node
     * @return the index of the right child
     */
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }
}
