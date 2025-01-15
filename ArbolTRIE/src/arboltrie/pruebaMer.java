
package arboltrie;
//import static arboltrie.NewMain.noPrefix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ifons
 */
public class pruebaMer {

    /**
     * @param args the command line arguments
     */
    public static int mergeSort2(char[] arr){
	if(arr.length>1){
		mergeSortR(arr);
	}
	return 1;
}

public static void mergeSortR(char[] arr ){
	if(arr.length>1){
		int n=arr.length;
		char[] arr1=Arrays.copyOfRange(arr, 0, n/2);
		char[] arr2=Arrays.copyOfRange(arr, n/2, n);
		mergeSortR(arr1);
		mergeSortR(arr2);
		combina(arr,arr1,arr2);
	}
}

public static void combina(char[] arr, char[] arr1, char[] arr2){
	int i=0;
	int j=0;
	int tot=0;
	
	while(i<arr1.length&&j<arr2.length){
		if(arr1[i]>arr2[j]){
			arr[tot]=arr2[j];
			j++;
		}
		else{
			arr[tot]=arr1[i];
			i++;
		}
		tot++;
	}
	if(i<arr1.length){
		for(int k=i;k<arr1.length;k++){
			arr[tot]=arr1[k];
			tot++;
		}
	}else{
		if(j<arr2.length){
			for(int k=j;k<arr2.length;k++){
				arr[tot]=arr2[k];
				tot++;
			}
		}
	}
}

public static String mergeSortS(String arr){
	if(arr.length()>1){
		arr=mergeSortSR(arr);
	}
	return arr;
}

public static String mergeSortSR(String arr ){
	if(arr.length()>1){
		int n=arr.length();
		String arr1=arr.substring(0, n/2);
		String arr2=arr.substring(n/2,n);
		String res1=mergeSortSR(arr1);
		String res2=mergeSortSR(arr2);
		return combinaS(res1,res2);
	}
        return arr;
}

public static String combinaS(String arr1, String arr2){
	int i=0;
	int j=0;
	int tot=0;
	String arr="";
        System.out.println("comparing "+arr1+" with "+arr2);
	while(i<arr1.length()&&j<arr2.length()){
		if(arr1.charAt(i)>arr2.charAt(j)){
			arr=arr.substring(0,tot)+arr2.charAt(j);
			j++;
		}
		else{
			arr=arr.substring(0,tot)+arr1.charAt(i);
			i++;
		}
		tot++;
	}
	if(i<arr1.length()){
                arr=arr+arr1.substring(i, arr1.length());
	
	}else{
		if(j<arr2.length()){
                    arr=arr+arr2.substring(j, arr2.length());
		}
	}
        System.out.println("Res " +arr);
        return arr;
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        String a="fdsjdk";
        char[] b=a.toCharArray();
        mergeSort2(b);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        String res=mergeSortS(a);
        System.out.println(res);
    
        char c='9';
        
        System.out.println(Character.getNumericValue(c));
        List<String> palabras=new ArrayList<String>();
 
        palabras.add("abcd");
        palabras.add("bcd");
        palabras.add("abcde");
        palabras.add("bcde");
        System.out.println("algo");
        //noPrefix(palabras);
        System.out.println("algo2");
    }
    

}
