import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        String classpath = System.getProperty("java.class.path");

        //array para manejar el redireccionamiento de la salida
        String[] salida =
                {"src/main/java/txt/examen1.txt",
                        "src/main/java/txt/examen2.txt"};
        //array con los dos grupos de alumnos
        String[][] grupos ={
                {"Pepe", "Juan", "Luis"},
                {"Rosa", "Miguel", "Pedro"}
        };

        //crea un proceso por cada iteracion del for al que se le pasan los dos arrays anteriores
        //se le ha añadido un "random" al constructor de ProductorExamenes para diferenciar la nomenclatura de los examenes en los diferentes procesos
        for (int i = 0; i< grupos.length; i++){
            new ProcessBuilder("java", "-cp", classpath, "Principal",
                    Arrays.toString(grupos[i]))
                    .redirectOutput(new File(salida[i]))
                    .start();
        }
    }
}
