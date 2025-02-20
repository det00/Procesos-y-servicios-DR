import java.io.IOException;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args){
        //scanner necesario para datos por consola
        Scanner scanner = new Scanner(System.in);

        //for que pide 4 numeros
        for (int i = 0; i<4; i++){
            System.out.println("Introduce un número");
            long num = scanner.nextLong();
            //se crea el hilo con el numero pedido por consola y se le da un nombre
            Thread thread = new Thread(new Primo(num),"Vuelta de for " + (i+1));
            //se inicia
            thread.start();
            try {
                //se llama a join para que el for no siga sin terminar el hilo
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
