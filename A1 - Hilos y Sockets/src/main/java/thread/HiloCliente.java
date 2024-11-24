package thread;

import controller.LibroController;
import model.Libro;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class HiloCliente implements Runnable {
    private Socket clientSocket;

    public HiloCliente(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        LibroController libroController = new LibroController();
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                //enviar el menu al cliente
                out.println("""
                                                           ╔═══════════════════════╗
                                                           ║      BIBLIOTECA       ║
                                                           ╠═══════════════════════╣
                                                           ║  1) Consultar ISBN    ║
                                                           ║  ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   ║
                                                           ║  2) Consultar Titulo  ║
                                                           ║  ------------------   ║
                                                           ║  3) Consultar Autor   ║
                                                           ║  ------------------   ║
                                                           ║  4) AñadirLibro       ║
                                                           ║  ------------------   ║
                                                           ║  5) Buscar todos      ║
                                                           ║  ------------------   ║
                                                           ║  6) Salir             ║
                                                           ╚═══════════════════════╝
                        """);
                var opcion = Integer.parseInt(in.readLine());
                System.out.println(opcion);
                switch (opcion) {
                    case 1 -> {
                        long isbn = Long.parseLong(in.readLine());
                        Libro respuesta = libroController.consultarISBN(isbn);
                        if (respuesta != null) {
                            out.println(respuesta);
                        } else {
                            out.println("No existe libro con ISBN: " + isbn);
                        }
                    }
                    case 2 -> {
                        String titulo = in.readLine();
                        Libro respuesta = libroController.consultarTitulo(titulo);
                        if (respuesta != null) {
                            out.println(respuesta);
                        } else {
                            out.println("El libro " + titulo + " no existe");
                        }
                    }
                    case 3 -> {
                        String autor = in.readLine();
                        List<Libro> librosAutor = libroController.consultarAutor(autor);
                        if (!librosAutor.isEmpty()) {
                            for (Libro l : librosAutor) {
                                out.println(l);
                            }
                        } else out.println("No existen libros del autor " + autor);
                    }

                    case 4 -> {
                        String titulo = in.readLine();
                        String autor = in.readLine();
                        float precio = Float.parseFloat(in.readLine());
                        long isbn = Long.parseLong(in.readLine());
                        Libro l = new Libro(isbn, titulo, autor, precio);
                        if (libroController.añadirLibro(l)) {
                            out.println("Se ha añadido: " + l);
                        } else out.println("No se pudo añadir el libro");
                    }
                    case 5 -> {
                        for (Libro l : libroController.consultarTodos()) {
                            out.println(l);
                        }
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.getMessage();
        }
    }
}
