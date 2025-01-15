/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

/**
 *
 * @author hca
 */
public class NodoBT <T extends Comparable <T>>{
    private T elem;
    private NodoBT<T> izq, der, papa;

    public NodoBT(T elem) {
        this.elem = elem;
        izq=null;
        der=null;
    }
    
    public T getElem(){
        return elem;
    }
    
    public void setElem(T elem){
        this.elem=elem;
    }
    
    public NodoBT<T> getIzq(){
        return izq;
    }
    
    public NodoBT<T> getDer(){
        return der;
    }

    public void setIzq(NodoBT<T> nuevo){
        izq=nuevo;
    }
    
    public void setDer(NodoBT<T> nuevo){
        der=nuevo;
    }
    
    public void setPapa(NodoBT<T> nuevo){
        papa=nuevo;
    }
    
    public NodoBT<T> getPapa(){
        return papa;
    }
    
    public void cuelga(NodoBT<T> n){
        if(n.getElem().compareTo(elem)<0){
            izq=n;
        }
        else{
            der=n;
        }
        n.setPapa(this.papa);
    }
    
    public int numDesc(){
        int hijos=0;
        
        if(izq!=null){
            hijos+=izq.numDesc();
        }
        if(der!=null){
            hijos+=der.numDesc();
        }
        
        return hijos;
    }
    
    
}
