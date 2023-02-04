/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase2_taller_interfaces.entidades;

/**
 *
 * @author usuga
 */
public class Independiente implements CreditoHipotecario,AutorizaPrestamo {
    private String nombre;
    private String companhia = "Droguería generica ";
    

    public Independiente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    private double getTasaInteres() {
        return 0.10;
    }

    public String getCompanhia() {
        return companhia;
    }
    
    @Override
    public double interesCredito(int monto, int tiempoMeses) {
        double interes = monto * tiempoMeses * getTasaInteres();
        return interes;
    }

    @Override
    public double valorFinal(int monto, int tiempoMeses) {
       double interes = interesCredito(monto, tiempoMeses);
        double valorfinal = monto+ interes;
        return valorfinal;
    }

    @Override
    public String condicionesCredito(int monto, int tiempoMeses) {
        if(tiempoMeses <=240 && monto <= 200 ){
            String resultado = " ";
            resultado +=" Usuario: "+ getNombre() + " Representante de la empresa: "+getCompanhia()+"<br>";
            resultado += "Total a pagar: "+valorFinal(monto, tiempoMeses)+ "En un perdiodo de: "+tiempoMeses+" meses."+"<br>";
            resultado +="Tasa de Interes: "+(getTasaInteres()*100);
            return resultado;
        }else{
            return "Credito hipotecario fallido al Usuario: "+ getNombre();
        }
    }

    

    
    
}
