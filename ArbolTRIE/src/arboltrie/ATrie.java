/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboltrie;

import java.util.ArrayList;

/**
 *
 * @author hca
 */
public class ATrie <T>{
    private NodoTrie<T> raiz;
    private Character[] simbolos;
    
    public ATrie() {
        raiz=null;
        simbolos=new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
    
    public ATrie(Character[] sim){
        simbolos=sim.clone();
        AlgoritmosOrdenamiento.mergeSortO(simbolos);
    }
    
    public boolean busca(String palabra){
        boolean res=false;
        boolean aux=true;
        int len=palabra.length();
        int i=0;
        int pos;
        NodoTrie<T> act=raiz;
        
        if(raiz!=null){
            while(i<len&&aux&&!res){
                act=act.getSig(palabra.charAt(i));
                if(act==null){
                    aux=false;
                }    
                i++;
            }
            
            if(aux&&act.isFinPalabra()!=0){
                res=true;
            }
        }
        return res;
    }
    
    public boolean buscaRe(String llave){
        boolean res=false;
        
        res=buscaRe(llave,raiz);
        
        return res;
    }
    
    private boolean buscaRe(String llave,NodoTrie act){
        if(act==null){
            return false;
        }
        
        if(llave.equals("")){
            if(act.isFinPalabra()!=0){
                return true;
            }
            return false;
        }
        /*
        int aux=posicion(llave.charAt(1));
        if(aux!=-1){
            act=act.get(aux);
        }
        
        return buscaRe(llave.substring(1),act);
        */
        return buscaRe(llave.substring(1),act.getSig(llave.charAt(0)));
    }
    
    public boolean remover(String palabra){
        boolean res=false;
        
        if(raiz!=null){
            res=remover(palabra,raiz,res);
        }
        return res;
    }
    
    private boolean remover(String llave,NodoTrie<T> act, boolean res){
        if(llave.length()==0){
            if(act.isFinPalabra()>0){
                act.setFinPalabra(0);
                return true;
            }
        }
        else{
            char a=llave.charAt(0);
            NodoTrie<T> aux=act.getSig(a);
            if(llave.length()>1){
                llave=llave.substring(1);
            }
            else{
                llave="";
            }
            if(aux!=null){
                res=remover(llave,aux,res);
            }
        
            if(res&&aux.isFinPalabra()==0){
                if(!aux.hayOtrosHijos()){
                    act.setNull(a);
                }
            }
        }
        return res;
    }
    
    //Profesor No funciona
    public boolean borra(String llave){
        NodoTrie<T>[] res= new NodoTrie[1];
        NodoTrie<T> a=borra(llave,raiz,res);
        if(res[0]==null){
            return false;
        }
        else{
            return true;
        }
    }
    
    private NodoTrie<T> borra(String llave, NodoTrie<T> act, NodoTrie<T>[] res){
        if(act!=null){
            if(llave==""){
                if(act.isFinPalabra()!=0){
                    res[0]=act;
                }
                act.setFinPalabra(0);
                boolean vacio=act.hayOtrosHijos();
                if(!vacio){
                    return null;
                }
                return act;
            }
            char simbolo=llave.charAt(0);
            NodoTrie<T> sig=act.getSig(simbolo);
            if(llave.length()>1){
                llave=llave.substring(1);
            }
            else{
                llave="";
            }
            NodoTrie<T> temp=borra(llave,sig,res);
            if(temp==null){
                act.setNull(simbolo);
            }
            if(act.isFinPalabra()==0&!act.hayOtrosHijos()){
                return null;
            }
            else{
                return act;
            }
        }
        else{
            throw new RuntimeException("La palabra no está registrada");
        }
    }
    
    
    public void inserta(String palabra){
        int len=palabra.length();
        int i=0;
        int pos;
        char valor;
        NodoTrie<T> act=raiz;
        
        if(raiz==null){
            NodoTrie<T> nuevo=new NodoTrie<T>(simbolos);
            act=nuevo.add(palabra.charAt(0));
            raiz=nuevo; 
            i++;
        }
        
        while(i<len){
            act=act.add(palabra.charAt(i));
            i++;
        }
        act.setFinPalabra(act.isFinPalabra()+1);
    }
    
    public void insertaRe(String palabra){
        if(raiz==null){
            NodoTrie<T> nuevo= new NodoTrie<T>(simbolos);
            raiz=nuevo;
        }
        insertaRe(palabra,raiz);
    }
    
    private void insertaRe(String llave,NodoTrie<T> act){
        if(llave==""){
            act.setFinPalabra(act.isFinPalabra()+1);
            return;
        }
        act=act.add(llave.charAt(0));
        
        if(llave.length()>1){
            llave=llave.substring(1);
        }
        else{
            llave="";
        }
        insertaRe(llave,act);
    }
    
    private int posicion(char a){
        int res=-1;
        int i=0;
        
        while(i<simbolos.length&&res==-1){
            if(simbolos[i]!=null&&simbolos[i]==a){
                res=i;
            }
        }
        
        return res;
    }
    
    public String[] ordenamientoLexicografico(String[] res,Character[] simbolos){
        ATrie aux = new ATrie(simbolos);
        int[] cont= {0};
        for(int i=0; i<res.length; i++){
            aux.inserta(res[i]);
        }
        
        if(aux.raiz!=null){
            ordenamientoLexicografico("",aux.raiz,res,cont);
        }
        return res;
    }
    
    private void ordenamientoLexicografico(String cad, NodoTrie<T> act, String[] res, int[] cont){
        String aux2;
        if(act.isFinPalabra()>0){
            for(int i=0; i<act.isFinPalabra();i++){
                res[cont[0]]=cad;
                cont[0]=cont[0]+1;
            }
        }
        int pos=act.sigNodo(0);
        while(pos!=-1){
            aux2=cad+simbolos[--pos];
            ordenamientoLexicografico(aux2,act.getNodoPos(pos),res,cont);
            pos=act.sigNodo(++pos);
        }   
    }
}
