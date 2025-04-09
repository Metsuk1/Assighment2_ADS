package entity.interfaces;

public interface IMyStack <T>{
    boolean isEmpty();
    int size();
    T peek();
    T push(T item);
    T pop();
}
