import java.io.Serializable;

public class Empleado implements Serializable {
    private String nombre;
    private String matricula;
    private int edad;
    private String apellidos;
    private Puesto puesto;


    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Empleado[" +
                "Nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", Edad=" + edad +
                ", Matricula='" + matricula + '\'' +
                ", Puesto=" + puesto +
                ']';
    }

    public Empleado(String nombre, String matricula, int edad, String apellidos, Puesto puesto) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.apellidos = apellidos;
        this.puesto = puesto;
    }
}
