package milestone1;

import data.StockFromCSV;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

// Linear search - just loops through the list and checks each item
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

    // search by any field - returns all matches
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