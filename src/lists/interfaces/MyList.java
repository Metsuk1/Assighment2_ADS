package lists.interfaces;

import java.util.Comparator;
import java.util.Iterator;

public interface MyList<T> {
    void add(T element);

    void add(int index, T element);

    void set(int index, T element);

    void addFirst(T element);

    void addLast(T element);

    void remove(int index);

    void removeFirst();

    void removeLast();

    void sort(Comparator<T> cmp);

    int indexOf(Object object);

    int lastIndexOf(Object object);

    boolean exists(Object object);

    public Object[] toArray();

    int size();

    T get(int index);

    T getFirst();

    T getLast();

    void clear();

    boolean isEmpty();

    Iterator<T> iterator();
}