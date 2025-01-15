/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skipl;

/**
 *
 * @author computacion1
 */
public class SkipL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SkipList a= new SkipList();
        a.inserta(2);
        a.inserta(6);
        a.inserta(12);
        a.inserta(8);
        a.inserta(8);
        a.inserta(4);
        a.inserta(16);
        a.inserta(14);
        a.inserta(10);
        
        System.out.println(a.buscaI(1).getElem());
        System.out.println(a.buscaI(10).getElem());
        System.out.println(a.buscaI(3).getElem());
        System.out.println(a.buscaI(16).getElem());
        System.out.println(a.buscaI(2).getElem());
        System.out.println(a.buscaI(8).getElem());
        System.out.println(a.buscaI(5).getElem());
        System.out.println("\n");
        System.out.println(a.borra(11));
        System.out.println(a.borra(2));
        System.out.println(a.busca(2));
        System.out.println(a.borra(6));
        System.out.println(a.busca(6));
        System.out.println(a.borra(8));
        System.out.println(a.busca(8));
        System.out.println(a.borra(16));
        System.out.println(a.busca(16));
    }
}
