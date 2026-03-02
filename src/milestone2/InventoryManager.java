package milestone2;

import data.StockFromCSV;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryManager {

    /**
     * Constructor to initialize inventory with data
     *
     * 1. Initializes LinkedList to store motorcycles
     * 2. Initializes HashMap to index motorcycles by engine number
     * 3. Loops through initialStock:
     *      - Adds each motorcycle to LinkedList
     *      - Adds each motorcycle to HashMap for fast search/delete
     */
    private LinkedList<StockFromCSV> inventory;
    private HashMap<String, StockFromCSV> engineIndex;

    public InventoryManager(List<StockFromCSV> initialStock) {
        inventory = new LinkedList<>();
        engineIndex = new HashMap<>();

        for (StockFromCSV stock : initialStock) {
            inventory.add(stock);
            engineIndex.put(stock.getEngineNumber(), stock);
        }
    }

    /**
     * Adds a new motorcycle to the inventory
     *
     * Steps:
     * 1. Append newStock to the LinkedList (used for display and sorting)
     * 2. Add newStock to engineIndex HashMap using engineNumber as the key
     *    (enables constant-time search and deletion by engine number)
     * 3. Prints the time taken for the add operation
     *
     * Note: Both LinkedList and HashMap are updated to maintain
     * performance and data consistency
     */
    public void addStock(StockFromCSV newStock) {
        long start = System.nanoTime();

        inventory.addLast(newStock);
        engineIndex.put(newStock.getEngineNumber(), newStock);

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Add operation completed in %.4f milliseconds\n", time);
    }

    /**
     * Deletes a motorcycle from inventory by engine number
     *
     * Steps:
     * 1. Look up motorcycle in engineIndex HashMap by engine number (O(1))
     * 2. If found:
     *      - Remove from LinkedList
     *      - Remove from HashMap
     *      - Return true
     * 3. If not found, return false
     * 4. Prints operation time
     *
     * Note: Using HashMap allows deletion in constant time,
     * which is a major improvement over linear search
     */
    public boolean deleteStock(String engineNumber) {
        long start = System.nanoTime();

        StockFromCSV toDelete = engineIndex.get(engineNumber);
        boolean deleted = false;

        if (toDelete != null) {
            inventory.remove(toDelete);
            engineIndex.remove(engineNumber);
            deleted = true;
        }

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Delete operation completed in %.4f milliseconds\n", time);

        return deleted;
    }

    /**
     * Sorts the inventory alphabetically by brand
     *
     * Steps:
     * 1. Convert LinkedList to array for easier indexing
     * 2. Sort the array using Merge Sort (O(n log n), stable)
     *    - Uses recursion to divide array
     *    - Merges sorted subarrays
     * 3. Convert sorted array back to LinkedList
     * 4. Prints operation time
     *
     * Note: Merge Sort improves performance over Insertion Sort,
     * especially for large inventories
     */
    public void sortByBrand() {
        long start = System.nanoTime();

        // convert linkedlist to array
        StockFromCSV[] array = new StockFromCSV[inventory.size()];
        int i = 0;
        for (StockFromCSV stock : inventory) {
            array[i++] = stock;
        }

        // sort the array
        MergeSort.sort(array);

        // put sorted items back to linkedlist
        inventory.clear();
        for (StockFromCSV stock : array) {
            inventory.add(stock);
        }

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Sort operation completed in %.4f milliseconds\n", time);
    }

    /**
     * Search for motorcycles by specific criteria
     *
     * Steps:
     * 1. If searching by engine number:
     *      - Use HashMap for O(1) direct lookup
     *      - Add to results if found
     *      - Return results immediately
     *
     * 2. For other fields (brand, purchase status):
     *      - Loop through LinkedList
     *      - Compare each motorcycle's field with search value
     *      - Add matches to results list
     *
     * 3. Print operation time and number of results found
     * 4. Return results list
     *
     * Note: Engine number search is O(1) using HashMap,
     * while other searches are O(n) using sequential search
     */
    public List<StockFromCSV> search(String field, String value) {
        long start = System.nanoTime();
        List<StockFromCSV> results = new ArrayList<>();

        // if searching by engine number, use HashMap
        if (field.equalsIgnoreCase("engineNumber")) {
            StockFromCSV found = engineIndex.get(value);
            if (found != null) {
                results.add(found);
            }

            long end = System.nanoTime();
            double time = (end - start) / 1_000_000.0;
            System.out.printf("Search operation completed in %.4f milliseconds (Found %d result(s))\n",
                    time, results.size());
            return results;
        }

        // for other fields, search through LinkedList
        for (StockFromCSV stock : inventory) {
            boolean match = false;

            switch (field.toLowerCase()) {
                case "brand":
                    match = stock.getBrand().equalsIgnoreCase(value);
                    break;
                case "purchasestatus":
                    match = stock.getPurchaseStatus().equalsIgnoreCase(value);
                    break;
            }

            if (match) {
                results.add(stock);
            }
        }

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Search operation completed in %.4f milliseconds (Found %d result(s))\n",
                time, results.size());

        return results;
    }

    // get all inventory items
    public List<StockFromCSV> getAllStock() {
        return new ArrayList<>(inventory);
    }

    public int getInventorySize() {
        return inventory.size();
    }
}