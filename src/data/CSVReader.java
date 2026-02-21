package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVReader {

    private CSVReader() {}

    static List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();

        try (InputStream inputStream = CSVReader.class.getClassLoader()
                .getResourceAsStream("march_2023_inventory.csv")) {

            if (inputStream == null) {
                System.err.println("Error: CSV file 'march_2023_inventory.csv' not found in resources folder!");
                return data;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return data;
        }

        return data;
    }
}