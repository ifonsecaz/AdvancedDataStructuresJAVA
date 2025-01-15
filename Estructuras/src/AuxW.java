/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ifons
 */
public class AuxW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double [][] arr=new Double[5][5];
        
        for(int i=0;i<5;i++){
            for(int j=0; j<5;j++){
                arr[i][j]=i+1.0;
            }
        }
        
        System.out.println(OperacionesArregloBidimensional.sumaPorRenglon(arr, 5, 4));
    }
    
}
