package milestone2;

import data.StockFromCSV;

public class MergeSort {
    // Public method to sort array of StockFromCSV by brand
    public static void sort(StockFromCSV[] array) {
        if (array == null || array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    // Recursive merge sort
    private static void mergeSort(StockFromCSV[] array, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    // Merge two sorted halves
    private static void merge(StockFromCSV[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        StockFromCSV[] leftArr = new StockFromCSV[n1];
        StockFromCSV[] rightArr = new StockFromCSV[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) leftArr[i] = array[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge arrays back into original
        while (i < n1 && j < n2) {
            if (leftArr[i].getBrand().compareToIgnoreCase(rightArr[j].getBrand()) <= 0) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) array[k++] = leftArr[i++];
        while (j < n2) array[k++] = rightArr[j++];
    }
}
