package paquete1;

public class Estudiante {
    private String nombre;
    private int edad;
    private Materia materia;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void agregarMateria(Materia materia) {
        this.materia = materia;
    }
    
    public boolean Aprobado() {
        if (materia == null) {
            System.out.println("El estudiante no tiene una materia asignada.");
            return false;
        }
        boolean aprobado = materia.verificarAprobacion();
        if (aprobado) {
            System.out.println("El estudiante ha aprobado la materia " + materia.getNombre() + ".");
        } else {
            System.out.println("El estudiante debera rendir un examen de recuperacion en la materia de "+materia.getNombre()+".");
            System.out.println("Nota requerida en el examen de recuperacion: "+materia.notaRecuperacion());
        }
        return aprobado;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
