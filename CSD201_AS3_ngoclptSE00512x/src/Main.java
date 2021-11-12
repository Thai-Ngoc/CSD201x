import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc;

    public static void end() {
        System.out.println("-----------------------------------");
    }

    //check int input
    private static int checkIntNumber() {
        int num = 0;
        sc = new Scanner(System.in);
        boolean check = true;
        while (check) {
            if(sc.hasNextInt()) {
                num = sc.nextInt();
                check = false;
            } else {
                System.out.println("Should you enter an integer?");
                System.out.print("Your choice: ");
                sc.nextLine();
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        MyPerson myPerson = new MyPerson();
        //Graph g = new Graph()
        int choice;
        while(true) {
            System.out.println("Choose one of these options: ");
            System.out.println("Person Tree: ");
            System.out.println("1. Insert a new person");
            System.out.println("2. Inorder traverse");
            System.out.println("3. Preorder traverse");
            System.out.println("4. Postorder traverse");
            System.out.println("5. Breadth-First Traversal traverse");
            System.out.println("6. Search by ID");
            System.out.println("7. Delete by ID");
            System.out.println("8. Balancing Binary Search Tree");
            System.out.println("9. Display adjacency matrix from file");
            System.out.println("10. DFS_Graph");
            System.out.println("11. BFS_Graph");
            System.out.println("12. Dijkstra");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Choice: ");

            //check choice
            choice = checkIntNumber();
            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            switch(choice) {
                case 1 -> {
                    myPerson.insert();
                    end();
                }

                case 2 -> {
                    myPerson.inOrder();
                    end();
                }

                case 3 -> {
                    myPerson.preOrder();
                    end();
                }

                case 4 -> {
                    myPerson.postOrder();
                    end();
                }

                case 5 -> {
                    myPerson.BST();
                    end();
                }

                case 6 -> {
                    myPerson.search();
                    end();
                }

                case 7 -> {
                    myPerson.delete();
                    System.out.println("Deleted!");
                    end();
                }

                case 8 -> {
                    myPerson.balance();
                    end();
                }
            }
        }
    }
}
