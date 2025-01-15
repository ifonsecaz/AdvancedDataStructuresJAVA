/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author edi
 */
public abstract class Lista<T> implements ListaADT<T> {
    protected Nodo<T> primero;
    protected Nodo<T> último;
    
    protected Lista(){
        primero=null;
        último=null;
    }

    public Iterator<T> iterator() {
        return new IteradorEE(primero);
    }

    public boolean estaVacía() {
       return primero==null;
    }

    public T quitaPrimero() {
        T res=null;
        
        if(!estaVacía()){
            Nodo<T> aux=primero;
            primero=primero.getSig();
            res=aux.getDato();
            if(aux==último){
                último=null;
            }
            else{
                aux.setSig(null);
            }
        }
        return res;
    }

    public T quitaÚltimo(){
        T res=null;
        
        if(!estaVacía()){
            Nodo<T> ant=primero;
            Nodo<T> act=primero.getSig();
            
            if(act!=null){
                while(act.getSig()!=null){
                    ant=act;
                    act=act.getSig();
                }
                ant.setSig(null);
                último=ant;
                res=act.getDato();
            }
            else{
                res=primero.getDato();
                primero=null;
                último=primero;
            }

        }
        return res;
    }

    public T quita(T dato) {
        T res=null;
        
        if(!estaVacía()){
            Nodo<T> ant=primero;
            Nodo<T> act=primero.getSig();
            
            if(primero.getDato().equals(dato)){
                res=quitaPrimero();
            }
            else{
                if(act!=null){
                    while(act.getSig()!=null&&!act.getDato().equals(dato)){
                        ant=act;
                        act=act.getSig();
                    }
                    
                    if(act.getDato().equals(dato)){
                        res=act.getDato();
                        ant.setSig(act.getSig());
                        act.setSig(null);
                    }
                }
            }
        }
        return res;
    }

    public boolean contiene(T dato) {
        boolean res=false;
        
        if(!estaVacía()){
            if(primero.getDato().equals(dato)){
                res=true;
            }
            else{
                Nodo<T> act=primero.getSig();
                
                while(act!=null&&!act.getDato().equals(dato)){
                    act=act.getSig();
                }
                if(act!=null){
                    res=true;
                }
            }
        }
        return res;
    }
    
    public int calculaTamaño() {
        int res=0;
        
        if(!estaVacía()){
            Iterator aux=this.iterator();
            
            while(aux.hasNext()){
                res++;
                aux.next();
            }
        }
        return res;
    }

    public T obtienePrimero() {
        T res=null;
        
        if(!estaVacía()){
            res=primero.getDato();
        }
        
        return res;
    }

    public T obtieneÚltimo() {
        T res=null;
        
        if(!estaVacía()){
            res=último.getDato();
        }
        
        return res;
    }
    
    public void invierte(){
        if(!estaVacía()&&primero.getSig()!=null){
            invierte(primero,primero.getSig());
            
            primero.setSig(null);
            Nodo<T> aux=primero;
            primero=último;
            último=aux;
        }
    }
    
    private void invierte(Nodo<T> act, Nodo<T> sig){
        if(sig!=null){
            Nodo<T> aux=sig.getSig();
            sig.setSig(act);

            invierte(sig,aux);
        }
    }
    
    public void invierteConPila(){
        if(!estaVacía()&&primero.getSig()!=null){
            invierteConPila(primero,primero.getSig());
            
            primero.setSig(null);
            Nodo<T> aux=primero;
            primero=último;
            último=aux;
        }
    }
    
    private void invierteConPila(Nodo<T> act,Nodo<T> sig){
        if(sig!=null){
            invierteConPila(sig,sig.getSig());
            sig.setSig(act);
        }
    }
    
    public String toString(){
        String res=null;
        
        if(!estaVacía()){
            StringBuilder cad= new StringBuilder();
            Nodo<T> act=primero;
           
            while(act!=null){
                cad.append("\n" + act.getDato());
                act=act.getSig();
            }
            
            res=cad.toString();
        }
        
        return res;
    }
    
    
}
