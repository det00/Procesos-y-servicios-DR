import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",18080);

        } catch (IOException e){
            System.out.println("No se pudo conectar cabeza filete");
        }
    }
}
