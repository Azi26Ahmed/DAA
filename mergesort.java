import java.util.Random;
public class mergesort{
    public static void main(String[] args) {
        Random r= new Random();
        int [] array = new int[10];
        for(int i=0;i<array.length;i++)
        {
            array[i]=r.nextInt(100);
        }
        System.out.println("Before Sorting:");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        Mergesort(array,0,array.length-1);
        System.out.println("After sorting:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
    static void Mergesort(int a[],int l,int h){
        if(l<h){
            int m=(l+h)/2;
            Mergesort(a, l, m);
            Mergesort(a, m+1, h);
            merge(a,l,m,h);
        }
    }
    static void merge(int[] a, int l, int m, int h) {
        int[] b = new int[h-l+1]; // Temporary array to store merged result
        int i = l, j = m + 1, k = 0;
    
        // Merge the two halves into the temporary array b[]
        while (i <= m && j <= h) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
    
        // Copy any remaining elements of the left half
        while (i <= m) {
            b[k] = a[i];
            i++;
            k++;
        }
    
        // Copy any remaining elements of the right half
        while (j <= h) {
            b[k] = a[j];
            j++;
            k++;
        }
    
        // Copy the merged elements back to the original array
        for (i = 0; i < b.length; i++) {
            a[l + i] = b[i];
        }
    }
    
    }
    
