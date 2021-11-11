public class Node<T> {
    private T info;
    private Node next;
    public Node() {};

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(T x) {
        this(x, null);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return info + " ";
    }
}
