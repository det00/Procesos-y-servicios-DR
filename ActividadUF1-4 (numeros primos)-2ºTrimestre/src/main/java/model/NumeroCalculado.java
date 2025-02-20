package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NumeroCalculado {
    private long numero;
    private String nombreHilo;
    private long duracionCalculo;
    private String esPrimo;

    @Override
    public String toString() {
        String infoHilo = String.format("Procesado por hilo: %s", nombreHilo);
        String infoPrimo = String.format("El número %s %s", numero, esPrimo);
        String infoCalculo = String.format("Cálculo realizado en %s nanosegundos", duracionCalculo);
        return infoHilo + "\n" + infoPrimo + "\n" + infoCalculo;
    }
}
