import java.util.*;
public class MyPerson {
    MyBSTree tree;
    Scanner sc;

    public MyPerson() {
        tree = new MyBSTree();
    }

    public void insert() {
        //input id
        sc = new Scanner(System.in);
        System.out.print("Input ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        //input name
        System.out.print("Input name: ");
        String name = sc.nextLine();
        //input birthplace
        System.out.print("Input birthplace: ");
        String birthplace = sc.nextLine();
        //input dob
        System.out.print("Input date of birth: ");
        String dob = sc.nextLine();

        //insert person into tree
        tree.insert(new Person(id, name, birthplace,dob));
    }
    //in-order traverse
    public void inOrder() {
        tree.inOrder(tree.root);
    }

    //in-order traverse
    public void preOrder() {
        tree.preOrder(tree.root);
    }

    //in-order traverse
    public void postOrder() {
        tree.postOrder(tree.root);
    }

    //BST
    public void BST() {
        tree.BST();
    }

    //search
    public void search() {
        sc = new Scanner(System.in);
        System.out.print("Search for ID: ");
        int id = sc.nextInt();
        Node p = tree.search(tree.root, id);
        if(p != null) {
            System.out.println(p.getInfo());
        } else {
            System.out.println("Id is not found.");
        }
    }

    //delete
    public void delete() {
        sc = new Scanner(System.in);
        System.out.print("Delete ID: ");
        int id = sc.nextInt();
        tree.deleteID(id);
    }

    //balance
    public void balance() {
        tree.balance();
    }
}
