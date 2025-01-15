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
public class MetodosRecursivos {
    
    public static int calculaFactorial(int n){
        if(n==1||n==0){
            return 1;
        }
        else{
            return n*calculaFactorial(n-1);
        }
    }
    
    public static int fibo(int n){
        if(n==1||n==0){
            return n;
        }
        else{
            return fibo(n-1)+fibo(n-2);
        }
    }
    
    public static int fiboConMem(int n){
        int[] m= new int[n+1];
        int i=2;
        
        m[0]=0;
        if(n>0){
            m[1]=1;
        }
        rellenaArray(m,i);
        
        return fiboConMem(n,m);
    }
    
    private static void rellenaArray(int[] m,int i){
        if(m.length>i){
            m[i]=-1;
            rellenaArray(m,i+1);
        }
    }
    
    private static int fiboConMem(int n, int[] m){    
        
        if(m[n]==-1){
            m[n]=fiboConMem(n-1,m) + fiboConMem(n-2,m);
        }
        return m[n];

    }
    
    public static int sumaArreglo(int tot, int[] arre){
        if(tot==0){
            return 0;
        }
        else{
            return arre[tot-1]+ sumaArreglo(tot-1,arre);
        }
    }
    
    public static int sumaArreSP(int tot, int[]arre){
        return sumaArreSP(tot,arre,0);
    }
    
    private static int sumaArreSP(int tot, int[]arre, int suma){
        if(tot==0){
            return suma;
        }
        else{
            suma+=arre[tot-1];
            return sumaArreSP(tot-1,arre,suma);
        }
    }

    public static <T> boolean sonIguales(ConjuntoADT<T> c1, ConjuntoADT<T> c2){
       
        boolean a=false;
        
        
        if(c1!=null&&c2!=null){
            if(c1.getCardinalidad()==c2.getCardinalidad()){
                Iterator<T> cont= c1.iterator();
                a=sonIguales(c2,cont);
            }
        }
        
        return a;
    }
    
    private static <T> boolean sonIguales(ConjuntoADT<T> c2, Iterator<T> cont){
        if(cont.hasNext()){
            T aux=cont.next();
            Iterator<T> cont2=c2.iterator();
            if(!contiene(aux,cont2)){
                return false;
            }
            
            return sonIguales(c2,cont);
        }
        else{
            return true;
        }
        
    } 
    
    private static <T> boolean contiene(T e, Iterator<T> cont2){
        if(cont2.hasNext()){
            if(cont2.next().equals(e)){
                return true;
            }
            return contiene(e,cont2);
        }
        else{
            return false;
        }
    }
    
    public static <T> boolean sonIgualesSinR(ConjuntoADT<T> c1, ConjuntoADT<T> c2){
        ConjuntoADT<T> aux = new ConjuntoA();
        boolean res=false;
        
        if(c1!=null&&c2!=null){
            if(c1.getCardinalidad()==c2.getCardinalidad()){
                aux=c1.inter(c2);
            
                if(c1.getCardinalidad()==aux.getCardinalidad()){
                    res=true;
                }
            }
        }    
        return res;
    }
}
