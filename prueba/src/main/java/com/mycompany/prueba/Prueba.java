/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/**
 *
 * @author ifons
 */
class Nodo<T extends Comparable<T>>{
    private T dato;
    private Nodo<T> sig;
    
    public Nodo(){
        this.sig=null;
        this.dato=null;
    }
    
    public Nodo(T dato){
        this.sig=null;
        this.dato=dato;
    }
    
    public void setDato(T dato){
        this.dato=dato;
    }
    
    public void setSig(Nodo<T> sig){
        this.sig=sig;
    }
    
    public T getDato(){
        return dato;
    }
    
    public Nodo getNodo(){
        return sig;
    }
}

class NodoArbol<T extends Comparable<T>>{
    private T dato;
    private NodoArbol<T> izq;
    private NodoArbol<T> der;
    private NodoArbol<T> padre;
    
    public NodoArbol(){
        this.izq=null;
        this.der=null;
        this.dato=null;
        this.padre=null;
    }
    
    public NodoArbol(T dato){
        this.izq=null;
        this.der=null;
        this.padre=null;
        this.dato=dato;
    }
    
    public void setDato(T dato){
        this.dato=dato;
    }
    
    public void cuelga(NodoArbol<T> nuevo){
        if(nuevo.getDato()!=null){
            if(nuevo.getDato().compareTo(dato)<=0){
                izq=nuevo;
            }
            else{
                der=nuevo;
            }
        }
    }

    public void setPadre(NodoArbol<T> padre){
        this.padre=padre;
    }
    
    public void setIzq(NodoArbol<T> izq){
        this.izq=izq;
    }
    
    public void setDer(NodoArbol<T> der){
        this.der=der;
    }
    
    public T getDato(){
        return dato;
    }
    
    public NodoArbol getPadre(){
        return padre;
    }
    
    public NodoArbol getIzq(){
        return izq;
    }
    
    public NodoArbol getDer(){
        return der;
    }
   
}

class Arbol<T extends Comparable<T>>{
    private NodoArbol<T> raiz;
    
    public Arbol(){
        raiz=null;
    }
    
    public void inserta(T dato){
        if(raiz==null){
            raiz=new NodoArbol(dato);
        }
        else{
            NodoArbol a=recorre(dato,raiz,raiz);
            NodoArbol<T> nuevo=new NodoArbol(dato);
            a.cuelga(nuevo);
            nuevo.setPadre(a);
        }
    }
    
    private NodoArbol recorre(T dato,NodoArbol<T> act,NodoArbol<T> ant){
        if(act==null){
            return ant;
        }
        if(act.getDato().compareTo(dato)<=0){
            return recorre(dato,act.getDer(),act);
        }
        return recorre(dato,act.getIzq(),act);
    }
    
    public boolean busca(T dato){
        boolean res=false;
        NodoArbol<T> aux;
        if(raiz!=null){
            aux=buscaRe(dato,raiz);
            if(aux!=null){
                res=true;
            }
        }
        return res;
    }
    
