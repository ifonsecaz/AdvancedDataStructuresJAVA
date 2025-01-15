/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author hca
 */
public class ListedBT <T extends Comparable<T>> implements BinaryTreeADT<T>{
    protected NodoBT<T> raiz;
    protected int cont;
    
    public ListedBT() {
        raiz=null;
        cont=0;
    }
    
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int size() {
        return cont;
    }

    public boolean conatins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T find(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public Iterator<T> inorden() {
        ArrayList<T> lista=new ArrayList<T>();
        
        inorden(raiz,lista);
        
        return lista.iterator();
    }
    
    private void inorden(NodoBT<T> act, ArrayList lista){
        if(act!=null){
            
            preorden(act.getIzq(),lista);
            lista.add(act.getElem());
            preorden(act.getDer(),lista);
        }
    }

    public Iterator<T> postorden() {
        ArrayList<T> lista=new ArrayList<T>();
        
        postorden(raiz,lista);
        
        return lista.iterator();
    }
    
    /*
    private void postorden(NodoBT<T> act, ArrayList lista){
        if(act.izq!=null){
            postorden(act.izq,lista);
        }
        if(act.der!=null){
            postorden(act.der,lista);
        }
        
        lista.add(act);
    }
    */
    private void postorden(NodoBT<T> act, ArrayList lista){
        if(act!=null){
            
            preorden(act.getIzq(),lista);
            
            preorden(act.getDer(),lista);
            
            lista.add(act.getElem());
        }
    }

    public Iterator<T> preorden() {
        ArrayList<T> lista=new ArrayList<T>();
      
        preorden(raiz,lista);
        
        return lista.iterator();
    }
    /*
    private void preorden(NodoBT<T> act, ArrayList lista){
        lista.add(act);
        
        if(act.izq!=null){
            preorden(act.izq,lista);
        }
        if(act.der!=null){
            preorden(act.der,lista);
        }
    }
    */
    
    private void preorden(NodoBT<T> act, ArrayList lista){
        if(act!=null){
            lista.add(act.getElem());
            
            preorden(act.getIzq(),lista);
            
            preorden(act.getDer(),lista);
        }
    }
    
    public Iterator<T> levelOrderPila(){
        Stack<NodoBT<T>> pila=new Stack();
        ArrayList<T> lista= new ArrayList();
        
        pila.push(raiz);
        
        while(!pila.isEmpty()){
            NodoBT<T> act=pila.pop();
            lista.add(act.getElem());
            if(act.getDer()!=null){
                pila.push(act.getDer());
            }
            if(act.getIzq()!=null){
                pila.push(act.getIzq());
            }
        }
        
        return lista.iterator();
    }
    
    public Iterator<T> levelorderCola(){
        Queue <NodoBT<T>> cola=new LinkedList();
        ArrayList<T> lista= new ArrayList();
        
        cola.add(raiz);
        
        while(!cola.isEmpty()){
            NodoBT<T> act=cola.remove();
            lista.add(act.getElem());
            if(act.getDer()!=null){
                cola.add(act.getDer());
            }
            if(act.getIzq()!=null){
                cola.add(act.getIzq());
            }
        }
        
        return lista.iterator();
    }
      
    private int altura(NodoBT<T> act){
        if(act==null)
            return 0;
        
        return 1+Math.max(altura(act.getIzq()),altura(act.getDer()));
    }
    
    
    
    public int altura(){
        int[] a={0};
        altura(raiz,0,a);
        
        return a[0];
    }
    
    private void altura(NodoBT<T> act, int i, int[] max){
        if(act!=null){
            if(act.getIzq()!=null){
                altura(act,i++,max);
            }
            if(act.getDer()!=null){
                altura(act,i++,max);
            }
        }
        else{
            if(i>max[0]){
                max[0]=i;
            }
        }
    }
}
