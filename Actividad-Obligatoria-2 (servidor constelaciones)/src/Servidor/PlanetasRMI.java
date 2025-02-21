package Servidor;

import Comun.PlanetasInterfaceRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PlanetasRMI extends UnicastRemoteObject implements PlanetasInterfaceRMI {
    private static final long serialVersionUID = 1L;
    private ArrayList<Planeta> planetas;

    public PlanetasRMI() throws RemoteException {
        planetas = new ArrayList<>();

        planetas.add(new Planeta("Mercurio", "77 millones de km", "4,879 km de diámetro", "Rocoso", "3.7 m/s²", "58 días terrestres", 0, false));
        planetas.add(new Planeta("Venus", "41 millones de km", "12,104 km de diámetro", "Rocoso", "8.87 m/s²", "243 días terrestres", 0, false));
        planetas.add(new Planeta("Tierra", "0 km", "12,742 km de diámetro", "Rocoso", "9.8 m/s²", "24 horas", 1, true));
        planetas.add(new Planeta("Marte", "78 millones de km", "6,779 km de diámetro", "Rocoso", "3.71 m/s²", "24.6 horas", 2, false));
        planetas.add(new Planeta("Júpiter", "628 millones de km", "139,820 km de diámetro", "Gaseoso", "24.79 m/s²", "9.9 horas", 79, false));
        planetas.add(new Planeta("Saturno", "1,275 millones de km", "116,460 km de diámetro", "Gaseoso", "10.44 m/s²", "10.7 horas", 83, false));
        planetas.add(new Planeta("Urano", "2,723 millones de km", "50,724 km de diámetro", "Gaseoso", "8.69 m/s²", "17.2 horas", 27, false));
        planetas.add(new Planeta("Neptuno", "4,351 millones de km", "49,244 km de diámetro", "Gaseoso", "11.15 m/s²", "16.1 horas", 14, false));
    }

    @Override
    public String buscarPlaneta(String nombre) throws RemoteException {
        StringBuilder resultado = new StringBuilder();
        for (Planeta p : planetas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                resultado.append(p).append("\n");
            }
        }
        return resultado.length() > 0 ? resultado.toString() : "❌ No se encontró el planeta.";
    }

    @Override
    public List<String> obtenerListaPlanetas() throws RemoteException {
        List<String> planetasInfo = new ArrayList<>();

        planetasInfo.add(String.format("%-15s %-25s %-25s %-20s %-20s %-20s %-20s %-15s",
                "Nombre", "Distancia a la Tierra", "Tamaño", "Composición",
                "Gravedad", "Duración del Día", "Número de Lunas", "Habitable"));
        planetasInfo.add("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Planeta p : planetas) {
            planetasInfo.add(String.format("%-15s %-25s %-25s %-20s %-20s %-20s %-20d %-15s",
                    p.getNombre(), p.getDistanciaNosotros(), p.getTamaño(), p.getMaterial(),
                    p.getGravedad(), p.getDuracionDia(), p.getNumeroLunas(),
                    p.isHabitable() ? "Sí" : "No"));
        }

        return planetasInfo;
    }


}
