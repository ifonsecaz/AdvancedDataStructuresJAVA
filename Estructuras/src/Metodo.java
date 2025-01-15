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
public class Metodo {
    public static boolean sonIguales(int[][] a,int[][] b, int ren1, int col1, int ren2 , int col2){
        boolean res=false;
        
        if(a!=null&&b!=null){
            if(ren1==ren2&&col1==col2){
                res=sonIguales(0,0,a,b,ren1,col1);
            }
        }
        
        return res;
    }
    
    private static boolean sonIguales(int i, int j,int[][] a, int[][]b, int ren, int col){
        if(i<ren){
            if(j<col){
                if(a[i][j]!=b[i][j]){
                    return false;
                }
                else{
                    return sonIguales(i,j+1,a,b,ren,col);
                }
            }
            else{
                return sonIguales(i+1,0,a,b,ren,col);
            }
        }
        else{
            return true;
        }
    }
    
    public static boolean analizaObjetos(ConjuntoADT<Object> a, int n){
        Iterator<Object> i= a.iterator();
        
        return analizaObjetos(n,i);
    }
    
    private static boolean analizaObjetos(int n,Iterator<Object> i){
       if(i.hasNext()&&n>0){
           Object a=i.next();
           
           try{
               if(((String)a).length()>10){
                   n--;
               }
           }catch(Exception e){
               
           }
           
           return analizaObjetos(n,i);
        }
       else{
           if(n>0){
               return false;
           }
           else{
               return true;
           }
       }
    }

}
