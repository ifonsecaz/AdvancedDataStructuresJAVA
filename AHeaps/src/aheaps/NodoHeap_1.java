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
public class NodoHeap_1<T extends Comparable<T>> {
    private T elem;
    private T prioridad;

    public NodoHeap_1(T elem, T prioridad) {
        this.elem = elem;
        this.prioridad = prioridad;
    }

    public NodoHeap_1(Object elem) {
        this.elem = (T) elem;        
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }
    public T getPrioridad(){
        return elem;
    }
    
    public String toString(){
        return "E:" + elem.toString();
    }
    
}