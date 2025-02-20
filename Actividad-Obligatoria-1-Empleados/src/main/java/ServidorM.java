import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorM {
    // Lista estática que simula una base de datos de empleados
    private static List<Empleado> empleados = new ArrayList<>();

    static {
        empleados.add(new Empleado("Juan", "MAT001", 30, "González", new Puesto("Desarrollador", "Programación Java")));
        empleados.add(new Empleado("María", "MAT002", 28, "López", new Puesto("Analista de Datos", "Análisis de datos")));
        empleados.add(new Empleado("Pedro", "MAT003", 35, "Martínez", new Puesto("Gerente de Proyectos", "Gestión de proyectos")));
        empleados.add(new Empleado("Ana", "MAT004", 26, "Ruiz", new Puesto("Diseñadora UX/UI", "Diseño de interfaz")));
        empleados.add(new Empleado("Carlos", "MAT005", 40, "Sánchez", new Puesto("Ingeniero de Software", "Desarrollo de software")));
        empleados.add(new Empleado("Laura", "MAT006", 29, "Fernández", new Puesto("Especialista en Marketing", "Marketing digital")));
        empleados.add(new Empleado("Manuel", "MAT007", 32, "Pérez", new Puesto("Técnico de Sistemas", "Mantenimiento de sistemas")));
        empleados.add(new Empleado("Sofía", "MAT008", 27, "Díaz", new Puesto("Consultora de RR.HH.", "Recursos Humanos")));
        empleados.add(new Empleado("Luis", "MAT009", 33, "Torres", new Puesto("Contador", "Contabilidad")));
        empleados.add(new Empleado("Elena", "MAT010", 31, "García", new Puesto("Abogada", "Asesoría legal")));
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }

    public static void main(String[] args) {
        System.out.println("APLICACIÓN DE SERVIDOR MULTITAREA");
        System.out.println("----------------------------------");
        try {
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccion = new InetSocketAddress("localhost", 2001);
            servidor.bind(direccion);
            System.out.println("Servidor listo para aceptar solicitudes");
            System.out.println("Dirección IP: " + direccion.getAddress());
            while (true) {
                Socket enchufeAlCliente = servidor.accept();
                System.out.println("Comunicación entrante");
                new HiloEscuchador(enchufeAlCliente);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}