# MotorPH Inventory System

Basic inventory management for MotorPH motorcycle shop. Made for DSA Milestone 1.

## What it does

- Add new motorcycles
- Delete motorcycles by engine number
- Sort by brand alphabetically
- Search by brand, engine number, or status

Loads 49 motorcycles from CSV when it starts. Everything runs in terminal.

## Tech used

**LinkedList** - main storage. Easy to add/remove without worrying about size.

**Insertion Sort** - yeah it's O(n²) but for 50 items it's fine. Converts LinkedList to array, sorts, then converts back.

**Linear Search** - just loops through everything. Works fine for this size.

Added execution time tracking to see how fast operations run.

## Files
```
src/
├── Main.java                    - menu and user input
├── data/
│   ├── StockFromCSV.java       - motorcycle data model
│   └── CSVReader.java          - reads CSV file
└── milestone1/
    ├── InventoryManager.java   - main logic (uses LinkedList)
    ├── InsertionSort.java      - sorting algorithm
    └── LinearSearch.java       - search algorithm
```

## Running it
```bash
javac Main.java
java Main
```

Pick from menu options 1-6.

## Sample output
```
Entry Date: 3/8/2023
Brand: Honda
Engine Number: ABC123
⏱️  Add operation completed in 0.7241 milliseconds
✅ Stock added successfully!
```
```
Enter Brand: Honda
⏱️  Search operation completed in 0.5432 milliseconds (Found 12 result(s))
```

## Performance

Tested with 49 motorcycles:
- Add: ~0.7ms
- Delete: ~2.8ms (has to search first)
- Sort: ~1-3ms
- Search: ~0.5ms

## Known issues

- Doesn't save changes back to CSV
- No input validation

## Requirements met

- ✅ Add stocks
- ✅ Delete stocks
- ✅ Sort by brand
- ✅ Search inventory

Built with Java 21 in IntelliJ IDEA.
