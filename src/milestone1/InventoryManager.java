package milestone1;

import data.StockFromCSV;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// Main inventory manager using LinkedList
public class InventoryManager {
    private LinkedList<StockFromCSV> inventory;

    public InventoryManager(List<StockFromCSV> initialStock) {
        inventory = new LinkedList<>();
        for (StockFromCSV stock : initialStock) {
            inventory.add(stock);
        }
    }

    // Add new stock to inventory
    public void addStock(StockFromCSV newStock) {
        long start = System.nanoTime();

        inventory.addLast(newStock);

        long end = System.nanoTime();
        double time = (end - start) / 1_000_000.0;

        System.out.printf("Add operation completed in %.4f milliseconds\n", time);
    }

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