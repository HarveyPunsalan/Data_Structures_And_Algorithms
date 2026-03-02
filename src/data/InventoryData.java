package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Alternative to CSV loading
 *
 */
public class InventoryData {

    /**
     * Load initial inventory without CSV dependency
     *
     * Steps:
     * 1. Create empty ArrayList
     * 2. Add StockFromCSV objects with hardcoded data
     *    - February old stocks
     *    - March new stocks
     * 3. Return the list
     */
    public static List<StockFromCSV> loadInitialInventory() {
        List<StockFromCSV> stockList = new ArrayList<>();

        // February old stocks
        stockList.add(new StockFromCSV("2/1/2023", "Old", "Honda", "142QVTSIUR", "On-hand"));
        stockList.add(new StockFromCSV("2/1/2023", "Old", "Honda", "PZCT1S00XE", "Sold"));
        stockList.add(new StockFromCSV("2/1/2023", "Old", "Honda", "4VBTV8YNM7", "Sold"));
        stockList.add(new StockFromCSV("2/1/2023", "Old", "Honda", "95AN3AWVF4", "On-hand"));
        stockList.add(new StockFromCSV("2/3/2023", "Old", "Kawasaki", "483QHIM661", "On-hand"));
        stockList.add(new StockFromCSV("2/3/2023", "Old", "Kymco", "SPHA17SSEE", "On-hand"));
        stockList.add(new StockFromCSV("2/3/2023", "Old", "Kymco", "0AV7SWGX93", "Sold"));
        stockList.add(new StockFromCSV("2/4/2023", "Old", "Kymco", "QMUB6UYLKL", "Sold"));
        stockList.add(new StockFromCSV("2/4/2023", "Old", "Honda", "V96GMTFFEI", "Sold"));
        stockList.add(new StockFromCSV("2/5/2023", "Old", "Kawasaki", "4J8UA0FMVY", "Sold"));
        stockList.add(new StockFromCSV("2/5/2023", "Old", "Kawasaki", "A8BDL926FA", "Sold"));
        stockList.add(new StockFromCSV("2/5/2023", "Old", "Kawasaki", "X8G5ZZ7A69", "Sold"));
        stockList.add(new StockFromCSV("2/6/2023", "Old", "Honda", "TY5SU0WPDX", "On-hand"));
        stockList.add(new StockFromCSV("2/6/2023", "Old", "Honda", "5Q0EZG7WKB", "On-hand"));
        stockList.add(new StockFromCSV("2/6/2023", "Old", "Suzuki", "9XUOUOJ2XZ", "On-hand"));
        stockList.add(new StockFromCSV("2/6/2023", "Old", "Kymco", "YUL4UTC4FU", "On-hand"));
        stockList.add(new StockFromCSV("2/6/2023", "Old", "Kymco", "2ESQRHAXWG", "On-hand"));
        stockList.add(new StockFromCSV("2/7/2023", "Old", "Kymco", "J8JA99VWZE", "Sold"));
        stockList.add(new StockFromCSV("2/7/2023", "Old", "Kymco", "NS530HOT9H", "Sold"));
        stockList.add(new StockFromCSV("2/7/2023", "Old", "Suzuki", "URIA0XXM05", "Sold"));
        stockList.add(new StockFromCSV("2/7/2023", "Old", "Yamaha", "IDN93SI4KW", "Sold"));
        stockList.add(new StockFromCSV("2/7/2023", "Old", "Honda", "PVAWKD51CE", "Sold"));
        stockList.add(new StockFromCSV("2/7/2023", "Old", "Honda", "K4KHCQAU41", "Sold"));
        stockList.add(new StockFromCSV("2/8/2023", "Old", "Honda", "Z4NY5JGZZT", "Sold"));
        stockList.add(new StockFromCSV("2/8/2023", "Old", "Honda", "IRQACSKUNZ", "Sold"));
        stockList.add(new StockFromCSV("2/8/2023", "Old", "Yamaha", "TMZCTALNDL", "Sold"));
        stockList.add(new StockFromCSV("2/8/2023", "Old", "Yamaha", "DVFUIA0YVB", "Sold"));
        stockList.add(new StockFromCSV("2/8/2023", "Old", "Kymco", "4M793VVAHI", "On-hand"));
        stockList.add(new StockFromCSV("2/8/2023", "Old", "Suzuki", "5N7IQVJ2BA", "On-hand"));

        // March new stocks
        stockList.add(new StockFromCSV("3/1/2023", "New", "Suzuki", "NO8VW05PU9", "On-hand"));
        stockList.add(new StockFromCSV("3/1/2023", "New", "Yamaha", "NWIP2MQEIN", "Sold"));
        stockList.add(new StockFromCSV("3/1/2023", "New", "Kawasaki", "1HCWCVZSX8", "Sold"));
        stockList.add(new StockFromCSV("3/3/2023", "New", "Kawasaki", "Z46VKPIJBY", "Sold"));
        stockList.add(new StockFromCSV("3/3/2023", "New", "Kawasaki", "LYQVEHJ6IU", "Sold"));
        stockList.add(new StockFromCSV("3/3/2023", "New", "Yamaha", "BVGQQNMATL", "Sold"));
        stockList.add(new StockFromCSV("3/4/2023", "New", "Kymco", "URWMSQZCBU", "Sold"));
        stockList.add(new StockFromCSV("3/4/2023", "New", "Yamaha", "5NGI5UZ8T2", "On-hand"));
        stockList.add(new StockFromCSV("3/5/2023", "New", "Honda", "W2UYM0EIRS", "On-hand"));
        stockList.add(new StockFromCSV("3/5/2023", "New", "Honda", "AITLTSJUK2", "On-hand"));
        stockList.add(new StockFromCSV("3/5/2023", "New", "Yamaha", "45CNYV7IFF", "On-hand"));
        stockList.add(new StockFromCSV("3/6/2023", "New", "Kymco", "MXS36NKV96", "Sold"));
        stockList.add(new StockFromCSV("3/6/2023", "New", "Kymco", "PWM3MJWPYE", "Sold"));
        stockList.add(new StockFromCSV("3/6/2023", "New", "Kymco", "5I80N9HB7W", "Sold"));
        stockList.add(new StockFromCSV("3/6/2023", "New", "Yamaha", "D01JMJL9PG", "On-hand"));
        stockList.add(new StockFromCSV("3/6/2023", "New", "Suzuki", "1R88BOJW8W", "On-hand"));
        stockList.add(new StockFromCSV("3/7/2023", "New", "Suzuki", "LAMH9Y1YD6", "On-hand"));
        stockList.add(new StockFromCSV("3/7/2023", "New", "Yamaha", "02G7NJCRGS", "On-hand"));
        stockList.add(new StockFromCSV("3/7/2023", "New", "Kawasaki", "392XSUBMUW", "On-hand"));

        return stockList;
    }
}