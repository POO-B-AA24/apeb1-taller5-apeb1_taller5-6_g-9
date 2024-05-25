import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String ruc;
    private String direccion;
    private List<Problema_3_SistemacategorizaciónDepartamentosEmpresaBase> problema1SistemacategorizaciónDepartamentosEmpresaBases;

    public Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.problema1SistemacategorizaciónDepartamentosEmpresaBases = new ArrayList<>();
    }

    public void agregarDepartamento(Problema_3_SistemacategorizaciónDepartamentosEmpresaBase departamentosEmpresaBaseamento) {
        problema1SistemacategorizaciónDepartamentosEmpresaBases.add(departamentosEmpresaBaseamento);
    }

    public void mostrarDepartamentos() {
        for (Problema_3_SistemacategorizaciónDepartamentosEmpresaBase departamentosEmpresaBasetamento : problema1SistemacategorizaciónDepartamentosEmpresaBases) {
            System.out.println(departamentosEmpresaBasetamento);
        }
    }
}
