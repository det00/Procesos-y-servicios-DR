package presentation;

import controller.LibroController;
import model.Libro;

import java.util.Scanner;

public class Menu {
        public void menuOpciones() {
            Scanner sca = new Scanner(System.in);
            LibroController libroController = new LibroController();
            boolean salir = true;
            while (salir) {
            System.out.println("""
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

                int opcion = Integer.parseInt(sca.nextLine());
                salir = menuSwitch(opcion, libroController);
            }
        }

        private boolean menuSwitch(int opcion, LibroController libroController){
            Scanner scanner = new Scanner(System.in);
            switch (opcion) {
                case 1 -> {
                    System.out.println("Inserte ISBN del libro a consultar");
                    long ISBN = Long.parseLong(scanner.nextLine());
                    libroController.consultarISBN(ISBN);
                    return true;
                }
                case 2 -> {
                    System.out.println("Inserte Titulo del libro a consultar");
                    String titulo = scanner.nextLine();
                    libroController.consultarTitulo(titulo);
                    return true;
                }
                case 3 -> {
                    System.out.println("Inserte Autor del libro a consultar");
                    String autor = scanner.nextLine();
                    libroController.consultarAutor(autor);
                    return true;
                }
                case 4 -> {
                    System.out.println("Inserte ISBN del libro");
                    Long ISBN = Long.parseLong(scanner.nextLine());
                    System.out.println("Inserte Titulo del libro");
                    String titulo = scanner.nextLine();
                    System.out.println("Inserte Autor del libro");
                    String autor = scanner.nextLine();
                    System.out.println("Inserte Precio del libro");
                    float precio = Float.parseFloat(scanner.nextLine());
                    Libro libro = new Libro(ISBN, titulo, autor, precio);
                    libroController.añadirLibro(libro);
                    return true;
                }
                case 5 -> {
                    libroController.consultarTodos();
                }
                case 6 -> {
                    return false;
                }
                default ->
                    System.out.println("Opcion incorrecta");

            }
            return true;
        }
}