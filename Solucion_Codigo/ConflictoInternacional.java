import java.util.ArrayList;
import java.util.List;

class ConflictoInternacional {
    private String nombre;
    private List<Pais> paisesInvolucrados;
    private String fechaInicio;
    private String estadoActual;
    private String detallesAdicionales;
    private List<Evento> eventos;

    public ConflictoInternacional(String nombre, List<Pais> paisesInvolucrados, String fechaInicio, String estadoActual, String detallesAdicionales) {
        this.nombre = nombre;
        this.paisesInvolucrados = paisesInvolucrados;
        this.fechaInicio = fechaInicio;
        this.estadoActual = estadoActual;
        this.detallesAdicionales = detallesAdicionales;
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void verificarCondicionesEspeciales(int totalPaises) {
        ONU onu = new ONU();
        int numPaisesConBatallas = 0;
        boolean batallaConArmasNucleares = false;

        for (Evento evento : eventos) {
            if (evento instanceof Batalla) {
                numPaisesConBatallas++;
                if (((Batalla) evento).isArmasNuclearesUtilizadas()) {
                    batallaConArmasNucleares = true;
                }
                if (((Batalla) evento).getNumeroBajas() >= 0.5 * paisesInvolucrados.size()) {
                    onu.convocarReunionUrgente();
                }
            }
        }

        if (numPaisesConBatallas > 0.5 * totalPaises) {
            actualizarEstado("Guerra Mundial");
        } else if (numPaisesConBatallas > 0.3 * totalPaises) {
            onu.convocarReunionUrgente();
        }

        for (Pais pais : paisesInvolucrados) {
            if (pais.getTipo().equals("Desarrollado") && batallaConArmasNucleares) {
                actualizarEstado("Guerra Mundial");
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del conflicto: ").append(nombre).append("\n");
        sb.append("Países involucrados: ");
        for (Pais pais : paisesInvolucrados) {
            sb.append(pais.getNombre()).append(" ");
        }
        sb.append("\nFecha de inicio: ").append(fechaInicio).append("\n");
        sb.append("Estado actual: ").append(estadoActual).append("\n");
        sb.append("Detalles adicionales: ").append(detallesAdicionales).append("\n");
        sb.append("Eventos asociados:\n");
        for (Evento evento : eventos) {
            sb.append("- ").append(evento).append("\n");
        }
        return sb.toString();
    }
}

class Evento {
    private String nombre;
    private String fecha;
    private String ubicacion;
    private String descripcion;

    public Evento(String nombre, String fecha, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public void actualizarInformacion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    @Override
    public String toString() {
        return nombre + " - " + fecha + " - " + ubicacion + " - " + descripcion;
    }
}

class Pais {
    private String nombre;
    private String tipo; // Desarrollado, en desarrollo, subdesarrollado

    public Pais(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class ONU {
    public void convocarReunionUrgente() {
        System.out.println("Convocando a reunión urgente de la ONU...");
    }

    public void declararEstado(String estado) {
        System.out.println("Declarando estado: " + estado);
    }
}

class Batalla extends Evento {
    private int numeroBajas;
    private boolean armasNuclearesUtilizadas;

    public Batalla(String nombre, String fecha, String ubicacion, String descripcion, int numeroBajas, boolean armasNuclearesUtilizadas) {
        super(nombre, fecha, ubicacion, descripcion);
        this.numeroBajas = numeroBajas;
        this.armasNuclearesUtilizadas = armasNuclearesUtilizadas;
    }

    public int getNumeroBajas() {
        return numeroBajas;
    }

    public boolean isArmasNuclearesUtilizadas() {
        return armasNuclearesUtilizadas;
    }

    @Override
    public String toString() {
        return super.toString() + " - Número de bajas: " + numeroBajas + " - Armas nucleares utilizadas: " + armasNuclearesUtilizadas;
    }
}


