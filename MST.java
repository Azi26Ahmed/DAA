import java.io.*;
import java.lang.*;
import java.util.*;

class MST {

    // A utility function to find the vertex with minimum key value,
    // from the set of vertices not yet included in MST
    int minKey(int key[], Boolean mstSet[], int V) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in parent[]
    void printMST(int parent[], int graph[][], int V) {
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total minimum cost: " + totalWeight);
    }

    // Function to construct and print MST for a graph represented using adjacency matrix representation
    void primMST(int graph[][], int V) {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];

        // To represent set of vertices included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first vertex in MST.
        // Make key 0 so that this vertex is picked as first vertex
        key[0] = 0;

        // First node is always root of MST
        parent[0] = -1;

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {

            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet, V);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non zero only for adjacent vertices of m mstSet[v] is false for
                // vertices not yet included in MST Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph, V);
    }

    public static void main(String[] args) {
        MST t = new MST();

        int[][] graph1 = { { 0, 2, 0, 6, 0 },
                           { 2, 0, 3, 8, 5 },
                           { 0, 3, 0, 0, 7 },
                           { 6, 8, 0, 0, 9 },
                           { 0, 5, 7, 9, 0 } };

        int[][] graph2 = { { 0, 1, 0, 0, 0, 0 },
                           { 1, 0, 2, 0, 3, 0 },
                           { 0, 2, 0, 4, 0, 0 },
                           { 0, 0, 4, 0, 5, 6 },
                           { 0, 3, 0, 5, 0, 7 },
                           { 0, 0, 0, 6, 7, 0 } };

        int[][] graph3 = { { 0, 9, 0, 0, 0, 0, 0, 0, 0 },
                           { 9, 0, 10, 0, 0, 0, 0, 0, 0 },
                           { 0, 10, 0, 1, 0, 0, 0, 0, 0 },
                           { 0, 0, 1, 0, 2, 3, 0, 0, 0 },
                           { 0, 0, 0, 2, 0, 4, 0, 0, 0 },
                           { 0, 0, 0, 3, 4, 0, 5, 0, 0 },
                           { 0, 0, 0, 0, 0, 5, 0, 6, 0 },
                           { 0, 0, 0, 0, 0, 0, 6, 0, 7 },
                           { 0, 0, 0, 0, 0, 0, 0, 7, 0 } };

        System.out.println("Graph 1:");
        t.primMST(graph1, graph1.length);

        System.out.println("\nGraph 2:");
        t.primMST(graph2, graph2.length);

        System.out.println("\nGraph 3:");
        t.primMST(graph3, graph3.length);
    }
}