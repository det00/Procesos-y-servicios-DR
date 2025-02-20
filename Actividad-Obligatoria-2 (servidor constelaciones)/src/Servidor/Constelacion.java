package Servidor;

public class Constelacion {
    private String nombre;
    private String observaciones;

    public Constelacion(String nombre, String observaciones) {
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Constelacion:" + nombre + ", observaciones='" + observaciones +'.';
    }
}
