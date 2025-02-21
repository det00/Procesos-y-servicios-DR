package Cliente;

import Comun.ConstelacionesInterfaceRMI;
import Comun.PlanetasInterfaceRMI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClienteRMI {

    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);

        try {
            registry = LocateRegistry.getRegistry("192.168.56.1", 5055);
            ConstelacionesInterfaceRMI constelaciones = (ConstelacionesInterfaceRMI) registry.lookup("cons");
            PlanetasInterfaceRMI planetas = (PlanetasInterfaceRMI) registry.lookup("plan");

            String opcion;
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "1":
                        System.out.println("🔎 Escribe el nombre de la constelación: ");
                        String constBuscada = lector.nextLine();
                        System.out.println(constelaciones.buscarConstelacion(constBuscada));
                        break;
                    case "2":
                        System.out.println("🔎 Escribe el nombre del planeta: ");
                        String planetaBuscado = lector.nextLine();
                        System.out.println(planetas.buscarPlaneta(planetaBuscado));
                        break;
                    case "3":
                        System.out.println("🌌 Lista de Constelaciones:");
                        List<String> listaConstelaciones = constelaciones.obtenerListaConstelaciones();  // Llamada al servidor
                        mostrarTablaConstelaciones(listaConstelaciones);  // Muestra la tabla de constelaciones
                        break;

                    case "4":
                        System.out.println("🪐 Lista de Planetas:");
                        List<String> listaPlanetas = planetas.obtenerListaPlanetas();  // Llamada al servidor
                        mostrarTablaPlanetas(listaPlanetas);  // Muestra la tabla de planetas
                        break;

                    case "5":
                        System.out.println("🎲 Generando sugerencia aleatoria...");
                        System.out.println("🌌 Orion es visible en invierno y tiene la estrella Betelgeuse.");
                        break;
                    case "6":
                        System.out.println("👋 Saliendo del programa...");
                        break;
                    case "7":
                        System.out.println("🔎 Escribe el nombre de la constelación para buscar las cercanas: ");
                        String constelacion = lector.nextLine();
                        System.out.println(constelaciones.buscarConstelacionesCercanas(constelacion));
                        break;
                    default:
                        System.out.println("❌ Opción incorrecta.");
                }
            } while (!opcion.equals("6"));

        } catch (RemoteException | NotBoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        lector.close();
    }

    private static void escribirMenu() {
        System.out.println("""
        
        🌠 EXPLORADOR ASTRONÓMICO 🌠
        1️⃣ Buscar Constelación
        2️⃣ Buscar Planeta
        3️⃣ Ver lista completa de constelaciones
        4️⃣ Ver lista completa de planetas
        5️⃣ Sugerencias aleatorias
        6️⃣ Salir
        7️⃣ Buscar Constelaciones Cercanas
        """);
    }

    private static void mostrarTablaPlanetas(List<String> planetas) {
        System.out.println("\n🪐 Lista de Planetas:");

        for (String planeta : planetas) {
            System.out.println(planeta);
        }
    }

    private static void mostrarTablaConstelaciones(List<String> constelaciones) {
        System.out.println("\n✨ Lista de Constelaciones:");

        for (String constelacion : constelaciones) {
            System.out.println(constelacion);
        }
    }


}
