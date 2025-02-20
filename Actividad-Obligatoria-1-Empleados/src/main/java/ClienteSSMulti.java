import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSSMulti {
    public static void main(String[] args) {
        System.out.println("APLICACIÓN CLIENTE");
        System.out.println("-----------------------------------");
        Scanner lector = new Scanner(System.in);
        try {
            Socket cliente = new Socket();
            InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 2001);
            System.out.println("Esperando a que el servidor acepte la conexión");
            cliente.connect(direccionServidor);
            System.out.println("Comunicación establecida con el servidor");

            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            String nombreEmpleado;
            do {
                System.out.println("Ingrese el nombre del empleado (o 'FIN' para terminar):");
                nombreEmpleado = lector.nextLine();
                salida.writeObject(nombreEmpleado);

                if (!"FIN".equals(nombreEmpleado)) {
                    Empleado empleado = (Empleado) entrada.readObject();
                    if (empleado != null) {
                        System.out.println("Información del empleado recibida: " + empleado.toString());
                    } else {
                        System.out.println("El empleado no fue encontrado.");
                    }
                }
            } while (!"FIN".equals(nombreEmpleado));

            entrada.close();
            salida.close();
            cliente.close();
            System.out.println("Comunicación cerrada");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S");
            System.out.println(e.getMessage());
        }
    }
}