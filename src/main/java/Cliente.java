import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;


public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",18080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String respuesta;

            while (!Objects.equals(respuesta = in.readLine(), "")){
                System.out.println(respuesta);
            }

            System.out.println("Escoge opción: ");
            String opcion = userInput.readLine();
            out.println(opcion);

            in.close();
            out.close();
            userInput.close();
            socket.close();


        } catch (IOException e){
            System.out.println("No se pudo conectar cabeza filete");
        }
    }
}
