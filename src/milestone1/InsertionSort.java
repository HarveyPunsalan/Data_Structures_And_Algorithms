package milestone1;

import data.StockFromCSV;

// Insertion sort for sorting motorcycles by brand
// Works like sorting playing cards - pick one card at a time and put it in the right spot
public class InsertionSort {

    /**
     * Sort array of motorcycles by brand
     * Takes an array and sorts it in place
     *
     * Algorithm:
     * 1. start from index 1 (assume first element is sorted)
     *
     * 2. for each position i from 1 to array.length - 1:
     *
     *    a. save current motorcycle:
     *       key = array[i]
     *
     *    b. initialize comparison index:
     *       j = i - 1
     *
     *    c. find correct position for key:
     *       while j >= 0 and array[j].getBrand() > key.getBrand():
     *
     *           shift element to the right:
     *           array[j + 1] = array[j]
     *
     *           move to previous element:
     *           j = j - 1
     *
     *    d. insert key in correct position:
     *       array[j + 1] = key
     *
     * 3. array is now sorted alphabetically
     */
    // sorts array alphabetically by brand name
    public static void sort(StockFromCSV[] array) {
        // start from index 1 because first item is already "sorted" by itself
        for (int i = 1; i < array.length; i++) {
            StockFromCSV key = array[i];
            int j = i - 1;

            // move elements that are greater than key one position ahead
            // compareToIgnoreCase returns positive if array[j] comes after key alphabetically
            while (j >= 0 && array[j].getBrand().compareToIgnoreCase(key.getBrand()) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            // put key in its correct spot
            array[j + 1] = key;
        }
    }

    // example with our actual motorcycle brands:
    // start with: Yamaha, Honda, Kawasaki, Honda, Suzuki
    //
    // pick Honda (2nd item) -> Yamaha comes after H, so shift Yamaha right -> Honda goes first
    // now: Honda, Yamaha, Kawasaki, Honda, Suzuki
    //
    // pick Kawasaki -> Yamaha comes after K, shift it -> Kawasaki goes between Honda and Yamaha
    // now: Honda, Kawasaki, Yamaha, Honda, Suzuki
    //
    // pick Honda (4th item) -> shift Yamaha and Kawasaki -> Honda goes after first Honda
    // now: Honda, Honda, Kawasaki, Yamaha, Suzuki
    //
    // pick Suzuki -> Yamaha comes after S, shift it -> Suzuki slots in before Yamaha
    // done: Honda, Honda, Kawasaki, Suzuki, Yamaha
}
