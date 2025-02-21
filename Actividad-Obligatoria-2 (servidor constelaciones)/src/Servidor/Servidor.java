package Servidor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        String host;
        int puerto = 5055;

        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("No se ha podido obtener la dirección IP");
            System.out.println(e.getMessage());
            return;
        }

        try {
            Registry registro = LocateRegistry.createRegistry(puerto);

            ConstelacionesRMI constelaciones = new ConstelacionesRMI();
            registro.rebind("cons", constelaciones);

            PlanetasRMI planetas = new PlanetasRMI();
            registro.rebind("plan", planetas);

            System.out.println("Servicios registrados en host " + host + " y puerto " + puerto);
            System.out.println("Servicio de constelaciones disponible como 'cons'");
            System.out.println("Servicio de planetas disponible como 'plan'");
        } catch (RemoteException e) {
            System.out.println("No se ha podido registrar el servicio");
            System.out.println(e.getMessage());
        }
    }
}
