/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author 072584980
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public int[] Insertion(int[] nums){
        return null;
    }
    
    /**
     * <b><p style="color:purple;"> Sorts a comparable array by using a selection sort algorithm. (Sean)</p></b>
     *
     * @param index This is the index of where you want to start sorting in the array
     * @param item The comparable array of interest to be sorted
     * @return The array that has been sorted.
     */
    public static Comparable[] selectionSort(int index, Comparable[] item) 
    {   //check if index searched is at the end of the array
        if (index == item.length - 2) {
            //if it is, then return the array.
            return item;
        }

        /*  basic algorithm to find the lowest index and value:
            create temporary variables to store the lowest value of the array and
            the corresponding index of that value.
        */
        Comparable lowest = item[index];
        int indexOfLowest = 0;

        //find index of smallest element of the array starting from the searching index
        for (int i = index; i < item.length; i++) 
        {   //if the lowest is smaller than the item in the current index when scanning the array,
            //reassign the lowest value and index of the lowest value to the index that was accessed.
            if (lowest.compareTo(item[i]) > 0) 
            {   //reassigns the index of the lowest value to the current index of the array
                indexOfLowest = i;
                //reassigns the lowest value to the current index of the array.
                lowest = item[i];
            }
        } 

        //checks if the lowest index was the smallest element of the array. If so,
        //do nothing and call sort again.
        if (indexOfLowest == 0) 
        {   return selectionSort(index + 1, item); } 
        //Otherwise, swap the index in focus with the index of the smallest item in the array.
        else 
        {   //store value of the element in focus into a temporary variable
            Comparable temp = item[index];
            //assign lowest value of the array to the element in focus.
            item[index] = item[indexOfLowest];
            //assign temporary to the previous index of the lowest value of the array.
            item[indexOfLowest] = temp;

            //call selection sort again
            return selectionSort(index + 1, item);
        }
    } //end of selection sort method

    /**
     * <b><p style="color:purple;"> Sorts an integer array by using a merge sort algorithm (Sean) </p></b>
     * @param item The array to be sorted
     * @param low The lower boundary of the area of interest
     * @param high The higher boundary of the area of interest.
     * @return The sorted array
     */
    public static int[] mergeSort(int[] item, int low, int high) 
    {   /* 
            The basic idea of mergesort is to split it into a tree of broken elements of the array and then merge them 
            into bigger subarrays that are in order and then merge the subarrays into ever larger subarrays that are in
            order. Eventually, you will get the sorted full array.
            Complexity: O(n log n)
        */
        
        //if low equals to high, only one index of interest exists.
        //This means that the array has been sorted and merged, so return it.
        if (low == high) 
        {   //converts the item to an array
            int[] temp = {item[high]};
            return temp;
        //otherwise, perform mergesort algorithm.
        } else 
        {
            //find the middle of the given array so that it can be split.
            int mid = (low + high) / 2;

            //split the given array into two subarrays, a and b. A and B are already sorted.
            int[] a = mergeSort(item, low, mid);
            int[] b = mergeSort(item, mid + 1, high);

            //create a temporary item array to store the two merged sorted subarrays.
            int[] temp = new int[a.length + b.length];

            //this is the next element to consider in the first subarray
            int countArr1 = 0;
            //this is the next element to consider in the second subarray
            int countArr2 = 0;
            //this is the next open spot in the merged array
            int nextSpot = 0;

            //runs as long as one array has not reached the end.
            while (countArr1 < a.length && countArr2 < b.length) 
            {   //compares which one should go first in the merged array
                if (a[countArr1] < b[countArr2]) 
                {   //set item to the next spot in the array open
                    temp[nextSpot] = a[countArr1];
                    countArr1++;
                } else 
                {   //set item to the next spot in the array open
                    temp[nextSpot] = b[countArr2];
                    countArr2++;
                }

                //since one spot was added to the temp array, the next open spot will
                //be shifted to the right.
                nextSpot++;
            }

            //fills in remainder of the array, if there is any
            while (countArr2 < b.length)
            {   //set item to the next spot in the array open
                temp[nextSpot] = b[countArr2];
                countArr2++;
                nextSpot++;
            }

            //fills in remainder of the temp array, if there is any
            while (countArr1 < a.length) 
            {   //set item to the next spot in the array open
                temp[nextSpot] = a[countArr1];
                countArr1++;
                nextSpot++;
            }

            //returns the sorted merged array.
            return temp;
        }
    } //end of merge sort algorithm
    
}
