/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edi
 */
public class ArregloGenerico <T extends Comparable<T>>{
    private T[] arreglo;
    private int tot;
    private final int MAX=20;

    public ArregloGenerico() {
        arreglo=(T[]) new Comparable[MAX];
        tot=0;
    }
    
    public ArregloGenerico(int max) {
        arreglo=(T[]) new Comparable[max];
        tot=0;
    }

    public int getTot() {
        return tot;
    }
    
    public boolean alta(T a){
        boolean res=false;
        
        if(tot<arreglo.length){
            arreglo[tot]=a;
            tot++;
        }
        
        return res;
    }
    
    public int busquedaSecuencial(T a){
        int pos=0;
        
        if(a!=null){
            pos=busquedaSecuencial(a,pos);
        }
        else{
            pos=-1;
        }
        return pos;
    }
    
    private int busquedaSecuencial(T a, int pos){
        if(pos==tot){
            return -1;
        }
        else{
            if(!a.equals(arreglo[pos])){
                return busquedaSecuencial(a,pos+1);
            }
            else{
                return pos;   
            }
        }
    }
    
    public int busquedaBinaria(T a){
        int pos=tot;
        int inicio=0;
        int fin=tot;
        
        return busquedaBinaria(a,pos,fin,inicio);
    }
    
    private int busquedaBinaria(T a, int pos, int fin, int inicio){
        if(a.equals(arreglo[inicio+(fin-inicio)/2])){
            return pos=inicio+(fin-inicio)/2;
        }
        else{
            if(fin-inicio<=1){
                if(a.compareTo(arreglo[inicio+(fin-inicio)/2])>0){
                    return -inicio-2;
                }
                else{
                    return -inicio-1;
                }
            }
        }
        if(a.compareTo(arreglo[inicio+(fin-inicio)/2])>0){
            inicio=inicio+ (fin-inicio)/2;
        }
        else{
            fin=(fin-inicio)/2;
        }
        return busquedaBinaria(a,pos,fin,inicio);
    }
    
    public int busquedaBinaria2(T obj){
        return busquedaBinaria2(obj,0,tot-1);
    }
    
    private int busquedaBinaria2(T obj,int inicio, int fin){
        if(inicio<fin){
            return -fin-1;
        }
        else{
            int mitad=(inicio+fin/2);
            int compara = obj.compareTo(arreglo[mitad]);
            if(compara==0){
                return mitad;
            }
            else{
                if(compara>0){
                    return busquedaBinaria2(obj,mitad+1,fin);
                }
                else{
                    return busquedaBinaria2(obj,inicio,mitad-1);
                }
            }
        }
    }
    
    public int posMayor(){
        int max=0;
        int pos=1;
        //considerar caso donde el arreglo no tenga elementos
        return posMayor(max,pos);
    }
    
    private int posMayor(int max,int pos){
        if(pos<tot){
            if(arreglo[max].compareTo(arreglo[pos])<0){
                max=pos;
            }
            return posMayor(max,pos+1);
        }
        else{
            return max;
        }
    }
    
    public int eliminaOcurrencias(T obj){
        int numEliminados=0;
        int n=0;
        
        if(obj!=null){
            numEliminados=eliminaOcurrencias(obj,numEliminados,n);
        }
        return numEliminados;
    }
    
    private int eliminaOcurrencias(T obj, int numE, int n){
        if(n<tot){
            if(obj.equals(arreglo[n])){
                numE++;
                tot--;
                arreglo[n]=arreglo[tot];
                arreglo[tot]=null;
            }
            else{
                n++;
            }
            return eliminaOcurrencias(obj,numE,n);
        }
        else{
            return numE;
        }
        
    }
    
    /*
    private void recorreIzq(int pos){
        if(pos<tot-1){
            arreglo[pos]=arreglo[pos+1];
            recorreIzq(pos+1);
        }
    }
    */
    
    public void ordenaSeleccionDirecta(){
        int n=0;
        
        ordenaSeleccionDirecta(n);
    }
    
    private void ordenaSeleccionDirecta(int n){
        if(n<tot-1){
            T aux;
            int men=posMenor(n,n+1);
            aux=arreglo[men];
            arreglo[men]=arreglo[n];
            arreglo[n]=aux;
            
            n++;
            ordenaSeleccionDirecta(n);
        }
    }
    
    private int posMenor(int men, int pos){
        if(pos<tot){
            if((arreglo[men].compareTo(arreglo[pos]))>0){
                men=pos;
            }
            return posMenor(men,pos+1);
        }
        else{
            return men;
        }
    }
    
    private void ordena(int i, int j, T men, int pos){
        if(i<tot-1){
            if(j<tot){
                if(arreglo[j].compareTo(men)<0){
                    men=arreglo[j];
                    pos=j;
                }
                ordena(i,j+1,men,pos);
                
            }
            else{
                arreglo[pos]=arreglo[i];
                arreglo[i]=men;
                ordena(i+1,i+2,arreglo[i+1],i+1);
            }
        }
    }
    
    public String toString(){
        StringBuilder cad= new StringBuilder();
        int total=0;
        String res;
        
        //Al enviar parámetros se puede instanciar dentro
        res=toString(cad,total);
        
        return res;
    }
    
    private String toString(StringBuilder cad, int total){
        if(total<tot){
            cad.append("\n" + arreglo[total]);
            return toString(cad,total+1);
            /*Se puede ahorrar el StringBuilder usando la pila de memoria
                return toString(n+1) + arreglo[n] + " ";
            */
        }
        //else{
            //return "";
        return cad.toString();
    }
}
