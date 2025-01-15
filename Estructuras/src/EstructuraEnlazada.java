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
public class EstructuraEnlazada <T> implements Iterable<T>{
    private Nodo<T> primero;

    public EstructuraEnlazada() {
        this.primero=null;
    }
    
    public boolean estaVacio(){
        return primero==null;
    }
    
    public void agregaInicio(T dato){
        if(dato!=null){
            Nodo<T> nuevo=new Nodo(dato);
            nuevo.setSig(primero);
            primero=nuevo;
        }
    }
    
    public void agregaFinal(T dato){
        if(dato!=null){
            if(estaVacio()){
                agregaInicio(dato);
            }
            else{
                Nodo<T> nuevo=new Nodo(dato);
                Nodo<T> act=primero;
                
                while(act.getSig()!=null){
                    act=act.getSig();
                }
                
                act.setSig(nuevo);
            }
        }
    }
    
    public String toString(){
        String cad;
        
        if(!estaVacio()){
            cad=toString(new StringBuilder(),primero);
        }
        else{
            cad="";
        }
        return cad;
    }
    
    private String toString(StringBuilder cad, Nodo<T> act){
        if(act==null){
            return cad.toString();
        }
        else{
            cad.append("\n");
            cad.append(act.toString());
            act=act.getSig();
            return toString(cad,act);
        }
    }
    
    public boolean buscaDato(T dato){
        return buscaDato(dato,primero);
    }
    
    private boolean buscaDato(T dato, Nodo<T> act){
        if(act==null){
            return false;
        }
        else{
            if(act.getDato().equals(dato)){
                return true;
            }
            else{
                return buscaDato(dato,act.getSig());
            }
        }
    }
    
    public T quitaPrimero(){
        T res;
        Nodo<T> aux;
        
        if(estaVacio()){
            res=null;
        }
        else{
            aux=primero;
            res=primero.getDato();
            primero=primero.getSig();
            aux.setSig(null);
        }
        return res;
    }
    
    public T quitaUltimo(){
        T res;
        
        if(estaVacio()){
            res=null;
        }
        else{
            if(primero.getSig()==null){
                res=quitaPrimero();
            }
            else{
                Nodo<T> ant=primero;
                Nodo<T> act=primero.getSig();
                
                while(act.getSig()!=null){
                    ant=act;
                    act=act.getSig();
                }
                
                res=act.getDato();
                ant.setSig(null);
            }
        }
        return res;
    }
    
