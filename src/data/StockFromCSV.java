package data;

import java.util.ArrayList;
import java.util.List;

public class StockFromCSV {
    private String brand;
    private String model;
    private double price;
    // Add more fields as needed

    // Constructor
    public StockFromCSV(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;

    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Static method to load all motorcycles from CSV
    public static List<StockFromCSV> loadFromCSV() {
        List<StockFromCSV> motorcycles = new ArrayList<>();
        List<String[]> csvData = CSVReader.readCSV();  // ← No parameter needed now!

        for (String[] row : csvData) {
            // Make sure row has enough columns to avoid ArrayIndexOutOfBoundsException
            if (row.length >= 3) {
                String brand = row[0].trim();
                String model = row[1].trim();
                double price = Double.parseDouble(row[2].trim());

                motorcycles.add(new StockFromCSV(brand, model, price));
            }
        }

        return motorcycles;
    }

    @Override
    public String toString() {
        return "Motorcycle{brand='" + brand + "', model='" + model + "', price=" + price + "}";
    }
}
