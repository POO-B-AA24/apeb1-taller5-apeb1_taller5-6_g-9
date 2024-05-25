package paquete1;

public class Materia {
    private String nombre;
    private double acd;  // Calificación ACD
    private double ape;  // Calificación APE
    private double aa;   // Calificación AA

    public Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAcd() {
        return acd;
    }

    public double getApe() {
        return ape;
    }

    public double getAa() {
        return aa;
    }
    public boolean verificarAprobacion() {
        double total = acd + ape + aa;
        double porcentaje = (total / 10) * 100;
        return porcentaje >= 70;
    }

    public double obtenerPorcentaje() {
        return ((acd + ape + aa) / 10) * 100;
    }
    public double notaRecuperacion() {
        double total = acd + ape + aa;
        double acumulado60 = total * 0.60;
        double notaNecesaria = 7 - acumulado60;

        // La nota de recuperación no puede ser negativa ni mayor que 3.5
        if (notaNecesaria < 0) {
            return 0;
        } else if (notaNecesaria > 3.5) {
            return 3.5;
        } else {
            return notaNecesaria;
        }
    }
}