/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author ifons
 */
public class AVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedBSTAVL a= new LinkedBSTAVL();
        
        a.add(100);
        a.add(300);
        a.add(375);
        a.add(200);
        a.add(400);
        a.add(500);
        a.add(350);
        a.add(380);
        a.add(360);
        a.add(50);
        a.add(390);
        /*
        a.remove(375);
        a.remove(50);
        a.remove(400);
        a.remove(380);
        */
        
        System.out.println(a.imprimeIzqDerNivel());
        
    }
    
}
