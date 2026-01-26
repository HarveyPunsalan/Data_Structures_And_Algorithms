package milestone1;

import data.StockFromCSV;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// Inventory manager to handle motorcycle inventory using LinkedList
public class InventoryManager {
    /**
     * Constructor to initialize inventory with data from CSV
     * Takes a list of motorcycles and loads them into LinkedList
     *
     * 1. create new LinkedList for inventory
     * 2. if initialData is not null:
     *    loop through each motorcycle in initialData
     *    add motorcycle to inventory LinkedList
     */
    private LinkedList<StockFromCSV> inventory;

    public InventoryManager(List<StockFromCSV> initialStock) {
        inventory = new LinkedList<>();
        for (StockFromCSV stock : initialStock) {
            inventory.add(stock);
        }
    }

    /**
     * Add new motorcycle to inventory
     * Takes a motorcycle object and adds it to the end of LinkedList
     * Returns true if successful, false if failed
     *
     * Algorithm:
     * 1. validate input:
     *    if motorcycle is null:
     *        print error message
     *        return false
     *
     * 2. add to LinkedList:
     *    inventory.addLast(motorcycle)
     *
     * 3. print success message
     *
     * 4. return true
     */
    // Add new stock to inventory
    public void addStock(StockFromCSV newStock) {
        long start = System.nanoTime();

        inventory.addLast(newStock);

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Add operation completed in %.4f milliseconds\n", time);
    }


    /**
     * Delete motorcycle from inventory by engine number
     * Searches through LinkedList and removes matching motorcycle
     * Returns true if deleted, false if not found
     *
     * Algorithm:
     * 1. check if inventory is empty:
     *    if inventory.isEmpty():
     *        print "inventory is empty"
     *        return false
     *
     * 2. search through LinkedList:
     *    for each motorcycle in inventory:
     *        if motorcycle.getEngineNumber() equals engineNumber:
     *            inventory.remove(motorcycle)
     *            print success message
     *            return true
     *
     * 3. if loop completes without finding:
     *    print "motorcycle not found"
     *    return false
     */
    // Delete stock by car engine number
    public boolean deleteStock(String engineNumber) {
        long start = System.nanoTime();

        StockFromCSV toDelete = LinearSearch.searchByEngineNumber(inventory, engineNumber);
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
     * Sort inventory alphabetically by brand
     * Converts LinkedList to Array, sorts it, then converts back
     *
     * Algorithm:
     * 1. check if inventory is empty:
     *    if inventory.isEmpty():
     *        print message and return
     *
     * 2. convert LinkedList to Array:
     *    get size of inventory
     *    create Motorcycle[] array of that size
     *    copy all motorcycles from LinkedList to array
     *
     * 3. insertion sort on array:
     *    for i = 1 to array.length - 1:
     *
     *        store current element:
     *        key = array[i]
     *        j = i - 1
     *
     *        shift elements greater than key to the right:
     *        while j >= 0 and array[j].getBrand() > key.getBrand():
     *            array[j + 1] = array[j]
     *            j = j - 1
     *
     *        insert key at correct position:
     *        array[j + 1] = key
     *
     * 4. convert sorted array back to LinkedList:
     *    clear inventory LinkedList
     *    for each motorcycle in sorted array:
     *        add motorcycle to inventory
     *
     * 5. print success message
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
        InsertionSort.sort(array);

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
                    match = stock.getEngineNumber().equalsIgnoreCase(value);
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