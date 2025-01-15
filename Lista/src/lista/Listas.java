/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author hca
 */
public class Listas <T>{
    protected Nodo<T> cabeza;

    public Listas() {
        cabeza=new Nodo<T>(null);
    }
    
    public void inserta(T dato){
        Nodo<T> nuevo = new Nodo<T>(dato);
        
        nuevo.setSig(cabeza.getSig());
        cabeza.setSig(nuevo);
    }
    
    public int contarElementos(){
        return contarElementos(0,cabeza.getSig());
    }
    
    private int contarElementos(int i, Nodo<T> act){
        if(act==null){
            return i;
        }
        else{
            return contarElementos(i+1,act.getSig());
        }
    }
    //
    private int cuenta(Nodo<T> act){
        if(act==null){
            return 0;
        }
        return cuenta(act.getSig())+1;
    }
    
    public boolean eliminarElem(T dato){
        return eliminarElem(dato,cabeza.getSig(),cabeza);
    }
    
    private boolean eliminarElem(T dato, Nodo<T> act,Nodo<T> ant){
        if(act==null){
            return false;
        }
        else{
            if(act.getDato().equals(dato)){
                ant.setSig(act.getSig());
                act.setSig(null);
                return true;
            }
            else{
                return eliminarElem(dato,act.getSig(),act);
            }
        }
    }
    //
    
    
    public void invierte(){
        if(cabeza.getSig()!=null){
            Nodo<T> aux=cabeza.getSig();
            invierte(cabeza,cabeza.getSig());
            aux.setSig(null);
        }
    }
    
    private void invierte(Nodo<T> act,Nodo<T> sig){
        if(sig==null){
            cabeza.setSig(act);
        }
        else{
            Nodo<T> aux= sig.getSig();
            sig.setSig(act);
            
            invierte(sig,aux);
        }
    }
    
    public void invierteSinEnl(){
        int t= contarElementos();
        Nodo<T> n1=null;
        Nodo<T> n2=null;
        
        if(cabeza.getSig()!=null&&cabeza.getSig().getSig()!=null){
            invierteSinEnl(1,t,n1,n2);
        }
    }
    
    private void invierteSinEnl(int i,int f,Nodo<T> n1, Nodo<T> n2){
        if(i<f){
            n1=buscaNodo(i,1,cabeza.getSig());
            n2=buscaNodo(f,1,cabeza.getSig());
            T aux=n2.getDato();
            
            n2.setDato(n1.getDato());
            n1.setDato(aux);
            
            invierteSinEnl(i+1,f-1,n1,n2);
        }
    }
    
    private Nodo<T> buscaNodo(int i,int cont,Nodo<T> act){
        if(cont<i){
            return buscaNodo(i,cont+1,act.getSig());
        }
        else{
            return act;
        }
    }
   
    //
    private Nodo<T> inv(Nodo<T> act){
        if(act==null){
            return cabeza.getSig();
        }
        
        T temp=act.getDato();
        Nodo<T> nodo = inv(act.getSig());
        nodo.setDato(temp);
            
        return nodo.getSig();
    }
    
    //
    public int edit(String s1, String s2){

        if(s1!=null&&s2!=null){
            int l;
            if(s1.length()<s2.length()){
                l=s2.length();
            }
            else{
                l=s1.length();
            }
            
            return edit(s1,s2,0,l);
        }
        else{
            
            return -1;
        }
    }
    
    private int edit(String s1,String s2,int cont,int max){
        if(s1.length()==0||s2.length()==0){
            return cont + s1.length() + s2.length(); //si una de las cadenas no está vacía, sumará los carácteres a eliminar(s1) o agregar(s2)
        }
        else{
            if(cont>=max){
                return max;
            }
            else{
                if(s1.charAt(0)==s2.charAt(0)){
                    return edit(s1.substring(1),s2.substring(1),cont,max); //va recortando la cadena al avanzar
                 }
                 else{
                    int r1=edit(s1.substring(1),s2.substring(1),cont+1,max); //Sustituir, suma uno a las operaciones y avanza al siguiente
                    int r2=edit(s1.substring(1),s2,cont+1,max); //Borrar, suma uno, avanza 1 en la cadena 1 como si lo eliminara
                    int r3=edit(s1,s2.substring(1),cont+1,max); //Agrega, agrega el caracter, entonces pasas al sig de la cadena 2 y sigues comparando el primero de la 1
            
                    int res=r1;
                    
                    if(res>r2){
                        res=r2;
                    }
                    else{
                        if(res>r3){
                            res=r3;
                        }
                    }
                    
                    return res;
                 }
            }
        }
        

        
    }
    
    
    
    public int corregir(String s1,String s2){
        int i=0;
        int t;
        if(!s1.equals(s2)){
            if(s1.length()<s2.length()){
                t=s2.length();
            }
            else{
                t=s1.length();
            }
            //i=corregir(s1,s2,t,0,0);
        }
        return i;
    }
    
    private void corregir(String s1,String s2,int t2,int pos,int op){
        if(pos<t2){
            if(s1.charAt(pos)==s2.charAt(pos)){
                corregir(s1,s2,t2,pos+1,op);
            }
            else{
                
            }
        }
        else{
            return op;
        }
    }
    
    public void permuta(String s1,String s2){
        if(s1.length()==0){
            System.out.println(s2);
        }
        for(int i=0; i<s1.length();i++){
            char p=s1.charAt(i);
            String resto=s1.substring(0, i) + s1.substring(i+1);
            permuta(resto,p+s2);
        }
    }
    
    public void permutaciones (String cad){
        
        if(cad!=null&& cad.length()>1){
            
                    
        }
    }
    
    private void permutaciones(String cad, int t, int ignora,int i,int pos){
        if(i<t){
            
            char p=cad.charAt(i);
            String a=cad.substring(0, i) + cad.substring(i+1);
            permutaciones(cad,t,ignora,i+1,pos);
            
        }
        else{
           
        }
    }
    
    
    public String toString(){
        StringBuilder cad= new StringBuilder();
        String res="";
        
        res=toString(cabeza.getSig(),cad);
        
        return res;
    }
    
    private String toString(Nodo<T> act,StringBuilder cad){
        if(act==null){
            return cad.toString();
        }
        else{
            cad.append(act.getDato());
            return toString(act.getSig(),cad);
        }
    }
    
}
