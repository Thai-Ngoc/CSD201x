import java.io.File;
import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner sc;
    static MyList<Product> myList = new MyList<Product>();
    static boolean check = false;// check load
    static File urlData = new File("E:\\Funix\\CSD201x\\CSD201x\\CSD201_AS2_ngoclptSE00512x\\src\\data.txt"); // url file
    private static void writeData() {
        // write file
        try {
            FileWriter fw = new  FileWriter(urlData);
            Node<Product> p = myList.getHead();
            while (p != null) {
                fw.write(p.getInfo().getId() + ";"
                        + p.getInfo().getTitle() + ";"
                        + p.getInfo().getQuality() + ";"
                        + p.getInfo().getPrice() + "\n");
                p = p.getNext();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully!");
    }
    private static void  loadData() throws IOException {
        // load data
        if (check) {
            return;
        }
        // read file
        FileInputStream fileInputStream = new FileInputStream(urlData);
        Scanner scanner = new Scanner(fileInputStream);
        try {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] subStr = str.split(";");
                // Only load data when there is enough info.
                if(subStr.length == 4) {
                    Product sp = new Product(subStr[0],subStr[1],Integer.parseInt(subStr[2]), Double.parseDouble(subStr[3]));
                    myList.insertAfter(sp);
                }
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("Exception");
            }
        }
        check = true;
    }
    // create product from input keyboard
    public static Product inputProduct() {
        sc = new Scanner(System.in);
        System.out.print("Input new ID: ");
        String id = " ";
        // check id.
        while (sc.hasNext()) {
            id = sc.nextLine();
            if(checkID(id)) {
                break;
            } else {
                System.out.println("ID already exists, please type again?");
                System.out.print("Input new ID: ");
            }
        }
        System.out.print("Input Product's Name: ");
        String title = sc.nextLine();
        System.out.print("Input Product's quantity: ");
        int quantity = checkIntNumber(); // check int
        System.out.print("Input Product's price: ");
        double price = checkDoubleNumber(); // check double

        return new Product(id, title, quantity, price);
    }
    // check if the id already exists
    static boolean checkID(String id) {
        Node<Product> p = myList.getHead();
        while (p != null) {
            if(p.getInfo().getId().equals(id)) {
                return false;
            }
            p = p.getNext();
        }
        return true;
    }
    // search by id
    public static void searchId() {
        sc = new Scanner(System.in);
        MyList<Product> productFound = new MyList<Product>();
        System.out.println("Search by ID");

        System.out.print("Input Id: ");
        String searchId = sc.nextLine();

        Node<Product> p = myList.getHead();
        while (p != null) {
            if(p.getInfo().getId().contains(searchId)) {
                productFound.insertAfter(p.getInfo());
            }
            p = p.getNext();
        }
        if(productFound.isEmpty()) {
            System.out.println("Product id could not be found!!!");
        } else {
            System.out.println("Result: ");
            head();
            productFound.traverse();
        }
    }
    // delete by id
    public static void deleteId() {
        sc = new Scanner(System.in);
        System.out.println("Delete by ID");
        // enter id
        System.out.print("Input ID: ");
        String deleteId = sc.nextLine();
        Node<Product> p = myList.getHead();
        while (p != null) {
            if(p.getInfo().getId().equals(deleteId)) {
                myList.delete(p.getInfo());
            }
            p = p.getNext();
        }
        System.out.println("Deleted!");
    }
    // sort by id
    public static void sortById() {
        Node<Product> pi, pj;
        Product t;
        pi = myList.getHead();
        while (pi != null) {
            pj = pi.getNext();
            while (pj != null) {
                // so sánh id liền kề
                if(CharSequence.compare(pi.getInfo().getId(),pj.getInfo().getId()) > 0) {
                    // đổi chỗ node
                    t = pi.getInfo();
                    pi.setInfo(pj.getInfo());
                    pj.setInfo(t);
                }
                pj = pj.getNext();
            }
            pi = pi.getNext();
        }
    }
    // covert to binary by recursive
    public static int convertToBinaryRecursive(int x) {
        if(x == 0) {
            return 0;
        } else {
            return (x % 2 + 10 * convertToBinaryRecursive(x / 2));
        }
    }
    // get all Items from file into stack
    public static void getAllItemsFromFileIntoStack() {
        MyStack<Product> stack = new MyStack<Product>();
        Node<Product> current = myList.getHead();
        while (current != null) {
            stack.push(current.getInfo());
            current = current.getNext();
        }
        // display stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Successfully!");
    }
    // get all Items from file into Queue
    public static void getAllItemsFromFileIntoQueue() throws Exception {
        MyQueue<Product> queue = new MyQueue<Product>();
        Node<Product> current = myList.getHead();
        while (current != null) {
            queue.enqueue(current.getInfo());
            current = current.getNext();
        }
        // display queue
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
    // list product
    public static void head() {
        System.out.printf("%-5s%-10s%-10s%-10s%n", "ID" ,"Title" ,"Quality", "Price");
        System.out.println("+------------------------------+");
    }
    // check int input.
    private static int checkIntNumber() {
        int num = 0;
        sc = new Scanner(System.in);
        boolean check = true;
        while (check) {
            if (sc.hasNextInt()) {
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
    // check double input.
    private static double checkDoubleNumber() {
        double num = 0;
        sc = new Scanner(System.in);
        boolean check = true;
        while (check) {
            if (sc.hasNextDouble()) {
                num = sc.nextDouble();
                check = false;
            } else {
                System.out.println("Should enter a real number?");
                System.out.print("Your choice: ");
                sc.nextLine();
            }
        }
        return num;
    }

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println();
            System.out.println("Choose one of this options:");
            System.out.println("Product list:");
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end.");
            System.out.println("3. Display data");
            System.out.println("4. Save product list to file.");
            System.out.println("5. Search by ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Sort by ID.");
            System.out.println("8. Convert to Binary");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display.");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Choice: ");
            // check choice
            choice = checkIntNumber();
            if(choice == 0) {
                System.out.println("Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1 -> {
                    head();
                    loadData();
                    myList.traverse();
                }
                case 2 -> myList.insertAfter(inputProduct());
                case 3 -> {
                    head();
                    myList.traverse();
                }
                case 4 -> writeData();
                case 5 -> searchId();
                case 6 -> deleteId();
                case 7 -> sortById();
                case 8 -> {
                    int quantityToHead = myList.getHead().getInfo().getQuality();
                    System.out.print("Quantity=" +
                            quantityToHead + " =>(" +
                            convertToBinaryRecursive(quantityToHead) + ")");
                    System.out.println();
                }
                case 9 -> {
                    head();
                    getAllItemsFromFileIntoStack();
                }
                case 10 -> {
                    head();
                    getAllItemsFromFileIntoQueue();
                }
                default -> System.out.println("**Invalid choice. Try again.**");
            }
        }
    }
}
