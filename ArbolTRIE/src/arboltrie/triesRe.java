/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboltrie;

import java.util.ArrayList;

/**
 *
 * @author ifonsecaz
 */
public class triesRe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ATrie a= new ATrie();
        ArrayList<String> res;
        int[][] tam=new int[3][2];
        System.out.println(tam.length);
        a.inserta("anti");
        a.inserta("abs");
        a.inserta("abbs");
        a.inserta("fer");
        
        //res=a.ordenamientoLexicografico();
        
        //System.out.println(res);
    }
}
