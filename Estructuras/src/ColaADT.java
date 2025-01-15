/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author ifonsecaz
 */
public interface ColaADT <T>{
    public boolean estaVacia();
    public T consultaPrimero();
    public void agrega(T dato);
    public T quita();  
    
    public int cuentaElementos();
    public T cosultaUltimo();
    public ArrayList<T> multiQuita(int n);
    
}
