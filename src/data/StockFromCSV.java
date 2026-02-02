package data;

import java.util.ArrayList;
import java.util.List;

public class StockFromCSV {
    private String entryDate;
    private String status;
    private String brand;
    private String engineNumber;
    private String purchaseStatus;

    public StockFromCSV(String entryDate, String status, String brand,
                      String engineNumber, String purchaseStatus) {
        this.entryDate = entryDate;
        this.status = status;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.purchaseStatus = purchaseStatus;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public static List<StockFromCSV> loadFromCSV() {
        List<StockFromCSV> motorcycles = new ArrayList<>();
        List<String[]> csvData = CSVReader.readCSV();

        for (String[] row : csvData) {
            if (row.length >= 5) {
                motorcycles.add(new StockFromCSV(
                        row[0].trim(),
                        row[1].trim(),
                        row[2].trim(),
                        row[3].trim(),
                        row[4].trim()
                ));
            }
        }

        return motorcycles;
    }
}
/**
 * StockFromCSV - represents one motorcycle in inventory
 * We Based this on MotorPH Inventory Data Layout
 *
 *
 * PSEUDOCODE:
 *
 * Step 1: Declare private fields based on CSV columns
 *         entryDate (String) - when the stock came in, format: M/D/YYYY
 *         status (String) - "Old" or "New" stock
 *         brand (String) - Honda, Yamaha, Kawasaki, Suzuki, or Kymco
 *         engineNumber (String) - unique ID for each motorcycle
 *         purchaseStatus (String) - "On-hand" or "Sold"
 *
 * Step 2: Create constructor that accepts all 5 fields as parameters
 *         assign each parameter to corresponding field:
 *             this.entryDate = entryDate
 *             this.status = status
 *             this.brand = brand
 *             this.engineNumber = engineNumber
 *             this.purchaseStatus = purchaseStatus
 *
 * Step 3: Create getter methods to retrieve field values
 *         getEntryDate() returns entryDate
 *         getStatus() returns status
 *         getBrand() returns brand
 *         getEngineNumber() returns engineNumber
 *         getPurchaseStatus() returns purchaseStatus
 *
 * Step 4: Create setter methods to update field values
 *         setEntryDate(String) updates entryDate
 *         setStatus(String) updates status
 *         setBrand(String) updates brand
 *         setEngineNumber(String) updates engineNumber
 *         setPurchaseStatus(String) updates purchaseStatus
 *
 * Step 5: Create loadFromCSV() static method to read motorcycles from file
 *         Step 5.1: create empty ArrayList for motorcycles
 *
 *         Step 5.2: call CSVReader to get data
 *                   csvData = CSVReader.readCSV()
 *
 *         Step 5.3: loop through each row in csvData
 *                   for each row:
 *                       if row has at least 5 columns:
 *                           extract and trim values from row[0] to row[4]
 *                           create new StockFromCSV object with these values
 *                           add object to motorcycles list
 *
 *         Step 5.4: return the motorcycles list
 */