import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class ProductorExamenes implements Runnable {
    private BufferExamenes buffer;
    private Thread hilo;
    public ProductorExamenes(BufferExamenes buffer) {
        // Construye el hilo. El nombre será la letra E seguida
        // del valor de la variable numeroExamen.
        int randomNumber = ThreadLocalRandom.current().nextInt(1,100);
        hilo = new Thread(this, String.format(String.valueOf(randomNumber)));
        // Establece el valor de la propiedad buffer
        this.buffer = buffer;
        // Inicia el hilo.
        this.hilo.start();
    }

    @Override
    public void run() {
        int aa = LocalDateTime.now().getYear();
        // Generación del código de examen.
        String codigo = this.hilo.getName() + "-" + aa;
        // Añade el nuevo código al buffer de exámenes.
        buffer.fabricarNuevoExamen(codigo);
        // Muestra un mensaje en consola informando sobre el
        // código del examen que se acaba de producir.
        System.out.println("Producido examen "+ codigo);
    }
}