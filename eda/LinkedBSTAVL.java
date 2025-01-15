/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

/**
 *
 * @author computacion1
 */
public class LinkedBSTAVL <T extends Comparable<T>> {
    private NodoAVL<T> raiz;
    private int cont;
    
    public LinkedBSTAVL(){
        raiz=null;
        cont=0;
    }
    
    public void add(T elem) {
        if(raiz!=null){
            NodoAVL<T> act=add(elem,raiz, raiz);
            boolean f=false;
            
            while(!f&&act.getPapa()!=null){ 
               if(act==act.getPapa().getIzq()){
                   act.getPapa().setFe(act.getPapa().getFe()-1);
               }
               else{
                   act.getPapa().setFe(act.getPapa().getFe()+1);
               }
               
               if(Math.abs(act.getPapa().getFe())==2){
                   //act.rotacion(act.getPapa());
                   f=true;
               }
               if(act.getPapa().getFe()==0){
                   f=true;
               }
               act=act.getPapa();
               
            }
        }
        else{
            cont++;
            raiz=new NodoAVL(elem);
            raiz.setPapa(raiz);
        }
    }
    
    private NodoAVL<T> add(T elem, NodoAVL act, NodoAVL ant){
        if(act!=null){
            if(act.getElem().compareTo(elem)<0){
                return add(elem, act.getIzq(), act);
            }
            else{
                return add(elem, act.getDer(), act);
            }
        }
        else{
            NodoAVL<T> nuevo=new NodoAVL(elem);
            cont++;
            ant.cuelga(nuevo);
            return nuevo;
        }
    }
    
    private void rotacion(NodoAVL<T> N){
        NodoAVL<T> alfa;
        NodoAVL<T> beta;
        NodoAVL<T> gamma;
        NodoAVL<T> papa;
        NodoAVL<T> A;
        NodoAVL<T> B;
        NodoAVL<T> C;
        NodoAVL<T> D;
        
        if(N.getFe()==-2 && (N.getIzq().getFe()==-1 || N.getIzq().getFe()==0)){
            alfa=N;     //Asignaciones
            papa=N.getPapa();
            beta=alfa.getIzq();
            gamma=beta.getIzq();
            A=gamma.getIzq();
            B=gamma.getDer();
            C=beta.getDer();
            D=alfa.getDer();
            
            gamma.cuelga(A);
            gamma.cuelga(B);
            alfa.cuelga(C);
            alfa.cuelga(D);
            beta.cuelga(alfa);
            beta.cuelga(gamma);
            if(papa!=null){
                papa.cuelga(beta);
            }
            else{
                beta.setPapa(raiz);
                raiz=beta;
            }
                       
            //alturas
            alfa.setAltura(N.getAltura());
            beta.setAltura(N.getAltura()-1);
            D.setAltura(N.getAltura()-3);
            gamma.setAltura(N.getAltura()-2);
            C.setAltura(N.getAltura()-3);
            
            
        }
        //izq-der
        if(N.getFe()==-2 && N.getIzq().getFe()==1){
            alfa=N;     //Asignaciones
            papa=N.getPapa();
            beta=alfa.getIzq();
            gamma=beta.getIzq();
            A=beta.getIzq();
            B=gamma.getDer();
            C=gamma.getDer();
            D=alfa.getDer();
            
            gamma.cuelga(beta);
            gamma.cuelga(alfa);
            alfa.cuelga(C);
            alfa.cuelga(D);
            beta.cuelga(A);
            beta.cuelga(B);
            if(papa!=null){
                papa.cuelga(gamma);
            }
            else{
                gamma.setPapa(raiz);
                raiz=beta;
            }
        }
    }
    
    public boolean remove(T elem) {
        boolean res=false;
        NodoAVL<T> pos=busca(raiz,elem);
        NodoAVL<T> hijoI;
        NodoAVL<T> hijoD;
        
        if(pos!=null){
            res=true;
            cont--;
            hijoI=pos.getIzq();
            hijoD=pos.getDer();
            
            if(hijoI==null&&hijoD==null){
                if(raiz==pos){
                    raiz=null;
                }
                else{
                    if(pos.getPapa().getElem().compareTo(elem)<0){
                        pos.getPapa().setDer(null);
                    }
                    else{
                        pos.getPapa().setIzq(null);
                    }
                }
            }
            else{
                if(hijoI!=null&&hijoD!=null){
                    while(hijoD.getIzq()!=null){
                        hijoD=hijoD.getIzq();
                    }
                    if(hijoD==pos.getDer()){
                        pos.setDer(hijoD);
                    }
                    else{
                        hijoD.getPapa().setIzq(hijoD.getDer());
                    }
                    if(raiz==pos){
                        raiz=hijoD;
                        raiz.setPapa(null);
                    }
                    else{
                        hijoD.setPapa(pos.getPapa());
                    }
                    hijoD.setIzq(pos.getIzq());
                    hijoD.setDer(pos.getDer());
                }
                else{
                    if(hijoI!=null){
                        if(raiz==pos){
                            raiz=hijoI;
                            raiz.setPapa(null);
                        }
                        else{
                            pos.getPapa().cuelga(hijoI);
                            hijoI.setPapa(pos.getPapa());
                        }
                    }
                    else{
                        if(raiz==pos){
                            raiz=hijoD;
                        }
                        else{
                            pos.getPapa().cuelga(hijoD);
                            hijoD.setPapa(pos.getPapa());
                        }
                    }
                }
            }
        }
        return res;
    }
    
    private NodoAVL<T> busca(NodoAVL<T> act, T elem){
        boolean encontre=false;
        
        while(act!=null&&encontre){
            if(act.getElem().compareTo(elem)<0){
                act=act.getDer();
            }
            else{
                if(act.getElem().compareTo(elem)>0){
                    act=act.getIzq();
                }
                else{
                    encontre=true;
                }
            }
        }
        
        if(encontre){
            return act;
        }
        else{
            return null;
        }
    }
    
}
