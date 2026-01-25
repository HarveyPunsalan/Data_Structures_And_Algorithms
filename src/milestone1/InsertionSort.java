package milestone1;

import data.StockFromCSV;

// Insertion sort for sorting motorcycles by brand
// Works like sorting playing cards - pick one card at a time and put it in the right spot
public class InsertionSort {

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
