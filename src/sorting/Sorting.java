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
        
    }
    
    public static Comparable[] selection(Comparable[] set, int index) {
        Comparable min;
            min = set[index];

        
        if(index == set.length) {
            return set;
        } else {
            for(int i=index;i<set.length;i++) {
                if(min.compareTo(set[i]) > 0) {
                    
                }
            }
        }
        return null;
    }
    
}
