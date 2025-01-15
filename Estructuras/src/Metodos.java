/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ifonsecaz
 */
public class Metodos {
    public static void invierte(ColaADT a){
        PilaADT aux= new PilaA();
        
        if(a!=null){
            while(!a.estaVacia()){
                aux.push(a.quita());
            }
            
            while(!aux.isEmpty()){
                a.agrega(aux.pop());
            }
        }
        
    }
    
    public static <T> void invierteC(ColaADT<T> a){
        if(a!=null){
            PilaADT aux= new PilaA();
            invierteC(a,aux);
        }
    }
    
    public static <T> void invierteC(ColaADT<T> a, PilaADT<T> aux){
        if(!a.estaVacia()){
            aux.push(a.quita());
            invierteC(a,aux);
            a.agrega(aux.pop());
        }
    }
    
    public static <T> ColaADT invierteR(ColaADT<T> a){
        ColaADT<T> nuevo= new ColaA();
        ColaADT<T> aux= new ColaA();
        int i=0;
        T[] b= (T[]) new Object[50];
        
        if(a!=null){
            copia(a,nuevo,aux);
            i=re(a,nuevo,i,b);

            invierteR(nuevo,b,i);
        }    
        return nuevo;    
    }
  
    
    private static<T> void copia(ColaADT<T> a, ColaADT<T> nuevo, ColaADT<T> aux){
        if(!a.estaVacia()){
            nuevo.agrega(a.consultaPrimero());
            aux.agrega(a.quita());
            
            copia(a,nuevo,aux);
        }
    }
  
    private static<T> int re(ColaADT<T> a, ColaADT<T> aux, int i,T[] b){
        if(!aux.estaVacia()){
            i++;
            b[i]=aux.consultaPrimero();
            a.agrega(aux.quita());
            
            return re(a,aux,i,b);
        }
        else{
            return i;
        }
    }
    
    private static void invierteR(ColaADT nuevo, Object[] b, int i){
        if(i>0){
            nuevo.agrega(b[i]);
            
            invierteR(nuevo,b,i-1);
        }
    }
    
    public static <T> ColaADT quitaRepe(ColaADT<T> a){
        ColaADT<T> nuevo = new ColaA();
        T b;
        
        if(a!=null){
           b=a.consultaPrimero();
           nuevo.agrega(a.quita());
          
           quitaRepe(a,nuevo,b); 
           copia(a,nuevo); 
        }
            
        return a;    
    }
    
    private static <T> void quitaRepe(ColaADT<T> a, ColaADT<T> nuevo, T b){
        if(!a.estaVacia()){
            if(!b.equals(a.consultaPrimero())){
                b=a.quita();
                nuevo.agrega(b);
            }
            else{
                a.quita();
            }
            quitaRepe(a,nuevo,b);
        }
    }
    //Copia se puede agregar en la parte recursiva de quitaRepe, si se usa un parámetro extra i==0, el cual se pregunta en el 1 if si es ==0
    //Al mometo de empezar a regresar los valores a a se altera este valor 
    private static <T> void copia(ColaADT<T> a, ColaADT<T>nuevo){
        if(!nuevo.estaVacia()){
            a.agrega(nuevo.quita());
            copia(a,nuevo);
        }
    }
    
    public static <T> int eliminaOcu(ColaADT<T> a,T dato){
        int res=0;
        ColaADT<T> aux;
        
        if(a!=null&&dato!=null){
            aux= new ColaA();
            
            eliminaOcu(a,dato,aux,res);
            copia(a,aux);
        }
        
        return res;
    }
    
    private static <T> int eliminaOcu(ColaADT<T> a, T dato, ColaADT<T> aux,int res){
        if(!a.estaVacia()){
            if(a.consultaPrimero().equals(dato)){
                res++;
                a.quita();
            }
            else{
                aux.agrega(a.quita());
            }
            return eliminaOcu(a,dato,aux,res);
        }
        return res;
    }

}
