import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        //crear el buffer de examenes
        BufferExamenes bufferExamenes = new BufferExamenes();

        //crear el productor de examenes pasandole el buffer
        new ProductorExamenes(bufferExamenes);

        //nuevo examinado con los argumentos que le entran por parámetro
        new Examinado(Arrays.toString(args), bufferExamenes);
    }
}