/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboltrie;
import java.util.Arrays;

/**
 *
 * @author ifons
 */
public class pruebaR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] a={10,9,8,7,6,5,4,3,2,1};
        //T[] b=(T[])new Object[10];
                //new Integer[10];          
        AlgoritmosOrdenamiento.pruebaMerge(a);
        
        for(int i=0; i<a.length;i++){
            System.out.println("\n"+a[i].toString());
        }
        
    }
    
}
