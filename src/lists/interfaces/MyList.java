package lists.interfaces;

public interface MyList<T> {
    void add(Object element);
    void remove(int index);
    int getSize();
    Object getByIndex(int index);
    void clear();
    boolean isEmpty();

}
