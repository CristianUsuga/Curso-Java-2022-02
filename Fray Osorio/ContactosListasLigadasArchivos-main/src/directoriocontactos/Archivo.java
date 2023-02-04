
package directoriocontactos;

import java.io.*;

public class Archivo {
    
    public static BufferedReader Abrir(String nombreArchivo) {

        //verificar la existencia del archicvo
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                FileReader fr = new FileReader(f);
                return new BufferedReader(fr);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }
        
    }
    
}
