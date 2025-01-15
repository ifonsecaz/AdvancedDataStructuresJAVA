/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author ifonsecaz
 */
public class ConjuntoEE<T> implements ConjuntoADT<T> {

    private EstructuraEnlazada conjunto;

    public ConjuntoEE() {
        conjunto = new EstructuraEnlazada();
    }

    public Iterator<T> iterator() {
        Iterator<T> a = conjunto.iterator();
        return a;
    }

    public boolean agrega(T elem) {
        boolean res = false;
        if (conjunto.buscaDato(elem)) {
            conjunto.agregaFinal(elem);
            res = true;
        }

        return res;
    }

    public T quita(T elem) {
        T res = (T) conjunto.quitaDato(elem);

        return res;
    }

    public boolean contiene(T elem) {
        return conjunto.buscaDato(elem);
    }

    public int getCardinalidad() {
        int res = 0;

        if (conjunto.estaVacio()) {
            res = getCardinalidad(iterator(), res);
        }

        return res;
    }

    private int getCardinalidad(Iterator<T> it, int res) {
        if (it.hasNext()) {
            it.next();
            return getCardinalidad(it, res + 1);
        } else {
            return res;
        }
    }

    public boolean estaVacio() {
        return conjunto.estaVacio();
    }

    public ConjuntoADT<T> u(ConjuntoADT<T> conj2) {
        
        if (conj2 == null) {
            throw new EmptyCollectionException();
        }
        ConjuntoADT<T> res=new ConjuntoEE();
        copiaConj(this.iterator(),res);
        copiaConj(conj2.iterator(),res);
        
        return res;
    }
    
    private void copiaConj(Iterator<T> it, ConjuntoADT<T> res){
        if(it.hasNext()){
            res.agrega(it.next());
            copiaConj(it,res);
        }
    }

    public ConjuntoADT<T> inter(ConjuntoADT<T> conj2) {
        if(conj2==null){
            throw new EmptyCollectionException();
        }
        
        ConjuntoADT<T>res= new ConjuntoEE();
        Iterator aux=this.iterator();
        
        while(aux.hasNext()){
            T dato=(T)aux.next();
            if(conj2.contiene(dato)){
                res.agrega(dato);
            }
        }
        
        return res;
    }

    public ConjuntoADT<T> dif(ConjuntoADT<T> conj2) {
        if(conj2==null){
            throw new EmptyCollectionException();
        }
        
        ConjuntoADT<T> res= new ConjuntoEE();
        copiaConj(this.iterator(),res);
        
        Iterator aux=conj2.iterator();
        
        while(aux.hasNext()){
            T dato=(T)aux.next();
            res.quita(dato);
        }
        
        return res;
    }

}
