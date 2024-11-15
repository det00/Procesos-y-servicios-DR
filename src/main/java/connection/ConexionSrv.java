package connection;

import controller.LibroController;
import model.Libro;
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
            String respuesta;
            out.println(menu.mostrarMenu());
            while (!(respuesta = in.readLine()).equals("6")) {
                System.out.println(respuesta);
                switch (respuesta) {
                    case "1" -> {
                        out.println("Inserte ISBN del libro a consultar: ");
                        Long ISBN = Long.parseLong(in.readLine());
                        out.println(libroController.consultarISBN(ISBN));
                    }
                    case "2" -> {
                        out.println("Inserte Titulo del libro a consultar: ");
                        String titulo = in.readLine();
                        out.println(libroController.consultarTitulo(titulo));
                    }
                    case "3" -> {
                        out.println("Inserte Autor del libro a consultar");
                        String autor = in.readLine();
                        out.println(libroController.consultarAutor(autor));
                    }
                    case "4" -> {
                        out.println("Inserte ISBN del libro: ");
                        Long ISBN = Long.parseLong(in.readLine());
                        out.println("Inserte Titulo del libro: ");
                        String titulo = in.readLine();
                        out.println("Inserte Autor del libro: ");
                        String autor = in.readLine();
                        out.println("Inserte Precio del libro");
                        float precio = Float.parseFloat(in.readLine());
                        Libro libro = new Libro(ISBN, titulo, autor, precio);
                        libroController.añadirLibro(libro);
                    }
                    case "5" -> out.println(libroController.consultarTodos());

                    default -> out.println("Opción no válida");
                }
                out.println(menu.mostrarMenu());
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e){
            System.out.println("Vete a freir hesparragos: "+ e.getMessage());
        }
    }
}
