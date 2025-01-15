/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skipl;

/**
 *
 * @author computacion1
 */
public class SkipList<T extends Comparable<T>> {
    private NodoSkip<T> cabeza,cola;
    private int cont;
    private int numListas;

    public SkipList() {
        cabeza=new NodoSkip<T>();
        cola=new NodoSkip<T>();
        cabeza.setDer(cola);
        cola.setIzq(cabeza);
        cont=0;
        numListas=0;
    }

    public int getCont() {
        return cont;
    }

    public int getNumListas() {
        return numListas;
    }
    
    public boolean busca(T elem){
        boolean res=false;
        NodoSkip<T> act=busca(cabeza,elem);
        if(act.getElem()!=null&&act.getElem().equals(elem)){
            res=true;
        }
        return res;
    }
    
    private NodoSkip<T> busca(NodoSkip<T> act,T elem){
        
        if((act.getElem()==null&&act.getIzq()==null)||(act.getElem()!=null&&act.getElem().compareTo(elem)<0)){
            return busca(act.getDer(),elem);
        }
        else{
            if(act.getAbajo()!=null){
                if(act.getElem()==null||act.getElem().compareTo(elem)>0){
                    return busca(act.getIzq().getAbajo(),elem);
                }
                else{
                    return busca(act.getAbajo(),elem);
                }
            }
            else{
                if(act.getElem()!=null&&act.getElem().equals(elem)){
                    return act;
                }
                else{
                    return act.getIzq();
                }
            }
        }
    }

    public boolean eliminar(T elem){
        boolean res=false;
        NodoSkip<T> act=busca(cabeza,elem);
        NodoSkip<T> aux;
        int i=0;
        
        if(act.getElem()!=null&&act.getElem().equals(elem)){
            res=true;
            cont--;
            //considerar caso solo 1 nivel
            while(i<numListas&&act!=null){
                aux=act.getIzq();
                aux.setDer(act.getDer());
                aux=act.getDer();
                aux.setIzq(act.getIzq());
                
                //Colapsar Listas
                if(act.getIzq().getIzq()==null&&act.getDer().getDer()==null){
                    if(numListas>1){
                        cabeza=act.getIzq().getAbajo();
                        cola=act.getDer().getAbajo();
                    
                        cola.setArriba(null);
                        cabeza.setArriba(null);
                        act=null;
                        
                        numListas--;
                    }
                }
                else{
                    act=act.getArriba();
                    i++;
                }
            }
        }
       
        
        return res;
    }
    
    //Método profesor
    public boolean borra(T elem){
        boolean res=false;
        NodoSkip<T> act=busca(cabeza,elem);
        NodoSkip<T> aux;
        
        if(act.getElem()!=null&&act.getElem().equals(elem)){
            res=true;
            cont--;
            while(act!=null){
                aux=act.getIzq();
                aux.setDer(act.getDer());
                aux=act.getDer();
                aux.setIzq(act.getIzq());
                act=act.getArriba();
            }
            //Elimino la primera lista
            if(numListas>(Math.log(cont+2)/Math.log(2))){
                cabeza=cabeza.getAbajo();
                cola=cola.getAbajo();
                act=cabeza;
                
                while(act!=null){
                    act.setArriba(null);
                    act=act.getDer();
                }
                numListas--;
            }
        }
        return res;
    }
    //P
    public void inserta2(T elem){
       int numVolados=1;
       NodoSkip<T> nuevo= new NodoSkip(elem);
       NodoSkip<T> act=busca(cabeza,elem);
       NodoSkip<T> nuevo2;
       cont++;
       boolean termine=false;
       do{
           meteNodo(act,nuevo);
           
           if(numVolados<(Math.log(cont+2)/Math.log(2))&&Math.random()>0.5){
               nuevo2=nuevo;
               if(numVolados>numListas){
                   nuevo=new NodoSkip<T>();
                   nuevo.setAbajo(cabeza);
                   cabeza.setArriba(nuevo);
                   cabeza=nuevo;
                   nuevo=new NodoSkip<T>();
                   nuevo.setAbajo(cola);
                   cola.setArriba(nuevo);
                   cola=nuevo;
                   cabeza.setDer(cola);
                   cola.setIzq(cabeza);
                   numListas++;
               }
               numVolados++;
               nuevo=new NodoSkip<T>(elem);
               nuevo2.setArriba(nuevo);
               nuevo.setAbajo(nuevo2);
               while(act.getArriba()==null){
                   act=act.getIzq();
               }
               act=act.getArriba();
                      
           }
           else{
               termine=true;
           }
       }while(!termine);
    }
    
    private void meteNodo(NodoSkip<T> act, NodoSkip<T> nuevo){
        act.getDer().setIzq(nuevo);
        nuevo.setDer(act.getDer());
        act.setDer(nuevo);
        nuevo.setIzq(act);
    }
    
    public void inserta(T elem){
        NodoSkip<T> act=busca(cabeza,elem);
        int i=1;
        NodoSkip<T> nuevo=new NodoSkip<T>(elem);
        NodoSkip<T> nuevo2,aux;
        cont++;

        nuevo.setDer(act.getDer());
        act.getDer().setIzq(nuevo);
        act.setDer(nuevo);
        nuevo.setIzq(act);
        aux=nuevo;

        while(i<(Math.log(cont+2)/Math.log(2))&&Math.random()>0.5){
            while(act!=null&&act.getArriba()==null){
                act=act.getIzq();
            }
            nuevo2= new NodoSkip<T>(elem);
            if(act!=null){
                act=act.getArriba();
            }
            else{
                act=new NodoSkip<T>();
                cabeza.setArriba(act);
                act.setAbajo(cabeza);
                cabeza=act;
                act=new NodoSkip<T>();
                cola.setArriba(act);
                act.setAbajo(cola);
                cola=act;
                cabeza.setDer(cola);
                cola.setIzq(cabeza);
                numListas++;

                act=cabeza;
            }

            nuevo2.setDer(act.getDer());
            act.getDer().setIzq(nuevo2);
            act.setDer(nuevo2);
            nuevo2.setIzq(act);
            nuevo2.setAbajo(aux);
            aux.setArriba(nuevo2);
            aux=nuevo2;

            i++;
        }
    }
    
    
    public NodoSkip<T> buscaI(T elem){
        NodoSkip<T> act= cabeza.getDer();
        int i=0;
        
        while(i<=numListas){
            while(act.getDer()!=null&&(act.getElem()==null||elem.compareTo(act.getElem())>0)){
                act=act.getDer();
            }
            if(i!=numListas){
                if(act.getElem()==null||!act.getElem().equals(elem)){
                    act=act.getIzq();
                    while(act.getAbajo()==null){
                        act=act.getIzq();
                    }
                }
                act=act.getAbajo();
            }
            i++;
        }
        if(act!=null&&act.getElem().equals(elem)){
            return act;        
        }
        else{
            return act.getIzq();
        }
    }
}
