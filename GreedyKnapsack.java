import java.util.*;

class greedyKnapsack {
    public static void knapsack(float m, int n, float w[], float p[]) {
        float x[] = new float[n + 1];
        float totalWeight = 0;
        float totalProfit = 0;

        for (int i = 1; i <= n; i++) {
            if (totalWeight + w[i] <= m) {
                x[i] = 1.0f;
                totalWeight += w[i];
                totalProfit += p[i];
            } else {
                x[i] = (m - totalWeight) / w[i];
                totalProfit += x[i] * p[i];
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("x[" + i + "]: " + x[i]);
        }
        System.out.println("\nThe profit earned by given optimal solution is: " + totalProfit);
    }

    public static void sortObject(int n, float p[], float w[]) {
        float ratio[] = new float[n + 1];
        for (int i = 1; i <= n; i++) {
            ratio[i] = p[i] / w[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (ratio[j] < ratio[j + 1]) {
                    float temp1 = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp1;

                    float temp2 = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = temp2;

                    float temp3 = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = temp3;
                }
            }
        }
    }

    public static void main(String args[]) {
        Random rand = new Random();

        // Generate random number of objects (less than 5)
        int n = rand.nextInt(5) + 1; // Generates a random number between 1 and 4

        // Generate random knapsack capacity
        float m = rand.nextInt(50) + 10; // Generates a random number between 10 and 59

        // Initialize arrays for profits and weights
        float p[] = new float[n + 1];
        float w[] = new float[n + 1];

        // Generate random profits and weights for each object
        for (int i = 1; i <= n; i++) {
            p[i] = rand.nextInt(50) + 10; // Generates a random profit between 10 and 59
            w[i] = rand.nextInt(20) + 5;  // Generates a random weight between 5 and 24
        }

        sortObject(n, p, w);

        System.out.println("No. of objects: " + n);
        System.out.println("Knapsack capacity: " + m);
        System.out.print("Profits: ");
        for (int i = 1; i <= n; i++) 
            System.out.print(p[i]+" " );
        System.out.println();
        System.out.print("Weights: ");
        for (int i = 1; i <= n; i++) 
                System.out.print(w[i]+" " );
        System.out.println();
        System.out.println("\nThe optimal solution is:");
        knapsack(m, n, w, p);
    }
}
