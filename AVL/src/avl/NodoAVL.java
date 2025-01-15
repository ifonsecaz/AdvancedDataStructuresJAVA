/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author hca
 */
public class NodoAVL <T extends Comparable<T>>{
    private T elem;
    private NodoAVL<T> izq, der, papa;
    private int fe,altura;

    public NodoAVL(T elem) {
        this.elem = elem;
        izq=null;
        der=null;
        papa=null;
        fe=0;
        altura=0;
    }
    
    public T getElem(){
        return elem;
    }
    
    public void setElem(T elem){
        this.elem=elem;
    }
    
    public NodoAVL<T> getIzq(){
        return izq;
    }
    
    public NodoAVL<T> getDer(){
        return der;
    }
    
    public int getFe(){
        return fe;
    }
    
    public int getAltura(){
        return altura;
    }
    
    public void setAltura(int alt){
        this.altura=alt;
    }
    
    public void setFe(int factE){
        fe=factE;
    }
    
    public void setIzq(NodoAVL<T> nuevo){
        izq=nuevo;
    }
    
    public void setDer(NodoAVL<T> nuevo){
        der=nuevo;
    }
    
    public void setPapa(NodoAVL<T> nuevo){
        papa=nuevo;
    }
    
    public NodoAVL<T> getPapa(){
        return papa;
    }
    
    public void cuelga(NodoAVL<T> n){
        if(n.getElem().compareTo(elem)<0){
            izq=n;
        }
        else{
            der=n;
        }
        //n.setPapa(this.papa);
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
