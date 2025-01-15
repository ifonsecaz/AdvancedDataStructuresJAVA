/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package per;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ifons
 */
class Trie{
	public Nodo raiz;	
	public Trie(){
		raiz=new Nodo();
	}

	public Trie(char dato){
		raiz=new Nodo(dato);
	}
}

class Nodo{
	public char dato;
	public Nodo[] hijos;
	public int cont;	

	public Nodo(){
		dato=0;
		hijos=new Nodo[2];
		cont=0;
	}	

	public Nodo(char dato){
		this.dato=dato;
		hijos=new Nodo[2];
		cont=0;
	}
	
        public int getHijos(){
            return cont;
        }
        
        public char getDato(){
            return dato;
        }
	public void agregaHijo(char dato){
		Nodo hijo=new Nodo(dato);
		if(cont>=hijos.length){
			expande();
		}	
		hijos[cont]=hijo;
		cont++;			
	}
        
        public void agregaHijo(Nodo hijo){
		
		if(cont>=hijos.length){
			expande();
		}	
		hijos[cont]=hijo;
		cont++;			
	}
	
	public void quitaHijo(int indice){
		int i=indice;
		while(i+1<hijos.length&&hijos[i]!=null){
			hijos[i]=hijos[i+1];
			i++;
		}
		cont--;
		hijos[i]=null;
	}

	public Nodo getHijo(int indice){
		Nodo res=null;
		if(indice<hijos.length){
			res=hijos[indice];
		
		}
		return res;
	}	

	public void expande(){
		Nodo[] aux=new Nodo[hijos.length*2];
		for(int i=0; i<hijos.length;i++){
			aux[i]=hijos[i];
		}		
		hijos=aux;
	}
}

public class Per {
public static boolean noPrefix(String word,int cont, Nodo nodo,int addC) {
        if(cont<word.length()){
         
            int i=nodo.getHijos();
            int j=0;
            boolean encontro=false;
            while(j<i&&!encontro){
                Nodo hijo=nodo.getHijo(j);
    
                if(hijo.getDato()==word.charAt(cont)){
                    encontro=true;
                }
                j++;
            }
            if(!encontro){
                
                Nodo nuevo=new Nodo(word.charAt(cont));
                nodo.agregaHijo(nuevo);
                nodo=nuevo;
            }
            else{
                addC++;
                nodo=nodo.getHijo(j-1);
            }
        
            return noPrefix(word,cont+1,nodo,addC);
        }
        else{
            if(addC>0){
                return false;
            }
            else{
                return true;
            }
        }
    }
    public static void noPrefix(List<String> words) {
    // Write your code here
        Trie arbPRaiz=new Trie();
        boolean res=true;
        //TreeMap<Integer,String> tam=new TreeMap<>();
        //Collections.sort(words, Comparator.comparing(String::length));
        //Falta ordenar strings
        for(int i=0;i<words.size();i++){
            
            System.out.println(noPrefix(words.get(i),0,arbPRaiz.raiz,0));
                }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> palabras=new ArrayList<String>();
 

        
        palabras.add("abcde");
        palabras.add("abcd");
        palabras.add("bcde");
        palabras.add("bcd");
        
        
        System.out.println("algo");
        noPrefix(palabras);
        System.out.println("algo2");
    }
    
}
