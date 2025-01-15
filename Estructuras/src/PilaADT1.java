/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edi
 */
public interface PilaADT1 <T>{
    public void push(T dato, char tipo);
    
    public T pop(char tipo);
    
    public T peek(char tipo);
    
    public boolean isEmpty(char tipo);
    
    public void multiPop(int n, char tipo);
    
}
