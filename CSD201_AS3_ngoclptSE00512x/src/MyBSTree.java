import java.util.ArrayList;

public class MyBSTree {
    Node root;
    ArrayList<Person> list;
    static boolean check = false; //check balance

    MyBSTree() {
        root = null;
        list = new ArrayList<>();
    }

    //isEmpty
    public  boolean isEmpty() {
        return root == null;
    }

    //option
    //insert
    public void insert(Person person) {
        Node q = new Node(person);
        if(isEmpty()) {
            root = q;
            return;
        }

        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            //check id exist
            if(p.getInfo().getId() == person.getId()) {
                System.out.println("ID already exists, cannot insert");
                return;
            }
            f = p;
            if(p.getInfo().getId() > person.getId()) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }

        }

        assert f != null;
        if(f.getInfo().getId() > person.getId()) {
            f.setLeft(q);
        } else {
            f.setRight(q);
        }
    }

    //option 2
    //inorder a tree
    //left > root > right
    public void inOrder(Node p) {
        if(p == null)
            return;
        inOrder(p.getLeft());
        System.out.println(p.getInfo());
        inOrder(p.getRight());
    }

    //option 3
    //preorder root > left > right
    public void preOrder(Node p) {
        if(p == null)
            return;
        System.out.println(p.getInfo());
        preOrder(p.getLeft());
        preOrder(p.getRight());
    }

    //option 4
    //postorder left > root > right
    public void postOrder(Node p) {
        if(p == null)
            return;
        postOrder(p.getLeft());
        postOrder(p.getRight());
        System.out.println(p.getInfo());
    }

    //option 5
    //BST a trê
    public void BST() {
        if(root == null)
            return;
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            System.out.println(p.getInfo());
            if(p.getLeft() != null)
                q.enqueue(p.getLeft());
            if(p.getRight() != null)
                q.enqueue(p.getRight());
        }
    }

    //option 6
    //search
    public Node search(Node p, int key) {
        if(p == null) {
            return  null;
        }

        if(p.getInfo().getId() == key) {
            return p;
        }

        if(p.getInfo().getId() < key) {
            return search(p.getLeft(), key);
        } else {
            return search(p.getRight(), key);
        }
    }

    //option 7
    //delete ID
    public void deleteID(int key) {
        root = delete(root, key);
    }

    //delete node
    public Node delete(Node p, int key) {
        //tree is empty
        if(p == null)
            return null;

        //otherwise, go on down tree
        if(p.getInfo().getId() > key) {
            p.setLeft(delete(p.getLeft(), key));
        } else if(key > p.getInfo().getId()) {
            p.setRight(delete(p.getRight(), key));
        } else {
            //node with only one leaf or no leaf
            if(p.getLeft() == null) {
                return p.getRight();
            } else if(p.getRight() == null) {
                return p.getLeft();
            }

            //node with two leaf, get the inorder
            p.setInfo(minValue(p.getRight()));
            //delete the inorder
            p.setRight(delete(p.getRight(), p.getInfo().getId()));
        }
        return p;
    }

    public Person minValue(Node p) {
        Person min = p.getInfo();
        while (p.getLeft() != null) {
            min = p.getLeft().getInfo();
            p = p.getLeft();
        }
        return min;
    }
}
