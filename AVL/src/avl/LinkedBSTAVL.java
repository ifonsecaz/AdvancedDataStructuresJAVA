/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.ArrayList;

/**
 *
 * @author computacion1
 */
public class LinkedBSTAVL <T extends Comparable<T>> implements BinarySearchTreeAVL<T> {
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
                   rotacion(act.getPapa());
                   f=true;
               }
               else{
                    if(act.getPapa().getFe()==0){
                        f=true;
                    }
               }
               act=act.getPapa();
               
            }
        }
        else{
            cont++;
            raiz=new NodoAVL(elem);
            raiz.setPapa(null);
        }
    }
    
    private NodoAVL<T> add(T elem, NodoAVL act, NodoAVL ant){
        if(act!=null){
            if(act.getElem().compareTo(elem)<0){
                return add(elem, act.getDer(), act);
            }
            else{
                return add(elem, act.getIzq(), act);
            }
        }
        else{
            NodoAVL<T> nuevo=new NodoAVL(elem);
            cont++;
            ant.cuelga(nuevo);
            nuevo.setPapa(ant);
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
            //izq-izq
                
            alfa=N;     //Asignaciones
            papa=N.getPapa();
            beta=alfa.getIzq();
            gamma=beta.getIzq();
            A=gamma.getIzq();
            B=gamma.getDer();
            C=beta.getDer();
            D=alfa.getDer();
            
            if(A!=null){
                gamma.cuelga(A);
                A.setPapa(gamma);
            }
            if(B!=null){
                gamma.cuelga(B);
                B.setPapa(gamma);
            }
            if(C!=null){
                alfa.cuelga(C);
                C.setPapa(alfa);
            }
            else{
                alfa.setIzq(null);
            }
            if(D!=null){
                alfa.cuelga(D);
                D.setPapa(alfa);
            }

            beta.cuelga(alfa);
            alfa.setPapa(beta);
            beta.cuelga(gamma);
            gamma.setPapa(beta);
                
            if(papa!=null){
                papa.cuelga(beta);
                beta.setPapa(papa);
            }
            else{
                beta.setPapa(null);
                raiz=beta;
            }
                
                //Fe
            if(beta.getFe()==0){
                beta.setFe(1);
                alfa.setFe(-1);
            }
            else{
                beta.setFe(0);
                alfa.setFe(0);
            }
            
        }
        else{
        //izq-der
            if(N.getFe()==-2 && N.getIzq().getFe()==1){
                alfa=N;     //Asignaciones
                papa=N.getPapa();
                beta=alfa.getIzq();
                gamma=beta.getDer();
                A=beta.getIzq();
                B=gamma.getIzq();
                C=gamma.getDer();
                D=alfa.getDer();
            
                gamma.cuelga(beta);
                beta.setPapa(gamma);
                gamma.cuelga(alfa);
                alfa.setPapa(gamma);
                
                if(A!=null){
                    beta.cuelga(A);
                    A.setPapa(beta);
                }
                if(B!=null){
                    beta.cuelga(B);
                    B.setPapa(beta);
                }
                else{
                    beta.setDer(null);
                }
                if(C!=null){
                    alfa.cuelga(C);
                    C.setPapa(alfa);
                }
                else{
                    alfa.setIzq(null);
                }
                if(D!=null){
                    alfa.cuelga(D);
                    D.setPapa(alfa);
                }
                
                if(papa!=null){
                    papa.cuelga(gamma);
                    gamma.setPapa(papa);
                }
                else{
                    gamma.setPapa(null);
                    raiz=beta;
                }
                
                if(gamma.getFe()==-1){
                    alfa.setFe(1);
                    beta.setFe(0);
                }
                else{
                    if(gamma.getFe()==0){
                        beta.setFe(0);
                        alfa.setFe(0);
                    }
                    else{
                        beta.setFe(-1);
                        alfa.setFe(0);
                    }
                }
                gamma.setFe(0);
            }
            else{
                //der-der
                if(N.getFe()==2 && (N.getDer().getFe()==1 || N.getDer().getFe()==0)){
                    alfa=N;
                    papa=N.getPapa();
                    beta=alfa.getDer();
                    gamma=beta.getDer();
                    A=alfa.getIzq();
                    B=beta.getIzq();
                    C=gamma.getIzq();
                    D=gamma.getDer();
                    
                    beta.cuelga(alfa);
                    alfa.setPapa(beta);
                    beta.cuelga(gamma);
                    gamma.setPapa(beta);

                    if(A!=null){
                        alfa.cuelga(A);
                        A.setPapa(alfa);
                    }
                    if(B!=null){
                        alfa.cuelga(B);
                        B.setPapa(alfa);
                    }
                    else{
                        alfa.setDer(null);
                    }
                    if(C!=null){
                        gamma.cuelga(C);
                        C.setPapa(gamma);
                    }
                    if(D!=null){
                        gamma.cuelga(D);
                        D.setPapa(gamma);
                    }
                    
                    if(papa!=null){
                        papa.cuelga(beta);
                        beta.setPapa(papa);
                    }
                    else{
                        beta.setPapa(null);
                        raiz=beta;
                    }
                    
                    if(beta.getFe()==0){
                        beta.setFe(-1);
                        alfa.setFe(1);
                    }
                    else{
                        beta.setFe(0);
                        alfa.setFe(0);
                    }
                }
                else{
                    //der-izq
                    alfa=N;
                    papa=N.getPapa();
                    beta=alfa.getDer();
                    gamma=beta.getIzq();
                    A=alfa.getIzq();
                    B=gamma.getIzq();
                    C=gamma.getDer();
                    D=beta.getDer();
                    
                    gamma.cuelga(alfa);
                    alfa.setPapa(gamma);
                    gamma.cuelga(beta);
                    beta.setPapa(gamma);
                    
                    if(A!=null){
                        alfa.cuelga(A);
                        A.setPapa(alfa);
                    }
                    if(B!=null){        
                        alfa.cuelga(B);
                        B.setPapa(alfa);
                    }
                    else{
                        alfa.setDer(null);
                    }
                    if(C!=null){
                        beta.cuelga(C);
                        C.setPapa(beta);
                    }
                    else{
                        beta.setIzq(null);
                    }
                    if(D!=null){
                        beta.cuelga(D);
                        D.setPapa(beta);
                    }
                    
                    if(papa!=null){
                        papa.cuelga(gamma);
                        gamma.setPapa(papa);
                    }
                    else{
                        gamma.setPapa(null);
                        raiz=gamma;
                    }
                    
                    if(gamma.getFe()==0){
                        alfa.setFe(0);
                        beta.setFe(0);
                    }
                    else{
                        if(gamma.getFe()==-1){
                            alfa.setFe(0);
                            beta.setFe(1);
                        }
                        else{
                            alfa.setFe(-1);
                            beta.setFe(0);        
                        }
                    }
                    gamma.setFe(0);
                }
            }
        }
    }
    
    public boolean remove(T elem) {
        boolean res=false;
        NodoAVL<T> pos=busca(raiz,elem);
        NodoAVL<T> hijoI=null;
        NodoAVL<T> hijoD=null;
        boolean f=false;
        NodoAVL<T> act=null;
        boolean inO=false;
        
        if(pos!=null){
            res=true;
            cont--;
            hijoI=pos.getIzq();
            hijoD=pos.getDer();
            
            if(hijoI==null&&hijoD==null){
                act=pos.getPapa();
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
                    inO=true;
                    while(hijoD.getIzq()!=null){
                        hijoD=hijoD.getIzq();
                    }
                    act=hijoD.getPapa();
                    if(act==pos){
                        act.setDer(null);
                        act=hijoD;
                    }
                    else{
                        act.setIzq(null);
                    }
                    if(hijoD.getDer()!=null){
                        hijoD.getPapa().cuelga(hijoD.getDer());
                    }
                   
                    if(pos.getIzq()!=null){
                        hijoD.cuelga(pos.getIzq());
                        pos.getIzq().setPapa(hijoD);
                    }
                    if(pos.getDer()!=null&&pos.getDer()!=hijoD){
                        hijoD.cuelga(pos.getDer());
                        pos.getDer().setPapa(hijoD);
                    }
                    if(raiz==pos){
                        raiz=hijoD;
                        raiz.setPapa(null);
                    }
                    else{
                        hijoD.setPapa(pos.getPapa());
                        pos.getPapa().cuelga(hijoD);
                    }
                    hijoD.setFe(pos.getFe());
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
                        act=hijoI.getPapa();
                    }
                    else{
                        if(raiz==pos){
                            raiz=hijoD;
                        }
                        else{
                            pos.getPapa().cuelga(hijoD);
                            hijoD.setPapa(pos.getPapa());
                        }
                        act=hijoD.getPapa();
                    }
                }
            }
        }
        
        if(act!=null){
            while(!f&&act!=null){
                if(inO && act==hijoD){
                    act.setFe(act.getFe()-1);
                }
                else{
                    if(act.getElem().compareTo(elem)>0){
                        act.setFe(act.getFe()+1);
                    }
                    else{
                        act.setFe(act.getFe()-1);
                    }
                }
                if(Math.abs(act.getFe())>=2){
                    rotacion(act);
                    f=true;
                }
                if(Math.abs(act.getFe())==1){
                    f=true;
                }
                
                act=act.getPapa();
            }
        }
        
        return res;
    }
    
    private NodoAVL<T> busca(NodoAVL<T> act, T elem){
        boolean encontre=false;
        
        while(act!=null&&!encontre){
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
    
    public T buscar(T elem){
        T res=null;
        NodoAVL<T> a;
        
        if(raiz!=null){
            a=busca(raiz,elem);
            if(a!=null){
                res=a.getElem();
            }
        }
        return res;
    }
    
    public String imprimeIzqDerNivel(){
        int niveles=0;
        NodoAVL<T> act=raiz;
        int conteo=0;
        ArrayList<String> elem= new ArrayList<String>();
        
        while(act!=null){
            niveles++;
            if(act.getFe()==-1){
                act=act.getIzq();
            }
            else{
                act=act.getDer();
            }
        }
        
        for(int i=0; i<=niveles; i++){
            recorre(elem,raiz,conteo,i);
        }
        
        return elem.toString();
    }    
    
    private void recorre(ArrayList<String> elem, NodoAVL<T> act, int conteo, int tope){
        if(act!=null){
            if(conteo==tope){
                elem.add("Elemento: " + act.getElem() + "   Factor de equilibrio: " + act.getFe() + "\n");
            }
            else{
                conteo++;
                recorre(elem,act.getIzq(),conteo,tope);
                recorre(elem,act.getDer(),conteo,tope);
            }
        }
    }
}

