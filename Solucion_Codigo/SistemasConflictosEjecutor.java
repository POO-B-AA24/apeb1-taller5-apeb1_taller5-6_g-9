import java.util.ArrayList;
import java.util.List;

public class SistemasConflictosEjecutor {
    public static void main(String[] args) {
        // Crear lista de países
        List<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Alemania", "Desarrollado"));
        paises.add(new Pais("Francia", "Desarrollado"));
        paises.add(new Pais("Austria", "Desarrollado"));

        // Crear conflictos
        ConflictoInternacional conflicto1 = new ConflictoInternacional("Disputa por Recursos Naturales en el Danubio", paises, "05/03/2024", "En curso", "Recursos naturales");
        ConflictoInternacional conflicto2 = new ConflictoInternacional("Conflicto de Fronteras", paises, "02/02/2020", "En curso", "Intervenciones internacionales");

        // Crear eventos
        Evento evento1 = new Evento("Cumbre Trilateral de Estrasburgo", "15/03/2004", "Estrasburgo", "En esta cumbre trilateral, líderes de Francia, Alemania y Austria se reunieron para discutir las tensiones fronterizas y buscar soluciones diplomáticas para promover la paz y la estabilidad en la región.");
        Batalla batalla2 = new Batalla("La Confrontación en la Región de los Alpes", "05/02/2024", "Paso del Mont Blanc", "Las fuerzas de Francia, Alemania y Austria se enfrentan en una batalla clave en Europa", 200, true);
        Batalla batalla1 = new Batalla("La batalla de los Tres Ríos", "01/02/2024", "Valle del Rin", "Enfrentamiento en las fronteras entre Francia, Alemania y Austria.", 1000, false);

        // Agregar eventos a los conflictos
        conflicto1.agregarEvento(evento1);
        conflicto1.agregarEvento(batalla1);
        conflicto2.agregarEvento(batalla2);

        // Mostrar información de los conflictos
        System.out.println("Información del conflicto 1:");
        System.out.println(conflicto1);
        System.out.println("\nInformación del conflicto 2:");
        System.out.println(conflicto2);

        // Verificar condiciones especiales
        conflicto1.verificarCondicionesEspeciales(paises.size());
        conflicto2.verificarCondicionesEspeciales(paises.size());
    }
}
