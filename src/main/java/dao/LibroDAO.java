package dao;


import model.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    private final List<Libro> listaLibros;


    public LibroDAO() {
        this.listaLibros = new ArrayList<>();
        listaLibros.add(new Libro(12345234L, "La Biblia", "Anónimo", 30));
        listaLibros.add(new Libro(78569L, "Odisea", "Homero", 23));
        listaLibros.add(new Libro(234561L, "Don Quijote de la Mancha", "Miguel de Cervantes", 31));
        listaLibros.add(new Libro(1238567L, "Historia de dos ciudades", "Charles Dickens", 16));
        listaLibros.add(new Libro(5451289L, "El principito", "Antoine de Saint-Exupéry", 10));
    }


    public Libro consultarISBN(Long ISBN) {
        Libro encontrado = null;
        for (Libro l : listaLibros) {
            if (l.getISBN().equals(ISBN)) {
                encontrado = l;
            }
        }
        return encontrado;
    }

    public Libro consultarTitulo(String titulo) {
        Libro encontrado = null;
        for (Libro l : listaLibros) {
            if (l.getTitulo().equals(titulo)) {
                return encontrado = l;
            }
        }
        return encontrado;
    }

    public Libro consultarAutor(String autor) {
        Libro encontrado = null;
        for (Libro l : listaLibros) {
            if (l.getAutor().equals(autor)) {
                return encontrado = l;
            }
        }
        return encontrado;
    }

    public boolean añadirLibro(Libro libro) {
        if (libro!=null){

            listaLibros.add(libro);
            System.out.println("SDFS");
            return true;
        } else return false;
    }

    public List<Libro> consultarTodos(){
        return listaLibros;

        }
    }
