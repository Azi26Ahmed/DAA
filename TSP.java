class TSP {
    static final int INF = Integer.MAX_VALUE;
    int[][] graph;
    boolean[] visited;
    int V;
    int minCost;
    int[] bestPath;
    int[] currentPath;

    TSP(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.visited = new boolean[V];
        this.minCost = INF;
        this.bestPath = new int[V + 1];
        this.currentPath = new int[V + 1];
    }

    void tsp(int currentPosition, int count, int cost) {
        if (count == V && graph[currentPosition][0] > 0) {
            int totalCost = cost + graph[currentPosition][0];
            if (totalCost < minCost) {
                minCost = totalCost;
                System.arraycopy(currentPath, 0, bestPath, 0, V);
                bestPath[V] = 0;
            }
            return;
        }

        for (int v = 1; v < V; v++) {
            if (!visited[v] && graph[currentPosition][v] > 0) {
                visited[v] = true;
                currentPath[count] = v;
                tsp(v, count + 1, cost + graph[currentPosition][v]);
                visited[v] = false;
            }
        }
    }

    void findBestPath() {
        visited[0] = true;
        currentPath[0] = 0;
        tsp(0, 1, 0);
        printSolution();
    }

    void printSolution() {
        if (minCost == INF) {
            System.out.println("Solution does not exist");
        } else {
            System.out.println("Minimum cost: " + minCost);
            System.out.print("Path: ");
            for (int i = 0; i <= V; i++) {
                System.out.print(bestPath[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int[][] graph2 = {
            {0, 29, 20, 21},
            {29, 0, 15, 17},
            {20, 15, 0, 28},
            {21, 17, 28, 0}
        };

        int[][] graph3 = {
            {0, 10, 15, 20, 25},
            {10, 0, 35, 25, 30},
            {15, 35, 0, 30, 20},
            {20, 25, 30, 0, 15},
            {25, 30, 20, 15, 0}
        };

        System.out.println("TSP for graph1:");
        new TSP(graph1).findBestPath();

        System.out.println("\nTSP for graph2:");
        new TSP(graph2).findBestPath();

        System.out.println("\nTSP for graph3:");
        new TSP(graph3).findBestPath();
    }
}
