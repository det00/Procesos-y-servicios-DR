package controller;

import dao.LibroDAO;
import model.Libro;

public class LibroController {
    LibroDAO ldao = new LibroDAO();

    public void consultarISBN(Long ISBN) {
        if (ldao.consultarISBN(ISBN) != null) {
            System.out.println(ldao.consultarISBN(ISBN));
        } else
            System.out.println("Libro con ISBN " + ISBN + " no encontrado");
    }

    public void consultarTitulo(String titulo) {
        if (ldao.consultarTitulo(titulo) != null) {
            System.out.println(ldao.consultarTitulo(titulo));
        } else
            System.out.println("Libro con Titulo " + titulo + " no encontrado");

    }

    public void consultarAutor(String autor) {
        if (ldao.consultarAutor(autor) != null) {
            System.out.println(ldao.consultarAutor(autor));
        } else
            System.out.println("Libro no con " + autor + " no encontrado");
    }

    public void añadirLibro(Libro libro) {
        if (ldao.añadirLibro(libro)) {
            System.out.println("Libro añadido correctamente");
            System.out.println(libro);
        } else {
            System.out.println("Libro no añadido");
        }
    }
    public void consultarTodos() {
        for (Libro l:ldao.consultarTodos()){
            System.out.println(l);
        }
    }
}
