/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstejecuciondinamica;

import java.lang.invoke.MethodHandles;

/**
 *
 * @author RGAMBOAH
 */
public class TstEjecucionDinamica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String strNomClase = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("Saludos desde la clase " +strNomClase );
        if(args.length == 0)
            System.out.println("Sin parámetros");
        else
            for( int i = 0; i < args.length; i++)
                System.out.println("args["+i+"]:"+args[i]);
    }
    
}
