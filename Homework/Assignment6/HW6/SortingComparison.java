package HW6;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author SHAO
 */
public class SortingComparison {
    public static void main(String[] args) {
        // Different input size
        int[] n = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};

        // Random array for n
        int randomArray[];

        // every sort algorithm's time array
        int[] insertionSortTime = new int[10];
        int[] mergeSortTime = new int[10];
        int[] quickSortTime = new int[10];
        int[] heapSortTime = new int[10];

        //Declare start, end and elaosed time
        long startTime, endTime, elapsedTime;

        // For each n input size
        for (int i = 0; i < 10; i++) {
            randomArray = new int[n[i]];
            for (int j = 0; j < n[i]; j++) {
                // Generate number randomly
                Random random = new Random();
                randomArray[j] = random.nextInt(1000000) + 1;
            }

            // Copy the random array every time
            int[] insertionData = Arrays.copyOf(randomArray, n[i]);
            int[] mergeData = Arrays.copyOf(randomArray, n[i]);
            int[] quickData = Arrays.copyOf(randomArray, n[i]);
            int[] heapData = Arrays.copyOf(randomArray, n[i]);

            // Do insert sort
            startTime = System.currentTimeMillis();
            insertionSort(insertionData);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            insertionSortTime[i] = (int) elapsedTime;

            // Do merge sort
            startTime = System.currentTimeMillis();
            mergeSort(mergeData, 0, mergeData.length - 1);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            mergeSortTime[i] = (int) elapsedTime;

            // Do quick sort
            startTime = System.currentTimeMillis();
            quickSort(quickData, 0, quickData.length - 1);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            quickSortTime[i] = (int) elapsedTime;

            // Do heap sort
            startTime = System.currentTimeMillis();
            heapSort(heapData);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            heapSortTime[i] = (int) elapsedTime;
        }

        // Print the table
        System.out.printf("%-12s%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7"
                + "d%n", "Algorithm", 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%-12s%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7"
                + "d%n", "insertion", insertionSortTime[0], insertionSortTime[1], insertionSortTime[2], insertionSortTime[3], insertionSortTime[4],
                insertionSortTime[5], insertionSortTime[6], insertionSortTime[7], insertionSortTime[8], insertionSortTime[9]);
        System.out.printf("%-12s%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7"
                + "d%n", "merge", mergeSortTime[0], mergeSortTime[1], mergeSortTime[2], mergeSortTime[3], mergeSortTime[4],
                mergeSortTime[5], mergeSortTime[6], mergeSortTime[7], mergeSortTime[8], mergeSortTime[9]);
        System.out.printf("%-12s%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7"
                + "d%n", "quick", quickSortTime[0], quickSortTime[1], quickSortTime[2], quickSortTime[3], quickSortTime[4],
                quickSortTime[5], quickSortTime[6], quickSortTime[7], quickSortTime[8], quickSortTime[9]);
        System.out.printf("%-12s%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7d%-7"
                + "d%n", "heap", heapSortTime[0], heapSortTime[1], heapSortTime[2], heapSortTime[3], heapSortTime[4],
                heapSortTime[5], heapSortTime[6], heapSortTime[7], heapSortTime[8], heapSortTime[9]);
    }

    /**
     * Insertion Sort resource: textbook
     *
     * @param: integer array
     */
    //Insertion-sort of an array of characters into nondecreasing order
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }
    }

    /**
     * Merge Sort resource: https://www.geeksforgeeks.org/merge-sort/
     *
     * @param: integer array, index of the first element, index of the last
     * element
     */
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * Merge two subarrays of array, first array[l...m], second[m+1....r]
     * resource: https://www.geeksforgeeks.org/merge-sort/
     *
     * @param: integer array, index of the first element, index of the middle
     * element, index of the last element
     */
    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Quick sort resource: https://www.geeksforgeeks.org/quick-sort/
     *
     * @param: integer array, index of the first element, index of the last
     * element
     *
     */
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is 
	            now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Quick sort resource: https://www.geeksforgeeks.org/quick-sort/
     *
     * @param: integer array, index of the first element, index of the last
     * element
     *
     */
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }

    /**
     * Heap Sort resource: https://www.geeksforgeeks.org/heap-sort/
     *
     * @param: integer array
     */
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Heap Sort resource: https://www.geeksforgeeks.org/heap-sort/
     *
     * @param: integer array, the size of array, index of the element
     */
    public static void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
