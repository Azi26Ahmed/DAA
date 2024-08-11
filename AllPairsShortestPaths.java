public class AllPairsShortestPaths {

    public static void allPairsShortestPaths(int[][] cost, int[][] A, int n) {
        // Initialize the A matrix with the cost matrix values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = cost[i][j];
            }
        }

        // Applying Floyd-Warshall algorithm to compute all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example inputs
        int INF = 99999; // Define infinity value

        // First input set
        int[][] cost1 = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };
        int n1 = cost1.length;
        int[][] A1 = new int[n1][n1];
        allPairsShortestPaths(cost1, A1, n1);
        System.out.println("All-pairs shortest paths for Input 1:");
        printMatrix(A1);

        // Second input set
        int[][] cost2 = {
            {0, INF, 3, INF},
            {2, 0, INF, INF},
            {INF, 7, 0, 1},
            {6, INF, INF, 0}
        };
        int n2 = cost2.length;
        int[][] A2 = new int[n2][n2];
        allPairsShortestPaths(cost2, A2, n2);
        System.out.println("All-pairs shortest paths for Input 2:");
        printMatrix(A2);

        // Third input set
        int[][] cost3 = {
            {0, 4, 11},
            {6, 0, 2},
            {3, INF, 0}
        };
        int n3 = cost3.length;
        int[][] A3 = new int[n3][n3];
        allPairsShortestPaths(cost3, A3, n3);
        System.out.println("All-pairs shortest paths for Input 3:");
        printMatrix(A3);
    }

    // Utility method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == 99999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }
}
