/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboltrie;

/**
 *
 * @author ifons
 */
public class Heap<T extends Comparable<T>> implements minHeap<T>{
    private NodoHeap<T>[] datos;
    private int cont;

    public Heap() {
        cont = 0;
        datos = new NodoHeap[1000];
    }
    
    public Heap(int max) {
        cont = 0;
        datos = new NodoHeap[max];
    }
    
    @Override
    public  void inserta(T elem,  T prioridad) {
        int pos = cont+1;                
        NodoHeap<T> aux = new NodoHeap(elem, prioridad);
        if(pos > datos.length){
            expande();
        }else if(pos == 1){
            datos[pos] = aux;
            cont++;
        }
        else{            
            boolean termine= false;
            datos[pos] = aux;
            while(pos >1  && !termine){                                    
              if(datos[pos/2].getPrioridad().compareTo(aux.getPrioridad()) > 0){
                    NodoHeap<T> au = datos[pos];
                    datos[pos] = datos[pos/2];
                    datos[pos/2]= au;                
                }else{
                    termine = true;                
                }
                pos = pos >> 1; //Es igual a hacer pos=pos/2
            }     
            cont+=1;
        }  
    }

    @Override
    public T getMin() {
        if(cont> 0)
            return datos[1].getPrioridad();
        else
            return null;
    }

    @Override
    public T eliminaMin() {        
        NodoHeap<T> aux;
        NodoHeap<T> res=null;
        if(cont == 0)
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        else if(cont == 1){
            res = datos[1];            
            cont= 0;
        }else{
            int pos = 1;
            boolean termine = false;
            res = datos[1];                                    
            datos[1] =  datos[cont];
            datos[cont] = null;
            cont--;
            while(pos < cont && !termine){
                if(datos[2*pos] != null && datos[2*pos+1] != null){ //Operacion 2*pos = pos<<1, Compara primero los hijos y se va por el menor
                    if(datos[2*pos].getPrioridad().compareTo(datos[2*pos+1].getPrioridad())< 0){ //Si del menor de los hijos es menor al papa los cambia
                        if(datos[2*pos].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux=datos[pos];
                            datos[pos] = datos[pos*2];
                            datos[pos*2]=aux;
                            pos*=2;
                        }                        
                        else
                            termine = true;                        
                    }else{
                        if(datos[2*pos+1].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux=datos[pos];
                            datos[pos] = datos[pos*2+1];
                            datos[pos*2+1]=aux;
                            pos = pos*2 +1;
                        }else
                            termine = true;
                    }                        
                }else if(datos[2*pos] != null){ //Caso solo hijo izq
                    if(datos[2*pos].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux=datos[pos];
                            datos[pos] = datos[pos*2];
                            datos[pos*2]=aux;
                            pos*=2;
                    }else
                            termine = true;                    
                }    
                else{
                    termine=true;
                }
                    /**
                }else if(datos[2*pos+1] != null){ //Caso solo hijo derecho
                    if(datos[2*pos+1].getPrioridad().compareTo(aux.getPrioridad()) < 0){
                            datos[pos] = datos[pos*2+1];
                            pos= pos*2+1;
                    }else
                            termine = true; 
                }else{
                    datos[pos]= new NodoHeap(aux);
                }      
                
            }
            
            if(termine)
                datos[pos] = new NodoHeap(aux);
            */
                
            }
        }
        return res.getElem();
    }

    private void expande() {
        NodoHeap<T>[] nuevo= new NodoHeap[datos.length];
        for(int i=0; i<datos.length; i++){
            nuevo[i]=datos[i];
        }
        datos=nuevo;
    }
    
    public String[] heapSort(String[] a){
        Heap aux=new Heap(a.length+1);
        String[] res= new String[a.length];
        
        for(int i=0; i<a.length; i++){
            aux.inserta(a[i], a[i]);
        }
        
        for(int j=0; j<a.length; j++){
            res[j]="" + aux.eliminaMin();
        }
        
        return res;
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i <= Math.sqrt(cont); i++){
            double ini = Math.pow(2, i);
            double fin = Math.pow(2, i+1);
            sb.append("nivel " + (i+1) + "\n");
            for(int j = (int) ini; j < fin && j <= cont; j++){
                sb.append(datos[j].toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
