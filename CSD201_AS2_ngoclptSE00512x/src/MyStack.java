import java.util.EmptyStackException;

public class MyStack<T> {
    Node<T> head;
    MyStack() {
        head = null;
    }
    boolean isEmpty() {
        return  head == null;
    }
    //push x in stack
    public void push(T x) {
        head = new Node<T> (x, head);
    }
    //pop x out stack
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        T x = head.getInfo();
        head = head.getNext();
        return x;
    }
}
