/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ifonsecaz
 */
public class PilaEE <T> implements PilaADT<T>{

    private EstructuraEnlazada pila;
   
    public PilaEE() {
        pila= new EstructuraEnlazada();
    }

    public void push(T dato) {
        Nodo<T> nuevo= new Nodo(dato);

        pila.agregaInicio(dato);
    }


    public T pop() {
        return (T)pila.quitaPrimero();
    }


    public T peek() {
        return (T)pila.getPrimerDato();
    }


    public boolean isEmpty() {
        return pila.estaVacio();
    }
    
}
