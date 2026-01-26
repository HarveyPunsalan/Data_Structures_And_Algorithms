package milestone1;

import data.StockFromCSV;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// Linear search just loops through the list and checks each item
// Not the fastest but works fine for our inventory size
public class LinearSearch {

    // finds one motorcycle by engine number
    // returns null if not found
    public static StockFromCSV searchByEngineNumber(LinkedList<StockFromCSV> list, String engineNumber) {
        for (StockFromCSV stock : list) {
            if (stock.getEngineNumber().equalsIgnoreCase(engineNumber)) {
                return stock;
            }
        }
        return null;
    }

    /**
     * Search for motorcycles matching criteria
     * Takes LinkedList, field name to search, and value to match
     * Returns list of all motorcycles that match
     *
     * Algorithm:
     * 1. create empty ArrayList for storing results
     *
     * 2. loop through each motorcycle in inventory:
     *
     *    get field value based on searchBy:
     *    if searchBy equals "brand":
     *        currentValue = motorcycle.getBrand()
     *    else if searchBy equals "engineNumber":
     *        currentValue = motorcycle.getEngineNumber()
     *    else if searchBy equals "status":
     *        currentValue = motorcycle.getStatus()
     *    else if searchBy equals "stockLabel":
     *        currentValue = motorcycle.getStockLabel()
     *
     *    compare values:
     *    if currentValue equals value (ignore case):
     *        add motorcycle to results list
     *
     * 3. return results list (empty if no matches found)
     */

    // This search by any field and returns all that matches
    // can search by brand, engine number, status, etc
    public static List<StockFromCSV> searchByField(LinkedList<StockFromCSV> list, String field, String value) {
        List<StockFromCSV> results = new ArrayList<>();

        for (StockFromCSV stock : list) {
            boolean match = false;

            // check which field we're searching
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
                case "status":
                    match = stock.getStatus().equalsIgnoreCase(value);
                    break;
                case "entrydate":
                    match = stock.getEntryDate().equals(value);
                    break;
            }

            if (match) {
                results.add(stock);
            }
        }

        return results;
    }

    // how it works: say we're looking for all Honda motorcycles
    // we have: Yamaha, Honda, Kawasaki, Honda, Suzuki
    //
    // look at Yamaha -> not Honda, skip it
    // look at Honda -> yeah that's Honda, add it to results
    // look at Kawasaki -> nope, keep going
    // look at Honda -> found another one, add it too
    // look at Suzuki -> not Honda, skip
    //
    // end up with 2 Hondas in the results list
}