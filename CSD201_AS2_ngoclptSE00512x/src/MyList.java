public class MyList<T> {
    Node<T> head;
    Node<T> tail;

    //constructor

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }
    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    //insert to tail
    public void insertAfter(T x) {
        Node<T> newNode = new Node<>(x);
        if(isEmpty()) {
            head = tail = newNode;
            return;
        }
        tail.setNext(newNode);
        this.tail = newNode;
    }

    //delete node by id
    public void delete(T x) {
        Node<T> temp = head, prev = null;
        //nếu id tại head xóa head
        if(temp != null && temp.getInfo() == x) {
            head = temp.getNext();
            return;
        }
        //kiểm tra id qua từng node
        while (temp != null && temp.getInfo() != x) {
            prev = temp;
            temp = temp.getNext();
        }
        if(temp == null) {
            return;
        }

        //set node
        prev.setNext(temp.getNext());
    }

    public void clear() {
        head = tail = null;
    }

    //display
    public void traverse() {
        Node<T> p = head;
        while (p != null) {
            System.out.println(p);
            p = p.getNext();
        }
    }
}
