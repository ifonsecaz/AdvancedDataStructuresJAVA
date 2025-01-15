/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

/**
 *
 * @author hca
 */
public class P <T>{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] a=new Integer[11];
        a[0]=25;
        a[1]=2000;
        a[2]=3;
        a[3]=666;
        a[4]=505;
        a[5]=-1;
        a[6]=30000;
        a[7]=5;
        a[8]=500;
        a[9]=122;
        a[10]=122222;
        
        //System.out.println(AlgoritmosOrdenamiento.selectionSort(a));
        //AlgoritmosOrdenamiento.insertionSort(a);
        //System.out.println(AlgoritmosOrdenamiento.bubbleSort(a));
        //System.out.println(AlgoritmosOrdenamiento.quickSort(a));
        //System.out.println(AlgoritmosOrdenamiento.mergeSortO(a));
        AlgoritmosOrdenamiento.mergeSort(a);
        //System.out.println(AlgoritmosOrdenamiento.selectionSortNoRec(a));
        //System.out.println(AlgoritmosOrdenamiento.insertionSortNoRec(a));
        //System.out.println(AlgoritmosOrdenamiento.bubbleSortNoRec(a));
        //AlgoritmosOrdenamiento.invertir(a);
        
        for(int i=0; i<11; i++){
            System.out.println(a[i]);
        }
        
        
    }
}
