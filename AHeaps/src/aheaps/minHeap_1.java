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
public interface minHeap_1<T>{
    public void inserta(T elem,T prioridad);
    public T getMin();
    public T eliminaMin();
}
