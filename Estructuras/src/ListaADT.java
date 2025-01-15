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
public interface ListaADT<T> extends Iterable<T> {
    public Iterator<T> iterator();
    public boolean estaVacía();
    public T quitaPrimero();
    public T quitaÚltimo();
    public T quita(T dato);
    public String toString();
    public boolean contiene(T dato);
    public int calculaTamaño();
    public T obtienePrimero();
    public T obtieneÚltimo();
}
