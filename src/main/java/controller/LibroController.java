package controller;

import dao.LibroDAO;
import model.Libro;

public class LibroController {
    LibroDAO ldao = new LibroDAO();

    public Libro consultarISBN(Long ISBN) {
        if (ldao.consultarISBN(ISBN) != null) {
            return (ldao.consultarISBN(ISBN));
        } else
            return null;
    }

    public Libro consultarTitulo(String titulo) {
        if (ldao.consultarTitulo(titulo) != null) {
            return (ldao.consultarTitulo(titulo));
        } else
            return null;

    }

    public Libro consultarAutor(String autor) {
        if (ldao.consultarAutor(autor) != null) {
            return(ldao.consultarAutor(autor));
        } else
            return null;
    }

    public void añadirLibro(Libro libro) {
        if (ldao.añadirLibro(libro)) {
            System.out.println("Libro añadido correctamente");
            System.out.println(libro);
        } else {
            System.out.println("Libro no añadido");
        }
    }
    public Libro consultarTodos() {
        for (Libro l:ldao.consultarTodos()){
            return(l);
        }
        return null;
    }
}
