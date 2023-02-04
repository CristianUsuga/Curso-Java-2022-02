/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ces2.encontrarrecursivo;

/**
 *
 * @author usuga
 */
public class EncontrarRecursivo {
    
     public static String encontrar_numero(int[]a, int numero, int pos,String encontrado) {  
       
        if (pos >= a.length) {
            return encontrado;
        } else {
            if(a[pos] == numero){
                encontrado += " "+pos+ " | ";
            }else if(pos >= (a.length)-1){
                encontrado ="Sin encontrar";
            }
            return encontrar_numero(a,numero,pos+1,encontrado);
        }

    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] a = {3, 9, 7, 3, 8, 3};
        System.out.println("3 is found in the following positions in the array: "+ encontrar_numero(a, 3, 0,""));
    }
}
