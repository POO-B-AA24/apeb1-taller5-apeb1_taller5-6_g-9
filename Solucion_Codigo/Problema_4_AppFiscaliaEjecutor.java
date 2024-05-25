import java.util.Date;

public class Problema_4_AppFiscaliaEjecutor {
    public static void main(String[] args) {
        Problema_4_AppFiscaliaBase fiscalia = new Problema_4_AppFiscaliaBase();
        // Crear personas implicadas
        PersonaImplicada persona1 = new PersonaImplicada("Juan Perez", 45, "Empresario", "acusado", 10, 100000);
        PersonaImplicada persona2 = new PersonaImplicada("Maria Gomez", 30, "Abogada", "testigo", 0, 0);
        // Crear una instancia de CasoCorrupcion con fecha de inicio hace 8 días
        Date fechaInicio = new Date(122, 0, 1); // 1 de enero de 2022
        CasoCorrupcion caso1 = new CasoCorrupcion("Caso1", fechaInicio, "Iniciado", "Detalles del caso 1");

        // Agregar personas al caso
        caso1.agregarPersona(persona1);
        caso1.agregarPersona(persona2);

        // Agregar caso a la fiscalía
        fiscalia.agregarCaso(caso1);

        // Mostrar casos y actualizar estado
        fiscalia.mostrarCasos();

        // Mostrar detalles de las personas implicadas en el caso
        System.out.println("Detalles de las personas implicadas en el caso:");
        for (PersonaImplicada persona : caso1.getPersonasImplicadas()) {
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Ocupación: " + persona.getOcupacion());
            System.out.println("Nivel de Implicación: " + persona.getNivelImplicacion());
            System.out.println("Tiempo de Implicación: " + persona.getTiempoImplicacion());
            System.out.println("Daño Económico: " + persona.getDanioEconomico());
            System.out.println("-----------------------------");
        }


        // Mostrar fianza si aplica
        for (PersonaImplicada persona : caso1.getPersonasImplicadas()) {
            if (persona.getNivelImplicacion().equals("acusado")) {
                double fianza = persona.calcularFianza();
                if (fianza > 0) {
                    System.out.println("Fianza para " + persona.getNombre() + ": " + fianza);
                }
            }
        }
    }
}