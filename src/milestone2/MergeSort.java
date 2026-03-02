package milestone2;

import data.StockFromCSV;

public class MergeSort {

    /**
     * Public method to sort array of StockFromCSV by brand
     *
     * Steps:
     * 1. Check if array is null or has less than 2 elements
     * 2. If valid, call mergeSort to start recursive sorting
     */
    public static void sort(StockFromCSV[] array) {
        if (array == null || array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Recursive merge sort function
     *
     * Steps:
     * 1. If left >= right, return (base case - single element)
     * 2. Calculate middle index
     * 3. Recursively sort left half
     * 4. Recursively sort right half
     * 5. Merge the two sorted halves
     */
    private static void mergeSort(StockFromCSV[] array, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * Merge two sorted halves into one sorted array
     *
     * Steps:
     * 1. Calculate sizes of left and right subarrays
     * 2. Create temporary arrays for left and right halves
     * 3. Copy data to temporary arrays
     * 4. Merge temporary arrays back into original array:
     *      - Compare brands from both arrays
     *      - Place smaller brand first
     *      - Continue until one array is empty
     * 5. Copy remaining elements from left array (if any)
     * 6. Copy remaining elements from right array (if any)
     *
     * Note: Uses compareToIgnoreCase for case-insensitive comparison
     */
    private static void merge(StockFromCSV[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        StockFromCSV[] leftArr = new StockFromCSV[n1];
        StockFromCSV[] rightArr = new StockFromCSV[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++) leftArr[i] = array[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // merge arrays back into original
        while (i < n1 && j < n2) {
            if (leftArr[i].getBrand().compareToIgnoreCase(rightArr[j].getBrand()) <= 0) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }

        // copy remaining elements
        while (i < n1) array[k++] = leftArr[i++];
        while (j < n2) array[k++] = rightArr[j++];
    }
}
