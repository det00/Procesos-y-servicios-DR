import java.util.Random;

public class Examinado implements Runnable {

    private Thread hilo;
    BufferExamenes buffer;

    public Examinado(String alumno, BufferExamenes generador) {
// Construye el hilo. El nombre será el nombre del alumno.
        hilo = new Thread(this, alumno);
// Establece el valor de la propiedad buffer
        this.buffer = generador;
// Inicia el hilo.
        this.hilo.start();
    }

    @Override
    public synchronized void run() {
        String codigoExamen = this.buffer.consumirExamen();
        if (codigoExamen != null) {
            // Simula aquí un examen de 10 preguntas
            // cuyas respuestas se seleccionarán al azar
            // entre A, B, C, D o – (sin contestar).
            Random random = new Random();
            String[] respuestas = {"A", "B", "C", "D", "-"};
            for (int i = 0; i < 10; i++) {
                String respuesta = respuestas[random.nextInt(respuestas.length)];
                System.out.println(codigoExamen + ";" + this.hilo.getName() + "; Pregunta " + i + ";" + respuesta);
            }
        }
        else {
            System.out.println("Agotado tiempo de espera y " + "no hay más exámenes");
        }
    }
}

