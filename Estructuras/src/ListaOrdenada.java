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
public class ListaOrdenada <T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T> {

    public ListaOrdenada() {
        super();
    }
    
    public boolean agrega(T dato) {
        boolean res=false;
        
        if(dato!=null){
            if(estaVacía()){
                primero=new Nodo(dato);
                último=primero;
                res=true;
            }
            else{
                if(último.getDato().compareTo(dato)<0){
                    Nodo<T> nuevo=new Nodo(dato);
                    último.setSig(nuevo);
                    último=nuevo;
                    res=true;
                }
                else{
                    if(primero.getDato().compareTo(dato)>0){
                        Nodo<T> nuevo=new Nodo(dato);
                        nuevo.setSig(primero);
                        primero=nuevo;
                        res=true;
                    }
                    else{
                        Nodo<T> ant=primero;
                        Nodo<T> act=primero.getSig();
                        
                        while(act!=null&&act.getDato().compareTo(dato)<=0){
                            ant=act;
                            act=act.getSig();
                        }
                        
                        if(act!=null&&!ant.getDato().equals(dato)){
                            Nodo<T> nuevo=new Nodo(dato);
                            ant.setSig(nuevo);
                            nuevo.setSig(act);
                            res=true;
                        }
                    }
                }
            }
        }    
        return res;
        
    }
    
    public boolean contiene(T dato){
        boolean res=false;
        
        if(dato!=null&&!estaVacía()){
            if(último.getDato().compareTo(dato)<=0){
                res=último.getDato().equals(dato);
            }
            else{
                Nodo<T> pos=busca(dato);
                res=pos.getDato().equals(dato);
            }
        }
        
        return res;
    }
    
    private Nodo<T> busca(T dato){
        Nodo<T> ant=primero;
        Nodo<T> act=primero.getSig();
                        
        while(act!=null&&act.getDato().compareTo(dato)<=0){
            ant=act;
            act=act.getSig();
        }
        
        return ant;
    }
        
    public T quita (T dato){
        T res=null;
        if(dato!=null&&!estaVacía()){
            if(primero.getDato().equals(dato)){
                res=quitaPrimero();
            }
            else{
                if(último.getDato().equals(dato)){
                    res=quitaÚltimo();
                }
                else{
                    if(primero.getDato().compareTo(dato)<0&&último.getDato().compareTo(dato)>0){
                        Nodo<T> pos=buscaAnterior(dato);
                        
                        if(pos.getSig().getDato().equals(dato)){
                            Nodo<T> aux=pos.getSig();
                            res=aux.getDato();
                            pos.setSig(aux.getSig());
                            aux.setSig(null);
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    private Nodo<T> buscaAnterior(T dato){
        Nodo<T> ant=primero;
        Nodo<T> act=primero.getSig();
                        
        while(act!=null&&act.getDato().compareTo(dato)<0){
            ant=act;
            act=act.getSig();
        }
        
        return ant;
    }
    
    public boolean equals(Object otra){
        boolean res=true;

        if(otra!=null&&otra instanceof ListaOrdenada){
            ListaOrdenada a=(ListaOrdenada)otra;
            if(this.calculaTamaño()==a.calculaTamaño()){
                Nodo<T> act=primero;
                Nodo<T> act2=a.primero;
                
                res=equals(act,act2,res);
            }
            else{
                res=false;
            }
        }
        else{
            res=false;
        }
        
        return res;
    }
    
    private boolean equals(Nodo<T> act, Nodo<T> act2,boolean res){
        if(act!=null&&res){
            if(!act.getDato().equals(act2.getDato())){
                res=false;
            }
            act=act.getSig();
            act2=act2.getSig();
            return equals(act,act2,res);
        }
        else{
            return res;
        }
    }
}
