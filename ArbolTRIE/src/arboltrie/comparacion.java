/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboltrie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class comparacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File a= new File("D:\\wiki-100k.txt");
        String n;
        String[] palabras= new String[10];
        String[] palabras2=new String[10];
        String[] palabras3=new String[10];
        int i=0;
        Character[] b={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',1,2,3,4,5,6,7,8,9,0,'­'};
        ATrie arbol=new ATrie(b);
        Heap aH= new Heap();
        
        try(Scanner lec= new Scanner(a)){
            while(lec.hasNext()&&i<10){
                n=lec.next();
                palabras[i]=n.toLowerCase(); 
                palabras2[i]=n.toLowerCase();
                palabras3[i]=n.toLowerCase();
                i++;
            }
            
            System.out.println("MergeSort");
            long tiempo=System.nanoTime();
            AlgoritmosOrdenamiento.mergeSortO(palabras);
            System.out.println(System.nanoTime()-tiempo);
            
            System.out.println("Tries");
            tiempo=System.nanoTime();
            arbol.ordenamientoLexicografico(palabras2,b);
            System.out.println(System.nanoTime()-tiempo);
            
            System.out.println("Heap");
            tiempo=System.nanoTime();
            aH.heapSort(palabras3);
            System.out.println(System.nanoTime()-tiempo);
            
            for(int hgfj=0; hgfj<palabras.length; hgfj++){
                System.out.print(palabras2[hgfj]);
            }
            System.out.println("");
            for(int hgfj=0; hgfj<palabras.length; hgfj++){
                System.out.print(palabras[hgfj]);
            }
            for(int hgfj=0; hgfj<palabras.length; hgfj++){
                System.out.print(palabras3[hgfj]);
            }
        }
        catch(FileNotFoundException ex){
            System.err.println(ex);
            System.exit(-1);
        }
    }
    
}
