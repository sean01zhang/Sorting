/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;

/**
 *
 * @author seanz
 */
public class StockInfo implements Comparable{
    private String[] stocks;

    public String[] getStocks() {
        return stocks;
    }
    
    public StockInfo(String[] stock) {
        stocks =stock.clone();
    }

    /*
        1. Price
        2. Date
        3. Dividend
        4. Earnings
        5. CPI
        6. Interest Rate
        7. PERatio
    */

    @Override
    public int compareTo(Object o) {
        StockInfo temp = (StockInfo)o;
        
        return compareToHelper(temp,0);
    }
    
    public int compareToHelper(StockInfo c, int startFrom) {
        if (startFrom > 6) {
            return 0;
        }else if(startFrom==1) {
            if (stocks[startFrom].equals(c.getStocks()[startFrom])) {
                return compareToHelper(c, startFrom+1);
            } else if (stocks[startFrom].isEmpty() || stocks[startFrom].equals("NA")) {
                return -1;
            } else if (c.getStocks()[startFrom].isEmpty() || c.getStocks()[startFrom].equals("NA")) {
                return 1;
            } else {
                if (Double.parseDouble((stocks[startFrom].split("\\."))[0]) > Double.parseDouble((c.getStocks()[startFrom].split("\\."))[0])) {
                    return 1;
                } else if(Double.parseDouble(stocks[startFrom].split("\\.")[0]) == Double.parseDouble(c.getStocks()[startFrom].split("\\.")[0])) {
                    if(Double.parseDouble(stocks[startFrom].split("\\.")[1]) > Double.parseDouble(c.getStocks()[startFrom].split("\\.")[1])) {
                        return 1;
                    } else if(Double.parseDouble(stocks[startFrom].split("\\.")[1]) == Double.parseDouble(c.getStocks()[startFrom].split("\\.")[1])) {
                        return compareToHelper(c, startFrom++);
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        } else {
            if (stocks[startFrom].equals(c.getStocks()[startFrom])) {
                return compareToHelper(c, startFrom+1);
            } else if (stocks[startFrom].isEmpty() || stocks[startFrom].equals("NA")) {
                return -1;
            } else if (c.getStocks()[startFrom].isEmpty() || c.getStocks()[startFrom].equals("NA")) {
                return 1;
            } else {
                if (Double.parseDouble(stocks[startFrom]) > Double.parseDouble(c.getStocks()[startFrom])) {
                    return 1;
                } else {
                    return -1;
                }
            }

        }
    }
    
    /**
     * Returns the stock info as a string back when the user wants it to be a string.
     * @return 
     */
    @Override
    public String toString() {
        return (stocks[0]+","+stocks[1]+","+stocks[2]+","+stocks[3]+","+stocks[4]+","+stocks[5]+","+stocks[6]+",");
    }
    
    
    
    
}
