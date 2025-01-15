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
public class ColaA <T> implements ColaADT<T>{
    private T[] cola;
    private int inicio;
    private int fin;
    private final int MAX=30;

    public ColaA() {
        inicio=-1;
        fin=-1;
        cola=(T[]) new Object[MAX];
    }
    
    public ColaA(int max) {
        inicio=-1;
        fin=-1;
        cola=(T[]) new Object[max];
    }
    
    public boolean estaVacia() {
        return inicio==-1;
    }

    public T consultaPrimero() {
        if(estaVacia()){
            throw new EmptyCollectionException();
        }
        
        return cola[inicio];
    }

    public void agrega(T dato) {
        if(estaVacia()){
            inicio=0;
        }
        else{
            if((fin+1)%cola.length==inicio){
                fin=inicio-1;
                expande();
            }
        }
        fin=(fin+1)%cola.length;
        cola[fin]=dato;
    }
    
    public void expande(){
        T[] nuevo = (T[])new Object[2*cola.length];
        int n,j;
        
        n=cola.length;
        
        for(int i=0; i<n; i++){
            j=(inicio+i)%n;
            nuevo[i]=cola[j];
        }
        
        inicio=0;
        fin=n-1;
        cola=nuevo;
    }

    public T quita() {
        if(estaVacia()){
            throw new EmptyCollectionException();
        }
        T resul;
        
        resul=cola[inicio];
        if(inicio==fin){
            inicio=-1;
            fin=-1;
        }
        else{
            inicio=(inicio+1)%cola.length;
        }
        
        return resul;
    }

    public int cuentaElementos() {
        int res=0;
        
        if(inicio>-1){
            if(fin<inicio){
                res=cola.length-inicio;
                res+=fin+1;

            }
            else{
                res=fin-inicio+1;
            }
        }
        return res;
    }

    public T cosultaUltimo() {
        if(estaVacia()){
            throw new EmptyCollectionException();
        }
        return cola[fin];
    }

    public ArrayList<T> multiQuita(int n) {
        ArrayList<T> res= new ArrayList();
        
        if(n<cuentaElementos()){
            int i=0;
            while(i<n){
                res.add(cola[inicio]);
                if(fin<inicio&&inicio==cola.length){
                    inicio=0;
                }
                else{
                    inicio++;
                }
                i++;
            }
            
            if(inicio==fin){
                inicio=-1;
                fin=-1;
            }
        }
        
        return res;
    }
    
    public boolean noHayVecinosIguales(){
        boolean res=true;
        int i;
        
        if(fin<inicio){
            i=inicio;
            while(i<cola.length-1&&res){
                if(cola[i].equals(cola[i+1])){
                    res=false;
                }
                else{
                    i++;
                }
            }
            if(res){
                i=0;
                while(i<fin){
                    if(cola[i].equals(cola[i+1])){
                    res=false;
                }
                else{
                    i++;
                }
                }
            }
        }
        else{
            i=inicio;
            while(i<fin-1&&res){
                if(cola[i].equals(cola[i+1])){
                    res=false;
                }
                else{
                    i++;
                }
            }
        }
        return res;
    }
    
    
    
    
    public String toString(){
        StringBuilder cad= new StringBuilder();
        int i=inicio;
        
        if(!estaVacia()){
            if(fin>inicio){
                while(i<=fin){
                    cad.append(cola[i]);
                    i++;
                }
            }
            else{
                while(i<cola.length){
                    cad.append(cola[i]);
                    i++;
                }
                i=0;
                while(i<=fin){
                    cad.append(cola[i]);
                    i++;
                }
            }
        }
        
        return cad.toString();
    }
    
}
