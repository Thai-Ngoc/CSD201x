import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        float[] a;
        int choice;
        while (true) {
            System.out.println("\n+-------------------Menu------------------+");
            System.out.println("|      1.Input                            |");
            System.out.println("|      2.Output                           |");
            System.out.println("|      3.Bubble sort                      |");
            System.out.println("|      4.Selection sort                   |");
            System.out.println("|      5.Insertion sort                   |");
            System.out.println("|      6.Search > value                   |");
            System.out.println("|      7.Search = value                   |");
            System.out.println("|      0. Exit                            |");
            System.out.println("+-------------------Menu------------------+\n");
            System.out.print("Choice: ");
            if(s.hasNextInt()) { // Require input is an integer
                choice = s.nextInt();
                // a = new float[choice];
                if (choice==0) {
                    System.out.println("Good bye, have a nice day!");
                    break;
                } else if (choice == 1) {
                    System.out.print("Input number of elements: ");
                    if (s.hasNextInt()) {
                        int quantity = s.nextInt();
                        if (quantity <= 20) {
                            a = new float[quantity];
                            Algorithm.write_file(a);
                        } else {
                            System.out.println("**You can only enter up to 20 numbers!**");
                        }
                    } else {
                        System.out.println("**Please enter an integer!**");
                        s.next();
                    }
                } else if ( choice == 2) {
                    a = Algorithm.Read_file();
                    System.out.print("Read from file\nArray a: ");
                    for (float v : a) {
                        System.out.print(v + " ");
                    }
                } else if ( choice == 3) {
                    a = Algorithm.Read_file();
                    System.out.println("Bubble sort");
                    Algorithm.BubbleSort(a);
                } else if ( choice == 4) {
                    a = Algorithm.Read_file();
                    System.out.println("Selection sort");
                    Algorithm.SelectionSort(a);
                } else if ( choice == 5) {
                    a = Algorithm.Read_file();
                    System.out.println("Insertion sort");
                    Algorithm.InsertionSort(a);
                } else if ( choice == 6) {
                    a = Algorithm.Read_file();
                    System.out.print("Linear Search\nInput value: ");
                    float value = s.nextFloat();
                    Algorithm.Search(a, value);
                } else if ( choice == 7) {
                    a = Algorithm.Read_file();
                    System.out.print("Binary Search\nInput value: ");
                    float value = s.nextFloat();
                    int result = Algorithm.binarySearch(a, 0, a.length - 1, value);
                    if (result == -1) {
                        System.out.println("Index of first element not found.");
                    } else {
                        System.out.println("Index of fist element: " + result);
                    }
                } else {
                    System.out.println("**Try again.**");
                }
            }  else {
                System.out.println("**Please enter an integer!**");
                s.next();
            }
        }
    }
}

