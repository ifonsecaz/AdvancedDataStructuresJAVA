/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author ifonsecaz
 */
public interface BinarySearchTreeAVL <T>{
    public void add(T elem);
    public boolean remove(T elem);
    public T buscar(T elem);
    public String imprimeIzqDerNivel();
}
