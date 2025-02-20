import java.io.Serializable;

public class Puesto implements Serializable {
    private String nombrePuesto;
    private String descripcionPuesto;

    public Puesto(String nombrePuesto, String descripcionPuesto) {
        this.nombrePuesto = nombrePuesto;
        this.descripcionPuesto = descripcionPuesto;
    }

    @Override
    public String toString() {
        return "Puesto: [Nombre del puesto: "+ nombrePuesto + ", Descripción: " + descripcionPuesto + "]";
    }

}
