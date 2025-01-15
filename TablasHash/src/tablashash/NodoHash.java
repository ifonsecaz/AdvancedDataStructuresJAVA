/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablashash;

/**
 *
 * @author computacion1
 */
public class NodoHash<T> {
    private int llave;
    private T elem;
    private NodoHash<T> sig;

    public NodoHash(int llave, T elem) {
        this.llave = llave;
        this.elem = elem;
        sig=null;
    }

    public int getLlave() {
        return llave;
    }

    public T getElem() {
        return elem;
    }

    public NodoHash<T> getSig() {
        return sig;
    }

    public void setSig(NodoHash<T> sig) {
        this.sig = sig;
    }
}
