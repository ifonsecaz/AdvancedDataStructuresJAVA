/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edi
 */
public class PilaA1 <T> implements PilaADT1<T>{

    private  T[] pila;
    
    private int topeA;
    
    private int topeB;
    
    private final int MAX=100;

    public PilaA1() {
        pila= (T[])new Object[MAX];
        topeA=-1;
        topeB=MAX;
    }
    
    public PilaA1(int max) {
        pila= (T[])new Object[max];
        topeA=-1;
        topeB=max;
    }

    @Override
    public void push(T dato, char numPila) {
        
        switch(numPila){
            case 'A':
                if(topeA == pila.length-1&&topeA==topeB-1){
                     expande();
                }
                topeA++;
                pila[topeA]=dato;
                break;
            case 'B':
                if(topeB == 0&&topeA==topeB-1){
                    expande();
                }
                topeB--;
                pila[topeB]=dato;
                
                break;
        }
    }

    private void expande(){
        T[] nuevo=(T[])new Object [pila.length*2];
        
        for(int i=0; i<=topeA; i++){
            nuevo[i]=pila[i];
        }
        for(int i=pila.length; i>=topeB; i--){
            nuevo[i]=pila[i]; //mal
        }
        topeB=pila.length+topeB;
        pila=nuevo;
    }
    
    @Override
    public T pop(char tipoPila) {
        T res=null;
        
        switch(tipoPila){
            case 'A':
                if(isEmpty(tipoPila)){
                    throw new EmptyCollectionException();
                }
                
                res=pila [topeA];
                
                pila[topeA]=null;
                topeA--;
                break;
            case 'B':
                if(isEmpty(tipoPila)){
                    throw new EmptyCollectionException();
                }
                
                res=pila [topeB];
                
                pila[topeB]=null;
                topeB++;
                
                break;
        }
        
        return res;
    }

    @Override
    public void multiPop(int n,char tipoPila) {
        int i=0;
        PilaA aux= new PilaA();
        
        switch(tipoPila){
            case 'A':
                if(n<=topeA+1){
                    while(i<n){
                        pop(tipoPila);
                        i++;
                    }
                }
                break;
            case 'B':
                if(n<(pila.length-topeB)){
                    while(i<n){
                        pop(tipoPila);
                        i++;
                    }
                }
        }
    }
    
    

    @Override
    public T peek(char tipoPila) {
        T res=null;
        
        switch(tipoPila){
            case 'A':
                if(isEmpty(tipoPila)){
            throw new EmptyCollectionException();
                }
                else{
                    res= pila[topeA];
                }
                break;
            case 'B':
                if(isEmpty(tipoPila)){
                    throw new EmptyCollectionException();
                }
                else{
                    res=pila[topeB];
                }
                break;
        }
    
        return res;
    }

    @Override
    public boolean isEmpty(char tipoPila){
        boolean res=false;
        
       switch(tipoPila){
           case 'A':
               if(topeA==-1){
                   res=true;
               }
               break;
           case 'B':
               if(topeB==pila.length){
                   res=true;
               }
               
               break;
       }
        return res;
    }
}
