/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author hca
 */
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Listas a= new Listas();
        
        a.inserta(1);
        a.inserta(2);
        a.inserta(3);
        a.inserta(4);
        a.inserta(5);
        
        System.out.println(a.contarElementos());
        //System.out.println(a.eliminarElem(5));
        System.out.println(a.toString());
        
        //a.invierte();
        a.invierteSinEnl();
        System.out.println(a.toString());
    }
}
