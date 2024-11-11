package connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexionSrv {
        public void conexion(){
        try{
            ServerSocket serverSocket = new ServerSocket(18080);
            System.out.println("Servidor escuchando en el puerto 18080");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

        } catch (IOException e){
            System.out.println("Vete a freir hesparragos");
        }
    }
}
