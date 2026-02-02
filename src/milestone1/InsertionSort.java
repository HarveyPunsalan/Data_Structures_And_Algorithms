package milestone1;

import data.StockFromCSV;

/**
 * SORT BY BRAND - using insertion sort
 *
 * Why this approach:
 * - inventory is stored in LinkedList
 * - insertion sort needs array indexing (array[i])
 * - LinkedList doesn't support efficient indexing
 * - solution: convert temporarily to array
 *
 *
 * PSEUDOCODE:
 *
 * Step 1: Convert LinkedList to Array
 *         Step 1.1: get inventory size
 *                   n = inventory.size()
 *
 *         Step 1.2: create array of that size
 *                   array = new StockFromCSV[n]
 *
 *         Step 1.3: copy each motorcycle from LinkedList to array
 *                   index = 0
 *                   for each stock in inventory:
 *                       array[index] = stock
 *                       index = index + 1
 *
 * Step 2: Sort the array using Insertion Sort algorithm
 *         Step 2.1: start loop from position 1 (position 0 already sorted)
 *                   for i = 1 to array.length - 1:
 *
 *         Step 2.2: save current motorcycle as key
 *                   key = array[i]
 *
 *         Step 2.3: initialize comparison position
 *                   j = i - 1
 *
 *         Step 2.4: find correct position for key
 *                   while j >= 0 and array[j].brand > key.brand:
 *                       shift array[j] one position to the right
 *                       array[j + 1] = array[j]
 *                       move j back: j = j - 1
 *
 *         Step 2.5: insert key at correct position
 *                   array[j + 1] = key
 *
 *         Note: brand comparison uses compareToIgnoreCase()
 *               if result > 0, first brand comes after second alphabetically
 *
 * Step 3: Convert sorted array back to LinkedList
 *         Step 3.1: clear the current LinkedList
 *                   inventory.clear()
 *
 *         Step 3.2: add sorted motorcycles back
 *                   for each stock in array:
 *                       inventory.add(stock)
 *
 * Step 4: Inventory is now sorted alphabetically by brand
 *
 *
 * Example walkthrough:
 * Initial: [Yamaha, Honda, Kawasaki, Honda, Suzuki]
 *
 * i=1: key=Honda, Yamaha > Honda, shift Yamaha right, insert Honda at position 0
 *      Result: [Honda, Yamaha, Kawasaki, Honda, Suzuki]
 *
 * i=2: key=Kawasaki, insert between Honda and Yamaha
 *      Result: [Honda, Kawasaki, Yamaha, Honda, Suzuki]
 *
 * i=3: key=Honda, insert after first Honda
 *      Result: [Honda, Honda, Kawasaki, Yamaha, Suzuki]
 *
 * i=4: key=Suzuki, insert before Yamaha
 *      Final: [Honda, Honda, Kawasaki, Suzuki, Yamaha]
 */

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
}
