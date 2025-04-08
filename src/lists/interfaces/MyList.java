package lists.interfaces;

public interface MyList<T> {
    void add(T element);
    void add(int index, T element);
    void set(int index, T element);
    void addFirst(T element);
    void addLast(T element);
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    public Object[] toArray();
    int size();
    T get(int index);
    T getFirst();
    T getLast();
    void clear();
    boolean isEmpty();
    boolean contains(T element);

}
