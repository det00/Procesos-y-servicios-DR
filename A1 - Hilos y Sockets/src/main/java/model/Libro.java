package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Libro {
    private Long ISBN;
    private String titulo;
    private String autor;
    private float precio;
}
