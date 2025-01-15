/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nreinas;
import java.util.ArrayList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author ifons
 */
public class NReinas {

    /**
     * @param args the command line arguments
     */
    public static boolean verifica(List<List<Integer>> tablero, int posR, int posC){
	int i=0;
	int n=tablero.size();
	//Check row
	while(i<posC){
		if(tablero.get(i).get(posR)==1){
			return false;
		}
		i++;
	} 
	//check upper diagonal
	i=posR-1;
	int j=posC-1;
	while(i>=0&&j>=0){
		if(tablero.get(j).get(i)==1){
			return false;
		}
		j--;
		i--;
	}
	//check under diagonal
	i=posR+1;
	j=posC-1;
	while(i<n&&j>=0){
		if(tablero.get(j).get(i)==1){
			return false;
		}
		j--;
		i++;
	}
	return true;
}

public static int asignaNum(List<List<Integer>> tablero,int contC,int startR, int total){
	if(startR<total){
		boolean res=verifica(tablero,startR, contC);
		if (res){
			return startR;
		}	
		else{
			return asignaNum(tablero, contC, startR+1,total);
		}
	}
	else{
		return total;
	}
}

public static boolean nReinas(List<List<Integer>> tablero,int contC,int startR,int posAnt, int total){
	if(contC>=total){
		//return true;	
                
                System.out.println(tablero.toString());
                return false;
	}
	else{
                int pos=asignaNum(tablero,contC,startR,total);
                
        
                boolean res;
		if(pos<total){
                        tablero.get(contC).set(pos, 1);
			res=nReinas(tablero,contC+1,0,pos,total);
		}
		else{
			return false;
		}
		if (res){
			return res;
		}
		else{
			tablero.get(contC).set(pos,0);
			return nReinas(tablero,contC,pos+1,0,total);			
		}			
	}
}

public static List<List<Integer>> nReinas(int numR){
    List<List<Integer>> tablero=new ArrayList<>();
    List<Integer> aux;
    for(int i=0; i<numR;i++){
	aux=new ArrayList<>();
        tablero.add(aux);
        for(int j=0;j<numR;j++){
	   tablero.get(i).add(0);
        }
    }

    nReinas(tablero,0,0,0,numR);
    return tablero;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        List<List<Integer>> tablero=nReinas(4);
        System.out.println(tablero.toString());
    }
    
}
