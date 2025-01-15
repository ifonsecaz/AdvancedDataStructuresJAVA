/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tstejecuciondinamica;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RGGH
 */
public class Distribuidor 
{
    public static void main( String args[])
    {

        System.out.println("Distribuidor, inciando con:");
        if( args.length == 0) //Checa que haya argumentos
            System.out.println("Sin argumentos");
        else
            for(int i = 0; i < args.length; i++)
                System.out.println("args[" + i + "]:" + args[i]);
        System.out.println("------------------------------------------");

        String[] argsPar = new String[0]; //Crea un nuevo arreglo de strings para guardar el resto de argumentos
		//No copia el primero, pues es la clase a levantar
        
        if( args.length > 1 )
        {
           argsPar = new String[args.length-1];
           for(int i=1;i<args.length;i++)
             argsPar[i-1] = args[i];  
        }
        if( args.length == 0 ) 
        {
            System.out.println("uso:\n" + 
                               "Distribuidor paqueteOTrayectoriajar.ClaseAEjecutar y argumentos");
        }
        else
        {
			//
            Class[] cArg = new Class[1]; //Crea un arreglo de clases
            cArg[0] = String[].class;
            System.out.println("Distribuidor redirigiendo a args[0]:" + args[0]);
            try 
            {
              Class cl = Class.forName( args[0]);
              Method m = cl.getMethod("main", cArg); //Llama al método main 
              m.invoke(cl, (Object) argsPar); //Pasa los argumentos
              System.out.println("Distribuidor ha invocado, notar cuando aparece este mensaje...");
            
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
     }     
   }    
}
