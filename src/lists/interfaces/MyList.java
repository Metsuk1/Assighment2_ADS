package lists.interfaces;

public interface MyList<T> {
    void add(T element);
    void remove(int index);
    int size();
    T get(int index);
    void clear();
    boolean isEmpty();

}
