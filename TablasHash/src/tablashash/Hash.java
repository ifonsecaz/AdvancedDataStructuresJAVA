/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablashash;

/**
 *
 * @author computacion1
 */
public class Hash<T> {
    private NodoHash<T>[] datos;
    private int cont;

    public Hash(int numE) {
        datos= new NodoHash[numE];
    }

    public Hash() {
        datos=new NodoHash[100];
    }
    
    public void insertar(T elem){
        int key=hashFunction(elem);
        NodoHash<T> nuevo= new NodoHash(key,elem);
        cont++;
        if(datos[key]==null){
            datos[key]=nuevo;
        }
        else{
            nuevo.setSig(datos[key]);
            datos[key]=nuevo;
        }
        if(cont>=(datos.length*0.7))
            expande();
    }
    
    public NodoHash<T> buscar(T elem){
        int key=hashFunction(elem);
        NodoHash<T> act=datos[key];
        
        while(act!=null&&!act.getElem().equals(elem)){
            act=act.getSig();
        }
        
        return act;
    }
    
    public NodoHash<T> eliminar(T elem){
        int key=hashFunction(elem);
        NodoHash<T> act=datos[key];
        NodoHash<T> ant=null;
        
        while(act!=null&&!act.getElem().equals(elem)){
            ant=act;
            act=act.getSig();
        }
        
        if(act!=null){
            if(ant==null){
               datos[key]=null; 
            }
            else{
                ant.setSig(act.getSig());
            }
        }
        return act;
    }
    
    private void expande(){
        NodoHash<T>[] nuevo= new NodoHash[datos.length*2];
        NodoHash<T>[] aux=datos;
        datos=nuevo;
        
        for(int i=0; i<datos.length; i++){
            NodoHash<T> act=aux[i];
            while(act!=null){
                insertar(act.getElem());
                act=act.getSig();
            }
        }
    }
    
    private int hashFunction(T elem){
        //return elem%datos.length;
        return 0;
    }
    
}
