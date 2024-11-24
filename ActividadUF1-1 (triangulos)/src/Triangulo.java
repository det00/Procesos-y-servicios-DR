import java.time.LocalDateTime;

public class Triangulo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Se requiere un argumento");
            return;
        }

        //AÑADE LA HORA DE INICIO DE PROCESO, FUERA DEL FOR PARA QUE NO SE REPITA EN CADA ITERACIÓN
        System.out.println("Hora de inicio del proceso: " + LocalDateTime.now() + "\n");

        int filas = Integer.parseInt(args[0]);
        for (int i = filas; i >= 1; i--) {
            for (int n = 1; n <= i; n++) {
                System.out.print(n);
            }
            System.out.println();
        }

        //AÑADE LA HORA DE FINALIZACION DEL PROCESO, FUERA DEL FOR POR LO MISMO QUE LA DE INICIO
        System.out.println("\n" + "Hora de finalicación del proceso: " + LocalDateTime.now());
    }
}