/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aheaps;

/**
 *
 * @author ifons
 */
public class AHeaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap_1 a= new Heap_1();
        a.inserta(5, 5);
        a.inserta(2, 2);
        a.inserta(10, 10);
        a.inserta(120, 120);
        a.inserta(150, 150);
        a.inserta(700, 700);
        a.inserta(1, 1);
        a.inserta(0, 0);
        a.inserta("a", "a");
        
        System.out.println(a.getMin());
        System.out.println(a.eliminaMin());
        System.out.println(a.getMin());
        System.out.println(a.eliminaMin());
        System.out.println(a.getMin());
    }
    
}
