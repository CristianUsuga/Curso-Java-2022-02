/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ces2.clase2_taller_interfaces.entidades;

/**
 *
 * @author usuga
 */
public interface CreditoHipotecario {
    double TASA_INTERES = 0.062;
    int MAXIMO_MESES=240;
    
    default public double interesCredito(int monto, int tiempoMeses){
    return 100;
    }
    
    public double valorFinal(int monto, int tiempoMeses);
}
