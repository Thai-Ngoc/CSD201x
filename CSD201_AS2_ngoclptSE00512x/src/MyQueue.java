public class MyQueue<T> {
    Node<T> head, tail;
    public MyQueue() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    //dequeue
    public T dequeue() throws Exception {
        if(isEmpty()) throw new Exception();
        T x = head.getInfo();
        head = head.getNext();
        if(head == null) {
            tail = null;
        }
        return x;
    }
    //enqueue
    public void enqueue(T x) {
        Node<T> t = new Node<>(x);
        if (isEmpty()) {
            head = tail = t;
        } else {
            tail.setNext(t);
            tail = tail.getNext();
        }
    }
}
