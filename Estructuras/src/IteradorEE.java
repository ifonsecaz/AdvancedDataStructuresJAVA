/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author edi
 */
public class IteradorEE <T> implements Iterator<T>{

    private Nodo<T> actual;

    public IteradorEE(Nodo<T> actual) {
        this.actual = actual;
    }
    

    public boolean hasNext() {
        return actual!=null;
    }

    public T next() {
        if(hasNext()){
            T res=actual.getDato();
            actual=actual.getSig();
            return res;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