    public boolean elimina(T dato){
        boolean res=false;
        if(raiz!=null){
            NodoArbol<T> aux=buscaRe(dato,raiz);
            
            if(aux!=null){
                res=true;
                NodoArbol<T> padre=aux.getPadre();


                if(aux.equals(raiz)){
                    if(aux.getDer()==null&&aux.getIzq()==null){
                        raiz=null;
                    }
                    else{
                        if(aux.getDer()!=null&&aux.getIzq()==null){
                            raiz=aux.getDer();
                            raiz.setPadre(null);
                            aux=null;
                        }
                        else{
                            if(aux.getDer()==null&&aux.getIzq()!=null){
                                raiz=aux.getIzq();
                                raiz.setPadre(null);
                                aux=null;
                            }
                            else{
                                NodoArbol<T> rem=aux.getIzq();
                                while(rem.getDer()!=null){
                                    rem=rem.getDer();
                                }
                                raiz=rem;
                                rem.getPadre().setDer(rem.getIzq());
                                rem.setPadre(null);
                                
                            }
                        }
                    }
                }
                else{
                    if(aux.getDer()==null&&aux.getIzq()==null){
                        if(padre.getIzq()!=null&&padre.getIzq().equals(aux)){
                            padre.setIzq(null);
                        }
                        else{
                            padre.setDer(null);
                        }
                        aux=null;
                    }
                    else{
                        if(aux.getDer()!=null&&aux.getIzq()==null){
                            if(padre.getIzq()!=null&&padre.getIzq().equals(aux)){
                                padre.setIzq(aux.getDer());
                            }
                            else{
                                padre.setDer(aux.getDer());
                            }
                            aux.getDer().setPadre(padre);

                            aux=null;
                        }
                        else{
                            if(aux.getDer()==null&&aux.getIzq()!=null){
                                if(padre.getIzq()!=null&&padre.getIzq().equals(aux)){
                                    padre.setIzq(aux.getIzq());
                                }
                                else{
                                    padre.setDer(aux.getIzq());
                                }
                                aux.getIzq().setPadre(padre);
                                aux=null;
                            }
                            else{
                                NodoArbol<T> rem=aux.getIzq();
                                while(rem.getDer()!=null){
                                    rem=rem.getDer();
                                }
                                if(padre.getIzq().equals(aux)){
                                    padre.setIzq(rem);
                                }
                                else{
                                    padre.setDer(rem);
                                }
                                rem.getPadre().setDer(rem.getIzq());
                                rem.setPadre(padre);
                                rem.setDer(aux.getDer());
                                rem.setIzq(aux.getIzq());
                                aux.getDer().setPadre(rem);
                                aux.getIzq().setPadre(rem);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    
    private NodoArbol buscaRe(T dato, NodoArbol<T> act){
        if(act==null){
            return null;
        }
        if(act.getDato().equals(dato)){
            return act;
        }
        if(act.getDato().compareTo(dato)<0){
            return buscaRe(dato,act.getDer());
        }
        return buscaRe(dato,act.getIzq());
    }
    
    public String imprime(){
        StringBuilder cad=new StringBuilder();
        if(raiz!=null){
            imprimeRe(cad,raiz);
            
            return cad.toString();

        }
        
        return "vacio";
    }
    
    private void imprimeRe(StringBuilder cad,NodoArbol<T> act){ //inorden
        if(act.getIzq()!=null){
            imprimeRe(cad,act.getIzq());
        }
        cad.append(act.getDato().toString());
        cad.append(" ");
        if(act.getDer()!=null){
            imprimeRe(cad,act.getDer());
        }
    }
    
    public String imprimeNiveles(){
        StringBuilder cad=new StringBuilder();
        if(raiz!=null){
            Queue<NodoArbol<T>> queue = new LinkedList<>();
            queue.add(raiz);
            while(!queue.isEmpty()){
                NodoArbol<T> aux=queue.remove();
                cad.append(aux.getDato().toString());
                cad.append(" ");
                if(aux.getIzq()!=null){
                    queue.add(aux.getIzq());
                }
                if(aux.getDer()!=null){
                    queue.add(aux.getDer());
                }
            }
            return cad.toString();

        }
        
        return "vacio";
    }
  
    
}



public class Prueba <T extends Comparable<T>>{

    
    public static void mergeSortArrReCo(int[] arr){
        if(arr.length==1){
            return;
        }
        int fin=arr.length;
        int mitad=fin/2;
        int[] izq=Arrays.copyOfRange(arr, 0, mitad);
        int[] der=Arrays.copyOfRange(arr, mitad, fin);
        mergeSortArrReCo(izq);
        mergeSortArrReCo(der);
        
        int i=0;
        int j=0;
        int cont=0;
        while(i<izq.length&&j<der.length){
            if(izq[i]<=der[j]){
                arr[cont]=izq[i];
                i++;
            }
            else{
                arr[cont]=der[j];
                j++;
            }
            cont++;
        }
        if(i<izq.length){
            while(i<izq.length){
                arr[cont]=izq[i];
                cont++;
                i++;
            }
        }
        else{
            if(j<der.length){
                while(j<der.length){
                  arr[cont]=der[j];
                  cont++;
                  j++;
                }
            }
        }
    }
    
    public static void mergeSortArrRe(int[] arr,int inicio, int fin){
        if(fin-inicio==1){
            return;
        }
        int mitad=inicio+(fin-inicio)/2;

        mergeSortArrRe(arr,inicio,mitad);
        mergeSortArrRe(arr,mitad,fin);
        //mergesort requiere si o si un arreglo aux
        int[] temp=new int[fin-inicio];
        int i=inicio;
        int j=mitad;
        int cont=0;
        while(i<mitad&&j<fin){
            if(arr[i]<=arr[j]){
                temp[cont]=arr[i];
                i++;
            }
            else{
                temp[cont]=arr[j];
                j++;
            }
            cont++;
        }
        if(i<mitad){
            while(i<mitad){
                temp[cont]=arr[i];
                cont++;
                i++;
            }
        }
        else{
            if(j<fin){
                while(j<fin){
                  temp[cont]=arr[j];
                  cont++;
                  j++;
                }
            }
        }
        int k=0;
        while(k<temp.length){
            arr[inicio+k]=temp[k];
            k++;
        }
    }
    
    public static Nodo mergeSortNod(Nodo cabeza,int len){
        if(len==1){
            return cabeza;
        }
        int mitad=len/2;
        int n=0;
        Nodo aux2,aux3;
        Nodo aux=cabeza;
        while(n<mitad){
            aux=aux.getNodo();
            n++;
        }
        aux2=mergeSortNod(cabeza,mitad);
        aux3=mergeSortNod(aux,len-mitad);
        //mergesort requiere si o si un arreglo aux
        Nodo temp,tempCabeza;
        int i=0;
        int j=0;
        int cont=0;
        if(aux2.getDato().compareTo(aux3.getDato())<=0){
                temp=aux2;
                tempCabeza=aux2;
                aux2=aux2.getNodo();
                i++;
                
        }else{
            temp=aux3;
            tempCabeza=aux3;
            aux3=aux3.getNodo();
            j++;
        }
        
        while(i<mitad&&j<(len-mitad)){
            if(aux2.getDato().compareTo(aux3.getDato())<=0){
                temp.setSig(aux2);
                temp=aux2;
                aux2=aux2.getNodo();
                i++;
            }
            else{
                temp.setSig(aux3);
                temp=aux3;
                aux3=aux3.getNodo();
                j++;
            }
            cont++;
        }
        if(i<mitad){
            while(i<mitad){
                temp.setSig(aux2);
                temp=aux2;
                aux2=aux2.getNodo();
                cont++;
                i++;
            }
        }
        else{
            if(j<(len-mitad)){
                while(j<(len-mitad)){
                  temp.setSig(aux3);
                  temp=aux3;
                  aux3=aux3.getNodo();
                  cont++;          
                  j++;
                }
            }
        }
        temp.setSig(null);
        return tempCabeza;
    }
    
    
    public static void main(String[] args) {
        //int[] a={1,2,3,4,5,6,7,8,9,10};
        int[] a={7,2,5,8,10,3,1,9,4,6};
        int[] a1={7,2,5,8,10,3,1,9,4,6};
        Nodo cabeza=new Nodo(7);
        Nodo aux,aux2;
        int n=0;
        aux2=cabeza;
        while(n<9){
            aux=new Nodo(a[n+1]);
            aux2.setSig(aux);
            aux2=aux;
            n++;
        }
        mergeSortArrRe(a1,0,10);
        
        int k=0;
        while(k<a1.length){
            System.out.println(a1[k]);
            k++;
        }
        System.out.println("fin");
        
        
        aux=mergeSortNod(cabeza,10);
        
        System.out.println(aux.getDato());
        while(aux.getNodo()!=null){
            aux=aux.getNodo();
            System.out.println(aux.getDato());
        }
        System.out.println("fin nod");
        int i=0;
        Arbol b=new Arbol();

        while(i<a.length){
            b.inserta(a[i]);
            i++;
        }
        System.out.println("a");
                System.out.println(b.imprimeNiveles());

        System.out.println(b.imprime());
        System.out.println(b.busca(5));
        System.out.println(b.elimina(5));
        System.out.println(b.imprime());
        System.out.println(b.imprimeNiveles());
        
        
    }
}
