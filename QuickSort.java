import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        // Generate an array with 10 random elements
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // random integers between 0 and 99
        }

        System.out.println("Unsorted array: " + Arrays.toString(array));
        
        // Perform quick sort
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array around a pivot and get the pivot index
            int pivotIndex = partition(array, low, high);
            
            // Recursively sort elements before and after the partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivotValue = array[low];
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && array[left] <= pivotValue) {
                left++;
            }

            while (left <= right && array[right] >= pivotValue) {
                right--;
            }

            if (left > right) {
                break;
            }

            swap(array, left, right);
        }

        swap(array, low, right);

        return right;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
