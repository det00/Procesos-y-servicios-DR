package connection;

import controller.LibroController;
import presentation.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexionSrv {
    Menu menu = new Menu();
    LibroController libroController = new LibroController();
        public void conexion(){
        try{
            ServerSocket serverSocket = new ServerSocket(18080);
            System.out.println("Servidor escuchando en el puerto 18080");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(menu.mostrarMenu());
            String respuesta = in.readLine();
            System.out.println(respuesta);

            menu.menuSwitch(Integer.parseInt(respuesta), libroController);

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e){
            System.out.println("Vete a freir hesparragos"+ e.getMessage());
        }
    }
}
