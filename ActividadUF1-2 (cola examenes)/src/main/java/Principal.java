public class Principal {
    public static void main(String[] args) {
        BufferExamenes generador = new BufferExamenes();
        new ProductorExamenes(generador);
        new Examinado("Rosa", generador);

        new ProductorExamenes(generador);
        new Examinado("Miguel", generador);

        new ProductorExamenes(generador);
        new Examinado("Carlos", generador);
    }
}