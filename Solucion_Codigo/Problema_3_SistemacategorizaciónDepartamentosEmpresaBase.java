import java.util.ArrayList;
import java.util.List;
public class Problema_3_SistemacategorizaciónDepartamentosEmpresaBase {
    private String nombre;
    private int numeroEmpleados;
    private double produccionAnual;
    private String categoria;

    public Problema_3_SistemacategorizaciónDepartamentosEmpresaBase(String nombre, int numeroEmpleados, double produccionAnual) {
        this.nombre = nombre;
        this.numeroEmpleados = numeroEmpleados;
        this.produccionAnual = produccionAnual;
        this.categoria = determinarCategoria();
    }
    private String determinarCategoria() {
        if (numeroEmpleados > 20 && produccionAnual > 1000000) {
            return "A";
        } else if (numeroEmpleados >= 20 && produccionAnual >= 1000000) {
            return "B";
        } else if (numeroEmpleados >= 10 && produccionAnual >= 500000) {
            return "C";
        } else {
            return "Sin categoría";
        }
    }

    @Override
    public String toString() {
        return "Departamento{" + "nombre=" + nombre + ", numeroEmpleados=" + numeroEmpleados + ", produccionAnual=" + produccionAnual + ", categoria=" + categoria + '}';
    }
    public String getCategoria() {
        return categoria;
    }
}
