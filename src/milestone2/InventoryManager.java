package milestone2;

import data.StockFromCSV;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

// Inventory manager to handle motorcycle inventory using LinkedList
public class InventoryManager {
    /**
     * Constructor to initialize inventory
     *
     * 1. Initializes LinkedList to store motorcycles
     * 2. Initializes HashMap to index motorcycles by engine number
     * 3. Loops through initialStock:
     *      - Adds each motorcycle to LinkedList
     *      - Adds each motorcycle to HashMap for fast search/delete
     */
    private LinkedList<StockFromCSV> inventory;
    // HashMap provides fast search and deletion by engine number (O(1))
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
     * Adds a new motorcycle to the inventory.
     *
     * Steps:
     * 1. Append newStock to the LinkedList (used for display and sorting)
     * 2. Add newStock to engineIndex HashMap using engineNumber as the key
     *    (enables constant-time search and deletion by engine number)
     * 3. Prints the time taken for the add operation
     *
     * Note: The method no longer returns a boolean. All motorcycles are
     * tracked in both the LinkedList and HashMap to maintain performance
     * and data consistency.
     */
    // Add new stock to inventory
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
     * which is a major improvement over linear search.
     */
    // Delete stock by car engine number
    public boolean deleteStock(String engineNumber) {
        long start = System.nanoTime();

        StockFromCSV toDelete = engineIndex.get(engineNumber);
        boolean deleted = false;

        if (toDelete != null) {
            inventory.remove(toDelete);
            deleted = true;
        }

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Delete operation completed in %.4f milliseconds\n", time);

        return deleted;
    }


    /**
     * Sorts the inventory alphabetically by brand.
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
     * especially for large inventories.
     */
    // Sort inventory by brand alphabetically
    // I need to convert to array first since LinkedList doesn't support direct sorting
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
     * Can search by: brand, engineNumber, status, or stockLabel
     * Returns list of all matching motorcycles
     *
     * Algorithm:
     * 1. create empty ArrayList for results
     *
     * 2. check if inventory is empty:
     *    if inventory.isEmpty():
     *        print message
     *        return empty list
     *
     * 3. search through LinkedList:
     *    for each motorcycle in inventory:
     *
     *        if searchBy equals "brand":
     *            if motorcycle.getBrand() equals value:
     *                add motorcycle to results
     *
     *        else if searchBy equals "engineNumber":
     *            if motorcycle.getEngineNumber() equals value:
     *                add motorcycle to results
     *
     *        else if searchBy equals "status":
     *            if motorcycle.getStatus() equals value:
     *                add motorcycle to results
     *
     *        else if searchBy equals "stockLabel":
     *            if motorcycle.getStockLabel() equals value:
     *                add motorcycle to results
     *
     * 4. check results:
     *    if results is empty:
     *        print "no matches found"
     *    else:
     *        print number of matches found
     *
     * 5. return results list
     */
    // Search inventory by field (brand, engine number, or status)
    public List<StockFromCSV> search(String field, String value) {
        long start = System.nanoTime();

        List<StockFromCSV> results = new ArrayList<>();

        // check each item in inventory
        for (StockFromCSV stock : inventory) {
            boolean match = false;

            switch (field.toLowerCase()) {
                case "brand":
                    match = stock.getBrand().equalsIgnoreCase(value);
                    break;
                case "enginenumber":
                    // Look up motorcycle directly in HashMap (O(1))
                    StockFromCSV found = engineIndex.get(value);
                    if (found != null) {
                        results.add(found);
                    }
                    // Return early since HashMap gives exact match
                    long end = System.nanoTime();
                    double time = (end - start) / 1_000_000.0;
                    System.out.printf("Search operation completed in %.4f milliseconds (Found %d result(s))\n",
                            time, results.size());
                    return results;
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