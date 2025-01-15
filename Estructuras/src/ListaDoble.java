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
public class ListaDoble <T> implements ListaADT<T>{

    private NodoDoble<T> primero;
    private NodoDoble<T> último;
    
    public Iterator<T> iterator() {
        return new IteradorDoble(primero);
    }

    public void agregaInicio(T dato){
        NodoDoble<T> nuevo=new NodoDoble(dato);
        if(estaVacía()){
            último=nuevo;
        }
        else{
            primero.setAnt(nuevo);
            nuevo.setSig(primero);
        }
        primero=nuevo;
    }
    
    public void agregaFinal(T dato){
        NodoDoble<T> nuevo= new NodoDoble(dato);
        
        if(estaVacía()){
            primero=nuevo;
        }
        else{
            último.setSig(nuevo);
            nuevo.setAnt(último);
        }
        último=nuevo;
    }
    
    public boolean estaVacía() {
       return primero==null;
    }

    public T quitaPrimero() {
        T res=null;
        
        if(!estaVacía()){
            res=primero.getDato();
            primero=primero.getSig();
            if(primero==null){
                último=null;
            }
            else{
                primero.getAnt().setSig(null);
                primero.setAnt(null);
            }
        }
        
        return res;
    }

    public T quitaÚltimo() {
        T res=null;
        
        if(!estaVacía()){
            res=último.getDato();
            último=último.getAnt();
            if(último==null){
                primero=null;
            }
            else{
                último.getSig().setAnt(null);
                último.setSig(null);
            }
        }
        return res;
    }
    
    public T quita(T dato) {
        T res=null;
        
        if(!estaVacía()){
            if(primero.getDato().equals(dato)){
                res=quitaPrimero();
            }
            else{
                if(último.getDato().equals(dato)){
                    res=quitaÚltimo();
                }
                else{
                    NodoDoble<T> act=primero.getSig();
                    
                    while(act!=null&&!act.getDato().equals(dato)){
                        act=act.getSig();
                    }
                    
                    if(act!=null){
                        res=act.getDato();
                        act.getSig().setAnt(act.getAnt());
                        act.getAnt().setSig(act.getSig());
                        act.setSig(null);
                        act.setAnt(null);
                    }
                }
            }
            
        }
        return res;
    }

    public boolean contiene(T dato) {
        boolean res=false;
        
        if(!estaVacía()){
            NodoDoble<T> act= primero;
            
            while(act!=null&&!act.getDato().equals(dato)){
                act=act.getSig();
            }
            
            if(act!=null){
                res=true;
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
       T res= null;
       
       if(!estaVacía()){
           res=último.getDato();
       }
       
       return res;
    }
    
    public boolean estaOrdenCreciente(){
        boolean res=true;
        
        if(primero!=último){
            res=estaOrdenCreciente(primero);
        }
        
        return res;
    }
    
    private boolean estaOrdenCreciente(NodoDoble<T> act){
        if(act.getSig()==null){
            return true;
        }
        else{
            if(((Comparable)act.getDato()).compareTo(act.getSig().getDato())<=0){
                return estaOrdenCreciente(act.getSig());
            }
            else{
                return false;
            }
        }
            
    }
    
    public boolean estáContenida(ListaDoble<T> a){
        boolean res=false;
        
        if(a!=null){
            if(a.estaVacía()){
                if(estaVacía()){
                    res=true;
                }
            }
            else{
                res=estaContenida(iterator(),a);
            }
        }
        
        return res;
    }
    
    private boolean estaContenida(Iterator<T> it, ListaDoble<T> a){
        if(it.hasNext()){
            if(!a.contiene(it.next())){
                return false;
            }
            else{
                return estaContenida(it,a);
            }
        }
        else{
            return true;
        }
    }
    
    public String toString(){
        String res=null;
        
        if(!estaVacía()){
            StringBuilder cad= new StringBuilder();
            NodoDoble<T> act=primero;
           
            while(act!=null){
                cad.append("\n" + act.getDato());
                act=act.getSig();
            }
            
            res=cad.toString();
        }
        
        return res;
    }
    
}
