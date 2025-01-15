/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edi
 */
public class OperacionesArregloBidimensional {
    
    public static double sumaPorRenglon(Double[][] a, int tot, int m){
        int pos=0;
        double sum=0;
        
        if(a!=null&&m<a.length){
            return sumaPorRenglon(a,tot,m,pos,sum);
        }
        else
            return sum;
    }
    
    private static double sumaPorRenglon(Double[][] a, int tot, int m, int pos, double sum){
        if(pos<tot){
            sum+=a[m][pos];
            return sumaPorRenglon(a,tot,m,pos+1,sum);
        }
        else{
            return sum;
        }
    }
    
    public static double sumaPorColumna(Double[][] a, int tot, int n){
        int pos=0;
        double sum=0;
        
        if(a!=null&&n<a[pos].length){
            return sumPorColumna(a,tot,n,pos,sum);
        }
        else{
            return sum;
        }
    }
    
    private static double sumPorColumna(Double[][] a,int tot, int n, int pos, double sum){
        if(pos<tot){
            sum+=a[pos][n];
            return sumPorColumna(a,tot,n,pos+1,sum);
        }
        else{
            return sum;
        }
    }
    
    public static String toString(Double[][] a, int totM, int totN){
        int posM=0;
        int posN=0;
        StringBuilder cad=new StringBuilder();
        
        if(a!=null){
            return toString(a,totM,totN,posM,posN,cad);
        }
        else{
            return "";
        }
    }
    
    private static String toString(Double[][] a, int totM, int totN,int posM, int posN,StringBuilder cad){
        if(posM<totM){
            if(posN<totN){
                cad.append("\t" + a[posM][posN]);
                return toString(a,totM,totN,posM,posN+1,cad);
            }
            posN=0;
            cad.append("\n");
            return toString(a,totM,totN,posM+1,posN,cad);
        }
        return cad.toString();
    }
    
    public static double sumaDiagonalPrincipal(Double[][] a, int totM, int totN){
        double sum=0;
        int pos=0;
        
        if(a!=null&&totM==totN){
            return sumaDiagonalPrincipal(a,totM,totN,sum,pos);
        }
        else{
            return sum;
        }
    }
    
    private static double sumaDiagonalPrincipal(Double[][] a, int totM, int totN,double sum, int pos){
        if(pos<totM){
            sum+=a[pos][pos];
            return sumaDiagonalPrincipal(a,totM,totN,sum,pos+1);
        }
        else{
            return sum;
        }
    }
    
    public static Double[][] sumaMatrices(Double[][] a, int totMA, int totNA, Double[][] b, int totMB, int totNB){
        int posM=0;
        int posN=0;
        Double[][] res=new Double[totMA][totMB];
        
        if(totMA==totMB&&totNA==totNB){
            sumaMatrices(a,totMA,totNA,b,posM,posN,res);
        }
        
        return res;
        
    }
    
    private static void sumaMatrices(Double[][] a, int totMA, int totNA, Double[][] b,int posM,int posN,Double[][] res){
        if(posM<totMA){
            if(posN<totNA){
                double sum=a[posM][posN]+b[posM][posN];
                res[posM][posN]=sum;
                
                sumaMatrices(a,totMA,totNA,b,posM,posN+1,res);
            }
            else{
                posN=0;
                sumaMatrices(a,totMA,totNA,b,posM+1,posN,res);
            }
        }
        //No necesita regresarse, todo lo que se modifica se guarda en la matriz que es pasada como dirección
        //return res;
    }
    
    public static Double[][] multiplicaciónMatrices(Double[][] a, int totMA, int totNA, Double[][] b, int totMB, int totNB){
        int posM=0;
        int posN=0;
        int e=0;
        double suma=0;
        Double[][] res= new Double[totMA][totNB];
        
        if(totNA==totMB){
            return multiplicaciónMatrices(a,totMA,totNA,totNB,b,posM,posN,res,e,suma);
        }
        else{
            return res;
        }
    }
    
    private static Double[][] multiplicaciónMatrices(Double[][] a,int totMA,int totNA,int totNB,Double[][] b,int posM,int posN,Double[][] res,int e,double suma){
        if(posM<totMA){
            if(posN<totNB){
                if(e<totNA){
                    suma+=(a[posM][e]*b[e][posN]);
                    e++;
                    return multiplicaciónMatrices(a,totMA,totNA,totNB,b,posM,posN,res,e,suma);
                }
                else{
                    res[posM][posN]=suma;
                    suma=0;
                    posN++;
                    e=0;
                    return multiplicaciónMatrices(a,totMA,totNA,totNB,b,posM,posN,res,e,suma);
                }
            }
            else{
                posM++;
                posN=0;
                return multiplicaciónMatrices(a,totMA,totNA,totNB,b,posM,posN,res,e,suma);
            }
        }
        else{
            return res;
        }
    }
}
