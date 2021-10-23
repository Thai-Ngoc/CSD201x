import java.io.*;
import java.util.*;

public class Algorithm {
    static float[] arr;
    static float[] b;

    static void display() {
        int i;
        for(i = 0; i < b.length;i++) {
            System.out.print("  " + b[i]);
        }
        System.out.println();
    }
    //==================================================

    // Swap element at position i with element at position k
    static void swap(int i, int k) {
        float x; x = b[i]; b[i] = b[k]; b[k] = x;
    }

//1. Write data from array to file

    public static void write_file(float[] a) {
        arr = new float[a.length];
        Scanner s = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("input.txt");
            for(int i = 0; i < a.length; i ++) {
                System.out.print( i+1 + ": ");
                float n = s.nextFloat();
                fw.write(n + " "); // Write string in FireWrite input
            }
            fw.close(); // Dong FireWriter
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

//2. Read data from file to array

    public static float[] Read_file() throws Exception {
        FileReader fr = new FileReader("input.txt");
        StringBuilder str = new StringBuilder();
        char []a = new char[60];
        fr.read(a); // return one character in ASCII
        for (char c : a) {
            str.append(c);  // Pass every character into string
        }
        for (int i = 0, j = 0; i < arr.length; i ++, j += 4) {
            arr[i] = Float.parseFloat(str.substring(j, j + 2)); // Cut String and pass String into float
        }
        fr.close();
        return arr;
    }

//3. Sort by Bubble Sort

    public static void BubbleSort(float[] a) {
        b = a; // assign a to b
        try {
            FileWriter fw = new FileWriter("output1.txt");
            for (int i = 0; i < b.length - 1; i ++) {
                for (int j = 1; j < b.length - i; j ++) {
                    if (b[j - 1] > b[j]) {
                        swap(j - 1, j); // Switch the value of two position in array
                    }
                }
                for (float v : b) {
                    fw.write(v + " "); // Write value of array in the output
                }
                fw.write("\n");
                display();
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

//4. Sort by Selection Sort

    public static void SelectionSort(float[] a) {
        b = a;
        try {
            FileWriter fw = new FileWriter("output2.txt");
            for (int i = 0; i < b.length -1; i ++) {
                for (int j = i + 1; j < b.length; j ++) {
                    if (b[i] > b[j] ) {
                        swap(i, j);
                    }
                }
                for (float v : b) {
                    fw.write(v + " "); // Write value of array in the output
                }
                fw.write("\n");
                display();
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

//5. Sort by Insertion Sort

    public static void InsertionSort(float[] a) {
        b = a;
        try {
            FileWriter fw = new FileWriter("output3.txt");
            for (int i = 0; i < b.length; i ++) {
                // choose a value to insert
                float valueToInsert = b[i];

                // choose position to insert
                int holePosition = i;

                // check the previous number is greater than the inserting value or not
                while (holePosition > 0 &&  a[holePosition - 1] > valueToInsert) {
                    a[holePosition] = a[holePosition - 1];
                    holePosition--;
                }

                if (holePosition != i) {
                    // insert element at the position chose
                    a[holePosition] = valueToInsert;
                }
                for (float v : b) {
                    fw.write(v + " "); // Write value of array in the output
                }
                fw.write("\n");
                display();
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

//6. Search by Linear Search algorithm:

    public static void Search(float[] a, float value) {
        b = a;
        try {
            FileWriter fw = new FileWriter("output4.txt");
            System.out.print("Chi so la: ");
            for (int i = 0; i < b.length; i ++) {
                if (b[i] > value) {
                    System.out.print(i + " ");
                    fw.write(i + " ");
                }
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

//7. Search by binary Search algorithm

    public static int binarySearch(float[] a, int l, int  r, float value) {
        b = a;
        for (int i = 0; i < b.length - 1; i ++) {
            for (int j = 1 ; j < b.length - i ; j ++) {
                if (b[j - 1] > b[j] ) {
                    swap(j - 1, j); // Switch values at 2 positions in array
                }
            }
        }
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is at the center
            if (b[mid] == value) {
                return mid;
            }
            // If  small element is at the center
            if (b[mid] > value) {
                return binarySearch(b, l, mid - 1, value);
            }

            return binarySearch(b, mid + 1, r, value);
        }

        // If element does not exist
        return -1;
    }
}