    public T quitaDato(T dato){
        T res=null;
        
        if(!estaVacio() && dato!=null){
            
            Nodo<T> act =primero.getSig();
            
            if(!primero.getDato().equals(dato)){
                
                if(primero.getSig()!=null){
                    Nodo<T> ant =primero;
                
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
            else{
                res=primero.getDato();
                primero.setSig(null);
                primero=act;
            }
        }
        return res;
    }
    
    public T getPrimerDato(){
        T res=null;
        
        if(estaVacio()){
            res=primero.getDato();
        }
        
        return res;
    }
    
    public boolean eliminaSiguienteDe(T dato){
        boolean res=false;
        
        if(dato!=null&&!estaVacio()){
            Nodo<T> ant=primero;
            
            while(ant.getSig()!=null&&!ant.getDato().equals(dato)){
                ant=ant.getSig();
            }
            
            if(ant.getDato().equals(dato)&&ant.getSig()!=null){
                Nodo<T> act=ant.getSig();
                
                ant.setSig(act.getSig());
                act.setSig(null);
                
                res=true;
            }
        }
        
        return res;
    }
    
    public boolean eliminaAnteriorDe(T dato){
        boolean res=false;
        
        if(dato!=null&&!estaVacio()){
            if(!primero.getDato().equals(dato)){
                if(primero.getSig()!=null){
                    Nodo<T> act=primero.getSig();
                    
                    if(act.getDato().equals(dato)){
                        res=true;
                        primero.setSig(null);
                        primero=act;
                        //quitaPrimero();
                    }
                    else{
                        if(act.getSig()!=null){
                            act=act.getSig();
                            Nodo<T> ant=primero;
                            
                            while(act.getSig()!=null&&!act.getDato().equals(dato)){
                                ant=ant.getSig();
                                act=act.getSig();
                            }
                    
                            if(act.getDato().equals(dato)){
                                act=ant.getSig();
                                ant.setSig(act.getSig());
                                act.setSig(null);
                                res=true;
                            }
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    public boolean insertaAntesQue(T refer, T nuevo){
        boolean res=false;
        
        if(nuevo!=null&&refer!=null&&!estaVacio()){
            if(primero.getDato().equals(refer)){
                Nodo<T> n= new Nodo(nuevo);
                
                n.setSig(primero);
                primero=n;
                res=true;
            }
            else{
                if(primero.getSig()!=null){
                    Nodo<T> act=primero.getSig();
                    Nodo<T> ant=primero;
                    
                    while(act.getSig()!=null&&!act.getDato().equals(refer)){
                        ant=act;
                        act=act.getSig();
                    }
                    
                    if(act.getDato().equals(refer)){
                        Nodo<T> n= new Nodo(nuevo);
                        
                        n.setSig(ant.getSig());
                        ant.setSig(n);
                        
                        res=true;
                    }
                }
            }
        }
        
        return res;
    }
    
    public int eliminaTodosRepetidosOrdenado(){
        int res=0;
        
        if(!estaVacio()){
            if(primero.getSig()!=null){
                Nodo<T> ant=primero;
                Nodo<T> act=primero.getSig();
                T dato=primero.getDato();
              
                if(act.getSig()==null&&act.getDato().equals(dato)){
                   primero.setSig(null);
                   res++;
                }
                else{
                    while(act.getSig()!=null){
                        while(act.getSig()!=null&&act.getDato().equals(dato)){
                            res++;
                            act=act.getSig();
                        }
                        ant.setSig(act);
                        
                        if(act.getSig()!=null){
                            if(!ant.getSig().equals(act)){
                                Nodo<T> elimina=ant.getSig();
                                
                                while(!elimina.getSig().equals(act)){
                                    ant=ant.getSig();
                                    elimina=elimina.getSig();
                                }
                                ant.setSig(null);
                            }
                            ant=act;
                            act=act.getSig(); 
                            dato=ant.getDato();
                        }
                    }
                    if(act.getSig()==null){
                        if(ant.getDato().equals(act.getDato())){
                            res++;
                            ant.setSig(null);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    public int eliminaTodosRepetidosDesordenados(){
        int res=0;
        
        if(!estaVacio()&&primero.getSig()!=null){
            Nodo<T> ant=primero;
            Nodo<T> act=ant.getSig();
            Nodo<T> refer=ant;
            T dato=ant.getDato();
            
           
            if(refer.getSig().getSig()!=null){
                while(ant!=null&&ant.getSig()!=null){
                    while(act!=null){
                        if(act.getDato().equals(dato)){
                            refer.setSig(act.getSig());
                            act.setSig(null);
                            act=refer.getSig();
                            res++;
                        }
                        else{
                            refer=act;
                            act=act.getSig();
                        }
                    }
                    
                    ant=ant.getSig();
                    if(ant!=null&&ant.getSig()!=null){
                        refer=ant;
                        act=ant.getSig();
                        dato=ant.getDato();
                    }
                }
                
            }
        }
        return res;
    }
    
    public int eliminaRepetidos(){
        int res=0;
        if(!estaVacio()){
            if(primero.getSig()!=null){
                Nodo<T> act=primero;
                Nodo<T> aux,ant;
                T dato;
                
                while(act.getSig()!=null){
                    aux=act.getSig();
                    dato=act.getDato();
                    ant=act;
                    while(aux!=null){
                        if(aux.getDato().equals(dato)){
                            ant.setSig(aux.getSig());
                            res++;
                            aux.setSig(null);
                            aux=ant.getSig();
                        }
                        else{
                            ant=aux;
                            aux=aux.getSig();
                        }
                    }
                    
                    act=act.getSig();
                }
            }
        }
        
        return res;
    }
 
    public void mezclaEE (EstructuraEnlazada objEE){
        if(objEE!=null&&!objEE.estaVacio()){
            if(!estaVacio()){
                Nodo<T> act=primero;
                Nodo<T> act2=objEE.primero;
                Nodo<T> sig=primero.getSig();
                Nodo<T> sig2=objEE.primero.getSig();
                
                while(sig!=null&&sig2!=null){
                    act.setSig(act2);
                    act2.setSig(sig);
                    act=sig;
                    act2=sig2;
                    sig=sig.getSig();
                    sig2=sig2.getSig();
                }
                act.setSig(act2);
                act=act2;
                
                
                if(sig!=null){
                    act.setSig(sig);
                }
                
            }
            else{
                primero=objEE.primero;
            }
        }
    }
    
    public Iterator<T> iterator(){
        return new IteradorEE(primero);
    }
}
