package Servidor;

public class Planeta {
    private String nombre;
    private String distanciaNosotros;
    private String tamaño;
    private String material;
    private String gravedad;
    private String duracionDia;
    private int numeroLunas;
    private boolean habitable;

    public Planeta(String nombre, String distanciaNosotros, String tamaño, String material, String gravedad, String duracionDia, int numeroLunas, boolean habitable) {
        this.nombre = nombre;
        this.distanciaNosotros = distanciaNosotros;
        this.tamaño = tamaño;
        this.material = material;
        this.gravedad = gravedad;
        this.duracionDia = duracionDia;
        this.numeroLunas = numeroLunas;
        this.habitable = habitable;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDistanciaNosotros() {
        return distanciaNosotros;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getMaterial() {
        return material;
    }

    public String getGravedad() {
        return gravedad;
    }

    public String getDuracionDia() {
        return duracionDia;
    }

    public int getNumeroLunas() {
        return numeroLunas;
    }

    public boolean isHabitable() {
        return habitable;
    }

    @Override
    public String toString() {
        return "🌍 Planeta: " + nombre + "\n" +
                "📏 Tamaño: " + tamaño + "\n" +
                "📡 Distancia a la Tierra: " + distanciaNosotros + "\n" +
                "🪨 Composición: " + material + "\n" +
                "🌐 Gravedad: " + gravedad + "\n" +
                "⏳ Duración del día: " + duracionDia + "\n" +
                "🌕 Número de lunas: " + numeroLunas + "\n" +
                "🏠 Habitable: " + (habitable ? "Sí" : "No") + "\n" +
                "----------------------------------";
    }
}