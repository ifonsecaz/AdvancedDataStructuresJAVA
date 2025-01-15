/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

/**
 *
 * @author hca
 */
public class AlgoritmosOrdenamiento  {
    
    public static <T extends Comparable<T>> int selectionSortNoRec(T[] a){
        int len=a.length;
        int min=0;
        int i=0;
        int pos=1;
        T aux;
        int comp=0;
        
        while(i<len){
            while(pos<len){
                comp++;
                if(a[min].compareTo(a[pos])>0){
                    min=pos;
                }
                pos++;
            }
            aux=a[min];
            a[min]=a[i];
            a[i]=aux;
            
            i++;
            min=i;
            pos=i+1;
        }
        return comp;
    }
    
    public static <T extends Comparable<T>> int selectionSort(T[] a){
        int comp=0;
        if(a!=null){
            
            comp=selectionSort(a,a.length,0,1,0,0);
        }
        return comp;
    } 
    
    private static <T extends Comparable <T>> int selectionSort(T[] a, int len, int min, int pos,int i,int comp){
        if(i<len){
            if(pos<len){
                comp++;
                if(a[min].compareTo(a[pos])>0){
                    min=pos;
                }
                comp=selectionSort(a,len,min,pos+1,i,comp);
            }
            else{
                T aux=a[i];
                a[i]=a[min];
                a[min]=aux;
                i++;
              
                comp=selectionSort(a,len,i,i+1,i,comp);
            }
        }
        return comp;
    }
    
    public static <T extends Comparable<T>> int insertionSort(T[] a){
       int comp=0;
       if(a!=null){
           comp=insertionSort(a,a.length,1,0,0);
       }
       
       return comp;
    }
    
    private static <T extends Comparable<T>> int insertionSort(T[] a, int l, int f, int min,int comp){
        if(f<l){
            if(a[f].compareTo(a[f-1])<0){
                comp++;
                if(a[min].compareTo(a[f])>0){
                    T aux=a[f];
                    a[f]=a[min];
                    a[min]=aux;
                }
                comp=insertionSort(a,l,f,min+1,comp);
            }
            comp=insertionSort(a,l,f+1,0,comp);
        }
        return comp;
    }
    
    public static <T extends Comparable<T>> int insertionSortNoRec(T[] a){
        int len=a.length;
        int i=0;
        int min=0;
        int f=1;
        T aux;
        int comp=0;
        
        while(f<len){
            while(a[f].compareTo(a[f-1])<0){
                comp++;
                if(a[min].compareTo(a[f])>0){
                    aux=a[f];
                    a[f]=a[min];
                    a[min]=aux;
                }
                min++;
            }
            comp++;
            f++;
            min=0;
        }
        return comp;
    }
    
    public static <T extends Comparable<T>> int bubbleSort(T[] a){
        int comp=0;
        comp=bubbleSort(a,a.length,1,comp);
        
        return comp;
    }
    
    private static <T extends Comparable<T>>  int bubbleSort(T[] a, int f, int pos,int comp){
        if(f>0){
            if(pos<f){
                comp++;
                if(a[pos].compareTo(a[pos-1])<0){
                    T aux= a[pos];
                    a[pos]=a[pos-1];
                    a[pos-1]=aux;
                }
                comp=bubbleSort(a,f,pos+1,comp);
            }
            else{
                comp=bubbleSort(a,f-1,1,comp);
            }
        }
        return comp;
    }
    
    public static <T extends Comparable<T>> int bubbleSortNoRec(T[] a){
        int f=a.length;
        int pos=1;
        T aux;
        int comp=0;
        
        while(f>0){
            while(pos<f){
                comp++;
                if(a[pos].compareTo(a[pos-1])<0){
                    aux=a[pos];
                    a[pos]=a[pos-1];
                    a[pos-1]=aux;
                    
                }
                pos++;
            }
            f--;
            pos=1;
        }
        return comp;
    }
    

    
    public static <T extends Comparable<T>> int quickSort(T[] a){
        int[] comp={0};
        if(a!=null){
            quickSort(a,a.length,0,0,a.length,comp);
        }
        
        return comp[0];
    }

