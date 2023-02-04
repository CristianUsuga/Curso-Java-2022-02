/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package directoriocontactos;

/**
 *
 * @author User
 */
public class Nodo {
    
    public String nombre;
    public String telefono;
    public String celular;
    public String correo;
    public String direccion;
    
    public Nodo siguiente;
    
    public void actualizar(String nombre,
                            String telefono,
                            String celular,
                            String correo,
                            String direccion){
        this.nombre=nombre;
        this.telefono=telefono;
        this.celular=celular;
        this.correo=correo;
        this.direccion=direccion;
    }
    
}
