/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboltrie;

/**
 *
 * @author hca
 */
public class NodoTrie <T>{
    private NodoTrie<T>[] hijos;
    private int numPalabras;
    private Character[] sim;
    
    public NodoTrie(Character[] sim) {
        hijos=new NodoTrie[sim.length];
        numPalabras=0;
        this.sim=sim;
    }

    public int isFinPalabra() {
        return numPalabras;
    }

    public void add(int pos) {
        if(hijos[pos]!=null){
            hijos[pos]=new NodoTrie<T>(sim);
        }
    }
    
    public NodoTrie<T> get(int pos){
        return hijos[pos];
    }
    
    //
    public NodoTrie<T> getSig(char l){
        int i=0;
        
        while(i<sim.length&&l!=sim[i]){
            i++;
        }
        if(i==sim.length){
            throw new RuntimeException("No existe el símbolo" + l);
        }
        return hijos[i];  
    }
    
    public NodoTrie<T> add(char l){
        int i=0;
        
        while(i<sim.length&&l!=sim[i]){
            i++;
        }
        if(i==sim.length){
            throw new RuntimeException("No existe el símbolo " + l);
        }
        if(hijos[i]==null){
            hijos[i]=new NodoTrie<T>(sim);
        }
        return hijos[i];
    }
    
    public void setNull(char l){
        int i=0;
        
        while(i<sim.length&&l!=sim[i]){
            i++;
        }
        if(i==sim.length){
            throw new RuntimeException("No existe el símbolo" + l);
        }
        hijos[i]=null;
    }
    
    public void setFinPalabra(int numPalabras) {
        this.numPalabras=numPalabras;
    }
    
    public boolean hayOtrosHijos(){
        boolean res=false;
        int i=0;
        
        while(!res&&i<hijos.length){
            if(hijos[i]!=null){
                res=true;
            }
            i++;
        }
        
        return res;
    }
    
    public int sigNodo(int i){
        while(i<hijos.length&&hijos[i]==null){
            i++;
        }
        if(i==hijos.length){
            i=-1;
        }
        else{
            i++;
        }
        return i;
    }
    
    public NodoTrie<T> getNodoPos(int i){
        return hijos[i];
    }
}
