import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Problema_4_AppFiscaliaBase {
    private List<CasoCorrupcion> casos;
    public Problema_4_AppFiscaliaBase() {
        this.casos = new ArrayList<>();
    }


    public void agregarCaso(CasoCorrupcion caso) {
        casos.add(caso);
    }

    public void mostrarCasos() {
        for (CasoCorrupcion caso : casos) {
            System.out.println(caso);
        }
    }
}
class CasoCorrupcion {
    private String nombre;
    private Date fechaInicio;
    private String estado;
    private String detalles;
    private List<PersonaImplicada> personasImplicadas;

    public CasoCorrupcion(String nombre, Date fechaInicio, String estado, String detalles) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.detalles = detalles;
        this.personasImplicadas = new ArrayList<>();

    }


    public void agregarPersona(PersonaImplicada persona) {
        personasImplicadas.add(persona);
    }

    public List<PersonaImplicada> getPersonasImplicadas() {
        return personasImplicadas;
    }

    @Override
    public String toString() {
        return "CasoCorrupcion{" +
                "nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", estado='" + estado + '\'' +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
class PersonaImplicada {
    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion;
    private int tiempoImplicacion;
    private double danioEconomico;

    public PersonaImplicada(String nombre, int edad, String ocupacion, String nivelImplicacion, int tiempoImplicacion, double danioEconomico) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
        this.tiempoImplicacion = tiempoImplicacion;
        this.danioEconomico = danioEconomico;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getNivelImplicacion() {
        return nivelImplicacion;
    }

    public int getTiempoImplicacion() {
        return tiempoImplicacion;
    }

    public double getDanioEconomico() {
        return danioEconomico;
    }
    public double calcularFianza() {
        if (nivelImplicacion.equals("acusado") && tiempoImplicacion < 365 && danioEconomico > 0) {
            // Calcular la fianza (por ejemplo, el 50% del daño económico causado al estado)
            double fianza = danioEconomico * 0.5;
            return fianza;
        } else {
            // En otros casos, no hay fianza
            return 0.0;
        }
    }
}
