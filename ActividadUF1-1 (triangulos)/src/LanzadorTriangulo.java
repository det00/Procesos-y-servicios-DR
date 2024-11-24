import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanzadorTriangulo {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");

        //CREO UN ARRAYLIST EN LA QUE MAS ADELANTE AÑADO LOS PROCESOS PARA PODERLOS MANEJAR
        List<Process> procesos = new ArrayList<>();

        //ARRAY DE LOS ARGUMENTOS PARA PODER MANIPULARLOS DENTRO DEL FOR
        int[] argumentos = {5, 7, 9};

        //ARRAY DE LOS ARCHIVOS TXT DE SALIDA, PARA PODER MANIPULARLOS DENTRO DEL FOR
        String[] trianguloTxt = {"src/Triangulos/triangulo5.txt", "src/Triangulos/triangulo7.txt", "src/Triangulos/triangulo9.txt"};

        //CREO LA CARPETA DE SALIDA DE LOS ARCHIVOS TXT SI NO EXISTE
        File f = new File("src/Triangulos");
        if (!f.exists()){
            f.mkdir();
        }

        //INICIO MANEJO DE EXCEPCIONES
        try {
            for (int i = 0; i < argumentos.length; i++) {
                //SE CREA EL PROCESO RECIBIENDO LOS PARAMETROS DEL ARRAY
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(argumentos[i]));

                //REDIRECCIONO LA SALIDA A USANDO EL ARRAYLIST CON LA RUTA
                pb.redirectOutput(new File(trianguloTxt[i]));

                //AÑADO CADA PROCESO AL ARRAYLIST DE PROCESOS PARA PODER MANIPULARLOS JUNTOS
                procesos.add(pb.start());
            }
            for (Process p : procesos) {
                //SE LE AÑADE WAITFOR A CADA UNO DE LOS PROCESOS DENTRO DEL FOR PARA QUE TERMINEN TODOS JUNTOS
                p.waitFor();
            }

            //MANEJO DE EXCEPCIONES
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
