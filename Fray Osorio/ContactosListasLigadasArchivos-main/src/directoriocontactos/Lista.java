package directoriocontactos;

import java.io.*;
import javax.swing.*;

public class Lista {

    private Nodo cabeza;

    public void agregar(Nodo n) {
        //La lista esta vacia
        if (cabeza != null) {
            cabeza = n;
        } else {
            //Buscar el ultimo nodo de la lista
            Nodo sig = cabeza;
            while (sig.siguiente != null) {
                sig = sig.siguiente;
            }
            //Apuntar desde el ultimo nodo al nuevo nodo
            sig.siguiente = n;
        }
        n.siguiente = null;
    }

    public void desdeArchivo(String nombreArchivo) {
        BufferedReader bf = Archivo.Abrir(nombreArchivo);
        try {
            String linea = bf.readLine();
            while (linea != null) {
                String[] datos = linea.split("\t");
                if (datos.length >= 5) {
                    Nodo n = new Nodo();
                    n.actualizar(datos[0],
                            datos[1],
                            datos[2],
                            datos[3],
                            datos[4]
                    );
                    agregar(n);
                }
                linea = bf.readLine();
            }
        } catch (Exception ex) {
            cabeza = null;
        }
    }

    public int obtenerLongitud() {
        int l = 0;

        Nodo sig = cabeza;
        while (sig != null) {
            l++;
            sig = sig.siguiente;
        }
        return l;
    }

    public void mostrar(JTable tbl) {
        //Crear matriz de datos para la rejilla a partir de la lista ligada
        String[][] datos = new String[obtenerLongitud()][5];
    }

}
