package Servidor;

public class Constelacion {
    private String nombre;
    private String observaciones;
    private String ubicacion;
    private String estrellasPrincipales;
    private String visibilidad;

    public Constelacion(String nombre, String observaciones, String ubicacion, String estrellasPrincipales, String visibilidad) {
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
        this.estrellasPrincipales = estrellasPrincipales;
        this.visibilidad = visibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstrellasPrincipales() {
        return estrellasPrincipales;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    @Override
    public String toString() {
        return "✨ Constelación: " + nombre + "\n" +
                "🔭 Observaciones: " + observaciones + "\n" +
                "📍 Ubicación: " + ubicacion + "\n" +
                "⭐ Estrellas principales: " + estrellasPrincipales + "\n" +
                "🌌 Mejor visibilidad en: " + visibilidad + "\n" +
                "----------------------------------";
    }
}
