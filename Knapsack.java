public class Knapsack {

    // Method to solve 0/1 Knapsack problem using dynamic programming
    public static int knapsack(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // Initialize the dp array with base cases
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = 0;
            }
        }

        // Fill the dp array according to the algorithm
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The maximum value that can be attained with the given capacity
        return dp[n][W];
    }

    // Driver method
    public static void main(String[] args) {
        // First input set
        int[] values1 = {60, 100, 120};
        int[] weights1 = {10, 20, 30};
        int W1 = 50; // Maximum capacity of knapsack
        int n1 = values1.length;
        System.out.println("Maximum value in Knapsack for Input 1 = " + knapsack(weights1, values1, n1, W1));

        // Second input set
        int[] values2 = {10, 40, 30, 50};
        int[] weights2 = {5, 4, 6, 3};
        int W2 = 10; // Maximum capacity of knapsack
        int n2 = values2.length;
        System.out.println("Maximum value in Knapsack for Input 2 = " + knapsack(weights2, values2, n2, W2));

        // Third input set
        int[] values3 = {70, 50, 30, 40};
        int[] weights3 = {10, 20, 30, 40};
        int W3 = 50; // Maximum capacity of knapsack
        int n3 = values3.length;
        System.out.println("Maximum value in Knapsack for Input 3 = " + knapsack(weights3, values3, n3, W3));
    }
}
