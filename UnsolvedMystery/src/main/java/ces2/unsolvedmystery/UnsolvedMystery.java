/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ces2.unsolvedmystery;

/**
 *
 * @author usuga
 */
public class UnsolvedMystery {

//    public static int myUnsolvedMystery1(int z) {
//        int x = 0;
//
//        for (int i = z; i > 0; i--) {
//            x += i;
//        }
//
//        return x;
//    }
    

    public static int myUnsolvedMystery(int z,int x ) {  
        if (z <= 0) {
            return x;
        } else {
            return myUnsolvedMystery(z-1,x + (z-1));
        }

    }

    public static void main(String[] args) {
        System.out.println("myUnsolvedMystery(4)=" + myUnsolvedMystery(4,4));
        System.out.println("myUnsolvedMystery(6)=" + myUnsolvedMystery(6,6));
        //System.out.println("myUnsolvedMystery(6)=" + myUnsolvedMystery1(6));
    }

}
