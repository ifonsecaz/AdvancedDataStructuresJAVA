

package arboltrie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;
/**
 *
 * @author ifons
 */
public class NewMain {
    public static boolean noPrefix(String word,int cont, DefaultMutableTreeNode nodo,int addC) {
        if(cont<word.length()){
         
            int i=nodo.getChildCount();
            int j=0;
            boolean encontro=false;
            while(j<i&&!encontro){
                DefaultMutableTreeNode hijo=(DefaultMutableTreeNode)nodo.getChildAt(j);
    
                if((char)hijo.getUserObject()==word.charAt(cont)){
                    encontro=true;
                }
                j++;
            }
            if(!encontro){
                
                DefaultMutableTreeNode nuevo=new DefaultMutableTreeNode(word.charAt(cont));
                nodo.add(nuevo);
                nodo=nuevo;
            }
            else{
                addC++;
                nodo=(DefaultMutableTreeNode) nodo.getChildAt(j-1);
            }
        
            return noPrefix(word,cont+1,nodo,addC);
        }
        else{
            if(addC>0){
                return false;
            }
            else{
                return true;
            }
        }
    }
    public static void noPrefix(List<String> words) {
    // Write your code here
        DefaultMutableTreeNode arbPRaiz=new DefaultMutableTreeNode();
        boolean res=true;
        //TreeMap<Integer,String> tam=new TreeMap<>();
        //Collections.sort(words, Comparator.comparing(String::length));
        //Falta ordenar strings
        for(int i=0;i<words.size();i++){
            
            System.out.println(noPrefix(words.get(i),0,arbPRaiz,0));
                }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> palabras=new ArrayList<String>();
 
        palabras.add("abcde");
        palabras.add("abcd");
        palabras.add("bcde");
        palabras.add("bcd");
        
        
        System.out.println("algo");
        noPrefix(palabras);
        System.out.println("algo2");
    }
    
}