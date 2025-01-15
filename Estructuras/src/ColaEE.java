/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ifonsecaz
 */
public class ColaEE<T> implements ColaADT<T>{

    private EstructuraEnlazada cola;

    public ColaEE() {
        cola= new EstructuraEnlazada();
    }
    
    public boolean estaVacia() {
        return cola.estaVacio();
    }

    public T consultaPrimero() {
        return (T)cola.getPrimerDato();
    }

    public void agrega(T dato) {
        cola.agregaFinal(dato);
    }

    public T quita() {
        return (T)cola.quitaPrimero();
    }

    public int cuentaElementos() {
        int res=0;
        
        if(!cola.estaVacio()){
            Iterator<T> a=cola.iterator();
            
            res++;
            while(a.hasNext()){
                a.next();
                res++;
            }
        }
        return res;
    }

    public T cosultaUltimo() {
        T res=(T)cola.quitaUltimo();
        cola.agregaFinal(res);
        
        return res;
    }
    
    public ArrayList<T> multiQuita(int n) {
        ArrayList<T> res= new ArrayList();
        
        if(cuentaElementos()>0&&cuentaElementos()>=n){

            for(int i=0; i<n; i++){
                res.add((T)cola.quitaPrimero());
            }
        }
        
        return res;
    }
    
}
