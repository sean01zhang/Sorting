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
        Double[] price = new Double[strA.length];
        
        for(int i=0;i<strA.length;i++) {
            price[i] = Double.parseDouble(strA[i].split(",")[0]);
        }
        
        long l = System.nanoTime();
        //2.18 ms
        price = Arrays.copyOf(Sorting.mergeSort(price, 0, price.length-1),price.length,Double[].class);
        
        //12.92 ms
        //price = Arrays.copyOf(Sorting.selectionSort(0, price),price.length,Double[].class);
        
        //7.17 ms
        //price = Arrays.copyOf(Sorting.insertionSort(price),price.length,Double[].class);
        
        //19.13 ms
        //price = Arrays.copyOf(Sorting.bubbleSort(price),price.length,Double[].class);
        
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
