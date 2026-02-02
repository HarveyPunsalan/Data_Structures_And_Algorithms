import data.StockFromCSV;
import milestone1.InventoryManager;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Loading inventory from CSV...");
        List<StockFromCSV> initialStock = StockFromCSV.loadFromCSV();

        InventoryManager manager = new InventoryManager(initialStock);
        System.out.println("Loaded " + manager.getInventorySize() + " motorcycles from CSV.");
        System.out.println("========================================\n");

        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addStock(scanner, manager);
                    break;
                case 2:
                    deleteStock(scanner, manager);
                    break;
                case 3:
                    sortByBrand(manager);
                    break;
                case 4:
                    searchStock(scanner, manager);
                    break;
                case 5:
                    displayAll(manager);
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using MotorPH Inventory System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-6.\n");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   MotorPH Inventory Management System ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Add New Stock");
        System.out.println("2. Delete Stock");
        System.out.println("3. Sort by Brand");
        System.out.println("4. Search Stock");
        System.out.println("5. Display All Stock");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    private static void addStock(Scanner scanner, InventoryManager manager) {
        System.out.println("\n--- Add New Stock ---");

        System.out.print("Entry Date (M/D/YYYY): ");
        String entryDate = scanner.nextLine();

        System.out.print("Stock Label (Old/New): ");
        String status = scanner.nextLine();

        System.out.print("Brand (Honda/Yamaha/Kawasaki/Suzuki/Kymco): ");
        String brand = scanner.nextLine();

        System.out.print("Engine Number: ");
        String engineNumber = scanner.nextLine();

        System.out.print("Purchase Status (On-hand/Sold): ");
        String purchaseStatus = scanner.nextLine();

        StockFromCSV newStock = new StockFromCSV(entryDate, status, brand,
                engineNumber, purchaseStatus);
        manager.addStock(newStock);

        System.out.println("Stock added successfully!\n");
    }

    private static void deleteStock(Scanner scanner, InventoryManager manager) {
        System.out.println("\n--- Delete Stock ---");
        System.out.print("Enter Engine Number to delete: ");
        String engineNumber = scanner.nextLine();

        boolean deleted = manager.deleteStock(engineNumber);

        if (deleted) {
            System.out.println("Stock deleted successfully!\n");
        } else {
            System.out.println("❌ Stock not found!\n");
        }
    }

    private static void sortByBrand(InventoryManager manager) {
        System.out.println("\n--- Sorting Inventory by Brand ---");
        manager.sortByBrand();
        System.out.println("Inventory sorted by brand!\n");

        displayAll(manager);
    }

    private static void searchStock(Scanner scanner, InventoryManager manager) {
        System.out.println("\n--- Search Stock ---");
        System.out.println("Search by:");
        System.out.println("1. Brand");
        System.out.println("2. Engine Number");
        System.out.println("3. Purchase Status");
        System.out.print("Enter choice: ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        String field = "";
        String value = "";

        switch (searchChoice) {
            case 1:
                field = "brand";
                System.out.print("Enter Brand: ");
                value = scanner.nextLine();
                break;
            case 2:
                field = "engineNumber";
                System.out.print("Enter Engine Number: ");
                value = scanner.nextLine();
                break;
            case 3:
                field = "purchaseStatus";
                System.out.print("Enter Status (On-hand/Sold): ");
                value = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid choice!\n");
                return;
        }

        List<StockFromCSV> results = manager.search(field, value);

        if (results.isEmpty()) {
            System.out.println("No results found!\n");
        } else {
            System.out.println("\n✅ Found " + results.size() + " result(s):");
            System.out.println("─".repeat(100));
            System.out.printf("%-15s %-12s %-12s %-20s %-15s\n",
                    "Entry Date", "Stock Label", "Brand", "Engine Number", "Status");
            System.out.println("─".repeat(100));

            for (StockFromCSV stock : results) {
                System.out.printf("%-15s %-12s %-12s %-20s %-15s\n",
                        stock.getEntryDate(),
                        stock.getStatus(),
                        stock.getBrand(),
                        stock.getEngineNumber(),
                        stock.getPurchaseStatus());
            }
            System.out.println("─".repeat(100) + "\n");
        }
    }

    private static void displayAll(InventoryManager manager) {
        System.out.println("\n--- All Inventory ---");
        List<StockFromCSV> allStock = manager.getAllStock();

        if (allStock.isEmpty()) {
            System.out.println("Inventory is empty!\n");
            return;
        }

        System.out.println("Total Stock: " + allStock.size());
        System.out.println("─".repeat(100));
        System.out.printf("%-15s %-12s %-12s %-20s %-15s\n",
                "Entry Date", "Stock Label", "Brand", "Engine Number", "Status");
        System.out.println("─".repeat(100));

        for (StockFromCSV stock : allStock) {
            System.out.printf("%-15s %-12s %-12s %-20s %-15s\n",
                    stock.getEntryDate(),
                    stock.getStatus(),
                    stock.getBrand(),
                    stock.getEngineNumber(),
                    stock.getPurchaseStatus());
        }
        System.out.println("─".repeat(100) + "\n");
    }
}