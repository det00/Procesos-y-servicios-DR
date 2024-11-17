import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        iniciarCliente();
    }

    public static void iniciarCliente() {
        Socket clientSocket;
        Scanner scanner = new Scanner(System.in);
        try {
            clientSocket = new Socket("localhost", 5001);
            System.out.println("Conectado al servidor");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            while (true) {
                String linea;
                while (!(linea = in.readLine()).isEmpty()) {
                    System.out.println(linea);
                }
                System.out.print("Seleccione una opcion: ");
                int opcion = 0;
                String inp = scanner.nextLine();
                try {
                    opcion = Integer.parseInt(inp);
                } catch (NumberFormatException e) {
                    System.out.println("Seleccione una opcion correcta");
                }
                out.println(opcion);

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Introduce el ISBN: ");
                        out.println(scanner.nextLine());
                        System.out.println(in.readLine());
                    }
                    case 2 -> {
                        System.out.print("Titulo: ");
                        out.println(scanner.nextLine());
                        System.out.println(in.readLine());
                    }
                    case 3 -> {
                        System.out.print("Autor: ");
                        out.println(scanner.nextLine());
                        System.out.println(in.readLine());
                    }
                    case 4 -> {
                        System.out.print("Titulo: ");
                        out.println(scanner.nextLine());
                        System.out.print("Autor: ");
                        out.println(scanner.nextLine());

                        float precio = 0;
                        boolean esFloat = false;
                        while (!esFloat){
                            System.out.print("Precio: ");
                            if (scanner.hasNextFloat()) {
                                precio = scanner.nextFloat();
                                esFloat = true;
                            } else {
                                System.out.println("Introduzca un precio válido");
                            }
                            scanner.nextLine();
                        }
                        out.println(precio);

                        long isbn = 0L;
                        boolean esLong = false;
                        while (!esLong) {
                            System.out.print("ISBN: ");
                            if (scanner.hasNextLong()) {
                                isbn = scanner.nextLong();
                                esLong = true;
                            } else {
                                System.out.println("Introduce un ISBN válido");
                                scanner.next();
                            }
                            scanner.nextLine();
                        }
                        out.println(isbn);
                        System.out.println(in.readLine());
                    }

                    case 5 -> System.out.println(in.readLine());

                    case 6 -> {
                        System.out.println("Saliendo de la aplicacion..");
                        out.println(6);
                        out.close();
                        return;
                    }
                }
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
