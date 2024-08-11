public class DFS {
    private static boolean[] visited;

    public static void main(String[] args) {
        int numberOfVertices = 6;
        int[][] graph1;
        int[][] graph2;
        int[][] graph3;
        graph1 = new int[][]{
            {0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 0},
        };
        
        graph2 = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0},
        };
        
        graph3 = new int[][]{
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
        };

        System.out.print("DFS traversal of graph1 starting from vertex 0: ");
        visited = new boolean[numberOfVertices];
        dfs(0, graph1);
        System.out.println();

        System.out.print("DFS traversal of graph2 starting from vertex 2: ");
        visited = new boolean[numberOfVertices];
        dfs(2, graph2);
        System.out.println();

        System.out.print("DFS traversal of graph3 starting from vertex 3: ");
        visited = new boolean[numberOfVertices];
        dfs(3, graph3);
        System.out.println();
    }

    public static void dfs(int v, int[][] graph) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for (int w = 0; w < graph.length; w++) {
            if (graph[v][w] == 1 && !visited[w]) {
                dfs(w, graph);
            }
        }
    }
}
