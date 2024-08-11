import java.util.Arrays;

public class DijkstraSSSP {
    static final double INF = 99999;

    // Method to find the vertex with the minimum distance value
    static int minDistance(double[] dist, boolean[] S, int n) {
        double min = INF;
        int minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!S[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Method that implements Dijkstra's single source shortest path algorithm
    static void shortestPaths(double[][] cost, int v, int n) {
        double[] dist = new double[n];
        boolean[] S = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(S, false);

        dist[v] = 0.0;

        for (int i = 0; i < n; i++) {
            if (i != v) {
                dist[i] = cost[v][i];
            }
        }

        S[v] = true;

        for (int count = 1; count < n - 1; count++) {
            int u = minDistance(dist, S, n);
            S[u] = true;

            for (int w = 0; w < n; w++) {
                if (!S[w] && cost[u][w] != INF && dist[u] != INF && dist[u] + cost[u][w] < dist[w]) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }

        printSolution(dist, n);
    }

    // Method to print the shortest distance array
    static void printSolution(double[] dist, int n) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    // Driver method
    public static void main(String[] args) {
        int n = 5;
        int v = 0;

        // Input 1
        double[][] cost1 = {
            {0, 10, 3, INF, INF},
            {INF, 0, 1, 2, INF},
            {INF, 4, 0, 8, 2},
            {INF, INF, INF, 0, 7},
            {INF, INF, INF, 9, 0}
        };

        System.out.println("Input 1:");
        shortestPaths(cost1, v, n);

        // Input 2
        double[][] cost2 = {
            {0, 6, INF, INF, 7},
            {INF, 0, 5, 10, INF},
            {INF, INF, 0, 3, INF},
            {INF, INF, INF, 0, 4},
            {INF, INF, 2, INF, 0}
        };

        System.out.println("\nInput 2:");
        shortestPaths(cost2, v, n);

        // Input 3
        double[][] cost3 = {
            {0, 2, INF, 1, INF},
            {INF, 0, 3, INF, 10},
            {4, INF, 0, 6, INF},
            {INF, INF, INF, 0, 2},
            {INF, INF, INF, INF, 0}
        };

        System.out.println("\nInput 3:");
        shortestPaths(cost3, v, n);
    }
}
