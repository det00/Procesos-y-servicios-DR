package controller;
import dao.LibroDAO;
import model.Libro;
import java.util.List;

public class LibroController {
    LibroDAO ldao = new LibroDAO();

    public Libro consultarISBN(Long ISBN) {
        return ldao.consultarISBN(ISBN);
    }

    public Libro consultarTitulo(String titulo) {
        return ldao.consultarTitulo(titulo);
    }

    public List<Libro> consultarAutor(String autor) {
        return ldao.consultarAutor(autor);
    }

    public boolean añadirLibro(Libro libro) {
        return ldao.añadirLibro(libro);
    }

    public List<Libro> consultarTodos() {
        return ldao.consultarTodos();
    }
}


