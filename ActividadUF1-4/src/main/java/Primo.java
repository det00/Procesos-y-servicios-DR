import model.NumeroCalculado;
//importo la clase para poder encapsular en objeto la info

public class Primo implements Runnable{
    //implemento runnable para tener el metodo "run"
    private long num;

    //constructor de clase que se usa en el lanzador
    public Primo(long num) {
        this.num = num;
    }

    @Override
    public void run() {
        //guardo en una variable el inicio del proceso
        //no lo hice en milisegundos por que los calculos son demasiado rapidos
        long tiempoInicio = System.nanoTime();
        //creo un objeto tipo numeroCalculado (requerimiento de encapsulacion)
        NumeroCalculado numeroCalculado = new NumeroCalculado();
        //le seteo el numero y el nombre del hilo
        numeroCalculado.setNumero(num);
        numeroCalculado.setNombreHilo(Thread.currentThread().getName());
        //boolean que llama a funcion para comprobar si es primo o no
        boolean esPrimo = esPrimo(num);
        //se le setea al objeto si es primo o no
        if (esPrimo){
            numeroCalculado.setEsPrimo("es primo.");
        }
        else {
            numeroCalculado.setEsPrimo("no es primo.");
        }
        //seteo de la duracion del proceso al objeto
        //calculando el final y restandole el inicio
        numeroCalculado.setDuracionCalculo(System.nanoTime()-tiempoInicio);
        //se llama al metodo toString de la clase para mostrar los datos
        System.out.println(numeroCalculado);
    }

    //funcion que comprueba si el numero es primo
    private boolean esPrimo(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
