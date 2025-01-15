/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ifonsecaz
 */
public class ListaDesordenada <T> extends Lista<T> implements ListaDesordenadaADT<T> {

    public ListaDesordenada() {
    }

    public void agregaInicio(T dato) {
       if(dato!=null){
           if(!estaVacía()){
                Nodo<T> nuevo= new Nodo(dato);
           
                nuevo.setSig(primero);
           
                primero=nuevo;
           }
           else{
               agregaPrimerDato(dato);
           }
       }
    }

    public void agregaFinal(T dato) {
        if(dato!=null){
            if(!estaVacía()){
               Nodo<T> nuevo= new Nodo(dato);
            
                último.setSig(nuevo);
            
                último=nuevo;
            }
            else{
                agregaPrimerDato(dato);
            }
        }
    }
    
    private void agregaPrimerDato(T dato){
        Nodo<T> nuevo= new Nodo(dato);
        
        primero=nuevo;
        último=nuevo;
    }

    public boolean agregaAntesQue(T refer, T dato) {
        boolean res=false;
        
        if(refer!=null&&dato!=null&&!estaVacía()){
            if(primero.getDato().equals(refer)){
                agregaInicio(dato);
                res=true;
            }
            else{
                Nodo<T> act=primero.getSig();
                Nodo<T> ant =primero;
                
                while(act!=null&&!act.getDato().equals(refer)){
                    ant=act;
                    act=act.getSig();
                }
                
                if(act!=null){
                    Nodo<T> nuevo= new Nodo(dato);
                    ant.setSig(nuevo);
                    nuevo.setSig(act);
                    res=true;
                }
            }
        }
        return res;
    }

    public boolean agregaDespuesQue(T refer, T dato) {
        boolean res=false;
        
        if(refer!=null&&dato!=null&&!estaVacía()){
            if(!último.getDato().equals(refer)){
                Nodo<T> act=primero;
            
                while(act!=null&&!act.getDato().equals(refer)){
                    act=act.getSig();
                }
                if(act!=null){
                    Nodo<T> nuevo= new Nodo(dato);
                    res=true;
                    nuevo.setSig(act.getSig());
                    act.setSig(nuevo);
                }
            }
            else{
                Nodo<T>nuevo= new Nodo(dato);
                res=true;
                último.setSig(nuevo);
                último=nuevo;
            }
        }
        
        return res;
    }
}
