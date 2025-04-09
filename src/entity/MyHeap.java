package entity;

import entity.interfaces.IMyHeap;
import entity.interfaces.MyList;

public class MyHeap <T> implements IMyHeap<T> {
    private MyList<T> list;

    public MyHeap(MyList<T> list) {
        this.list = list;
    }


    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void insert(T element) {

    }

    @Override
    public T getMax() {
        return null;
    }

    @Override
    public T getMin() {
        return null;
    }

    @Override
    public T extractMax() {
        return null;
    }

    @Override
    public T extractMin() {
        return null;
    }
}
