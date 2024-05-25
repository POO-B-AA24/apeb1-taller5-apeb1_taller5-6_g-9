package paquete1;

import java.util.Scanner;

public class EjecutorCalificacionesEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int edadEstudiante = scanner.nextInt();

        Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante);

        System.out.print("Ingrese el nombre de la materia: ");
        scanner.nextLine(); // Consumir el salto de línea
        String nombreMateria = scanner.nextLine();

        System.out.print("Ingrese la calificacion ACD (0-3.5): ");
        double acd = scanner.nextDouble();

        System.out.print("Ingrese la calificacion APE (0-3.5): ");
        double ape = scanner.nextDouble();

        System.out.print("Ingrese la calificacion AA (0-3): ");
        double aa = scanner.nextDouble();

        Materia materia = new Materia(nombreMateria, acd, ape, aa);

        estudiante.agregarMateria(materia);

        System.out.println(estudiante);
        estudiante.Aprobado();

        scanner.close();
    }
}