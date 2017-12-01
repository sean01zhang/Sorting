/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import Util.FILEIO;
import java.util.Arrays;

/**
 *
 * @author seanz
 */
public class Stocks {
    public static void main(String[]args) {
        //load in array of info
        String[] strA = FILEIO.getStrAFromF("stockdataunsorted.txt","\n");
        //load 1st element into an int array
        StockInfo[] price = new StockInfo[strA.length];
        
        for(int i=0;i<strA.length;i++) {
            price[i] = new StockInfo(strA[i].split(","));
        }
        
        long l = System.nanoTime();
        //9.413555 9.607601 9.699948
        //price = Arrays.copyOf(Sorting.mergeSort(price, 0, price.length-1),price.length,StockInfo[].class);
        
        //9.360368 9.048843 8.943053
        //Arrays.sort(price);
        
        //125.408182 122.670793 123.683397
        //price = Arrays.copyOf(Sorting.selectionSort(0, price),price.length,StockInfo[].class);
        
        //59.889698 62.927214 62.504347
        //price = Arrays.copyOf(Sorting.insertionSort(price),price.length,StockInfo[].class);
        
        //265.380315 267.374544 265.503347
        //price = Arrays.copyOf(Sorting.bubbleSort(price),price.length,StockInfo[].class);
        
        long l2 = System.nanoTime();
        
        double tt = (double)(l2-l)/1000000;
        System.out.println(tt);
        
        
        String out="";
        for(int i=0;i<price.length;i++) {
            out+=price[i].toString()+"\n";
        }
        
        FILEIO.printF("stockdatasorted.txt", out, false);
        
    }
}
