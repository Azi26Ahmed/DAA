public class NQueens {
    int[] x; // Global array to store the positions of the queens

    // Method to check if a queen can be placed in the kth row and ith column
    boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false; // Two in the same column or same diagonal
            }
        }
        return true;
    }

    // Method to solve the N-Queens problem using backtracking
    void nQueens(int k, int n) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;
                if (k == n) {
                    printSolution(n);
                } else {
                    nQueens(k + 1, n);
                }
            }
        }
    }

    // Method to print the solution
    void printSolution(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    // Main method to initialize and solve the N-Queens problem for multiple inputs
    public static void main(String[] args) {
        int[] boardSizes = {1, 4, 6}; // Sizes of the chessboards

        for (int n : boardSizes) {
            System.out.println("Solving for " + n + "-Queens: ");
            NQueens queens = new NQueens();
            queens.x = new int[n + 1]; // Initialize the global array
            queens.nQueens(1, n); // Solve the N-Queens problem starting from the 1st row
            System.out.println();
        }
    }
}
