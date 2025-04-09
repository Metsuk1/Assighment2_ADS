package entity.nodes;

public class MyNode <T>{
    private T node;
    private MyNode<T> next;
    private MyNode<T> previous;

    public MyNode(T node) {
        setNode(node);
    }

    public boolean hasNext(){
        return next != null;
    }

    public boolean hasPrevious(){
        return previous != null;
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

    public void setPrevious(MyNode<T> previous) {
        this.previous = previous;
    }

    public MyNode<T> getPrevious() {
        return previous;
    }

}

