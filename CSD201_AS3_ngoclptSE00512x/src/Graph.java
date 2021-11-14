import java.util.*;
import java.io.*;

public class Graph {
    int [][] a;
    int n;
    ArrayList<Integer> listVisited;
    int[] visited;

    //file
    static File urlData = new File("E:\\Funix\\CSD201x\\CSD201x\\CSD201_AS3_ngoclptSE00512x\\src\\Matrix.txt");

    Graph() {
        n = 7;
        a = new int[n][n];
        listVisited = new ArrayList<>();
        visited = new int[n];
    }

    public void readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(urlData);
        Scanner scanner = new Scanner(fileInputStream);
        try {
            int k = 0;
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] subStr = str.split(";");

                if (subStr.length == n) {
                    for (int i = 0; i < n; i++) {
                        a[k][i] = Integer.parseInt(subStr[i]);
                    }
                }
                k++;
            }
        } finally{
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("Exception");
            }
        }
    }

    //option 9
    //print matrix from file
    public void printMatrix() throws IOException {
        readFile();
        System.out.println("Weight matrix: ");
        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%10d", a[i][j]);
            }
            System.out.println();
        }
    }

    //visit
    //print vertices according ABC
    public void visit(int i) {
        switch (i) {
            case 0 -> System.out.print("A");
            case 1 -> System.out.print("B");
            case 2 -> System.out.print("C");
            case 3 -> System.out.print("D");
            case 4 -> System.out.print("E");
            case 5 -> System.out.print("F");
            case 6 -> System.out.print("G");
        }
    }

    //print path according
    public void visitPath(int i) {
        switch(i) {
            case 0 -> System.out.print("A");
            case 1 -> System.out.print("->B");
            case 2 -> System.out.print("->C");
            case 3 -> System.out.print("->D");
            case 4 -> System.out.print("->E");
            case 5 -> System.out.print("->F");
            case 6 -> System.out.print("->G");
        }
    }

    //option 10 DFS
    //depth from vertices k
    //use recursion
    public void DFS(int k) {
        visited[k] = 1;
        listVisited.add(k);
        visit(k);
        for(int i = 0; i < n; i++) {
            if(a[k][i] > 0 && a[k][i] != 9999 && visited[i] != 1) {
                DFS(i);
            }
        }
    }

    //option 11 BFS
    //from vertices k
    public void BFS(int k) {
        System.out.print("BFS_Graph: ");
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[k] = true;
        queue.add(k);
        while(!queue.isEmpty()) {
            k = queue.poll();
            visit(k);
            for(int i = 0; i < n; i++) {
                if (a[k][i] != 9999 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    //option 12
    //dijkstra from A to E
    //the shortest distance
    public int minDistance(int[] array, Boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && array[i] <= min) {
                min = array[i];
                min_index = i;
            }
        }
        return min_index;
    }

    //The length of the shortest path
    void printPath(int current, int[] dist) {
        if(current == -1) {
            return;
        }
        printPath(dist[current], dist);
        visitPath(current);
    }

    //print result
    void printResult(int start, int end, int[] dist, int[] parent) {
        System.out.print("Vertex\t Distance \n");
        int result = 0;
        for(int vertexIndex = 0; vertexIndex < end + 1; vertexIndex++) {
            result = vertexIndex;
        }

        if(result != start && end < dist.length) {
            visit(start);
            visitPath(result);
            System.out.print("\t\t");
            System.out.println(dist[result]);
            System.out.print("Path: ");
            printPath(result, parent);
            System.out.println();
        }
    }

    //dijkstra
    public void dijkstra(int start, int end) {
        int[] dist = new int[n];
        int[] parent = new int[n]; //parent
        Boolean[] visited = new Boolean[n];
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[start] = 0;
        parent[start] = -1;

        for(int count = 0; count < n; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for(int v = 0; v < n; v++) {
                if(!visited[v] && a[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + a[u][v] < dist[v])

                {
                    dist[v] = dist[u] + a[u][v];
                    parent[v] = u;
                }
            }
        }
        //print result
        printResult(start, end, dist, parent);
    }
}
