/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

/**
 *
 * @author hca
 */
public class LinkedBST <T extends Comparable <T>> extends ListedBT<T> implements BinaryTreeSearchTree<T>{
    
    public LinkedBST() {
        super();
    }

    public void add(T elem) {
        if(raiz!=null){
            add(elem,raiz, raiz);
        }
        else{
            cont++;
            raiz=new NodoBT(elem);
            raiz.setPapa(raiz);
        }
    }
    
    private void add(T elem, NodoBT act, NodoBT ant){
        if(act!=null){
            if(act.getElem().compareTo(elem)<0){
                add(elem, act.getIzq(), act);
            }
            else{
                add(elem, act.getDer(), act);
            }
        }
        else{
            cont++;
            ant.cuelga(new NodoBT(elem));
            
        }
    }
    //Asegurarse act no sea nulo
    private void add2(T elem, NodoBT<T> act){
        if(act.getElem().compareTo(elem)<0){
            if(act.getIzq()!=null){
                add2(elem,act.getIzq());
            }
            else{
                act.setIzq(new NodoBT(elem));
                cont++;
            }
        }
        else{
            if(act.getDer()!=null){
                add2(elem, act.getDer());
            }
            else{
                act.setDer(new NodoBT(elem));
                cont++;
            }
        }
    }
    
    public boolean remove(T elem) {
        boolean res=false;
        NodoBT<T> pos=busca(raiz,elem);
        NodoBT<T> hijoI;
        NodoBT<T> hijoD;
        
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
    
    protected NodoBT<T> busca(NodoBT<T> act, T elem){
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
    
    @Override
    public T removeMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
