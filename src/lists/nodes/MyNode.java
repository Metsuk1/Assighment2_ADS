package lists.nodes;

public class MyNode <T>{
    private T node;
    private MyNode<T> next;

    public MyNode(T node) {
        this.node = node;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public T getNode() {
        return node;
    }

}

