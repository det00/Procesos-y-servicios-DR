package Cliente;

import Comun.ConstelacionesInterfaceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteConstelacionesRMI {

    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            registry = LocateRegistry.getRegistry("192.168.56.1", 5055);
            System.out.println("Hemos obtenido el registro");
            ConstelacionesInterfaceRMI constelaciones = (ConstelacionesInterfaceRMI) registry.lookup("cons");
            System.out.println("Hemos obtenido el objeto remoto");
            System.out.println(); // Retorno de carro.

            String buscado;
            String opcion;

            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "N":
                        System.out.println("Escribe nombre de la constelación: ");
                        buscado = lector.nextLine();
                        System.out.println(constelaciones.buscarConstelacion(buscado));
                        break;
                    /*case "B":
                        System.out.println("Escribe nombre banda: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarBanda(buscado));
                        break;
                    case "A":
                        System.out.println("Escribe nombre álbum: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarAlbum(buscado));
                        break;
                    case "P":
                        System.out.println("Escribe año de producción: ");
                        buscado = lector.nextLine();
                        int a = Integer.parseInt(buscado);
                        System.out.println(canciones.buscarProducido(a));
                        break;
                    case "F":
                        System.out.println("Programa finalizado");
                        break;*/
                    default:
                        System.out.println("Opción incorrecta");
                }


            } while (!opcion.equals("F"));


        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();
    }

    private static void escribirMenu() {
        System.out.println();
        System.out.println("Información de constelaciones");
        System.out.println("--------------------------");
        System.out.println("N = Nombre");
        /*System.out.println("B = Banda");
        System.out.println("A = Álbum");
        System.out.println("P = Año producción");*/
        System.out.println("F = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
}