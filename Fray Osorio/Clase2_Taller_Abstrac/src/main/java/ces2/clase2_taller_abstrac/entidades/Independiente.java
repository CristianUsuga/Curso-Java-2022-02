/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase2_taller_abstrac.entidades;

/**
 *
 * @author usuga
 */
public class Independiente extends Persona {

    public Independiente(String nombre) {
        super(nombre);
    }

    @Override
    public double valorFinal(double monto, double tiempoMeses) {
         double interes = interesCredito(monto, tiempoMeses, TASA_INTERESIndependiente);
        double valorfinal = monto+ interes;
        return valorfinal;
    }

    @Override
    public String condicionesCredito(double monto, double tiempoMeses) {
       if(tiempoMeses <=240  && monto <200.0){
            String resultado = " ";
            resultado +=" Usuario: "+ getNombre() + " Accionista de la empresa: "+getEmpresas()+"<br>";
            resultado += "Total a pagar: "+valorFinal(monto, tiempoMeses)+ " En un perdiodo de: "+tiempoMeses+" meses."+"<br>";
            resultado +="Tasa de Interes: "+(TASA_INTERESIndependiente*100)+"<br>";
            return resultado;
        }else{
            return "Credito hipotecario fallido al accionista: "+ getNombre()+"<br>";
        }
    }
}
