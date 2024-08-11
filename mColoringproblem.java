public class mColoringproblem {
    final static int V = 4;
    static int color[];

    static boolean isSafe(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    static boolean graphColoringUtil(int graph[][], int m, int color[], int v) {
        if (v == V)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;

                color[v] = 0;
            }
        }

        return false;
    }

    static boolean graphColoring(int graph[][], int m) {
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(color);
        return true;
    }

    static void printSolution(int color[]) {
        System.out.println("Assigned colors are:");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int graph1[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 }
        };
        int m1 = 3;
        System.out.println("Graph 1:");
        graphColoring(graph1, m1);

        int graph2[][] = {
            { 0, 1, 1, 0 },
            { 1, 0, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 1, 0 }
        };
        int m2 = 3;
        System.out.println("Graph 2:");
        graphColoring(graph2, m2);

        int graph3[][] = {
            { 0, 1, 0, 1 },
            { 1, 0, 1, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 0 }
        };
        int m3 = 3;
        System.out.println("Graph 3:");
        graphColoring(graph3, m3);
    }
}
