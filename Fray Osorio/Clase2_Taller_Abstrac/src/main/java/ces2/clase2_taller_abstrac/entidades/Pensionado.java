/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase2_taller_abstrac.entidades;

/**
 *
 * @author usuga
 */
public class Pensionado extends Persona {

    public Pensionado(String nombre) {
        super(nombre);
    }

    @Override
    public double valorFinal(double monto, double tiempoMeses) {
         double interes = interesCredito(monto, tiempoMeses, TASA_INTERESPensionado);
        double valorfinal = monto+ interes;
        return valorfinal;
    }

    @Override
    public String condicionesCredito(double monto, double tiempoMeses) {
        if(tiempoMeses <=120 ){
            String resultado = " ";
            resultado +=" Usuario: "+ getNombre() + " Ex-trabajador de la empresa: "+getEmpresas()+"<br>";
            resultado += "Total a pagar: "+valorFinal(monto, tiempoMeses)+ " En un perdiodo de: "+tiempoMeses+" meses."+"<br>";
            resultado +="Tasa de Interes: "+(TASA_INTERESPensionado*100)+"<br>";
            return resultado;
        }else{
            return "Credito hipotecario fallido al Usuario: "+ getNombre()+ ". No se puede hacer un prestamo de más de 120 meses "+"<br>";
        }
    }
}
