/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase2_taller_interfaces.entidades;

public class Empleado implements CreditoHipotecario, AutorizaPrestamo{
    private String nombre;
    String [] empresa = {"Nutresa","Comfama", "EMP"};

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresa() {
        int darEmpresa = (int)Math.floor(Math.random()*(2-0+1)+0);
        return empresa[darEmpresa];
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
        if(tiempoMeses <=240 ){
            String resultado = " ";
            resultado +=" Usuario: "+ getNombre() + " Trabajador de la empresa: "+getEmpresa()+"<br>";
            resultado += "Total a pagar: "+valorFinal(monto, tiempoMeses)+ "En un perdiodo de: "+tiempoMeses+" meses."+"<br>";
            resultado +="Tasa de Interes: "+(getTasaInteres()*100);
            return resultado;
        }else{
            return "Credito hipotecario fallido al Usuario: "+ getNombre();
        }
    }

    private double getTasaInteres() {
        return 0.072;
    }

    
    
}
