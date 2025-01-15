/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edi
 */
public class NodoDoble<T> {
    private T dato;
    private NodoDoble<T> ant;
    private NodoDoble<T> sig;

    public NodoDoble(T dato) {
        this.dato = dato;
        ant=null;
        sig=null;
    }
    
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getSig() {
        return sig;
    }

    public void setSig(NodoDoble<T> sig) {
        this.sig = sig;
    }
    
    public NodoDoble<T> getAnt(){
        return ant;
    }
    
    public void setAnt(NodoDoble<T> ant){
        this.ant=ant;                
    }
    
    public String toString(){
        return dato.toString();
    }
    
}
