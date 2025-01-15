/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skipl;

/**
 *
 * @author computacion1
 */
public class NodoSkip<T> {
    private NodoSkip<T> izq,der,arriba,abajo;
    private T elem;

    public NodoSkip(T elem) {
        this.elem = elem;
        izq=null;
        der=null;
        arriba=null;
        abajo=null;
    }

    public NodoSkip() {
        elem=null;
        izq=null;
        der=null;
        arriba=null;
        abajo=null;
    }
    
    public T getElem() {
        return elem;
    }

    public NodoSkip<T> getIzq() {
        return izq;
    }

    public NodoSkip<T> getDer() {
        return der;
    }

    public NodoSkip<T> getArriba() {
        return arriba;
    }

    public NodoSkip<T> getAbajo() {
        return abajo;
    }

    public void setIzq(NodoSkip<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoSkip<T> der) {
        this.der = der;
    }

    public void setArriba(NodoSkip<T> arriba) {
        this.arriba = arriba;
    }

    public void setAbajo(NodoSkip<T> abajo) {
        this.abajo = abajo;
    }
}
