package Servidor;

import Comun.ConstelacionesInterfaceRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ConstelacionesRMI extends UnicastRemoteObject implements ConstelacionesInterfaceRMI {
    private static final long serialVersionUID = 1L;
    private ArrayList<Constelacion> constelaciones;

    public ConstelacionesRMI() throws RemoteException {
        constelaciones = new ArrayList<>();

        constelaciones.add(new Constelacion("Osa Mayor", "Se desplaza en círculos alrededor del polo norte.",
                "Hemisferio Norte", "Dubhe, Merak, Alioth", "Todo el año"));

        constelaciones.add(new Constelacion("Osa Menor", "Contiene la estrella Polaris.",
                "Hemisferio Norte", "Polaris, Kochab", "Todo el año"));

        constelaciones.add(new Constelacion("Orion", "Visible en invierno con su famoso cinturón.",
                "Ecuador celeste", "Betelgeuse, Rigel", "Invierno"));

        constelaciones.add(new Constelacion("Leo", "Una de las constelaciones del Zodiaco.",
                "Hemisferio Norte", "Regulus, Denebola", "Primavera"));

        constelaciones.add(new Constelacion("Escorpio", "Sus estrellas forman un escorpión.",
                "Hemisferio Sur", "Antares, Shaula", "Verano"));

        constelaciones.add(new Constelacion("Can Mayor", "Contiene la estrella más brillante del cielo nocturno.",
                "Hemisferio Sur", "Sirio, Adhara", "Invierno"));

        constelaciones.add(new Constelacion("Casiopea", "Fácilmente reconocible por su forma de M o W.",
                "Hemisferio Norte", "Schedar, Caph", "Otoño"));

        constelaciones.add(new Constelacion("Cruz del Sur", "Señala el Polo Sur celeste.",
                "Hemisferio Sur", "Acrux, Mimosa", "Todo el año en el hemisferio sur"));

        constelaciones.add(new Constelacion("Acuario", "Una de las más antiguas.",
                "Ecuador celeste", "Sadalsuud, Sadalmelik", "Otoño"));

        constelaciones.add(new Constelacion("Géminis", "Destaca por sus dos estrellas gemelas.",
                "Hemisferio Norte", "Cástor, Pólux", "Invierno"));
    }

    @Override
    public String buscarConstelacion(String nombre) throws RemoteException {
        StringBuilder resultado = new StringBuilder();
        for (Constelacion c : constelaciones) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                resultado.append(c).append("\n");
            }
        }
        return resultado.length() > 0 ? resultado.toString() : "❌ No se encontró la constelación.";
    }

    @Override
    public String buscarConstelacionesCercanas(String nombre) throws RemoteException {
        switch (nombre.toLowerCase()) {
            case "osa mayor":
                return "🔍 Constelaciones cercanas a Osa Mayor:\n✨ Osa Menor, Casiopea y El Boyero.";
            case "osa menor":
                return "🔍 Constelaciones cercanas a Osa Menor:\n✨ Osa Mayor, Dragón.";
            case "orion":
                return "🔍 Constelaciones cercanas a Orión:\n✨ Tauro, Can Mayor, Géminis y Erídano.";
            case "leo":
                return "🔍 Constelaciones cercanas a Leo:\n✨ Virgo, Cáncer, Coma Berenices.";
            case "escorpio":
                return "🔍 Constelaciones cercanas a Escorpio:\n✨ Sagitario, Libra, Corona Austral.";
            case "can mayor":
                return "🔍 Constelaciones cercanas a Can Mayor:\n✨ Can Menor, Orión, Monoceros.";
            case "casiopea":
                return "🔍 Constelaciones cercanas a Casiopea:\n✨ Perseo, Andrómeda, Cefeo.";
            case "cruz del sur":
                return "🔍 Constelaciones cercanas a Cruz del Sur:\n✨ Centauro, Musca.";
            case "acuario":
                return "🔍 Constelaciones cercanas a Acuario:\n✨ Capricornio, Piscis, Pegaso.";
            case "géminis":
                return "🔍 Constelaciones cercanas a Géminis:\n✨ Orión, Cáncer, Lince.";
            default:
                return "❌ No se encontraron constelaciones cercanas a '" + nombre + "'.";
        }
    }

    @Override
    public List<String> obtenerListaConstelaciones() throws RemoteException {
        List<String> constelacionesInfo = new ArrayList<>();

        constelacionesInfo.add(String.format("%-20s %-60s %-25s %-25s %-20s",
                "Nombre", "Observaciones", "Ubicación",
                "Estrellas Principales", "Visibilidad"));
        constelacionesInfo.add("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Constelacion c : constelaciones) {
            constelacionesInfo.add(String.format("%-20s %-60s %-25s %-25s %-20s",
                    c.getNombre(), c.getObservaciones(), c.getUbicacion(),
                    c.getEstrellasPrincipales(), c.getVisibilidad()));
        }

        return constelacionesInfo;
    }


}
