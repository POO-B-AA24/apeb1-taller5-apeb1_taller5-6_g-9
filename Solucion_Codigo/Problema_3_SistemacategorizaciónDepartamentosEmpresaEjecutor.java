import java.util.Scanner;

public class Problema_3_SistemacategorizaciónDepartamentosEmpresaEjecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la empresa:");
        String nombreEmpresa = scanner.nextLine();

        System.out.println("Ingrese el RUC de la empresa:");
        String rucEmpresa = scanner.nextLine();

        System.out.println("Ingrese la dirección de la empresa:");
        String direccionEmpresa = scanner.nextLine();

        Empresa empresa = new Empresa(nombreEmpresa, rucEmpresa, direccionEmpresa);

        while (true) {
            System.out.println("Ingrese el nombre del departamento (o 'salir' para terminar):");
            String nombreDepartamento = scanner.nextLine();
            if (nombreDepartamento.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese el número de empleados del departamento (> a 10):");
            int numeroEmpleados = scanner.nextInt();

            System.out.println("Ingrese la producción anual del departamento (> a 500.000):");
            double produccionAnual = scanner.nextDouble();
            scanner.nextLine();  // Consumir el salto de línea

            Problema_3_SistemacategorizaciónDepartamentosEmpresaBase departamento = new Problema_3_SistemacategorizaciónDepartamentosEmpresaBase(nombreDepartamento, numeroEmpleados, produccionAnual);
            empresa.agregarDepartamento(departamento);
        }

        System.out.println("Departamentos de la empresa:");
        empresa.mostrarDepartamentos();

        scanner.close();
    }
}

