import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",18080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String respuesta;
            String opcion;

            while (true) {
                // Mostrar el menú recibido del servidor
                while (!(respuesta = in.readLine()).isEmpty()) {
                    System.out.println(respuesta);
                }

                // Pedir al usuario que elija una opción
                System.out.println("Escoge opción: ");
                opcion = userInput.readLine();
                out.println(opcion);

                // Si el usuario elige "6", salir del bucle
                if (opcion.equals("6")) {
                    System.out.println("Cerrando la conexión...");
                    break;
                }

                // Leer y mostrar la respuesta del servidor para la opción seleccionada
                while (!(respuesta = in.readLine()).isEmpty()) {
                    System.out.println(respuesta);
                }
            }

            in.close();
            out.close();
            userInput.close();
            socket.close();


        } catch (IOException e){
            System.out.println("No se pudo conectar cabeza filete");
        }
    }
}
