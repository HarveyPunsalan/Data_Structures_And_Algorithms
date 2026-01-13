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