package ces2.clase2_taller_interfaces.entidades;

public class Pensionado implements CreditoHipotecario, AutorizaPrestamo{
    private String name;
    private double tasaInteres = 0.062;
    String [][] agencia = {{"Colpensiones","si"},{"Ninguna","no"},{"Privada","si"}};

    public String getAgencia() {
         int darAgencia = (int)Math.floor(Math.random()*(2-0+1)+0);
        return agencia [darAgencia][0];
    }
   
    private int edad= (int)Math.floor(Math.random()*(80-62+1)+62);

    public Pensionado(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
    
        
    @Override
    public double interesCredito(int monto, int tiempoMeses) {
        double interes = monto * tiempoMeses * getTasaInteres();
        return interes;
    }

    @Override
    public double valorFinal(int monto,  int tiempoMeses) {
        
        double interes = interesCredito(monto, tiempoMeses);
        double valorfinal = monto+ interes;
        return valorfinal;
    }

    @Override
    public String toString() {
        return "Pensionado{" + "name=" + name + ", tasaInteres=" + tasaInteres + ", edad=" + edad + '}';
    }

    @Override
    public String condicionesCredito(int monto,  int tiempoMeses) {
        String resultado;
        if(tiempoMeses <=120){
            resultado = " ";
            resultado += "Usuario: "+ getName()+" Edad: "+getEdad()+ " Agencia: "+ getAgencia()+"<br>";
            resultado +="El valor total a pagar es: "+ valorFinal(monto, tiempoMeses)+ "<br>";
            resultado += "En un tiempo de: "+ tiempoMeses+" meses"+"<br>";
            
            return resultado;
        }else{
            return "No se puede un prestamo a más de 10 años (120 meses) ";
        }
    }    
    
}