    private static <T extends Comparable<T>> void quickSort(T[] a, int len,int piv, int i, int antP,int[] comp){
       if(i<len-1){
           if(piv<len-1){
               piv=ordena(a,len,piv+1,piv,comp);
           }
           if(antP>piv){
                quickSort(a,piv,0,0,piv,comp);
           }
           else{
                quickSort(a,piv,antP+1,antP+1,piv,comp);
           }
           if(len==a.length){
               quickSort(a,len,piv+1,piv+1,piv,comp);
           }
           else{
               quickSort(a,piv,piv+1,piv+1,piv,comp);
           } 
       }
    }
    
    
    
    private static <T extends Comparable<T>> int ordena(T[] a, int len,int i,int piv,int[] comp){
        if(i<len){
            comp[0]=comp[0]+1;
            if(a[piv].compareTo(a[i])>0){
                T aux=a[i];
                a[i]=a[piv+1];
                a[piv+1]=aux;
                
                aux=a[piv];
                a[piv]=a[piv+1];
                a[piv+1]=aux;
                
                return ordena(a,len,i+1,piv+1,comp);
            }
            else{
                return ordena(a,len,i+1,piv,comp);
            }
        }
        else{
            return piv;
        }
    }
    
    public static <T extends Comparable<T>> int mergeSortO(T[] datos){
        int[] comp={0};
        mergeSortO(datos,0,datos.length-1,comp);
        
        return comp[0];
    }
    
    private static <T extends Comparable<T>> void mergeSortO(T[] datos, int min, int max,int[] comp){
        T[] temp;
        int indice,izq,der;
        if(min==max)    //Termina una vez el tamaño del arreglo es de 1
            return;
        
        int tam=max-min+1;      //Establece los rangos para hacer los intervalos más pequeños
        int mitad=(max + min)/2;    //va de mina a mitad; y de mitad+1 a max
        temp=(T[])(new Comparable[tam]);
        mergeSortO(datos,min,mitad,comp);
        mergeSortO(datos, mitad+1, max,comp);
        
        izq=min;
        der=mitad+1;
        int cont=0;
        
        while(izq<=mitad&&der<=max){        //ordena en un arreglo temp
            comp[0]=comp[0]+1;
            if(datos[izq].compareTo(datos[der])<0){
                temp[cont]=datos[izq];
                izq++;
            }
            else{
                temp[cont]=datos[der];
                der++;
            }
            cont++;
        }
        
        if(izq<=mitad){
            while(mitad>=izq){
                datos[max]=datos[mitad];
                max--;
                mitad--;
            }
        }
        
        cont=0;
        
        while(cont<tam&&temp[cont]!=null){      //pasa los datos en el arreglo
            datos[min+cont]=temp[cont];
            
            cont++;
        }
        
    }
    
    public static <T extends Comparable<T>> void mergeSort(T[] a){
        int n=a.length;
        int ancho=2;
        int inicio,fin,mitad;
        int numP,j,izq,der,cont;
        T[] temp=(T[])(new Comparable[n]);
        
        while(ancho<n){
            numP=n/2;
            j=1;
            inicio=0;
            
            while(j<numP&&inicio+ancho<n){
                fin=inicio+ancho;
                mitad=(inicio+fin)/2;
                izq=inicio;
                der=mitad;
                cont=0;
                
                while(izq<mitad&&der<fin){        
                    if(a[izq].compareTo(a[der])<0){
                        temp[cont]=a[izq];
                        izq++;
                    }
                    else{
                        temp[cont]=a[der];
                        der++;
                    }
                    cont++;
                }
        
                if(izq<mitad){
                    while(mitad>izq){
                        a[fin]=a[mitad];
                        fin--;
                        mitad--;
                    }
                }
        
                cont=0;
        
                while(cont<ancho&&temp[cont]!=null){      
                    a[inicio+cont]=temp[cont];
            
                    cont++;
                }
                inicio=fin;
                j++;
            }
            n*=2;
        }
    }
    
    public static <T extends Comparable<T>> void invertir(T[] a){
        int len=a.length/2;
        int f=a.length-1;
        T aux;
        
        for(int i=0; i<len; i++){
            aux=a[i];
            a[i]=a[f-i];
            a[f-i]=aux;
        }
    }
    
    public static <T extends Comparable<T>> T[] tomaNelem(T[] a, int n){
        T[] b=(T[])new Object[n];
        
        System.arraycopy(a, 0, b, 0, n);
        
        return b;
    }
   
}