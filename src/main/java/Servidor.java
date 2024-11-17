import thread.HiloCliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        iniciarServidor();
    }

    public static void iniciarServidor(){
        ServerSocket serverSocket;
        Socket clientSocket;
        try {
            serverSocket = new ServerSocket(5001);
            System.out.println("Servidor escuchando...");
            while(true){
                clientSocket = serverSocket.accept();
                System.out.println("Cliente " + clientSocket.getLocalAddress() + " conectado");
                new Thread(new HiloCliente(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}