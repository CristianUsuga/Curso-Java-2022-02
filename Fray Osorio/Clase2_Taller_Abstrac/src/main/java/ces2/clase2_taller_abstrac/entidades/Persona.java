package ces2.clase2_taller_abstrac.entidades;


public abstract class Persona {
    private String nombre;
    double TASA_INTERESEmpleado = 0.076;
    double TASA_INTERESIndependiente =0.10;
    double TASA_INTERESPensionado = 0.062;
    String [] empresas = {"Nutresa","EPM","Droguería"};
    

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public String getEmpresas() {
        int darEmpresa = (int)Math.floor(Math.random()*(2-0+1)+0);
        return empresas[darEmpresa];
    }
    public double interesCredito(double montoPrestamo, double tiempoMeses, double TASA_INTERES){
        double interes = montoPrestamo * tiempoMeses * TASA_INTERES;
        return interes;
    }
    public abstract double valorFinal(double monto, double tiempoMeses);
    
    public abstract String condicionesCredito(double monto, double tiempoMeses);
    
    
    
    
    
}
