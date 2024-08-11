public class BFS {
    static int[] visited;
    static int[] queue;
    static int front;
    static int rear;

    public static void main(String[] args) {
        // Sample graph initialization (graph and visited array should be set up before calling bfs)
        int numberOfVertices = 6; // Example size of the graph
        int[][] graph1;
        int[][] graph2;
        int[][] graph3;
        graph1 = new int[][]{
            {0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 0}
        };
        graph2 = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0}
        };
        graph3 = new int[][]{
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0}
        };

        // Run BFS for each graph with specified starting vertex
        System.out.print("BFS traversal of graph1 starting from vertex 0: ");
        bfs(0, graph1, numberOfVertices);
        System.out.println();

        System.out.print("BFS traversal of graph2 starting from vertex 2: ");
        bfs(2, graph2, numberOfVertices);
        System.out.println();

        System.out.print("BFS traversal of graph3 starting from vertex 3: ");
        bfs(3, graph3, numberOfVertices);
        System.out.println();
    }

    public static void bfs(int v, int[][] graph, int numberOfVertices) {
        visited = new int[numberOfVertices];
        queue = new int[numberOfVertices];
        front = 0;
        rear = -1;

        int u = v;
        visited[v] = 1;
        queue[++rear] = u;

        while (front <= rear) {
            u = queue[front++]; // Get first unexplored vertex
            System.out.print(u + " "); // Print the visited vertex
            
            for (int w = 0; w < graph.length; w++) {
                if (graph[u][w] == 1 && visited[w] == 0) {
                    queue[++rear] = w; // Add w to queue
                    visited[w] = 1;
                }
            }
        }
    }
}
